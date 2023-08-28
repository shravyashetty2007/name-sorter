
import java.util.List;

import helper.FileHelper;
import implementation.FileOperation;
import implementation.Sorter;
import interfaces.IFileOperation;
import interfaces.ISorter;
import model.PersonName;
/**
 * 
 * @author shravya shetty
 *
 * This is the main class that calls the file reader, sorter and file writer methods
 * The input file name is read from the command line arguments
 */
public class NameSorter {



	public static void main(String[] args) {

		if (args.length < 1) {
			System.out.println("Input file name is required");
			return;
		}

		final String inputFile = args[0];
		final String outputFile = "sorted-names-list.txt"; // this can be stored in constant file and read from there

		IFileOperation fileOperation = new FileOperation(new FileHelper());
		ISorter sorter = new Sorter();

		List<PersonName> inputNames = fileOperation.readAndProcessUnsortedNames(inputFile);

		List<PersonName> sortedNames = sorter.sortByLastNameAndGivenName(inputNames);

		for (PersonName name : sortedNames) {
			System.out.println(name.toString());
		}

		fileOperation.writeSortedNames(sortedNames,outputFile);

	}

}



