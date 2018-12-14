import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.BasicStroke;

/**
 * Address every Canvas that is connected to this.
 * Allows for customization of the canvas
 * 
 *
 * @author (Aeijan Bajracharya && Jinwon Kim)
 *
 * @version (12/15/16)
 */

public class Canvas
{
    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;
    private BasicStroke pen;
    private static final int DEFAULT_POINT_SIZE = 10;
    private Point origin;
    public static int WIDTH;
    public static int HEIGHT;

    /**
     * Create a Canvas with default height, width and background color 
     * (300, 300, white).
     * @param title  title to appear in Canvas Frame     
     */
    public Canvas(String title)
    {
        this(title, 300, 300, Color.white);        
    }

    /**
     * Create a Canvas with default background color (white).
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     */
    public Canvas(String title, int width, int height)
    {
        this(title, width, height, Color.white);
    }

    /**
     * Create a Canvas.
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bgClour  the desired background color of the canvas
     * this - establishes the origin, the height, and the width
     */
    public Canvas(String title, int width, int height, Color bgColor)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();
        this.origin = new Point(WIDTH/2, HEIGHT/2);
        this.HEIGHT = height;
        this.WIDTH = width;
    }

    public void plotPoint(Point p, int radius, Color c){
    }

    /**
     * Set the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false) 
     */
    public void setVisible(boolean visible)
    {
        if(graphic == null) {
            // first time: instantiate the offscreen image and fill it with
            // the background color
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(true);
    }

    /**
     * Provide information on visibility of the Canvas.
     * @return  true if canvas is visible, false otherwise
     */
    public boolean isVisible()
    {
        return frame.isVisible();
    }

    /**
     * Draw the outline of a given shape onto the canvas.
     * @param  shape  the shape object to be drawn on the canvas
     */
    public void draw(Shape shape)
    {
        graphic.draw(shape);
        canvas.repaint();
    }

    /**
     * Sets the "pen size" to given size (thickness)
     * @param size the thickness of the pend
     */
    public void setPenSize(int size)
    {
        pen = new BasicStroke(size);
        graphic.setStroke(pen);
    }

    /**
     * Fill the internal dimensions of a given shape with the current 
     * foreground color of the canvas.
     * @param  shape  the shape object to be filled 
     */
    public void fill(Shape shape)
    {
        graphic.fill(shape);
        canvas.repaint();
    }

    /**
     * Fill the internal dimensions of the given circle with the current 
     * foreground color of the canvas.
     */
    public void fillCircle(int xPos, int yPos, int diameter)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos, yPos, diameter, diameter);
        fill(circle);
    }

    public void drawCircle(double xPos, double yPos, double diameter)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos, yPos, diameter, diameter);
        draw(circle);
    }
    
    public void drawRectangle(double xPos, double yPos, double width, double height)
    {
        Rectangle2D.Double rectangle = new Rectangle2D.Double(xPos, yPos, width, height);
        setForegroundColor(Color.white);
        draw(rectangle);
    }

    /**
     * Fill the internal dimensions of the given rectangle with the current 
     * foreground color of the canvas. This is a convenience method. A similar 
     * effect can be achieved with the "fill" method.
     */
    public void fillRectangle(int xPos, int yPos, int width, int height)
    {
        fill(new Rectangle(xPos, yPos, width, height));
    }

    /**
     * Erase the whole canvas.
     */
    public void erase()
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Erase the internal dimensions of the given circle. This is a 
     * convenience method. A similar effect can be achieved with
     * the "erase" method.
     */
    public void eraseCircle(double xPos, double yPos, double diameter)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos, yPos, diameter, diameter);
        erase(circle);
    }

    /**
     * Erase the internal dimensions of the given rectangle. This is a 
     * convenience method. A similar effect can be achieved with
     * the "erase" method.
     */
    public void eraseRectangle(int xPos, int yPos, int width, int height)
    {
        erase(new Rectangle(xPos, yPos, width, height));
    }

    /**
     * Erase a given shape's interior on the screen.
     * @param  shape  the shape object to be erased 
     */
    public void erase(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.fill(shape);              // erase by filling background color
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Erases a given shape's outline on the screen.
     * @param  shape  the shape object to be erased 
     */
    public void eraseOutline(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.draw(shape);  // erase by drawing background color
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Draws an image onto the canvas.
     * @param  image   the Image object to be displayed 
     * @param  x       x co-ordinate for Image placement 
     * @param  y       y co-ordinate for Image placement 
     * @return  returns boolean value representing whether the image was 
     *          completely loaded 
     */
    public boolean drawImage(Image image, int x, int y)
    {
        boolean result = graphic.drawImage(image, x, y, null);
        canvas.repaint();
        return result;
    }

    /**
     * Draws a String on the Canvas.
     * @param  text   the String to be displayed 
     * @param  x      x co-ordinate for text placement 
     * @param  y      y co-ordinate for text placement
     */
    public void drawString(String text, int x, int y)
    {
        graphic.drawString(text, x, y);   
        canvas.repaint();
    }

    /**
     * Erases a String on the Canvas.
     * @param  text     the String to be displayed 
     * @param  x        x co-ordinate for text placement 
     * @param  y        y co-ordinate for text placement
     */
    public void eraseString(String text, int x, int y)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.drawString(text, x, y);   
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Draws a line on the Canvas.
     * @param  x1   x co-ordinate of start of line 
     * @param  y1   y co-ordinate of start of line 
     * @param  x2   x co-ordinate of end of line 
     * @param  y2   y co-ordinate of end of line 
     */
    public void drawLine(int x1, int y1, int x2, int y2)
    {
        graphic.drawLine(x1, y1, x2, y2);   
        canvas.repaint();
        graphic.setStroke(new BasicStroke(1));
    }

    public void setStroke(int s){
        BasicStroke stroke = new BasicStroke(s);
        graphic.setStroke(stroke);
    }

    /**
     * Sets the foreground color of the Canvas.
     * @param  newColor   the new color for the foreground of the Canvas 
     */
    public void setForegroundColor(Color newColor)
    {
        graphic.setColor(newColor);
    }

    /**
     * Returns the current color of the foreground.
     * @return   the color of the foreground of the Canvas 
     */
    public Color getForegroundColor()
    {
        return graphic.getColor();
    }

    /**
     * Sets the background color of the Canvas.
     * @param  newColor   the new color for the background of the Canvas 
     */
    public void setBackgroundColor(Color newColor)
    {
        backgroundColor = newColor;   
        graphic.setBackground(newColor);
    }

    /**
     * Returns the current color of the background
     * @return   the color of the background of the Canvas 
     */
    public Color getBackgroundColor()
    {
        return backgroundColor;
    }

    /**
     * changes the current Font used on the Canvas
     * @param  newFont   new font to be used for String output
     */
    public void setFont(Font newFont)
    {
        graphic.setFont(newFont);
    }

    /**
     * Returns the current font of the canvas.
     * @return     the font currently in use
     **/
    public Font getFont()
    {
        return graphic.getFont();
    }

    /**
     * Sets the size of the canvas.
     * @param  width    new width 
     * @param  height   new height 
     */
    public void setSize(int width, int height)
    {
        canvas.setPreferredSize(new Dimension(width, height));
        Image oldImage = canvasImage;
        canvasImage = canvas.createImage(width, height);
        graphic = (Graphics2D)canvasImage.getGraphics();
        graphic.drawImage(oldImage, 0, 0, null);
        frame.pack();
    }

    /**
     * Returns the size of the canvas.
     * @return     The current dimension of the canvas
     */
    public Dimension getSize()
    {
        return canvas.getSize();
    }

    /**
     * Waits for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     * @param  milliseconds  the number 
     */
    public void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (InterruptedException e)
        {
            // ignoring exception at the moment
        }
    }

    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class CanvasPane extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }

    /**
     * Allows user to create of a point at an particular coordinate.
     * 
     * 
     */
    public void plotPoint(Point p)
    {
        plotPoint(p, DEFAULT_POINT_SIZE);
    }

    /**
     * Plots the given point, of size radius on this canvas.
     * Plots a point over the coordinate rather than it's left upper corner.
     * @param p The Point to plot
     * @param diameter The size of point to plot
     */
    public void plotPoint(Point p, int diameter){
        int x = origin.getX() + p.getX() - ((diameter/2));
        int y = origin.getY() - p.getY() - ((diameter/2)); 
        fillCircle(x, y, diameter);
    }

    /**
     * Draws the axes in the middle of the Canvas.
     * 
     */
    public void axes(){
        setForegroundColor(Color.BLACK);
        drawLine(WIDTH/2, 0, WIDTH/2,HEIGHT);
        drawLine(0, HEIGHT/2 , WIDTH, HEIGHT/2);
    }

    /**
     * plots a random point on the plane
     * 
     */
    public void plotRandom(){
        plotPoint(randomPoint());
    }

    /**
     * @return - a value that is within the domain of the CartesianPlane (assumes a square plane)
     * 
     */
    public int randomCoord(){

        return ((int)(Math.random() * WIDTH)) - (WIDTH / 2);
    }

    /**
     * @return - a Point with random coordinates
     * 
     */
    public Point randomPoint(){
        return new Point(randomCoord(), randomCoord());
    }

    /**
     * Creates the safetyMap
     * plots the points and changes the color based on the distance
     * @param start - start of the "hot spot" of the power lines
     * 
     */
    public void safetyMap(Point start, int numOfLocations){

        for (int i = 0; i < numOfLocations; i++)
        {
            axes();
            Point random = randomPoint();
            double distance = start.getDistance(random);

            if(distance < 50){
                setForegroundColor(Color.red);
            }
            else if(distance >= 50 && distance < 100){
                setForegroundColor(Color.orange);
            }

            else if(distance >= 100 && distance < 200){
                setForegroundColor(Color.yellow);
            }

            else {
                setForegroundColor(Color.green);
            }
            plotPoint(random);
        }

    }
}