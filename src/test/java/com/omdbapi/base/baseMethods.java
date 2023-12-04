package com.omdbapi.base;


import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;


public class baseMethods {


    public static void verifyStatusCode(Response response, int statusCode) {
        response
                .then()
                .assertThat()
                .statusCode(statusCode);
    }

    public static String compareDoubles(double value1, double value2) {
        int comparisonResult = Double.compare(value1, value2);

        if (comparisonResult < 0) {
            return System.out.printf("%.2f kucuktur %.2f", value1, value2).toString();
        } else if (comparisonResult > 0) {
            return System.out.printf("%.2f buyuktur %.2f", value1, value2).toString();
        } else {
            return System.out.printf("%.2f ve %.2f esittir", value1, value2).toString();
        }
    }

    public static String compareIntegers(int value1, int value2) {
        int comparisonResult = Integer.compare(value1, value2);

        if (comparisonResult < 0) {
            return System.out.printf("%n%d yilinda cikan film %d yilinda cikan filme gore daha eskidir", value1, value2).toString();
        } else if (comparisonResult > 0) {
            return System.out.printf("%n%d yilinda cikan film %d yilinda cikan filme gore daha yenidir", value1, value2).toString();
        } else {
            return System.out.printf("%n%d yilinda cikan film %d yilinda cikan filmle ayni yilda cikmistir", value1, value2).toString();
        }
    }

    public static List<String> findCommonValues(String first, String second) {
        String[] firstValues = first.split(", ");
        String[] secondValues = second.split(", ");

        // Virgülle ayrılmış parçaları birer liste içinde sakla
        List<String> firstList = new ArrayList<>();
        List<String> secondList = new ArrayList<>();
        for (String value : firstValues) {
            firstList.add(value);
        }
        for (String value : secondValues) {
            secondList.add(value);
        }

        // Ortak elemanları bul
        List<String> commonElements = new ArrayList<>();
        for (String value : firstList) {
            if (secondList.contains(value)) {
                commonElements.add(value);
            }
        }

        return commonElements;
    }
}
