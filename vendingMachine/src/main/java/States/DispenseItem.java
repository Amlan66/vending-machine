package main.java.States;

import main.java.vending.VendingMachine;

public class DispenseItem implements State{
    private VendingMachine vendingMachine;

    public DispenseItem(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        throw new RuntimeException("Machine is Dispensing Item, cannot collect cash");
    }

    @Override
    public void dispenseChange(String productCode) {
        throw new RuntimeException("Machine is Dispensing Item, cannot dispense change");
    }

    @Override
    public void dispenseItem(String productCode) {
        //TODO
    }

    @Override
    public void cancelTransaction() {
        throw new RuntimeException("Machine is Dispensing Item, cannot cancel Transaction");
    }
}
