package main.java.vending;

import main.java.States.Ready;
import main.java.States.State;

import java.util.Map;

public class VendingMachine {

    private int cashCollected;
    private Map<String, Integer> productCodeToPriceMap;
    private Map<String, Integer> productCodeToQuantityMap;
    private State state;

    public VendingMachine(Map<String,Integer> productCodeToPriceMap, Map<String,Integer> productCodeToQuantityMap){
        this.state = new Ready(this);
        this.productCodeToPriceMap = productCodeToPriceMap;
        this.productCodeToQuantityMap = productCodeToQuantityMap;
    }

    public int getCashCollected(){
        return this.cashCollected;
    }

    public VendingMachine addCash(int cash){
        this.cashCollected = cash;
        return this;
    }

    public void dispenseChange(String productCode) {
        this.state.dispenseChange(productCode);
    }

    public void dispenseItem(String productCode) {
        this.state.dispenseItem(productCode);
    }

    public VendingMachine addItem(String productCode, int quantity){
        if(quantity < 1)
            throw new RuntimeException("Invalid Quantity added, has to be minimum one");
        this.productCodeToQuantityMap.put(productCode, this.productCodeToQuantityMap.getOrDefault(productCode,0)+quantity);
        return this;
    }

    public VendingMachine removeItem(String productCode, int quantity){
        int currentStock = productCodeToQuantityMap.getOrDefault(productCode,0);

        if(currentStock < quantity)
            throw new RuntimeException("Item cannot be dispensed because of insufficient stock");

        this.productCodeToQuantityMap.put(productCode, currentStock-quantity);
        return this;
    }

    public void cancelTransaction(){
        this.state.cancelTransaction();
    }
    public VendingMachine setState(State state){
        this.state = state;
        return this;
    }

    public State getState() {
        return this.state;
    }

}
