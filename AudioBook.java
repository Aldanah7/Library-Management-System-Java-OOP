
package pkg3_2i2_townlibrarysystem;

public class AudioBook extends Book{
   
    private String audioFormat;
    private String narrator;
    private int time;

    
    public AudioBook(String audioFormat, String narrator, int time, String authorName, int quantity, String category, String itemTitle, int ID) {
        super(authorName, quantity, category, itemTitle, ID);
        this.audioFormat = audioFormat;
        this.narrator = narrator;
        this.time = time;
    }



  public AudioBook() {
    
    super( "", 0, "", "",0);
    
    
    this.narrator = "";
    this.time = 0;
}

    public String getAudioFormat() {
        return audioFormat;
    }

    public String getNarrator() {
        return narrator;
    }

    public int getTime() {
        return time;
    }

    public void setAudioFormat(String audioFormat) {
        this.audioFormat = audioFormat;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public void setTime(int time) {
        this.time = time;
    }
    

    @Override
    public double calcFine(int daysOverdue){
      
        if (getTime() > 2) {
            
            return 20 * daysOverdue;
        }
        else {
           return 3 *  daysOverdue;
        }
        
        
        
    }
    
   
    
    @Override
  public int NumberOfCopies (){
      return 1 ;

}
 @Override
    public String toString() {
        return "\n AudioFormat:" + audioFormat + "\n Narrator:" + narrator + "\n Time:" + time ;
    }
    
  public void sample(){
System.out.println("Sample of the audio book is playing"); 
}
  
}