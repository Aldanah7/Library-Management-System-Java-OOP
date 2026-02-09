
package pkg3_2i2_townlibrarysystem;

public class PhysicalBook  extends Book{
    
  private boolean hardCover;       

    public PhysicalBook(boolean hardCover, String authorName, int quantity, String category, String itemTitle, int ID) {
        super(authorName, quantity, category, itemTitle, ID);
        this.hardCover = hardCover;
    }

   

    public PhysicalBook() {
    super( "", 0, "", "",0);
    this.hardCover = false;
}
    
    public boolean isHardCover() {
        return hardCover;
    }

    public void setHardCover(boolean hardCover) {
        this.hardCover = hardCover;
    }

    
    @Override
    public double calcFine(int daysOverdue){
      
        if (isHardCover()) {
            
            return 5 * daysOverdue;
        }
        else {
           return 2 *  daysOverdue;
        }
        
        
        
    }
    
    
    
    @Override
  public int NumberOfCopies (){
      return 1 ;
  }
    
    @Override
    public String toString() {
        return " \n HardCover:" + hardCover;
    
    
  
    
}

  }
  