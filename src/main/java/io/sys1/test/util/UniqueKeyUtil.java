package io.sys1.test.util;

import java.util.UUID;

public class UniqueKeyUtil {
    public static String getUniqueKey() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
