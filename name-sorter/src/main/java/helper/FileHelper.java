package helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author shravya shetty
 * 
 * Helper Class for reading and writing to file
 *
 */
public class FileHelper {

	//read from file and store it in the list
	public List<String> readFromFile(String inputFile) {
		List<String> input = new ArrayList<String>();

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			String line;
			while ((line = reader.readLine()) != null) {
				input.add(line.trim());
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return input;
	}


	//write the sorted list to file
	public void writeToFile(List<String> output, String outputFile) {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
			for (String name : output) {
				writer.write(name);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}




