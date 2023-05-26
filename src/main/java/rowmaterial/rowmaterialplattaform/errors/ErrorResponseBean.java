package rowmaterial.rowmaterialplattaform.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseBean {

    private String errorCode;

    private String errorValue;
}
