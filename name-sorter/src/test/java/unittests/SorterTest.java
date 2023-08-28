package unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import implementation.Sorter;
import model.PersonName;

public class SorterTest {


	private Sorter sorter;

	@Before
	public void setUp() {
		sorter = new Sorter();
	}

	@Test
	public void testSortByLastNameAndGivenName() {

		List<PersonName> inputNames = new ArrayList<>();
		inputNames.add(new PersonName("Shalmi", "Shetty"));
		inputNames.add(new PersonName("Shravya Bhaskar", "Shetty"));
		inputNames.add(new PersonName("Viraj", "Hegde"));

		List<PersonName> expected = new ArrayList<>();
		expected.add(new PersonName("Viraj", "Hegde"));
		expected.add(new PersonName("Shalmi", "Shetty"));
		expected.add(new PersonName("Shravya Bhaskar", "Shetty"));

		List<PersonName> actual = sorter.sortByLastNameAndGivenName(inputNames);

		assertEquals (expected.size(),actual.size());

		for (int i = 0; i < actual.size(); i++) {
			PersonName expectedPerson = expected.get(i);
			PersonName actualPerson = actual.get(i);
			assertEquals(expectedPerson.getGivenName(), actualPerson.getGivenName());
			assertEquals(expectedPerson.getLastName(), actualPerson.getLastName());
		}  


	}

	@Test
	public void testEmptyList() {
		ArrayList<PersonName> names = new ArrayList<>();

		sorter.sortByLastNameAndGivenName(names);

		assertTrue(names.isEmpty());
	}

}
