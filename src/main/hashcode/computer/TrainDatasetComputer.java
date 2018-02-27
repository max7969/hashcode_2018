package hashcode.computer;

import java.util.ArrayList;
import java.util.List;

public class TrainDatasetComputer extends AbstractDatasetComputer {

	// Global infos about dataset
	public int rowCount;
	public int columnCount;
	public int thresholdIngredientsPerSlice;
	public int maxCellPerSlice;

	public TrainDatasetComputer(String fileNameIn, String fileNameOut) {
		super(fileNameIn, fileNameOut);
	}

	private void readFirstLineInfo(String firstLine) {
		String[] parameters = firstLine.split(" ");
		rowCount = Integer.parseInt(parameters[0]);
		columnCount = Integer.parseInt(parameters[1]);
		thresholdIngredientsPerSlice = Integer.parseInt(parameters[2]);
		maxCellPerSlice = Integer.parseInt(parameters[3]);
	}

	@Override
	public void read() {
		readFirstLineInfo(this.lines.get(0));

	}

	@Override
	public List<String> getResultInLines() {
		List<String> result = new ArrayList<>();
		result.add(rowCount + ";" + columnCount + ";" + thresholdIngredientsPerSlice + ";" + maxCellPerSlice);
		return result;
	}

	@Override
	public void compute() {
		// On cree l'objet result
	}

}
