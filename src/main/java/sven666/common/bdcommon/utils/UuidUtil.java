package sven666.common.bdcommon.utils;

import java.util.UUID;

/**
 * @author : S_ven
 * @create : 2019-05-30 10:33
 * @describe: UuidUtil
 */
public class UuidUtil {

    public static String uuid() {
        return UUID.randomUUID().toString();
    }
    
    public static String uuidReplace() {
        return uuid().replace("-", "");
    }


}