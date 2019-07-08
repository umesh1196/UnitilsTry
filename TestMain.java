package umehTest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.reflectionassert.ReflectionComparatorMode;

public class TestMain {

	public static void main(String args[]) throws NoSuchFieldException, SecurityException
	{
		final Double id = 25.00;
		List<String> tempList = new ArrayList<String>();
		tempList.add("123");
		tempList.add("456");
		Map<Integer,String> tempMap = new HashMap<Integer,String>();
		tempMap.put(1, "umesh");
		Test2 t21 = new Test2(tempList,tempMap);
		List<String> tempList2 = new ArrayList<String>(tempList);
		tempList2.add("789");
		Test2 t22 = new Test2(tempList2,tempMap);
		Test t1 = new Test("val1","name1",t21);
		Test t2 = new Test("val1","name2",t22);
		//ReflectionAssert.assertReflectionEquals(t1,t2,ReflectionComparatorMode.LENIENT_ORDER);
		Field[] field = Test.class.getDeclaredFields();
		//System.out.println(Test.class.getDeclaredField("name").getName());
		Set<Field> toBeIgnoreeFields = new HashSet<Field>();
		toBeIgnoreeFields.add(Test.class.getDeclaredField("name"));
		toBeIgnoreeFields.add(Test2.class.getDeclaredField("valueList"));
		Map<String,Set<String>> classNameToIgnoredFields = new HashMap<String,Set<String>>();
		Set<String> testClassIgnoredFields = new HashSet<String>();
		testClassIgnoredFields.add("name");
		classNameToIgnoredFields.put(Test.class.getName(),testClassIgnoredFields );
		Set<String> test2ClassIgnoredFields = new HashSet<String>();
		test2ClassIgnoredFields.add("valueList");
		classNameToIgnoredFields.put(Test2.class.getName(),test2ClassIgnoredFields);
		//ReflectionAssert.assertReflectionEquals(t1,t2,ReflectionComparatorMode.LENIENT_ORDER);
		MwReflectionAssert.assertReflectionEquals(t1, t2, classNameToIgnoredFields, MwReflectionComparatorMode.LENIENT_ORDER,MwReflectionComparatorMode.IGNORE_PROPERTIES);
		//MwReflectionAssert.assertReflectionEquals(t1, t2, ReflectionComparatorMode.LENIENT_ORDER);
	}
	
}
