package hashcode;

import java.io.IOException;

import hashcode.computer.TrainDatasetComputer;

public class HashCode {

	public static void train(String fileNameIn, String fileNameOut) throws IOException {
		TrainDatasetComputer trainDatasetComputer = new TrainDatasetComputer(fileNameIn, fileNameOut);
		trainDatasetComputer.read();
		trainDatasetComputer.compute();
		trainDatasetComputer.write();

	}

	public static void hashcode(String fileNameIn, String fileNameOut) {

	}

	public static void main(String[] args) throws IOException {
		String basePath = new java.io.File(".").getCanonicalPath();

		train(basePath + "/src/inputs/training/example.in", basePath + "/src/outputs/training/example.out");
	}
}
