package sven666.common.bdcommon.utils;

/**
 * @author : S_ven
 * @create : 2019-04-25 16:16
 * @describe: ExceptionUtil
 */
public class ExceptionUtil {

    /**
     * 获取第一条堆栈信息
     *
     * @param throwable 异常
     * @return 异常信息
     */
    public static String getSimpleStackTrace(Throwable throwable) {
        StackTraceElement[] stackElements = throwable.getStackTrace();
        if (stackElements != null) {
            return throwable.getClass().getName() + " : " + throwable.getMessage()
                    + " \n at " + stackElements[0].getClassName() + " (" + stackElements[0].getFileName()
                    + ") " + stackElements[0].getMethodName()
                    + ":" + stackElements[0].getLineNumber();
        }
        return null;
    }

}