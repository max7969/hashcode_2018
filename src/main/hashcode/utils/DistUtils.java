package hashcode.utils;

public class DistUtils {

	public static long getDist(long x, long y, long a, long b) {
		return Math.abs(x - a) + Math.abs(y - b);
	}
}
