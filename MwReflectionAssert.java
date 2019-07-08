package umehTest;

import static org.unitils.reflectionassert.ReflectionComparatorFactory.createRefectionComparator;

import java.util.Map;
import java.util.Set;

import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.reflectionassert.ReflectionComparator;
import org.unitils.reflectionassert.ReflectionComparatorMode;
import org.unitils.reflectionassert.difference.Difference;


import junit.framework.Assert;
import junit.framework.AssertionFailedError;

public class MwReflectionAssert extends ReflectionAssert {

	public static void assertReflectionEquals(Object expected, Object actual,Map<String,Set<String>>toBeIgnoredFieldNames,MwReflectionComparatorMode... comparatorModes ) throws AssertionFailedError{
		  ReflectionComparator reflectionComparator = MwReflectionComparatorFactory.createRefectionComparator(toBeIgnoredFieldNames,comparatorModes);
		  Difference difference = reflectionComparator.getDifference(expected, actual);
	        if (difference != null) {
	            Assert.fail(getFailureMessage(null, difference));
	        }
	}
}
