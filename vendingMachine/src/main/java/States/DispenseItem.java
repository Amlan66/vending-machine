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
        System.out.println("Dispensing item "+ productCode);
        this.vendingMachine.removeItem(productCode);
        System.out.println(productCode + " dispensed");
        System.out.println("Machine is ready to take new orders");
        this.vendingMachine.setState(new Ready(this.vendingMachine));
    }

    @Override
    public void cancelTransaction() {
        throw new RuntimeException("Machine is Dispensing Item, cannot cancel Transaction");
    }
}
