package com.simbirsoft.taxi_service.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class SelectCreator {

    private SelectCreator() {}

    public static Map<String, String> bodyTypeCreate() {
        Map<String, String> bodyTypeMap = new LinkedHashMap<>();

        bodyTypeMap.put("хэтчбек", "хэтчбек");
        bodyTypeMap.put("седан", "седан");
        bodyTypeMap.put("универсал", "универсал");
        bodyTypeMap.put("лифтбэк", "лифтбэк");
        bodyTypeMap.put("купе", "купе");
        bodyTypeMap.put("кабриолет", "кабриолет");
        bodyTypeMap.put("внедорожник", "внедорожник");
        bodyTypeMap.put("кроссовер", "кроссовер");
        bodyTypeMap.put("пикап", "пикап");

        return bodyTypeMap;
    }

    public static Map<String, String> transmissionType() {
        Map<String, String> transmissionMap = new LinkedHashMap<>();

        transmissionMap.put("механика", "механика");
        transmissionMap.put("автомат", "автомат");

        return transmissionMap;
    }

    public static Map<String, String> driveTypeCreate() {
        Map<String, String> driveTypeMap = new LinkedHashMap<>();

        driveTypeMap.put("передний", "передний");
        driveTypeMap.put("задний", "задний");
        driveTypeMap.put("полный", "полный");

        return driveTypeMap;
    }
}
