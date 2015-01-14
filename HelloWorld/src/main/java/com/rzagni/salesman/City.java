package com.rzagni.salesman;

/**
 * A basic city implementation, holding just the city coordinates 
 * @author Roberto
 *
 */
public class City {
	private int x, y;

	public City() {
		this(200);
	}
	public City(int maxDist) {
		this((int)(Math.random()*maxDist), (int)(Math.random()*maxDist));
	}

	public City(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	public double distance(City c) {
		int xDist = c.getX() - this.getX();
		int yDist = c.getY() - this.getY();
		double dist = Math.sqrt(xDist*xDist + yDist*yDist);
		return dist;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getX() + ", " + getY();
	}
	
	

}
