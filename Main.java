
package pkg3_2i2_townlibrarysystem;

 import java.util.ArrayList;
 import java.util.InputMismatchException;
 import java.util.Scanner;

public class Main {
    
    
static ArrayList<BookCheckout> itemList = new ArrayList<BookCheckout>();
static ArrayList<BorrowSession> BorrowList= new ArrayList<BorrowSession>();

    
    public static void main(String[] args) {
       
        Scanner input = new Scanner (System.in);
        int choice = 0;
        
        fillList(itemList);
        
        System.out.println("***WELCOME TO LAIBRARY SYSTEM***");
        do{
        try{
        menu();
 
        choice = input.nextInt();
        switch(choice){
            case 1://Add Item
               System.out.print("1. PhysicalBook\n"
                                + "2. AudioBook\n"
                                + "3. Maps\n"
                                + "Select type of the item to add >> ");
                       
         int itemType = input.nextInt();

         if (itemType < 1 || itemType > 3) {
               System.out.println("Invalid choice!");
                        } else {
        BookCheckout item;
               System.out.print("Enter the category : ");
        String category = input.nextLine();
        
        input.nextLine();
        
               System.out.print("Enter the title: ");
        String itemTitle = input.nextLine();
        
               System.out.print("Enter number of copies : ");
         int quantity = input.nextInt();

                            //if or switch
                         
         if (itemType == 1) {
         input.nextLine();
               System.out.print("Enter the author name : ");
         String authorName = input.nextLine();
         
               System.out.print("Is the book has hardcover?  *answer with (true\false)* : ");
         boolean hardCover = input.nextBoolean();
         
               System.out.print("Enter item ID: ");
           int ID  = input.nextInt();
         
       item = new PhysicalBook (hardCover,authorName,quantity,category, itemTitle,ID);
        
                            } else if (itemType == 2) {
         input.nextLine();
               System.out.print("Enter the author name: ");
         String authorName = input.nextLine();
         
               System.out.print("Enter the format : ");
         String audioFormat = input.nextLine();
         
               System.out.print("Enter the narrator : ");
         String narrator = input.nextLine();
         
              System.out.print("Enter the time : ");
          int time = input.nextInt();
          
               System.out.print("Enter item ID: ");
           int ID  = input.nextInt();
          
         
         item = new AudioBook ( audioFormat,narrator,time,authorName,quantity,category, itemTitle,ID);
          
                            } else {
               System.out.print("Enter the type of map: ");
          String typeOfMap = input.nextLine();
         input.nextLine();
         
         System.out.print("Enter item ID: ");
           int ID  = input.nextInt();
         
      
         item = new Maps (typeOfMap, quantity, category, itemTitle,ID);
             
                            }  
         
     itemList.add(item);
                        }//end else
                        break;
                
            case 2: //Remove Item       
                   System.out.print("Enter the item title to remove : ");
            String itemTitle = input.nextLine();
            boolean removed = false;
            for(int i = 0;i<itemList.size();i++){
                BookCheckout ele =itemList.get(i);
                if(ele instanceof LibraryAssets){
                    if(((LibraryAssets)ele).getItemTitle().equals(itemTitle) ){
                        itemList.remove(i);
                        removed = true ;
                        break;
                    }
                }
            }//end loop
                if(removed)     {
                    System.out.println("Item with title"+ itemTitle+"has been removed.");
                }   else{
                    System.out.println("No item with title"+ itemTitle+"is found.");
                }
                        break;
            case 3://Display Item
                for(BookCheckout ele : itemList){
                    //Polymorphic methods (Polymorphism)
                     System.out.println(ele);
                     System.out.println("Availabile:"+ ele.Availability());
                          if(ele instanceof LibraryAssets){
                    System.out.printf("Fine For One Day Due: %.2f SAR\n",((LibraryAssets)ele).calcFine(1));
            }
              
                }
                 System.out.println("----------------------------");
                    
                        break;
                 
                case 4://Show AudioBook Items Only
                for (BookCheckout ele : itemList) {
                    // Downcasting to call specific methods
                if (ele instanceof AudioBook) {
                     System.out.println(ele);
                    ((AudioBook) ele).sample();
                     System.out.println("----------------------------");
                        }
                                }
                        break;


           case 5://Borrow Order
                    System.out.print("How many days want to borrow the items? ");
            int days = input.nextInt();
            if (days > BookCheckout.DAYS_TILL_RETURN) {
                    System.out.println("Sorry, the max allowed days is " + BookCheckout.DAYS_TILL_RETURN);
                       continue;
                        }
                    System.out.print("How many items want to borrow? ");
           int num = input.nextInt();
           if (num < 1 || num > BookCheckout.ITEMS) {
                    System.out.println("Sorry, the min number is 1 and the max allowed number of items is " + BookCheckout.ITEMS);
                       continue;
                        }
            LibraryAssets[] orderItems = new LibraryAssets[num];
                    System.out.println("Enter " + num + " item ids:");
            int count = 0;
            while (count < num) {
                    System.out.printf("Enter item #%d id: ", (count + 1));
            int assetId = input.nextInt();
                   //search for product
            boolean isFound = false;
            for (BookCheckout ele : itemList ) {
            if (ele instanceof LibraryAssets) {
            LibraryAssets asset = (LibraryAssets) ele;
            if (asset.getID() == assetId) {
            if (asset.Availability()) {
            asset.checkOut();
            orderItems[count] = asset;
            isFound = true;
            break;
              }
                }
                    }
                        }//end
            if (!isFound) {
                   System.out.println("Invalid item id or item is not available!");
                 }      else {
                    count++;
           }
            }//end loop

             
                   System.out.print("Enter your id: ");
             int customerId = input.nextInt();
                 System.out.print("Enter session ID: ");
            int sessionId = input.nextInt();

                System.out.print("Enter loan period (in days): ");
            int loanPeriod = input.nextInt();
            input.nextLine(); // consume newline

                System.out.print("Enter status ( Confirmed, Cancelled.....): ");
            String status = input.nextLine();
             
                System.out.println("");

       
            Customer customer = new Customer(customerId);
            BorrowSession b = new BorrowSession(customer,  orderItems, sessionId, loanPeriod,status);
                  System.out.print("Confirm order? (Y/N): ");
            char answer = input.next().charAt(0);
            if (answer == 'y' || answer == 'Y') {
            b.approveSession();
            BorrowList.add(b);
                   System.out.println(b);
                }           else {
                   System.out.println("Your order has been cancelled!");
                    }
                    break;


        
          case 6:
                    System.out.print("Enter the session ID: ");
        int sessionID=input.nextInt();
        boolean exists=false;
        for(BorrowSession x:BorrowList ){
        if(x.getSession_ID()==sessionID) {
        x.cancelSession();
                    System.out.println(x);
         exists=true;
            }
                    }
        if(exists==false){
                    System.out.println("Session number " + sessionID + " does not exist " );
                                }
      
                 break;
        
          case 7:
                    System.out.print("Enter the session ID: ");
          sessionID=input.nextInt();
            exists=false;
          for(BorrowSession x: BorrowList ){
          if(x.getSession_ID()==sessionID) {
                    System.out.print("Enter the loan period: ");
          int loanPeriodd =input.nextInt();
          x.processReturn(loanPeriodd);
          exists=true;
           }
               }
          if(exists==false){
                    System.out.println("Session number " + sessionID + " does not exist " ); 
                            }
                     break;
    
           case 8: 
           GUI.main(null);
                     break;

           case 9:
           ReadText rt = new ReadText();
           rt.openTextFile("borrowSession.txt");
           rt.readFromFile();
           rt.closeFile();
                      break;

           case 10:
           WriteText wf = new WriteText();
           wf.openTextFile("borrowSession.txt");
                        
                        
                   
            if (BorrowList.isEmpty()) {
                       System.out.println("No sessions yet.");
                        } else {
                            for (BorrowSession ele : BorrowList) {
                                wf.writeToFile(ele);
                            }
                        }
                        
                        
                        
                        
             wf.closeFile();
                        System.out.println("All sessions saved to the text file borrowSession.txt");
                        break;

             case 11://Exit
                        System.out.println("Thank you for using our system.\n Have a nice day.");
                             break;
            default:
                        System.out.println("Invalid Choice!");
                }
       
        }     catch(InputMismatchException ex){
            System.err.println("Invalid input ");
            input.nextLine();
        }     catch(NullPointerException ex){
            System.err.println(ex);
            input.nextLine();
        }     catch(ClassCastException  ex){
            System.err.println(ex);
            input.nextLine();
        }catch(ArrayIndexOutOfBoundsException ex){
            System.err.println(ex);
            input.nextLine();
        }catch(Exception ex){
            System.err.println(ex);
        }
        }while(choice!=12);    
        }
    
    public static void menu(){
        System.out.print("\n1. Add Item.\n"
                + "2. Remove Item.\n"
                + "3. Display Items.\n"
                + "4. Show AudioBook Items Only.\n"
                + "5. Borrow Order.\n"
                + "6. Cancel Order.\n"
                + "7. Return Items.\n"
                + "8. GUI.\n"
                + "9.Read From File.\n"
                + "10.Save Orders.\n"
                + "11.Exit.\n"
                + ">> ");
    }
        public static void fillList(ArrayList<BookCheckout> List) {
        itemList.add(new PhysicalBook (true, "Mike",2,"Programming","Java Programming Language",1234));
        itemList.add(new PhysicalBook (false,"Luna",1,"Art","What Is Art?",4321));
        itemList.add(new AudioBook("MP3","David Attenborough",30,"Alex",3, "Educational","The Power of Habit",9999));
        itemList.add(new Maps("Saudi Arabia Map",6,"Geography","",7654));
        itemList.add(new  DisscussionRoom("RM101", true));
        itemList.add(new  DisscussionRoom("RM102", false));
    }
}
    

    

 

