package es.agrobook.api.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import es.agrobook.dto.RestErrorDto;

public class ResponseBodyMatchers {
    
    private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
  
  
    public <T> ResultMatcher containsObjectAsJson(Object expectedObject, TypeReference<T> targetClass) {
        return mvcResult -> {
            String json = mvcResult.getResponse().getContentAsString();
            System.out.println(json);
            T actualObject = objectMapper.readValue(json, targetClass);

            if(isIterableType(targetClass))
                assertIterableEquals((Iterable<?>)expectedObject, (Iterable<?>)actualObject);
            else
                assertEquals(expectedObject, actualObject);
        };
        
    }

    public <T> ResultMatcher containsObjectAsJson(Object expectedObject, Class<T> targetClass) {
        return containsObjectAsJson(expectedObject, new TypeReference<T>(){
            @Override
            public Type getType() {
                return targetClass;
            }
        });
    }

    public ResultMatcher containsError(RestErrorDto expectedRestErrorDto) {
        return mvcResult -> {
            String json = mvcResult.getResponse().getContentAsString();
            //System.out.println(json);
            RestErrorDto resultRestErrorDto = objectMapper.readValue(json, RestErrorDto.class);
                    
            // In test mode there is no HttpServletRequest. RestMessageDto path can not be calculated
            // assertEquals(resultRestErrorDto.getPath().toString(), expectedRestErrorDto.getPath().toString());
            assertTrue(resultRestErrorDto.getMessage().contains(expectedRestErrorDto.getMessage()));

            if(expectedRestErrorDto.getValidationErrors() != null)
                expectedRestErrorDto.getValidationErrors().stream().forEach( expectedValidationError -> 

                    assertTrue( String.format("ValidationError on field: \"%s\" with message: \"%s\" not contained in RestErrorDto result.\n" + 
                        "resultValidationErrors: %s ", 
                        expectedValidationError.getField(), expectedValidationError.getMessage(), resultRestErrorDto.getValidationErrors()), 

                        resultRestErrorDto.getValidationErrors().stream().anyMatch(resultValidationError -> 

                            resultValidationError.getField().equals(expectedValidationError.getField()) &&
                            resultValidationError.getMessage().contains(expectedValidationError.getMessage()))));
        };
    }
    
    public static ResponseBodyMatchers responseBody(){
        return new ResponseBodyMatchers();
    }

    private static boolean isIterableType(TypeReference<?> typeReference) {
        Type type = typeReference.getType();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            if (rawType instanceof Class) {
                Class<?> rawClass = (Class<?>) rawType;
                return Iterable.class.isAssignableFrom(rawClass);
            }
        }
        return Iterable.class.isAssignableFrom((Class<?>)type);
    }
  
}
