
package pkg3_2i2_townlibrarysystem;


public class BorrowSession {
    
   private Customer Customer ;
   private LibraryAssets[] assets;
   private int session_ID;
   private int loanPeriod;
   private String status;

    public BorrowSession(Customer Customer, LibraryAssets[] assets, int session_ID, int loanPeriod, String status) {
        this.Customer = Customer;
        this.assets = assets;
        this.session_ID = session_ID;
        this.loanPeriod = loanPeriod;
        this.status = status;
    }

    public BorrowSession() {
        this(null,null,0,0,"");
    }

    public void setCustomer(Customer Customer) {
        this.Customer = Customer;
    }

    public void setAssets(LibraryAssets[] assets) {
        this.assets = assets;
    }

    public void setSession_ID(int session_ID) {
        this.session_ID = session_ID;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Customer getCustomer() {
        return Customer;
    }

    public LibraryAssets[] getAssets() {
        return assets;
    }

    public int getSession_ID() {
        return session_ID;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public String getStatus() {
        return status;
    }
    
    public final void approveSession(){
        setStatus("Confirmed");
        
        System.out.println("Order has been confirmed successfully.");
    }
    
    public final void cancelSession(){
       setStatus("Cancelled");
       for(LibraryAssets assets : assets){
           assets.setQuantity(assets.getQuantity() + 1);
    }    
      
    System.out.println("Order has been cancelled successfully.");
}
    
    public final int createSessionID(){
        int min = 1;
        int max = 1000;
        int num = (int) (Math.random()*((max-min)+1))+min;
        return num; 
    }

    public final void processReturn(int loanPeriod){
        double fine = 0;
        setStatus("Returned");
        for(LibraryAssets assets : assets){
           assets.checkIn();
           
           fine += assets.calcFine(loanPeriod);
              
    }  
        System.out.println("All items has been returned successfully.Thank you!");
   
     if(fine>0){
         System.out.println("You have "+ loanPeriod + "days overdue");
         System.out.printf("Your total fine is : %.2f SAR.\n",fine);
     }
    else
        System.out.println("No days overdue fine!");
}

    
    
    @Override
    public String toString() {
        return "\n Customer:" + Customer + " \n Assets:" + assets + " \n Session ID:" + session_ID + " /n LoanPeriod:" + loanPeriod + "  \n Status:" + status ;
    }
    

    
    
}
