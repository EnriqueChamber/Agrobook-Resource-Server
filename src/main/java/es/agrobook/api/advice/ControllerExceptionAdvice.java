package es.agrobook.api.advice;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.OffsetDateTime;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import es.agrobook.dto.RestErrorDto;
import es.agrobook.dto.ValidationMessageDto;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice(annotations = RestController.class)
public class ControllerExceptionAdvice {

    @Autowired
    private HttpServletRequest request;
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestErrorDto> exception(Exception exception) {
        RestErrorDto errorDto = new RestErrorDto(getRequestURI(), OffsetDateTime.now(), exception.getMessage(), exception.getLocalizedMessage());
        return ResponseEntity.internalServerError().body(errorDto);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<RestErrorDto> noSuchElementException(NoSuchElementException exception) {
        RestErrorDto errorDto = new RestErrorDto(getRequestURI(), OffsetDateTime.now(), exception.getMessage(), exception.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestErrorDto> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        RestErrorDto errorDto = new RestErrorDto(getRequestURI(), OffsetDateTime.now(), exception.getMessage(), exception.getNestedPath());
        errorDto.setValidationErrors(exception.getFieldErrors().stream()
            .map(fieldError -> new ValidationMessageDto(fieldError.getField(), fieldError.getCode()))
            .toList());
        return ResponseEntity.badRequest().body(errorDto);
    }

    
    private URI getRequestURI() {
        try {
            String path = request.getServletPath();
            return new URI(path);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }
}
