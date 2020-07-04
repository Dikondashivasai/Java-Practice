class person {
	String name;
	int age;

	void speak() {
		System.out.println("my name is" + name + "iam" + age
				+ "year so of old ");
	}

	int calcalateage() {
		int yearleft = 65 - age;
		return yearleft;

	}

	int getage() {
		return age;

	}

	String getname() {
		return name;
	}
}

public class app {

	public static void main(String[] args) {
		person person1 = new person();
		person1.name = " sai";
		person1.age = 26;
		person person2 = new person();
		person2.name = " shiva";
		person2.age = 25;
		person2.speak();
		int year = person2.calcalateage();
		System.out.println("yeartill:" + year);
		int age = person2.getage();
		String name = person2.getname();
		System.out.println("name is" + name);
		System.out.println("age is" + age);

	}
}
