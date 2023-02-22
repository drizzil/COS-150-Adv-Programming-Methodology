public class ParkingTicketSimulator
{
   public static void main(String[] args)
   {
      // Create a ParkedCar object.
      // The car was parked for 125 minutes.
      ParkedCar car = new ParkedCar("Nissan", "Datsun 240z", "Black", "SOMEDAY", 130);

      // Create a ParkingMeter object. 60 minutes were purchased.
      ParkingMeter meter = new ParkingMeter(90);

      // Create a PoliceOfficer object.
      PoliceOfficer officer = new PoliceOfficer("Derrick Halverson", "0001");

      // Let the officer patrol.
      ParkingTicket ticket = officer.patrol(car, meter);

      // Did the officer issue a ticket?
      if (ticket != null)
         System.out.println(ticket);
      else
         System.out.println("No crimes committed!");
   }
}