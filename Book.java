
package pkg3_2i2_townlibrarysystem;

public abstract class Book extends LibraryAssets {
  
    private String authorName;

    public Book( String authorName, int quantity, String category, String itemTitle,int ID) {
        super(quantity, category, itemTitle,ID);
        this.authorName = authorName;
    }

    public Book() {
        this("",0,"","",0);
    }


    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }


    @Override
    public String toString() {
        return  " \n Author Name:" + authorName ;
    }
   
}
