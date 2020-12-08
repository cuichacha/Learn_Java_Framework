package code.exception;

public class BusinessException extends RuntimeException {
    private Integer code;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BusinessException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
