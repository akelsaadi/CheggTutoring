import java.text.DecimalFormat;
public class SmartCard_Driver
{
   public static void main(String[] args) 
   {
      Station downtown = new Station("Downtown", 1);
      Station center = new Station("Center City", 1);
      Station uptown = new Station("Uptown", 2);
      Station suburbia = new Station("Suburb", 4);
     
      SmartCard jimmy = new SmartCard(20.00); //bought with $20.00 
      jimmy.board(center);            		    //boarded in zone 1
      jimmy.disembark(suburbia);					 //disembark in zone 4
      jimmy.disembark(uptown);					 //disembark without having boarded
   	
   	//lots more test cases!				
   }
}

class SmartCard 
   {
      private static DecimalFormat df = new DecimalFormat("$0.00");
      private static double MIN_FARE = 0.5;
      double moneyRemaining;
      Station boardedAt = null;
      boolean isOnBoard = false;
      
      //constructor
      public SmartCard()
      {
         moneyRemaining = 0.0;
      }
      public SmartCard(double money)
      {
         moneyRemaining = money;
      }

      public void addMoney( double amount )
      {
         moneyRemaining += amount;
      }
      public double moneyOnCard()
      {
         return moneyRemaining;
      }
      public boolean onBoardStatus()
      {
         return isOnBoard;
      }

      public void board( Station station )
      {
         if(isOnBoard)
         {
            System.out.println("Please see the station manager!");
         }
         else if(moneyRemaining < MIN_FARE)
         {	
            System.out.println("Please add more money");

         }
         System.out.println("Boarded at: " + station);
         boardedAt = station;
         isOnBoard = true;
      }
     
      public double cost(Station station)
      {

         double zoneTraveled = Math.abs(boardedAt.getZone() - station.getZone());
         return .50 + .75 * zoneTraveled;
      }	
      

      public void disembark(Station station)
      {
         if(!isOnBoard)
         {
            System.out.println("Please see the station manager!");
            //System.exit(0);
         }
         else
         {
            double cost = cost(station);
            moneyRemaining -= cost;
            isOnBoard = false;  
            System.out.print("From " + boardedAt.getName() + " to " + 
            station.getName() + " costs " + df.format(cost)+"."  );
            System.out.println("  Balance "+ df.format(moneyRemaining));
         }
      }
   }
   class Station
   {
      String stationName;
      int zone;
      public Station(String name, int zone)
      {
         stationName = name;
         this.zone = zone;
      }
      public int getZone()
      {
         return zone;
      }
      public String getName()
      {
         return stationName;
      }
      public String toString()
      {
         return stationName;
      }
   }

 