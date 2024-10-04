package com.scribblenetwork.utils;

import java.util.UUID;

public class ContentUtils {

    public static String generateContentId() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
