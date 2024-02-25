package main.java.States;

public interface State {
    void collectCash(int cash);
    void dispenseChange(String productCode) throws Exception;
    void dispenseItem(String productCode);
    void cancelTransaction();
}
