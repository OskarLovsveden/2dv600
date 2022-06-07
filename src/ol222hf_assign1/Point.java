/*
* Date: 2021-09-08.
* File Name: Point.Java
* Author: Oskar Lövsveden
*/

package ol222hf_assign1;

/**
 * Class Description: Represent a point containing a x and y value.
 * 
 * @version 1 08 Sept 2021
 * @author Oskar Lövsveden
 */
public class Point {
    private int x;
    private int y;

    /** Default constructor. */
    public Point() {
        this(0, 0);
    }

    /**
     * Constructur with values for x and y.
     * 
     * @param x An int to set as the x value.
     * @param y An int to set as the y value.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Check if two points are equal to eachother, i.e same location.
     * 
     * @param p A Point to compare against.
     * @return true if both points' x and y locations are equal, otherwise false.
     */
    public boolean isEqualTo(Point p) {
        return (this.x == p.x && this.y == p.y);
    }

    /**
     * Distance between two points.
     * 
     * @param p A Point to compare against.
     * @return A double representing the distance between the two points.
     */
    public double distanceTo(Point p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    /**
     * Move the point a set amount from its current location.
     * 
     * @param x An int representing the amount to move the x.
     * @param y An int representing the amount to move the y.
     */
    public void move(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    /**
     * Move the point to a new location.
     * 
     * @param x An int representing the new x location.
     * @param y An int representing the new y location.
     */
    public void moveToXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** Returns a string with coordinates suitable for print-outs. */
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
