package sample;

public class SameNameAlreadyExistsException
	extends Exception{

	private String name;

	public SameNameAlreadyExistsException(String name) {
		super("同じ名前がすでに存在します：" + name);
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

