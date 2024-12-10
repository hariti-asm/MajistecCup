package ma.hariti.asmaa.wrm.majesticcup.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ApiResponseDTO<T> {
    private final boolean success;
    private final T data;
    private final String error;
    private final int status;

    public ApiResponseDTO(boolean success, T data, String error, int status) {
        this.success = success;
        this.data = data;
        this.error = error;
        this.status = status;
    }


    public static <T> ApiResponseDTO<T> success(T data) {
        return new ApiResponseDTO<>(true, data, null, 200);
    }



    public static <T> ApiResponseDTO<T> success(T data, int status) {
        return new ApiResponseDTO<>(true, data, null, status);
    }


    public static <T> ApiResponseDTO<T> error(String message, int status) {
        return new ApiResponseDTO<>(false, null, message, status);
    }


    public static <T> ApiResponseDTO<T> error(String message, T data, int status) {
        return new ApiResponseDTO<>(false, data, message, status);
    }
}