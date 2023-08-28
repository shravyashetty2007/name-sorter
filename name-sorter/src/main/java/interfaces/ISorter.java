package interfaces;
import java.util.List;

import model.PersonName;

public interface ISorter {
	
	List<PersonName> sortByLastNameAndGivenName(List<PersonName> person);

}
