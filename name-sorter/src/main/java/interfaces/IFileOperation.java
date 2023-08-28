package interfaces;

import java.util.List;

import model.PersonName;

public interface IFileOperation {
	
	List<PersonName> readAndProcessUnsortedNames(String fileName);
	
	void writeSortedNames(List<PersonName> names, String filePath);
	
	

}
