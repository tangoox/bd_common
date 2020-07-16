package sven666.common.bdcommon.response;

/**
 * @author : S_ven
 * @create : 2019-04-01 10:29
 * @code 200
 * @describe: 请求状态
 */
public enum RespStatus {
    /**
     * 请求成功
     */
    SUCCESS(200, "请求成功"),

    /**
     * 请求失败
     */
    FAIL(-200, "请求失败"),

    /**
     * 服务器异常
     */
    EXCEPTION(500, "服务器异常"),

    /**
     * 请求资源不存在
     */
    NOTFOUND(404, "请求资源不存在");

    private final int code;

    private final String msg;

    RespStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static RespStatus getStatusByCode(int code) {
        for (RespStatus item : RespStatus.values()) {
            if (item.getCode() == code) {
                return item;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}