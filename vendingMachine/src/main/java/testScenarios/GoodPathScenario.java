package main.java.testScenarios;

import main.java.vending.VendingMachine;

import java.util.HashMap;
import java.util.Map;

import static main.java.testScenarios.PopulateScenarios.*;

public class GoodPathScenario {

    public static void main(String[] args) {

        Map<String, Integer> productCodeToPriceMap = new HashMap<>();
        Map<String, Integer> productCodeToQuantityMap = new HashMap<>();
        populateProductInfo(productCodeToPriceMap, productCodeToQuantityMap);
        VendingMachine vendingMachine = new VendingMachine(productCodeToPriceMap, productCodeToQuantityMap);

        vendingMachine.collectCash(25);
        vendingMachine.dispenseChange("fruit");

        System.out.println("********New operation**********");
        vendingMachine.collectCash(20);
        vendingMachine.cancelTransaction();

    }

}
