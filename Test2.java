package umehTest;

import java.util.List;
import java.util.Map;

public class Test2 {

	private List<String> valueList;
	private Map<Integer,String> map;
	public List<String> getValueList() {
		return valueList;
	}
	public void setValueList(List<String> valueList) {
		this.valueList = valueList;
	}
	public Map<Integer, String> getMap() {
		return map;
	}
	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}
	public Test2(List<String> valueList, Map<Integer, String> map) {
		super();
		this.valueList = valueList;
		this.map = map;
	}
	
	
}
