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
        this.cashCollected = 0;
    }

    public int getCashCollected(){
        return this.cashCollected;
    }

    public void setCollectedCash(int cash){
        this.cashCollected = cash;
    }
    public void addCash(int cash){
        this.cashCollected += cash;
    }

    public void collectCash(int cash){
        this.state.collectCash(cash);
    }

    public int calculateChange(String productCode){
        int change = cashCollected-productCodeToPriceMap.getOrDefault(productCode,0);
        return change;
    }

    public void dispenseChange(String productCode) {
        this.state.dispenseChange(productCode);
    }

    public void dispenseItem(String productCode) {
        this.state.dispenseItem(productCode);
    }

    public void addItem(String productCode, int quantity){
        if(quantity < 1)
            throw new RuntimeException("Invalid Quantity added, has to be minimum one");
        this.productCodeToQuantityMap.put(productCode, this.productCodeToQuantityMap.getOrDefault(productCode,0)+quantity);
    }

    public void removeItem(String productCode){
        int currentStock = productCodeToQuantityMap.getOrDefault(productCode,0);

        if(currentStock == 0)
            throw new RuntimeException("Item cannot be dispensed because of insufficient stock");

        this.productCodeToQuantityMap.put(productCode, currentStock-1);
        this.cashCollected -= productCodeToPriceMap.get(productCode);
    }

    public void cancelTransaction(){
        this.state.cancelTransaction();
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

}
