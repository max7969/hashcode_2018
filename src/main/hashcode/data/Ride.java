package hashcode.data;

public class Ride {

	public long rowStart;
	public long columnStart;
	public long rowFinish;
	public long columnFinish;
	public long earliestStart;
	public long latestFinish;
	public long id;

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

}
