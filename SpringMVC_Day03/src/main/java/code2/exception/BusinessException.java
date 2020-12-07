package code2.exception;

public class BusinessException extends RuntimeException{
    private Integer getFailure;

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

    public BusinessException(String message, Integer getFailure) {
        super(message);
        this.getFailure = getFailure;
    }


    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
