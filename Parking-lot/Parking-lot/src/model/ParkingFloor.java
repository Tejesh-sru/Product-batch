import model.ParkingSlot;

public class ParkingFloor {
    List<ParkingSlot> slots;

    public ParkingFloor(){
        slots = new ArrayList<>();
    }
    public void addSlot(ParkingSlot slot) {
        slots.add(slot);
    }
}
