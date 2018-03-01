package hashcode.computer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDatasetComputer {

	// Input file in lines
	protected List<String> lines;

	// Output file
	private File output;

	public AbstractDatasetComputer(String fileNameIn, String fileNameOut) {
		try {
			this.lines = Files.lines(Paths.get(fileNameIn)).collect(Collectors.toList());
			output = new File(fileNameOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract void read();

	public abstract void compute();

	public abstract List<String> getResultInLines();

	public void write() throws IOException {
		FileWriter fileWriter = new FileWriter(this.output);
		List<String> lines = getResultInLines();
		for (String line : lines) {
			fileWriter.write(line + "\n");
		}
		fileWriter.close();
	}
}
