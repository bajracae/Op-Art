import java.awt.Color;
/**
 * Our cartestian plane on which to draw.
 * 
 * @author (Aeijan Bajracharya && Jinwon Kim)
 * @version 12/15/16
 */
public class PlaneRunner{
    private Canvas plane;
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;
    private static final int DEFAULT_POINT_SIZE = 10;
    private Point origin;

    /**
     * Creates the background color of the canvas
     * 
     */public PlaneRunner(){
        Color bg = new Color(105,0, 255);
        plane = new Canvas("Jinwon" , WIDTH, HEIGHT , bg);
        plane.setVisible(true);

    }

    
    /**
     * runs the axes method from Canvas
     * 
     */
    public void testaxes(){
        plane.axes();
    }

    /** 
     * runs the plotPoint method from Canvas
     * @param p The point to plot
     */
    public void testplotPoint(Point p){
        plane.plotPoint(p,DEFAULT_POINT_SIZE);

    }

    /**
     * runs the plotPoint method from Canvas
     * 
     */
    public void testplotPoint(){
        //below is 2a
        //plane.plotPoint(new Point(-200, 150), 10);
        //plane.plotPoint(new Point(200, 150), 10);
        //plane.plotPoint(new Point(-200, -150), 10);
        //plane.plotPoint(new Point(200, -150), 10);

        //below is 2b
        //plane.plotPoint(new Point(100,300), 30);
        //plane.plotPoint(new Point(-100,300), 10);
        //plane.plotPoint(new Point(100,-300), 15);
        //plane.plotPoint(new Point(-100,-300), 20);
    }

    /**
     * runs the plotRandom method from Canvas
     * 
     */
    public void testplotRandom(){
        for(int i = 0; i < 20; i++){
            plane.plotRandom();    
        }

    }

    /**
     * runs the randomCoord method from Canvas
     * 
     */
    public void testrandomCoord(){
        for(int i = 0; i < 20; i++){
            plane.randomCoord();
        }
    }

    /**
     * runs the randomPoint method from Canvas
     * 
     */
    public void testrandomPoint(){
        for(int i = 0; i < 20; i++){
            plane.plotPoint(plane.randomPoint());
        }
    }

    /**
     * runs the safetyMap method
     * draws the safetyMap
     */
    public static void testsafetyMap(){
        Canvas safetyMap = new Canvas("Safety Map", 600, 600);
        safetyMap.setVisible(true);
        safetyMap.safetyMap(new Point(0, 0), 10000);
    }

    /** 
     * plots points at the listed coordinates
     */
    public void test(){
        Point p1 = new Point(300,100);
        Point p2 = new Point(200,300);
        plane.plotPoint(p1);
        plane.plotPoint(p2);

    }

    /**
     * draws a line from the particular coordinate to another
     * 
     */
    public void testLines(){
        plane.drawLine(0,0, WIDTH - 1, HEIGHT - 1);
        plane.drawLine(0, HEIGHT-1 , WIDTH-1, 0);
    }

    /** 
     * draws the target
     * @param rings the rings to be drawn with different color.
     */
    public void target(int rings){
        for(int i = 0; i < rings; i++){
            if(i%2 ==0){
                plane.setForegroundColor(Color.RED);
            }
            else{
                plane.setForegroundColor(Color.WHITE);
            }
            int diameter = (int)(WIDTH*.9*(rings-i)/rings);
            plane.fillCircle(WIDTH/2-diameter/2,HEIGHT/2-diameter/2, diameter);

        }
    }

    /**
     * Draws triangles
     * @param vertices new vertices
     */
    public void drawTriangle(Point[] vertices){
        plane.drawLine(vertices[0].getX(), vertices[0].getY(), vertices[1].getX(), vertices[1].getY());
        plane.drawLine(vertices[1].getX(), vertices[1].getY(), vertices[2].getX(), vertices[2].getY());
        plane.drawLine(vertices[2].getX(), vertices[2].getY(), vertices[0].getX(), vertices[0].getY());
    }

    /** 
     * Draws an isosceles triangle
     * @param p The point to plot 
     */
    public void drawTriangle(Point p){
        plane.drawLine(p.getX(), p.getY(), p.getX() + 50, p.getY() + 50);
        plane.drawLine(p.getX(), p.getY(), p.getX() + 50 , p.getY() -50);
        plane.drawLine(p.getX() + 50, p.getY() + 50, p.getX() + 50 , p.getY() - 50);

    }

    /**
     * runs the randomPoint method from Canvas
     */
    public Point randomPoint(){
        return new Point((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
    }

    /**
     * returns random number of vertices
     * @param num number
     * 
     */public Point[] randomVertices(int num){
        Point[] vertices = new Point[num];
        for (int i = 0; i < num; i++){
            vertices[i] = randomPoint();
        }
        return vertices;  
    }

    /**
     * draws a triangle with random vertices
     * 
     */
    public void testTriangle(){
        drawTriangle(randomVertices(3));
    }
    
    /**
     * draws triangles at random points of the plane
     * 
     */
    public void testTriangle2(){
        drawTriangle(randomPoint());
    }
}