
package implementation;
import java.util.ArrayList;
import java.util.List;

import helper.FileHelper;
import interfaces.IFileOperation;
import model.PersonName;

/**
 * 
 * @author shravya shetty
 * 
 * This contains the logic to store the name as the object with parameters given name and last name
 * Note - An interface can also be created if we have a different logic for segregating the names.
 */
public class FileOperation implements IFileOperation{

	FileHelper fileHelper;

	public FileOperation(FileHelper fileHelper) {
		this.fileHelper = fileHelper;
	}

	@Override
	public void writeSortedNames(List<PersonName> names, String outputFile) {
		List<String> outputNames = new ArrayList<>();
		if (!names.isEmpty()) {
			names.stream().forEach((name) -> outputNames.add(name.toString()));
		}
		fileHelper.writeToFile(outputNames, outputFile);

	}

	@Override
	public List<PersonName> readAndProcessUnsortedNames(String inputFile) {
		List<PersonName> names = new ArrayList<>();

		List<String> inputNames = fileHelper.readFromFile(inputFile);

		int lastIndex;
		String lastName, givenName;

		if (!inputNames.isEmpty()) {
			for (String name : inputNames) {
				lastIndex = name.lastIndexOf(" ");
				givenName = name.substring(0,lastIndex);
				lastName = name.substring(lastIndex + 1);
				names.add(new PersonName(givenName, lastName));
			}
		}
		return names;
	}
}

