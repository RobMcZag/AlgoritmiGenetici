package com.rzagni.mastermind;

public enum ResultMarker {
	EMPTY("One wrong color independent of position"),	// Wrong color independent of position
	WHITE("One right color in wrong position"),	// Right color in wrong position
	BLACK("One right color in right position");	// Right color in right position
	
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

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.name() + " (" + this.ordinal() + ") is used to signal " + this.description;
	}
	
	
}
