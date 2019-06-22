package com.simbirsoft.taxi_service.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGeneration {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "_";

    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;

    private static final int PASSWORD_LENGTH = 8;

    private static SecureRandom random = new SecureRandom();

    public static String generatePassword() {
        StringBuilder password = new StringBuilder();
        String shufflePasswordAllowBase = PASSWORD_ALLOW_BASE;

        for(int i = 0; i < PASSWORD_LENGTH; i ++) {
            shufflePasswordAllowBase = shuffleString(shufflePasswordAllowBase);
            password.append(shufflePasswordAllowBase
                        .charAt(random.nextInt(shufflePasswordAllowBase.length())));
        }

        return password.toString();
    }

    private static String shuffleString(String baseChars) {
        List<String> chars = new ArrayList<>(Collections.singletonList(baseChars));
        Collections.shuffle(chars);
        return String.join("", chars);
    }

}
