package implementation;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import interfaces.ISorter;
import model.PersonName;

public class Sorter implements ISorter {

	@Override
	public List<PersonName> sortByLastNameAndGivenName(List<PersonName> names) {
		// TODO Auto-generated method stub
		
		if (!names.isEmpty()) {
			Collections.sort(names, Comparator
					.comparing(PersonName::getLastName)
					.thenComparing(PersonName::getGivenName));
		}
		return names;
		
	}
	
	

}
