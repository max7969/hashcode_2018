package hashcode.data;

import hashcode.utils.DistUtils;

public class Ride {

	public long rowStart;
	public long columnStart;
	public long rowFinish;
	public long columnFinish;
	public long earliestStart;
	public long latestFinish;
	public long id;

	public long score;

	public Ride(long rowStart, long columnStart, long rowFinish, long columnFinish, long earliestStart,
			long latestFinish, long id) {
		super();
		this.rowStart = rowStart;
		this.columnStart = columnStart;
		this.rowFinish = rowFinish;
		this.columnFinish = columnFinish;
		this.earliestStart = earliestStart;
		this.latestFinish = latestFinish;
		this.id = id;
	}

	public void computeScore(Vehicle vehicle) {
		long distFromRide = DistUtils.getDist(rowStart, columnStart, vehicle.row, vehicle.column);

		long virtualNextStepAvailable = distFromRide
				+ DistUtils.getDist(rowStart, columnStart, rowFinish, columnFinish);

		if (virtualNextStepAvailable > latestFinish) {
			this.score = 100000000;
		} else {
			this.score = Math.abs(earliestStart - (virtualNextStepAvailable + vehicle.nextStepAvailable));
		}

	}
}
