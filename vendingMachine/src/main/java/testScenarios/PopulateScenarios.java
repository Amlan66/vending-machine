package main.java.testScenarios;

import java.util.Map;

public class PopulateScenarios {

    static void populateProductInfo(Map<String,Integer> productCodeToPrice, Map<String,Integer> productCodeToQuantity){

        productCodeToPrice.put("fruit", 10);
        productCodeToPrice.put("juice", 20);
        productCodeToPrice.put("chips", 30);
        productCodeToPrice.put("cake",40);
        productCodeToPrice.put("icecream", 50);

        productCodeToQuantity.put("fruit",10);
        productCodeToQuantity.put("juice",5);
        productCodeToQuantity.put("chips",4);
        productCodeToQuantity.put("cake",3);
        productCodeToQuantity.put("icecream",2);

    }
}
