package FrameworkMIF;

public class Action {
	private String name;
	private Method method;
	
	
	public Action() { }
	
	public Action(String name, Method method) {
		this.name = name;
		this.method = method;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Method getMethod() {
		return method;
	}


	public void setMethod(Method method) {
		this.method = method;
	}
	
}
