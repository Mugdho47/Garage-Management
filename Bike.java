public class Bike extends Vehicle {
    String bikeModel;

    public Bike(String registrationNumber, String ownerName, String bikeModel) {
        super(registrationNumber, ownerName);
        this.bikeModel = bikeModel;
    }

    @Override
    public void displayDetails() {
        System.out.println("Bike - Reg No: " + registrationNumber + ", Owner: " + ownerName + ", Model: " + bikeModel);
    }
}

