package hashcode.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import hashcode.utils.DistUtils;

public class Vehicle {

	public long id;
	public long row;
	public long column;
	public long nextStepAvailable;
	public List<Ride> ridesAssigned = new ArrayList<>();

	public Vehicle(long id, long row, long column) {
		super();
		this.id = id;
		this.row = row;
		this.column = column;
		this.nextStepAvailable = 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(ridesAssigned.size());
		for (Ride ride : ridesAssigned) {
			builder.append(" ");
			builder.append(ride.id);
		}
		return builder.toString();
	}

	public Ride getBetterRide(List<Ride> rides) {
		rides.stream().forEach(ride -> ride.computeScore(this));
		return rides.stream().min(new Comparator<Ride>() {
			@Override
			public int compare(Ride o1, Ride o2) {
				return (int) (o1.score - o2.score);
			}
		}).get();
	}

	public void addNewRide(Ride ride) {
		ridesAssigned.add(ride);
		this.row = ride.rowFinish;
		this.column = ride.columnFinish;
		this.nextStepAvailable = this.nextStepAvailable
				+ DistUtils.getDist(row, column, ride.rowStart, ride.columnStart)
				+ DistUtils.getDist(ride.rowStart, ride.columnStart, ride.rowFinish, ride.columnFinish);
	}
}
