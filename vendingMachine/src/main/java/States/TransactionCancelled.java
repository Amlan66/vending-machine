package main.java.States;

import main.java.vending.VendingMachine;

public class TransactionCancelled implements State{

    private VendingMachine vendingMachine;

    @Override
    public void collectCash(int cash) {
        throw new RuntimeException("Machine is cancelling transaction, cannot collect cash");
    }

    @Override
    public void dispenseChange(String productCode) {
        throw new RuntimeException("Machine is cancelling transaction, cannot dispense change");
    }

    @Override
    public void dispenseItem(String productCode) {
        throw new RuntimeException("Machine is cancelling transaction, cannot dispense item");
    }

    @Override
    public void cancelTransaction() {
        //TODO
    }
}
