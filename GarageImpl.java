import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GarageImpl implements Garage {
    private List<Vehicle> vehicles;
    private String filePath;

    public GarageImpl() {
        vehicles = new ArrayList<>();
        filePath = "garage.txt";
        loadVehiclesFromFile();
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        saveVehiclesToFile();
    }

    @Override
    public void removeVehicle(String registrationNumber) {
        vehicles.removeIf(vehicle -> vehicle.registrationNumber.equals(registrationNumber));
        saveVehiclesToFile();
    }

    @Override
    public void displayVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
        }
    }

    private void loadVehiclesFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String type = parts[0].trim();
                    String regNo = parts[1].trim();
                    String owner = parts[2].trim();
                    String model = parts[3].trim();

                    if (type.equalsIgnoreCase("Car")) {
                        vehicles.add(new Car(regNo, owner, model));
                    } else if (type.equalsIgnoreCase("Bike")) {
                        vehicles.add(new Bike(regNo, owner, model));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    private void saveVehiclesToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof Car) {
                    Car car = (Car) vehicle;
                    bw.write("Car," + car.registrationNumber + "," + car.ownerName + "," + car.carModel);
                } else if (vehicle instanceof Bike) {
                    Bike bike = (Bike) vehicle;
                    bw.write("Bike," + bike.registrationNumber + "," + bike.ownerName + "," + bike.bikeModel);
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
