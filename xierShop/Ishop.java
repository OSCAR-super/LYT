package xierShop;

public interface Ishop {
    void by();
    void sold() throws SoldOutException;
    void add(Bubble bubble);
    void add(Coconut coconut);
}
