package com.yi.nuo.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取当前用户IP
 *
 * @author 黄雪冬
 * @date 2019-02-25
 */
@Slf4j
public class IpUtil {

    private static final String X_FORWARDED_FOR = "x-forwarded-for";
    private static final String UNKNOWN = "unknown";
    private static final String LOCAL_IP = "127.0.0.1";
    private static final String UNKNOWN_IP = "0:0:0:0:0:0:0:1";

    private IpUtil() {
    }

    public static String getIp(HttpServletRequest request) {
        // remoteIp
        String ip = request.getHeader(X_FORWARDED_FOR);
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip)) {
            ip = request.getHeader("Client_IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (LOCAL_IP.equals(ip) || UNKNOWN_IP.equals(ip)) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                    ip = inet.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!StringUtils.isEmpty(ip)) {
            List<String> list = stringToList(ip, ",");
            if (list.size() > 1) {
                ip = list.get(0);
            }
        }

        return ip;
    }

    private static List<String> stringToList(String str, String split) {
        List<String> list = new ArrayList<>();
        if (StringUtils.isEmpty(str)) {
            return list;
        }
        for (String s : str.split(split)) {
            if (StringUtils.isEmpty(s)) {
                continue;
            }
            list.add(s);
        }
        return list;
    }
}
