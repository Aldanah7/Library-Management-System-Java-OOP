
package pkg3_2i2_townlibrarysystem;

public abstract class LibraryAssets implements BookCheckout {

   private int quantity;
   private String category;
   private String itemTitle;
   private int ID;

    public LibraryAssets(int quantity, String category, String itemTitle, int ID) {
        this.quantity = quantity;
        this.category = category;
        this.itemTitle = itemTitle;
        this.ID = ID;
    }

   

    public LibraryAssets() {
        this(0,"","",0);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
   
    
    
   public abstract int NumberOfCopies ();
   
   public abstract double calcFine(int daysOverdue);
   
   @Override
   public final boolean Availability(){
       if (quantity <= 0){
           return false;
       }else {
           return true;
       }
   }
   
   @Override
   public final void checkOut(){
       if(Availability()){
           quantity --;
       }else {
           System.out.println("Sorry, the item is not available");
       }
   }
   
    @Override
     public final void checkIn(){
       quantity++;
        System.out.println(getItemTitle()+ "has been returned, Thank you.");
   }

    @Override
    public String toString() {
        return  "\n Quantity:" + quantity + " \n Category:" + category + " \n ItemTitle:" + itemTitle;
    }
   
   
   
}
