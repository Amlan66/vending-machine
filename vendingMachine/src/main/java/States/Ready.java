package main.java.States;

import main.java.vending.VendingMachine;

public class Ready implements State{

    private VendingMachine vendingMachine;

    public Ready(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        this.vendingMachine.addCash(cash);
    }

    @Override
    public void dispenseChange(String productCode) {
        this.vendingMachine.setState(new DispenseChange(this.vendingMachine));
        this.vendingMachine.dispenseChange(productCode);
    }

    @Override
    public void dispenseItem(String productCode) {
        throw new RuntimeException("Transaction has not been initiated, Item cannot be dispensed");
    }

    @Override
    public void cancelTransaction() {
        this.vendingMachine.setState(new TransactionCancelled(this.vendingMachine));
        this.vendingMachine.cancelTransaction();
    }
}
