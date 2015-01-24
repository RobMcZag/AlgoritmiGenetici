package com.rzagni.mastermind;

public enum ResultMarker {
	BLACK("One right color in right position"),	// Right color in right position
	WHITE("One right color in wrong position"),	// Right color in wrong position
	EMPTY("One wrong color independent of position");	// Wrong color independent of position
	
	private final String description;
	
	private ResultMarker(String desc) {
		this.description = desc;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Counts the ResultMarkers of each type.
	 * @param result the result to count markers in;
	 * @return an array with the count for every Marker in their ordinal order;
	 */
	public static int[] countResultMarkers(ResultMarker[] result) {
		int[] count = new int[ResultMarker.values().length];
		for (ResultMarker resultMarker : result) {
			count[resultMarker.ordinal()]++;
		}
		return count;
	}
}
