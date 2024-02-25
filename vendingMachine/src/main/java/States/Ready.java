package main.java.States;

import main.java.vending.VendingMachine;

public class Ready implements State{

    private VendingMachine vendingMachine;

    @Override
    public void collectCash(int cash) {
        //TODO
    }

    @Override
    public void dispenseChange(String productCode) throws Exception {
        throw new RuntimeException("Unable to dispense change as no cash has been collected");
    }

    @Override
    public void dispenseItem(String productCode) {
        //TODO
    }

    @Override
    public void cancelTransaction() {
        //TODO
    }
}
