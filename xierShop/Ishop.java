package xierShop;

public interface Ishop {
    void by();
    void sold() throws SoldOutException;
    void add(int x);
    void add(double y);
}
