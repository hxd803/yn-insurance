package com.yi.nuo.common.util;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Random;

/**
 * Md5加密方法
 *
 * @author 黄雪冬
 * @date 2019-02-25
 */
@Slf4j
public class Md5Util {

    private Md5Util() {

    }

    private static byte[] md5(String s) {
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(s.getBytes(StandardCharsets.UTF_8));
            return algorithm.digest();
        } catch (Exception e) {
            log.error("MD5 Error...", e);
        }
        return new byte[0];
    }

    private static String toHex(byte[] hash) {
        if (hash == null) {
            return null;
        }
        StringBuilder buf = new StringBuilder(hash.length * 2);
        int i;

        for (i = 0; i < hash.length; i++) {
            if ((hash[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString(hash[i] & 0xff, 16));
        }
        return buf.toString();
    }

    public static String hash(String s) {
        try {
            String s1 = toHex(md5(s));

            if (s1 == null) {
                return null;
            }
            return new String(s1.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.error("not supported charset...", e);
            return s;
        }
    }

    public static String createSalt() {
        int i = new Random().nextInt(999999);
        return String.format("%06d", i);
    }
}
