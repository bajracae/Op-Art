
/**
 * Address every point in the plane
 * 
 * @author (Aeijan Bajracharya && Jinwon Kim) 
 * @version (12/15/16)
 */
public class Point
{
    private int x;
    private int y;

    /**
     * Creates x-coordinate.
     * Creates y-coordinate.
     * 
     */
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of this point.
     * @return the x-coordinate.
     */
    public int getX(){
        return x;
    }

    /**
     * Returns the y-coordinate of this point.
     * @return the y-coordinate.
     */
    public int getY(){
        return y;
    }

    /**
     * Measures the distance between two points.
     * 
     */
    
    public double getDistance(Point other){
        int dX = other.getX() - getX();
        int dY = other.getY() - getY();
        return Math.sqrt((dY*dY) + (dX*dX));
    }

     /**
     * Calculates the slope of the line produced by two points.
     * 
     */
    public double slope(Point other){
        double rise = getY() - other.getY();
        double run = getX() - other.getX();
        if (run!=0){
            return rise/run;
        }
        else{
            return Double.NaN;
        }
    }
}