package ma.hariti.asmaa.wrm.majesticcup.dto;

import lombok.Getter;

@Getter
public class ApiResponseDTO<T> {
    private final boolean success;
    private final T data;
    private final String error;
    private final int status;

    private ApiResponseDTO(boolean success, T data, String error, int status) {
        this.success = success;
        this.data = data;
        this.error = error;
        this.status = status;
    }

    public static <T> ApiResponseDTO<T> success(T data, int totalElements) {
        return new ApiResponseDTO<>(true, data, null, totalElements);
    }

    public static <T> ApiResponseDTO<T> success(T data) {
        return new ApiResponseDTO<>(true, data, null, 0);
    }

    public static <T> ApiResponseDTO<T> error(String message, int status) {
        return new ApiResponseDTO<>(false, null, message, status);
    }

    public static <T> ApiResponseDTO<T> error(String message, T data, int status) {
        return new ApiResponseDTO<>(false, data, message, status);
    }
}