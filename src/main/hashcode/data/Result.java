package hashcode.data;

import java.util.List;

public class Result {

	public Vehicle vehicle;
	public List<Ride> rides;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(rides.size());
		for (Ride ride : rides) {
			builder.append(" ");
			builder.append(ride.id);
		}
		return super.toString();
	}
}
