
package pkg3_2i2_townlibrarysystem;

public class DisscussionRoom implements BookCheckout {
    
    private String roomID;
    private boolean bookingStatus;

    public DisscussionRoom(String roomID, boolean bookingStatus) {
        this.roomID = roomID;
        this.bookingStatus = bookingStatus;
    }

    public DisscussionRoom() {
        
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public boolean isBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(boolean bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    
    @Override
   public final boolean Availability(){
       if (isBookingStatus())
           return false;
       else 
           return true;
   }
   
   @Override
   public final void checkOut(){
       if(Availability()){
           System.out.println("you booked this room");
           this.bookingStatus=true;
       }else {
           System.out.println("the room is not available");
       }
   }
   
    @Override
   public final void checkIn(){
       this.bookingStatus=false;
        System.out.println("hope you enjoyed your room come back soon");
   }

    @Override
    public String toString() {
        return " Room ID: " + roomID + "\n BookingStatus: " + bookingStatus ;
    }
    
   
}