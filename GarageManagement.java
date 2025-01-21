public class GarageManagement {
    public static void main(String[] args) {
        GarageImpl garage = new GarageImpl();

        Vehicle car = new Car("627633", "Alif", "Suzuki");
        Vehicle bike = new Bike("123456", "John", "Yamaha");

        garage.addVehicle(car);
        garage.addVehicle(bike);

        garage.displayVehicles();

        garage.removeVehicle("627633");
        garage.displayVehicles();
    }
}
