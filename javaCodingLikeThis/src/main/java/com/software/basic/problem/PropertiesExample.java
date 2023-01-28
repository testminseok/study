package com.software.basic.problem;

import java.io.*;
import java.util.Properties;

public class PropertiesExample {

    private static final String DEFAULT_PROPERTIES_PATH = "D:" + File.separator + "config.properties";
    private static final String RESOURCE_PROPERTIES_PATH = "config/config.properties";

    private static String serverIp;

    public static void main(String[] args) {
        setServerIp(PropertiesExample.getKey("serverIp"));
        System.out.println("SERVER_IP : " + getServerIp());
        System.out.println("SERVER_IP : " + PropertiesExample.getKeyByResourcePath("serverIp"));
    }

    public static String getServerIp() {
        return serverIp;
    }

    public static void setServerIp(String serverIp) {
        PropertiesExample.serverIp = serverIp;
    }

    public static String getKey(String key) {
        String value = null;
        try (InputStream inputStream = new FileInputStream(DEFAULT_PROPERTIES_PATH)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            value = properties.getProperty(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String getKeyByResourcePath(String key) {
        String value = null;
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(RESOURCE_PROPERTIES_PATH)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            value = properties.getProperty(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
