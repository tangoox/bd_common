package sven666.common.bdcommon.response;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * @author : S_ven
 * @create : 2020/7/16 14:47
 * @describe: Response
 */

@Data
@Builder
public class Resp<T> implements Serializable {

    /**
     * 状态码，200成功，其他失败
     */
    private int code;

    /**
     * 泛型返回值
     */
    private T data;

    /**
     * 返回信息，前端使用
     */
    private String uiMsg;

    /**
     * 调试信息
     */
    private String debugMsg;

    /**
     * 扩展信息
     */
    private Object extra;

    public Resp(int code, T data, String uiMsg, String debugMsg, Object extra) {
        this.code = code;
        this.data = data;
        this.uiMsg = uiMsg;
        this.debugMsg = debugMsg;
        this.extra = extra;
    }

    public Resp() {
    }
}