package hz.blog.markhub.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ServiceExceptionEnum implements CommonError{
    // unknown error
    UNKNOWN_ERROR(10000, "Service failed due to internal error"),

    // login related
    AUTHENTICATION_FAILED(20000, "Authentication Failed."),
    CREDENTIALS_EXPIRED(20001, "Token has already expired. Please login again")
    ;

    private int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return errCode;
    }

    @Override
    public String getErrMsg() {
        return errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
