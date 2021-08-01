package com.sharma.nks.products.order.management.util;


import java.util.Objects;

public class UniqueIdGenerator {

    private static final long MAX = 10000000000L;
    private static final int CODE_LENGTH = 5;

    public static String getUniqueId() {
        String id = String.valueOf((long) (Math.random() * MAX));
        if (id.length() != 10) {
            return getUniqueId();
        }
        return id;
    }

    /**
     * @param prefix: if prefix is size is less then 4 character then 0's will be appended.
     * @return 14 digit uniqueId as prefix + 10 digit number
     */
    public static String getUniqueId(String prefix) {
        String initials;
        if (Objects.isNull(prefix)) {
            initials = "0000";
        } else {
            initials = prefix.trim();
            if(initials.length()>CODE_LENGTH-1){
                initials=initials.substring(0,4);
            }
        }
        int zeros = initials.length() % CODE_LENGTH;
        for (int i = CODE_LENGTH - 1; i > zeros; i--) {
            initials = initials.concat("0");
        }

        return initials + getUniqueId();
    }
}
