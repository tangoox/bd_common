package sven666.common.bdcommon.utils;


import sven666.common.bdcommon.response.Resp;
import sven666.common.bdcommon.response.RespStatus;

/**
 * @author : S_ven
 * @create : 2020/7/16 15:07
 * @describe: RespUtils
 */
public class RespUtils {
    /**
     * =============================================成功=============================================
     */
    private static <T> Resp<T> success(int code, T t, String uiMsg, Object extra) {
        return Resp.<T>builder().code(code).data(t).uiMsg(uiMsg).extra(extra).build();
    }

    public static <T> Resp<T> success(T t, String uiMsg, Object extra) {
        return success(RespStatus.SUCCESS.getCode(), t, uiMsg, extra);
    }

    public static <T> Resp<T> success(T t, String uiMsg) {
        return success(t, uiMsg, null);
    }

    public static <T> Resp<T> success(T t) {
        return success(t, RespStatus.SUCCESS.getMsg());
    }

    /**
     * =============================================失败=============================================
     */
    private static <T> Resp<T> fail(int code, String uiMsg, String debugMsg) {
        return Resp.<T>builder().code(code).uiMsg(uiMsg).debugMsg(debugMsg).build();
    }

    public static <T> Resp<T> fail(String uiMsg, String debugMsg) {
        return fail(RespStatus.FAIL.getCode(), uiMsg, debugMsg);
    }

    public static <T> Resp<T> fail(String uiMsg) {
        return fail(uiMsg, RespStatus.FAIL.getMsg());
    }

    public static <T> Resp<T> fail() {
        return fail(RespStatus.FAIL.getMsg());
    }

}