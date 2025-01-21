public class Car extends Vehicle {
     String carModel;

    public Car(String registrationNumber, String ownerName, String carModel) {
        super(registrationNumber, ownerName);
        this.carModel = carModel;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car - Reg No: " + registrationNumber + ", Owner: " + ownerName + ", Model: " + carModel);
    }
}

