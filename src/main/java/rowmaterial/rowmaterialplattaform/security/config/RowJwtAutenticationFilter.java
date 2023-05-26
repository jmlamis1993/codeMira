package rowmaterial.rowmaterialplattaform.security.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class RowJwtAutenticationFilter extends OncePerRequestFilter {

    private final RowMaterialToken rowMaterialToken;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
      final String authHeader = request.getHeader("Authorization");
      final String rowMaterialToken;
      final String usermail;

      if (authHeader == null  || !authHeader.startsWith("Bearer "))
        {
            filterChain.doFilter(request,response);
            return;
        }

      rowMaterialToken = authHeader.substring(7);
      usermail = this.rowMaterialToken.extractUsername(rowMaterialToken);
      if (usermail != null && SecurityContextHolder.getContext().getAuthentication() == null)
      {
          UserDetails userDetails = this.userDetailsService.loadUserByUsername(usermail);
          if  (this.rowMaterialToken.isTokenValid(rowMaterialToken,userDetails))
          {
              UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
                      (userDetails, null, userDetails.getAuthorities());
              authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
              SecurityContextHolder.getContext().setAuthentication(authenticationToken);
          }
      }
      filterChain.doFilter(request,response);
    }
}
