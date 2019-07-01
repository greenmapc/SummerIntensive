package com.simbirsoft.taxi_service.util.search;

public class SearchRequestParser {
    public static String getSimpleQueryString(String request) {
        String[] keywords = request.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String keyword : keywords)  {
            builder.append(keyword).append("~2|");
        }

        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
