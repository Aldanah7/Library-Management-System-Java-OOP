
package pkg3_2i2_townlibrarysystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class ReadText {
    private Scanner input;
    public void openTextFile(String fileName ){
        try{
            input=new Scanner (new File( fileName));
        }
        catch (FileNotFoundException ex){
            System.err.println("Error opening or creating file.");
             System.err.println(ex);
        }
    }
           
    
     public void readFromFile(){
                try{
                    while (input.hasNextLine()){
                        System.out.println(input.nextLine());
                        
                }
                
            }catch(NoSuchElementException ex){
                    System.err.println("File improperly formed.");
                     System.err.println(ex);
                     System.exit(1);
                    input.close();
                          }
                catch(IllegalStateException ex){
                    System.err.println("Error reading from file.");
                    System.err.println(ex);
    
                }
                
                
     } 
       public void closeFile(){
           if (input!= null) {
              input.close();
           }
     
     
     
}
}