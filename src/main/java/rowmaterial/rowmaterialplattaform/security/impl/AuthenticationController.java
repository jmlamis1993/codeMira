package rowmaterial.rowmaterialplattaform.security.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/гуахиро/app/public")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService autehmticationService;
    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registrer
            (@RequestBody RegistrerRequest request) throws JsonProcessingException {
        return ResponseEntity.ok(autehmticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate
            (@RequestBody AuthenticationRequest request) throws JsonProcessingException {
           return ResponseEntity.ok(autehmticationService.authentice(request)) ;
    }
}
