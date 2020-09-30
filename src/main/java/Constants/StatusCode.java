package Constants;

public enum  StatusCode {

    LOGIN_ERROR(500, "Incorrect username or password"),
    LOGIN_AUTHORIZATION(302, "Login session timeout"),
    PARAM_ERROR(401, "Incorrect parameters"),
    UNAUTHORIZED(401, "Unauthorized user"),
    USER_ERROR(500, "Failed to get user information"),
    LOGOUT_ERROR(500, "Failed to log out"),
    SYSTEM_ERROR(500, "System error"),
    FILE_ERROR(400, "Empty file uploaded"),
    COMMON_SUCCESS(200, "Success"),
    RESET_SUCCESS(200, "Resetting password successful");

    private final int code;
    private final String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
