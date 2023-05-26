package rowmaterial.rowmaterialplattaform.restpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rowmaterial.rowmaterialplattaform.entity.Usuario;
import rowmaterial.rowmaterialplattaform.repository.IRepoLocation;
import rowmaterial.rowmaterialplattaform.restpoint.response.JsonFormatResponse;
import rowmaterial.rowmaterialplattaform.restpoint.response.RestGlobalResponseService;
import rowmaterial.rowmaterialplattaform.restpoint.response.RestParametersResponse;
import rowmaterial.rowmaterialplattaform.security.impl.AuthenticationResponse;

@RestController
@RequestMapping("/гуахиро/app/auth/location")
public class BeanRestLocation {

    private IRepoLocation location;
    private RestGlobalResponseService restGlobalResponseService;

    @GetMapping("/listLocation")
    public ResponseEntity<JsonFormatResponse> listLocations() throws JsonProcessingException {
        //location.findAll().
        return ResponseEntity.ok(restGlobalResponseService.responseServiceConfig(RestParametersResponse.builder().JsonCode("").build()));
    }
}
