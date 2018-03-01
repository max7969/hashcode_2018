package hashcode;

import java.io.IOException;

import hashcode.computer.HashcodeDatasetComputer;
import hashcode.computer.TrainDatasetComputer;

public class HashCode {

	public static void train(String fileNameIn, String fileNameOut) throws IOException {
		TrainDatasetComputer trainDatasetComputer = new TrainDatasetComputer(fileNameIn, fileNameOut);
		trainDatasetComputer.read();
		trainDatasetComputer.compute();
		trainDatasetComputer.write();

	}

	public static void hashcode(String fileNameIn, String fileNameOut) throws IOException {
		HashcodeDatasetComputer hashcodeDatasetComputer = new HashcodeDatasetComputer(fileNameIn, fileNameOut);
		hashcodeDatasetComputer.read();
		hashcodeDatasetComputer.init();
		hashcodeDatasetComputer.compute();
		hashcodeDatasetComputer.write();
	}

	public static void main(String[] args) throws IOException {
		String basePath = new java.io.File(".").getCanonicalPath();

		hashcode(basePath + "/src/inputs/hashcode/a_example.in", basePath + "/src/outputs/hashcode/a_example.out");
		hashcode(basePath + "/src/inputs/hashcode/b_should_be_easy.in",
				basePath + "/src/outputs/hashcode/b_should_be_easy.out");
		hashcode(basePath + "/src/inputs/hashcode/c_no_hurry.in", basePath + "/src/outputs/hashcode/c_no_hurry.out");
		hashcode(basePath + "/src/inputs/hashcode/d_metropolis.in",
				basePath + "/src/outputs/hashcode/d_metropolis.out");
		hashcode(basePath + "/src/inputs/hashcode/e_high_bonus.in",
				basePath + "/src/outputs/hashcode/e_high_bonus.out");
	}
}
