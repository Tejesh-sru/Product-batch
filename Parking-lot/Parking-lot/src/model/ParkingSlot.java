package model;

public class ParkingSlot {
   List<vehicle> vehicles;
//    6 slots for 6 vechiles 2 for car,2 for bike, 2 for truck
   public ParkingSlot() {
       vehicles = new ArrayList<>();
   }
   public void addVehicle(vehicle v) {
       vehicles.add(v);
   }
   public void removeVehicle(vehicle v) {
       vehicles.remove(v);
   }
   public List<vehicle> getVehicles() {
       return vehicles;
   }
}
