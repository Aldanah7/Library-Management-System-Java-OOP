
package pkg3_2i2_townlibrarysystem;

public class Maps extends LibraryAssets {
    private String typeOfMap;

    public Maps(String typeOfMap, int quantity, String category, String itemTitle,int ID) {
        super(quantity, category, itemTitle,ID);
        this.typeOfMap = typeOfMap;
    }

    public Maps() {
    }

    public String getTypeOfMap() {
        return typeOfMap;
    }

    public void setTypeOfMap(String typeOfMap) {
        this.typeOfMap = typeOfMap;
    }

   @Override 
   public int NumberOfCopies(){ // the types of map 
     return 7;  
   }
    
   @Override
   public  double calcFine(int daysOverdue){
       if(getTypeOfMap().equals("Physical maps"))
           return 6*daysOverdue;
       else
           return 7*daysOverdue;
   }

    @Override
    public String toString() {
        return  "\n Type of map: " + typeOfMap + super.toString();
    }
    
}