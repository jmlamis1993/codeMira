package rowmaterial.rowmaterialplattaform.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
public class RowMaterialToken {

    private static final String SCRET_Key = "556B58703273357638792F423F4528482B4B6250655368566D59713374367739";
    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails)
    {
        return generateToken(new HashMap<>(), userDetails);
    }

    public boolean isTokenValid (String token, UserDetails userDetails)
    {
        String userName = this.extractUsername(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token)
    {
        return extratExpirationToken(token).before(new Date());
    }

    private Date extratExpirationToken(String token) {
        return extractClaims(token,Claims::getExpiration);
    }

    public String generateToken(Map<String, Objects> xtraClaim, UserDetails userDetails)
    {
        return Jwts.builder().setClaims(xtraClaim).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
                .signWith(getSingleKey(), SignatureAlgorithm.HS256).compact();
    }

    public <T> T extractClaims(String token, Function<Claims,T> claimsResolver)
    {
        final Claims claims = extractAllClaims(token);
        return  claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts.parserBuilder()
                .setSigningKey(getSingleKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSingleKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SCRET_Key);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
