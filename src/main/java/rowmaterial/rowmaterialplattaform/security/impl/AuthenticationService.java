package rowmaterial.rowmaterialplattaform.security.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rowmaterial.rowmaterialplattaform.entity.Usuario;
import rowmaterial.rowmaterialplattaform.enumerated.UsuarioRol;
import rowmaterial.rowmaterialplattaform.repository.IRepoUser;
import rowmaterial.rowmaterialplattaform.security.config.RowMaterialToken;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    final PasswordEncoder passwordEncoder;
    final IRepoUser repoUser;

    final RowMaterialToken rowMaterialToken;

    final AuthenticationManager authenticationManager;


    Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
    public AuthenticationResponse register(RegistrerRequest request) throws JsonProcessingException {

        var user = Usuario.builder().userName(request.getUserName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .avatar(request.getAvatar())
                .phone_number(request.getPhone_number())
                .rol(UsuarioRol.COSTUMER)
                .active(true)
                .build();

        repoUser.save(user);

        return getAuthenticationResponse(user, rowMaterialToken);

    }

    private static AuthenticationResponse getAuthenticationResponse(Usuario user, RowMaterialToken rowMaterialToken) throws JsonProcessingException {
        var jwtToken = rowMaterialToken.generateToken(user);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonMapper jsonMapper = new JsonMapper();
        ObjectNode node = jsonMapper.createObjectNode();
        node.put("userName",user.getUserName());
        node.put("email",user.getEmail());
        node.put("first_name",user.getFirst_name());
        node.put("last_name",user.getLast_name());
        node.put("avatar",user.getAvatar());
        node.put("phone_nomber",user.getPhone_number());


        return new AuthenticationResponse().builder().token(jwtToken).userName(node).build();
    }

    public AuthenticationResponse authentice(AuthenticationRequest request) throws JsonProcessingException {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassword()));

            Usuario user = repoUser.findByUserName(request.getUserName()).orElseThrow();
        return getAuthenticationResponse(user, rowMaterialToken);


    }
}
