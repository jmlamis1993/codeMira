package rowmaterial.rowmaterialplattaform.errors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import rowmaterial.rowmaterialplattaform.security.impl.AuthenticationResponse;


@ControllerAdvice
public class ErrorHandlerBeanGlobal extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<Object> handleEntityNotFound(BadCredentialsException ex) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ErrorResponseBean errorResponseBean = new ErrorResponseBean();
        errorResponseBean.setErrorCode("1");
        errorResponseBean.setErrorValue(ex.getMessage());
       return new ResponseEntity<>(AuthenticationResponse.builder().error(ex.getMessage()).build() , HttpStatus.UNAUTHORIZED);
    }
}
