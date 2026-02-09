
package pkg3_2i2_townlibrarysystem;

public class Customer {
    
    private int libraryCardId;
    
    public Customer(int libraryCardId) {
        this.libraryCardId = libraryCardId;
    }
    
    public Customer() {
        this(0);
    }

    public void setLibraryCardId(int libraryCardId) {
        this.libraryCardId = libraryCardId;
    }
    
     public int getLibraryCardId() {
        return libraryCardId;
    }
     
    @Override
    public String toString() {
        return  "\n library Card Id:" + libraryCardId;
    }
    
}