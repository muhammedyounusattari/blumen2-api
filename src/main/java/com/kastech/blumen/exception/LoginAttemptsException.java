package com.kastech.blumen.exception;

public class LoginAttemptsException extends RuntimeException{
    private static final long serialVersionUID = -3868232127218537194L;
    protected String errorCode;
    protected Object[] messageParams;
    public LoginAttemptsException() {
        super();
    }
    public LoginAttemptsException(String msg) {
        super(msg);
    }
    public LoginAttemptsException(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }
    public LoginAttemptsException(Throwable e) {
        super(e);
    }
    public LoginAttemptsException(String msg, Throwable e) {
        super(msg, e);
        this.errorCode = e.getMessage();
    }
    public static String getStack(Throwable e) {
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        return st[4].getClassName() + "." + st[4].getMethodName() + "():" + st[4].getLineNumber() + " ->"                + e.getMessage();
    }
    public static String getStack() {
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        return st[4].getClassName() + "." + st[4].getMethodName() + "():" + st[4].getLineNumber() + " -> ";
    }
    public String getErrorCode() {
        return this.errorCode;
    }     /**     * @return Returns the messageParams.     */
    public Object[] getMessageParams() {
        return messageParams;
    }
}
