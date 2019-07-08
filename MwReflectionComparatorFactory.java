package umehTest;


import static umehTest.MwReflectionComparatorMode.LENIENT_DATES;
import static umehTest.MwReflectionComparatorMode.LENIENT_ORDER;
import static umehTest.MwReflectionComparatorMode.IGNORE_DEFAULTS;
import static umehTest.MwReflectionComparatorMode.IGNORE_PROPERTIES;

import static org.unitils.util.CollectionUtils.asSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.unitils.reflectionassert.ReflectionComparator;
import org.unitils.reflectionassert.ReflectionComparatorFactory;
import org.unitils.reflectionassert.ReflectionComparatorMode;
import org.unitils.reflectionassert.comparator.Comparator;
import org.unitils.reflectionassert.comparator.impl.LenientDatesComparator;

public class MwReflectionComparatorFactory extends ReflectionComparatorFactory {
	
	   public static ReflectionComparator createRefectionComparator(Map<String, Set<String>>toBeIgnoredFields,MwReflectionComparatorMode... modes) {
	        List<Comparator> comparators = getComparatorChain(asSet(modes),toBeIgnoredFields);
	        return new ReflectionComparator(comparators);
	    }


	    /**
	     * Creates a comparator chain for the given modes.
	     * If no mode is given, a strict comparator will be created. 
	     *
	     * @param modes The modes, null for strict comparison
	     * @param toBeIgnoredFields 
	     * @return The comparator chain, not null
	     */
	    protected static List<Comparator> getComparatorChain(Set<MwReflectionComparatorMode> modes, Map<String, Set<String>> toBeIgnoredFields) {
	        List<Comparator> comparatorChain = new ArrayList<Comparator>();
	        if (modes.contains(LENIENT_DATES)) {
	            comparatorChain.add(LENIENT_DATES_COMPARATOR);
	        }
	        if (modes.contains(IGNORE_DEFAULTS)) {
	            comparatorChain.add(IGNORE_DEFAULTS_COMPARATOR);
	        }
	        comparatorChain.add(LENIENT_NUMBER_COMPARATOR);
	        comparatorChain.add(SIMPLE_CASES_COMPARATOR);
	        if (modes.contains(LENIENT_ORDER)) {
	            comparatorChain.add(LENIENT_ORDER_COMPARATOR);
	        } else {
	            comparatorChain.add(COLLECTION_COMPARATOR);
	        }
	        comparatorChain.add(MAP_COMPARATOR);
	        comparatorChain.add(HIBERNATE_PROXY_COMPARATOR);
	        if(modes.contains(IGNORE_PROPERTIES))
	        {
	        	comparatorChain.add(new IgnorePropertiesComparator(toBeIgnoredFields));
	        }
	        comparatorChain.add(OBJECT_COMPARATOR);
	        return comparatorChain;
	    }
}
