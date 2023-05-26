package rowmaterial.rowmaterialplattaform.restpoint.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import rowmaterial.rowmaterialplattaform.entity.Usuario;
import rowmaterial.rowmaterialplattaform.security.config.RowMaterialToken;
import rowmaterial.rowmaterialplattaform.security.impl.AuthenticationRequest;
import rowmaterial.rowmaterialplattaform.security.impl.AuthenticationResponse;

@Service
@RequiredArgsConstructor
public class RestGlobalResponseService {



    public JsonFormatResponse responseServiceConfig(RestParametersResponse petition) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonMapper jsonMapper = new JsonMapper();
        ObjectNode node = jsonMapper.createObjectNode();
        node.put("response",petition.getJsonCode());
        return getJsonConfigFormatResponse( node);
    }

    private static JsonFormatResponse getJsonConfigFormatResponse(ObjectNode node) throws JsonProcessingException {
        return new JsonFormatResponse().builder().jsonFormat(node).build();
    }
}
