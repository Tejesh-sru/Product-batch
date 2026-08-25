import model.Bike;
import model.Car;
import model.Truck;
import services.ParkingLotServices;
public class Main{
    public static void main(String[] args) {
    ParkingLotServices pls = new ParkingLotServices();
    Bike b1 =new Bike(number:"123",vehicleType:"Bike");
    Bike b2 =new Bike(number:"456",vehicleType:"Bike");
    Bike b3 =new Bike(number:"789",vehicleType:"Bike");
    Car c1 =new Car(number:"789",vehicleType:"Car"); 
    Car c2 =new Car(number:"456",vehicleType:"Car");
    Car c3 =new Car(number:"123",vehicleType:"Car");
    Truck t1 =new Truck(number:"123",vehicleType:"Truck");
    Truck t2 =new Truck(number:"456",vehicleType:"Truck");
    Truck t3 =new Truck(number:"789",vehicleType:"Truck");  

    System.out.println(pls.parkvehicle(b1)?"Vehicle parked successfully":"Failed to park vehicle");
    }
}