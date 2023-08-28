package unittests;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import helper.FileHelper;
import implementation.FileOperation;
import model.PersonName;


public class FileOpertionTest {

	@Mock
	private FileHelper fileHelperMock;

	@InjectMocks
	private FileOperation fileOperation;


	@Before
	public void initService() {
		fileHelperMock = mock(FileHelper.class);
		fileOperation = new FileOperation(fileHelperMock);
	}

	@Test
	public void testReadNamesFromFileContainsGivenNameAndLastName() {
		// Arrange
		String filePath = "\\\\Test1.txt";

		List<String> inputNames = new ArrayList<>();

		// Adding strings to the list
		inputNames.add("Shravya Bhaskar Shetty");
		inputNames.add("Shalmi Shetty");

		List<PersonName> expected = new ArrayList<>();
		expected.add(new PersonName("Shravya Bhaskar", "Shetty"));
		expected.add(new PersonName("Shalmi", "Shetty"));

		when(fileHelperMock.readFromFile(filePath)).thenReturn(inputNames);

		// Act
		List<PersonName> actual = fileOperation.readAndProcessUnsortedNames(filePath);
		

		// Assert
		for (int i = 0; i < actual.size(); i++) {
			PersonName expectedPerson = expected.get(i);
			PersonName actualPerson = actual.get(i);
			assertEquals(expectedPerson.getGivenName(), actualPerson.getGivenName());
			assertEquals(expectedPerson.getLastName(), actualPerson.getLastName());
		}

		verify(fileHelperMock, times(1)).readFromFile(filePath);
	}

	@Test
	public void testWriteNamesToFileContainsGivenNameAndLastName() {
		// Arrange
		String filePath = "\\\\Test2.txt";
		List<String> outputNames = new ArrayList<>();
		outputNames.add("Shravya Bhaskar Shetty");
		outputNames.add("Shalmi Shetty");

		List<PersonName> names = new ArrayList<>();
		names.add(new PersonName("Shravya Bhaskar", "Shetty"));
		names.add(new PersonName("Shalmi", "Shetty"));
		
		doNothing().when(fileHelperMock).writeToFile(outputNames,filePath);

		// Act
		fileOperation.writeSortedNames(names, filePath);

		// Assert
		verify(fileHelperMock, times(1)).writeToFile(outputNames, filePath);
	}
	
}
