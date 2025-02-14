import java.util.*;
class rooms{
   int roomnumb;
   boolean RoomsAvailablility;
   String type;
   double price;

   public rooms( int roomnumb,boolean RoomsAvailablility,String type,double price){
       this.roomnumb=roomnumb;
       this.type=type;
       this.RoomsAvailablility=RoomsAvailablility;
       this.price=price;
   }

   public int getroomnumb(){
       return roomnumb;
   }
   public String gettype(){
       return type;
   }
   public double getprice(){
       return price;
   }
   public boolean RoomsAvailablility(){
       return RoomsAvailablility;
    }
   public void setUnAvailable(){
       RoomsAvailablility=false;
   }

}
class Reservation{
   int roomId;
   String Customername;
   int numbofnights;
   double totalprice=0;
   //rooms r;

   public Reservation(String Customername,int numbofnights,rooms r) {
       this.Customername=Customername;
       this.numbofnights=numbofnights;
       this.totalprice=((r.getprice())*numbofnights);
       this.roomId=r.getroomnumb();
       r.setUnAvailable();
   }
   public int getroomId() {
       return roomId;
   }
   public String getCustomername(){
       return Customername;
   }
   public int getNumbofnights() {
       return numbofnights;
   }
   public double getTotalprice() {
       return totalprice;
   } 
}
class Confirmation{
   
   ArrayList<rooms> RoomArrayList=new ArrayList<>();
   ArrayList<Reservation> reservationsArrayList=new ArrayList<>();
   rooms r1=new rooms(111,true,"1Bedroom",2000);
   rooms r2=new rooms(222,true,"2Bedrooms",3000);
   rooms r3= new rooms(333,true,"3Bedroom",4000);
   rooms r4=new rooms(444,true,"4Bedroom",5000);
   void roomsInitialize(){
   RoomArrayList.add(r1);
   RoomArrayList.add(r2);
   RoomArrayList.add(r3);
   RoomArrayList.add(r4);
   }
   void availableRooms(){ 
       System.out.println("|roomno.|price |capacity");
   for(rooms r:RoomArrayList){
       if(r.RoomsAvailablility()){
           System.out.println("| "+r.getroomnumb()+"   | "+r.getprice()+"| "+r.gettype());
       }
   }
}
   void enteringBookingdetails(String CustomerName,int numbofnights,int roomId){
       for(rooms r:RoomArrayList){
           if(r.RoomsAvailablility() && r.getroomnumb()==roomId ){
               Reservation c1=new Reservation(CustomerName, numbofnights, r);
               reservationsArrayList.add(c1);
               System.out.println("Your reservation is Successfull!!");
               System.out.println(c1.getroomId()+ "   is your room Identification number");
              return;
           }
       }
      System.out.println("Invalid room");
   }

   void displayDetails(int roomId){
       for(Reservation r: reservationsArrayList){
           if(r.getroomId()==roomId){
           System.out.println("Booking ID: "+r.getroomId());
           System.out.println("Customer name: "+r.getCustomername());
           System.out.println("Number of nights: "+r.getNumbofnights());
           System.out.println("Total price $"+r.getTotalprice());
       }
   }
}
}

public class HotelReservationSystem{
   public static void main(String args[]){
       Confirmation obj1=new Confirmation();
       System.out.println("Welcome to our hotel..");
       System.out.println("Please read the options below..");
       obj1.roomsInitialize();
   while (true) {
           System.out.println("Enter your Option: ");
           System.out.println("1. For Available rooms");
           System.out.println("2. Make a reservation");
           System.out.println("3. For reservation details");
           System.out.println("4. Quit");        
           Scanner s=new Scanner(System.in);
          int choice =s.nextInt();
       switch(choice){
       case 1:
       obj1.availableRooms();
       break;
       case 2:
       System.out.print("Enter your  name: ");
       String CustomerName=s.next();
       System.out.print("Enter no. of nights you want to stay: ");
       int numbofnights=s.nextInt();
       System.out.print("Enter your room number: ");
       int roomId=s.nextInt();
       obj1.enteringBookingdetails(CustomerName,numbofnights,roomId);
         break;
       case 3:
          System.out.println("Details are:");
          System.out.print("Enter room id:");
          int roomIdTodisplay=s.nextInt();
          obj1.displayDetails(roomIdTodisplay);
          break;
       case 4:
          System.out.println("Exit.");
          System.out.println("Thankyou for Booking a room in our Hotel!!");
          System.exit(0);
          s.close();
          break;
       default:
          System.out.println("Invalid choice");
          break;
}
}
}
}