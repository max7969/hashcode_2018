package hashcode.computer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hashcode.data.Result;
import hashcode.data.Ride;
import hashcode.data.Vehicle;

public class HashcodeDatasetComputer extends AbstractDatasetComputer {

	public long rowCount;
	public long columnCount;
	public int vehicleCount;
	public long numberOfRide;
	public long bonus;
	public long stepNumber;

	// Objets utiles
	public List<Ride> rides = new ArrayList<>();
	public List<Vehicle> vehicles = new ArrayList<>();

	// Solution
	List<Result> results = new ArrayList<>();

	public HashcodeDatasetComputer(String fileNameIn, String fileNameOut) {
		super(fileNameIn, fileNameOut);
	}

	@Override
	public void read() {
		readFirstLine();
		readRides();
	}

	public void init() {
		for (long i = 0; i < vehicleCount; i++) {
			vehicles.add(new Vehicle(i, 0, 0));
		}
	}

	public void readFirstLine() {
		String[] parameters = lines.get(0).split(" ");
		rowCount = Long.parseLong(parameters[0]);
		columnCount = Long.parseLong(parameters[1]);
		vehicleCount = Integer.parseInt(parameters[2]);
		numberOfRide = Long.parseLong(parameters[3]);
		bonus = Long.parseLong(parameters[4]);
		stepNumber = Long.parseLong(parameters[5]);
	}

	public void readRides() {
		lines.remove(0);
		long id = 0;
		for (String line : lines) {
			String[] rideParameters = line.split(" ");
			rides.add(new Ride(Long.parseLong(rideParameters[0]), Long.parseLong(rideParameters[1]),
					Long.parseLong(rideParameters[2]), Long.parseLong(rideParameters[3]),
					Long.parseLong(rideParameters[4]), Long.parseLong(rideParameters[5]), id++));
		}
	}

	@Override
	public void compute() {
		computeSimple();
	}

	public void computeSimple() {
		int count = 0;
		for (Ride ride : rides) {
			vehicles.get(count % vehicles.size()).ridesAssigned.add(ride);
			count++;
		}
	}

	@Override
	public List<String> getResultInLines() {
		return vehicles.stream().map(vehicle -> vehicle.toString()).collect(Collectors.toList());
	}
}
