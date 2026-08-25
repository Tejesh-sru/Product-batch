package model;

public class vehicle {
private String number;
private String vehicleType;
vehicle(String number, String vehicleType){
    this.number = number;
    this.vehicleType = vehicleType;
    
}
public String getNumber() {
    return number;
}
public void setNumber(String number) {
    this.number = number;
}
public String getVehicleType() {
    return vehicleType;
}
public void setVehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
}


}
