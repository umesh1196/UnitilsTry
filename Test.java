package umehTest;

public class Test {

	private String val ;
	private String name;
	private Test2 obj;
	public Test(String val, String name, Test2 obj) {
		super();
		this.val = val;
		this.name = name;
		this.obj = obj;
	}
	public Test2 getObj() {
		return obj;
	}
	public void setObj(Test2 obj) {
		this.obj = obj;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Test(String val, String name) {
		super();
		this.val = val;
		this.name = name;
	}
	
}
