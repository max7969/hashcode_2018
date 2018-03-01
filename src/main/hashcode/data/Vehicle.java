package hashcode.data;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {

	public long id;
	public long row;
	public long column;
	public List<Ride> ridesAssigned = new ArrayList<>();

	public Vehicle(long id, long row, long column) {
		super();
		this.id = id;
		this.row = row;
		this.column = column;
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
}
