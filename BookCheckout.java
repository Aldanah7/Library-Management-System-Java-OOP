
package pkg3_2i2_townlibrarysystem;

public interface BookCheckout {
  
    public static final int ITEMS = 5;
    public static final int DAYS_TILL_RETURN = 10;

    public abstract void checkOut();
    public abstract void checkIn();
    public abstract boolean Availability();

}
