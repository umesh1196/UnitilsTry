package umehTest;

public enum MwReflectionComparatorMode{

	  /**
     * Ignore fields that do not have a default value for the left-hand (expected) side
     */
    IGNORE_DEFAULTS,

    /**
     * Do not compare the actual time/date value, just that both left-hand (expected) and right-hand side are null or not null.
     */
    LENIENT_DATES,

    /**
     * Do not compare the order of collections and arrays. Only check that all values of the left-hand (expected) side
     * collection or array are also contained in the right-hand (actual) side and vice versa.
     */
    LENIENT_ORDER,

	IGNORE_PROPERTIES;
}
