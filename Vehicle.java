public abstract class Vehicle {
    protected String registrationNumber;
    protected String ownerName;

    public Vehicle(String registrationNumber, String ownerName) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
    }

    public abstract void displayDetails();
}
