package rowmaterial.rowmaterialplattaform.security.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrerRequest {

    private String userName;
    private String lastName;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private String address;
    private String avatar;
    private String phone_number;

    private String basket_frecuency;


}
