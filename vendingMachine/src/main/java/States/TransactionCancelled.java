package main.java.States;

import main.java.vending.VendingMachine;

public class TransactionCancelled implements State{

    private VendingMachine vendingMachine;

    public TransactionCancelled(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

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
        System.out.println("Returning collected cash amount "+ this.vendingMachine.getCashCollected());
        this.vendingMachine.setCollectedCash(0);
        this.vendingMachine.setState(new Ready(this.vendingMachine));
        System.out.println("Machine is ready to take new orders");
    }
}
