package hz.blog.markhub.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ServiceExceptionEnum implements CommonError{
    // login related
    CREDENTIALS_EXPIRED(10000, "Token has already expired. Please login again")
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
