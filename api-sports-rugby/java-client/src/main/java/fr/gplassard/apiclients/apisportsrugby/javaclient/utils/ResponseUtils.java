package fr.gplassard.apiclients.apisportsrugby.javaclient.utils;

import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiException;
import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiResponse;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ResponseUtils {

    public static <T,U> ApiResponse<U> handleResponse(ApiResponse<T> response, Function<T, Object> errorExtracter, Function<T, U> transform) throws ApiException {
        var errors = ResponseUtils.getErrors(errorExtracter.apply(response.getData()));
        if (!errors.isEmpty()) {
            throw new ApiException(
                    response.getStatusCode(),
                    errors.toString()
            );
        }
        return new ApiResponse<>(
                response.getStatusCode(),
                response.getHeaders(),
                transform.apply(response.getData())
        );
    }

    @SuppressWarnings("unchecked")
    private static List<Map<String, Object>> getErrors(Object errors) {
        // errors can either be a JSON array of objects or directly an object if there is only one error
        if (errors == null) {
            return Collections.emptyList();
        }
        if (errors instanceof List) {
            return (List<Map<String, Object>>) errors;
        }
        return Collections.singletonList((Map<String, Object>) errors);
    }
}
