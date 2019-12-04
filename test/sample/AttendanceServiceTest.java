package sample;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AttendanceServiceTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();


	private AttendanceService service;

	@Before
	public void setUp() {
		service = new AttendanceService();

	}

	@Test
	public void testAddPerson_3Person() throws Exception {

		service.addPerson(new Person("大橋", true));
		service.addPerson(new Person("田中", false));
		service.addPerson(new Person("佐藤", true));

		Event event = service.getEvent();

		List<Person> personList = event.getPersonList();
		assertThat(personList.size(), is(3));

		assertThat(personList.get(0).getName(),is("大橋"));
		assertThat(personList.get(0).isOk(),is(true));
		assertThat(personList.get(0).getName(),is("田中"));
		assertThat(personList.get(0).isOk(),is(false));
		assertThat(personList.get(0).getName(),is("佐藤"));
		assertThat(personList.get(0).isOk(),is(true));
	}

	@Test
	public void testAddPerson_noPerson() throws Exception {

		Event event = service.getEvent();
		List<Person> personList = event.getPersonList();

		assertThat(personList.size(),is(0));
	}

	@Test
	public void testAddPerson_duplicateName() throws Exception{
		expectedException.expect(SameNameAlreadyExistsException.class);
		expectedException.expectMessage("同じ名前がすでに存在します；田中");

		service.addPerson(new Person("大橋", true));
		service.addPerson(new Person("田中", false));
		service.addPerson(new Person("佐藤", true));
		service.addPerson(new Person("田中", true));
	}

}
