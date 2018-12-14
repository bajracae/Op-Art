import java.awt.Graphics2D;
import java.awt.Graphics;

import java.awt.Color; 
import javax.swing.JFrame;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
/**
 * Write a description of class OpArtRunner here.
 * 
 * @author (Aeijan Bajracharya && Jinwon Kim) 
 * @version (Jan 25, 2017)
 */
public class OpArtRunner
{
    private Canvas plane;
    public static int WIDTH = 600;
    public static int HEIGHT = 600;
    public static int DIAMETER= 600;
    public static int LOOP= WIDTH/2;
    private Point origin;
    /**
     * Creates the background color 
     */
    public OpArtRunner()
    {
        Color bg = new Color(0,0,2);
        plane = new Canvas("Op Art", WIDTH,HEIGHT,bg);

        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
        plane.setVisible(true);
        plane.setForegroundColor(Color.white);

    }

    /**
     * Test the entire class to print the art board
     */
    public void testdrawArt(){
        Lines();
        LeftTopRectangle();
        RightTopRectangle();
        LeftBottomRectangle();
        RightBottomRectangle();
        eraseCenterCircle();
        eraseAroundCenterCircle();
        eraseCornerCircle();
        drawCenterCircle();
        drawAroundCenterCircle();
        drawCornerCircle();

    }

    /**
     * Draws top left rectangles
     */
    public void LeftTopRectangle(){
        plane.setStroke(2);
        double x1 = WIDTH-WIDTH;
        double y1 = HEIGHT-HEIGHT;
        double width = WIDTH/2-5;
        double height = HEIGHT/2-5;

        for (int i = 0; i < LOOP; i++){
            plane.drawRectangle(x1,y1,width,height);

            x1 = x1 + 5;
            y1 = y1 + 5;
            width = width -10;
            height = height- 10;

        }
    }

    /**
     * Draws top right rectangles
     */
    public void RightTopRectangle(){
        double x2 = WIDTH/2+5;
        double y2 = HEIGHT-HEIGHT;
        double width2 = WIDTH/2-5;
        double height2 = HEIGHT/2-5;

        for (int i = 0; i < LOOP; i++){
            plane.drawRectangle(x2,y2,width2,height2);

            x2 = x2 +5;
            y2 = y2 +5 ;
            width2 = width2 - 10;
            height2 = height2 - 10;
        }
    }

    /**
     * Draws left bottom rectangles
     */
    public void LeftBottomRectangle(){
        double x3 = WIDTH-WIDTH;
        double y3 = HEIGHT/2+5;
        double width3 = WIDTH/2-5;
        double height3 = HEIGHT/2-5;

        for (int i = 0; i < LOOP; i++){
            plane.drawRectangle(x3,y3,width3,height3);
            x3 = x3 + 5;
            y3 = y3 + 5;
            width3 = width3 - 10;
            height3 = height3 - 10;

        }
    }

    /**
     * Draws right bottom rectangles
     */
    public void RightBottomRectangle(){
        double x4 = WIDTH/2+5;
        double y4 = HEIGHT/2+5;
        double width4 = WIDTH/2-5;
        double height4 = HEIGHT/2-5;

        for (int i = 0; i < LOOP; i++){
            plane.drawRectangle(x4,y4,width4,height4);
            x4 = x4 + 5;
            y4 = y4 + 5;
            width4 = width4 - 10;
            height4 = height4 - 10;
        }
    }

    /**
     * Draws the middle intersecting lines
     */
    public void Lines(){
        //plane.drawLine(0, 0, WIDTH, HEIGHT);
        //plane.drawLine(WIDTH,0,0,HEIGHT);
        plane.setStroke(2);
        plane.drawLine(WIDTH/2, 0, WIDTH/2, HEIGHT);
        plane.setStroke(2);
        plane.drawLine(0,WIDTH/2,WIDTH,HEIGHT/2);
    }

    /**
     * Erases the circle in the center
     */
    public void eraseCenterCircle(){
        plane.eraseCircle((WIDTH/2)/2,(HEIGHT/2)/2,DIAMETER/2);//center

    }

     /**
     * Draws the center circles
     */
    public void drawCenterCircle(){
        double x6 = (WIDTH/2)/2;
        double y6 = (HEIGHT/2)/2;
        double drawdiameter = DIAMETER/2;
        plane.setStroke(2);
        for (int i = 0; i < LOOP; i++){
            plane.drawCircle(x6, y6, drawdiameter);

            x6 = x6+5;
            y6 = y6+5;
            drawdiameter = drawdiameter - 10;

        }
    }

     /**
     * Erases the around the center circle
     */
    public void eraseAroundCenterCircle(){
        plane.eraseCircle((WIDTH/6)-5, (HEIGHT/6)-5,(DIAMETER/2)-(DIAMETER/6));//top left

        plane.eraseCircle(WIDTH/2+5, (HEIGHT/6)-5,(DIAMETER/2)-(DIAMETER/6));//top right

        plane.eraseCircle((WIDTH/6)-5, (HEIGHT/2)+5,(DIAMETER/2)-(DIAMETER/6));//bottom left

        plane.eraseCircle(WIDTH/2+5, (HEIGHT/2)+5,(DIAMETER/2)-(DIAMETER/6));//bottom right
    }
    
     /**
     * Draws the circles around the center
     */
    public void drawAroundCenterCircle(){

        double x7 = (WIDTH/6)-5;
        double y7 = (HEIGHT/6)-5;
        double drawS1diameter = DIAMETER/3;
        for (int i = 0; i < LOOP; i++){
            plane.drawCircle(x7, y7, drawS1diameter);

            x7 = x7+5;
            y7 = y7+5;
            drawS1diameter = drawS1diameter - 10;
        }

        double x8 = (WIDTH/2)+5;
        double y8 = (HEIGHT/6)-5;
        double drawS2diameter = DIAMETER/3;
        for (int i = 0; i < LOOP; i++){
            plane.drawCircle(x8, y8, drawS2diameter);

            x8 = x8+5;
            y8 = y8+5;
            drawS2diameter = drawS2diameter - 10;
        }

        double x9 = (WIDTH/6)-5;
        double y9 = (HEIGHT/2)+5;
        double drawS3diameter = DIAMETER/3;
        for (int i = 0; i < LOOP; i++){
            plane.drawCircle(x9, y9, drawS3diameter);

            x9 = x9+5;
            y9 = y9+5;
            drawS3diameter = drawS3diameter - 10;
        }

        double x10 = (WIDTH/2)+5;
        double y10 = (HEIGHT/2)+5;
        double drawS4diameter = DIAMETER/3;
        for (int i = 0; i < LOOP; i++){
            plane.drawCircle(x10, y10, drawS4diameter);

            x10 = x10+5;
            y10 = y10+5;
            drawS4diameter = drawS4diameter - 10;
        }
    }

    /**
     * Erases the circle in the corners
     */
    public void eraseCornerCircle(){
        plane.eraseCircle(WIDTH-WIDTH,HEIGHT-HEIGHT,DIAMETER/4);//top left
        plane.eraseCircle(WIDTH/2+WIDTH/4,HEIGHT-HEIGHT,DIAMETER/4);//top right
        plane.eraseCircle(WIDTH-WIDTH,HEIGHT/2+HEIGHT/4,DIAMETER/4);//bottom left
        plane.eraseCircle(WIDTH/2+WIDTH/4,HEIGHT/2+HEIGHT/4,DIAMETER/4);//bottom right
    }

    /**
     * Draws the circles on the four corners
     */
    public void drawCornerCircle(){
        double x11 = WIDTH-WIDTH;
        double y11 = HEIGHT-HEIGHT;
        double drawS5diameter = (DIAMETER/2)/2;
        for (int i = 0; i < LOOP; i++){
            plane.drawCircle(x11, y11, drawS5diameter);

            x11 = x11+5;
            y11 = y11+5;
            drawS5diameter = drawS5diameter - 10;
        }

        double x12 = WIDTH/2+((WIDTH/2)/2);
        double y12 = HEIGHT-HEIGHT;
        double drawS6diameter = (DIAMETER/2)/2;
        for (int i = 0; i < LOOP; i++){
            plane.drawCircle(x12, y12, drawS6diameter);

            x12 = x12+5;
            y12 = y12+5;
            drawS6diameter = drawS6diameter - 10;
        }

        double x13 = WIDTH-WIDTH;
        double y13 = HEIGHT/2+((HEIGHT/2)/2);
        double drawS7diameter = (DIAMETER/2)/2;
        for (int i = 0; i < LOOP; i++){
            plane.drawCircle(x13, y13, drawS7diameter);

            x13 = x13+5;
            y13 = y13+5;
            drawS7diameter = drawS7diameter - 10;
        }

        double x14 = WIDTH/2+((WIDTH/2)/2);
        double y14 = HEIGHT/2+((HEIGHT/2)/2);
        double drawS8diameter = (DIAMETER/2)/2;
        for (int i = 0; i < LOOP; i++){
            plane.drawCircle(x14, y14, drawS8diameter);

            x14 = x14+5;
            y14 = y14+5;
            drawS8diameter = drawS8diameter - 10;
        }
    }
}