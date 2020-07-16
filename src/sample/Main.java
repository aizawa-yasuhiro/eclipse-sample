package sample;

public class Main {

    // Git test
	public static void main(String[] args) {
		 AttendanceService service = new AttendanceService();

        //参加者追加
		try {
			service.addPerson(new Person("大橋", true));
			service.addPerson(new Person("田中", false));
			service.addPerson(new Person("佐藤", true));
			service.addPerson(new Person("田中", false));
		}catch(SameNameAlreadyExistsException e) {
			System.out.println("「"+ e.getName()+"」はすでに使われているため登録できません。");
		}


		//イベント取得
		Event event = service.getEvent();

		//表示
		for (Person person : event.getPersonList()) {

			if (person.isOk()){
				System.out.print("○");
			}else {
				System.out.print("×");
			}

			System.out.println(person.getName());
		}

		int total = event.getTotal();
		if (total > 0) {
			System.out.println("---------------");
			System.out.println("合計" + total + "人");
			System.out.println("参加" + event.calcOkCount() + "人");
			System.out.println("参加率" + event.calcPercentage() + "%");
		}else {
			System.out.println("登録データがありません");
		}
	}

}
