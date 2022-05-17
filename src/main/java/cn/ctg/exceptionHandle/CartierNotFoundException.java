package cn.ctg.exceptionHandle;

public class CartierNotFoundException extends RuntimeException{
    private static final long serialVersionUID=1L;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    private int retCode;
    private String msg;

    public CartierNotFoundException(int retCode, String msg) {
        this.retCode = retCode;
        this.msg = msg;
    }

}
