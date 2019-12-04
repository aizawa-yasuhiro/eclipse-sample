package sample;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {

	private List<Person> personList = new ArrayList<Person>();

	public void addPerson(Person newPerson)
		throws SameNameAlreadyExistsException{
		for (Person person : personList) {
			if(person.getName().equals(newPerson.getName())){
				throw new SameNameAlreadyExistsException(person.getName());
			}
		}
		personList.add(newPerson);
	}

	public Event getEvent(){
		return new Event(personList);
	}

}
