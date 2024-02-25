package main.java.States;

import main.java.vending.VendingMachine;

public class DispenseChange implements State{

    private VendingMachine vendingMachine;

    @Override
    public void collectCash(int cash) {
        throw new RuntimeException("Machine is Dispensing Change, cannot collect cash");
    }

    @Override
    public void dispenseChange(String productCode) throws Exception {
        //TODO
    }

    @Override
    public void dispenseItem(String productCode) {
        throw new RuntimeException("Machine is Dispensing Change, cannot dispense Item");
    }

    @Override
    public void cancelTransaction() {
        throw new RuntimeException("Machine is Dispensing Change, cannot cancel transaction");
    }
}
