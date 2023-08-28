package model;

/**
 * 
 * @author shravya shetty
 * @date 25-08-2022
 * 
 * This is a model class that holds the persons attributes
 *
 */
public class PersonName {
	
	private String givenName;
    private String lastName;

    public PersonName(String givenName, String lastName) {
        this.givenName = givenName;
        this.lastName = lastName;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return givenName + " " + lastName;
    }

}
