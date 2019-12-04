package sample;

import java.util.List;

public class Event {

	private List<Person> personList;

	public Event(List<Person> personList) {
		this.personList = personList;
	}

	public List<Person> getPersonList(){
		return personList;
	}

	public int getTotal() {
		return personList.size();
	}

	public int calcOkCount() {
		int okCount = 0;
		for (Person person : personList) {

			if (person.isOk()){
				okCount++;
			}
		}
		return okCount;
	}

	public int calcPercentage() {
		int percentage = 0;
		int total = getTotal();
		if (total > 0) {
			percentage = calcOkCount() * 100 / total;
		}
		return percentage;
	}

}
