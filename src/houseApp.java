import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**House Applet
 * Drawing a house and implementing mouse events. If user clicks on windows or door, they will
 * open or close depending on the status. (Ex: window is open. User clicks and window closes)
 */

public class houseApp extends JApplet {

    private boolean leftWindowClosed = false;
    private boolean rightWindowClosed = false;
    private boolean doorClosed = false;

    //Constant used in determining the size and locations of the
    // house, roof, windows, and door.

    private final int houseWidth = 200;
    private final int houseHeight = 80;
    private final int houseX = 20;
    private final int houseY = 30;
    private final int roofTop = 0;
    private final int windowWidth = 50;
    private final int windowHeight = 30;
    private final int doorWidth = 40;
    private final int doorHeight = 70;
    private final int doorY = 40;
    private final int doorX = (((houseWidth/2)+ houseX) -(doorWidth/2));
    private final int leftWindowX = ((houseWidth/4)+houseX)-(windowWidth/2);
    private final int leftWindowY = 40;
    private final int rightWindowX = (((houseWidth/4)*3)+houseX)-(windowWidth/2);
    private final int rightWindowY = leftWindowY;
    private final int knobWidth = 10;
    private final int knobHeight = knobWidth;

    /**
     * init method
     */

    public void init()
    {
        //Set background color to white.
        getContentPane().setBackground(Color.white);

        //Add mouse listener.
        addMouseListener(new MyMouseListener());
    }

    /**
     * Paint method draws the house.
     */

    public void paint (Graphics g)
    {
        //call base class paint method.
        super.paint(g);

        //draw the outline of the house and roof.
        drawHouse(g);

        //Draw the correct windows and door.
        if(leftWindowClosed)
            drawClosedWindow( g, leftWindowX,leftWindowY);
        else
            drawOpenWindow(g, leftWindowX, leftWindowY);

        if (rightWindowClosed)
            drawClosedWindow(g, rightWindowX, rightWindowY);

        else
            drawOpenWindow(g, rightWindowX, rightWindowY);

        if(doorClosed)
            drawClosedDoor(g, doorX, doorY);
        else
            drawOpenDoor(g, doorX, doorY);
    }

    /**
     * The drawHouse method draws the outline of the house.
     */

    private void drawHouse(Graphics g)
    {
        //Draw black unfilled rectangle.
        g.setColor(Color.black);
        g.drawRect(houseX, houseY, houseWidth, houseHeight);

        //Draw the roof.
        //First, the base line.
        g.drawLine((houseX-10), houseY,(houseWidth+30), houseY );
        //Next a line from the left corner to the top.
        g.drawLine((houseX-10), houseY, ((houseWidth/2)+houseX), roofTop);
        g.drawLine(((houseWidth/2)+ houseX), roofTop,(houseWidth+30), houseY);

    }

    /**
     * drawOpenWindow method draws an open window at the specified X,Y coordinates.
     *
     */

    private void drawOpenWindow (Graphics g, int x, int y)
    {
        //set the drawing color and draw a filled window.
        g.setColor(Color.black);
        g.fillRect(x,y,windowWidth, windowHeight);
    }

    /**
     * drawClosedWindow method draws a closed window at specified X,Y
     * coordinates.
     */

    private void drawClosedWindow(Graphics g, int x, int y)
    {
        //Set the color and draw the outline.
        g.setColor(Color.black);
        g.drawRect(x, y, windowWidth, windowHeight);
        //Draw a horizontal line.
        g.drawLine(x,(y+(windowHeight/2)),
                (x+windowWidth), (y+(windowHeight/2)));
        //Draw a vertical line.
        g.drawLine((x+(windowWidth/2)), (y+windowHeight),
                (x+(windowWidth/2)), y);

    }
    /**
     * drawOpenDoor method draws an open door at the specified X,Y coordinates.
     */

    private void drawOpenDoor (Graphics g, int x, int y)
    {
        //Set the drawing color and draw a filled door.
        g.setColor(Color.black);
        g.fillRect(x, y, doorWidth, doorHeight);
    }

    /**
     * drawClosedDoor method draws a closed door at the specified X,Y coordinates.
     */

    private void drawClosedDoor (Graphics g, int x, int y)
    {
        //Set the drawing color and draw the door outline.
        g.setColor(Color.black);
        g.drawRect(x, y,doorWidth, doorHeight);

        //draw the door knob.
        g.fillOval(((x+doorWidth)-knobWidth), (y+(doorHeight/2)), knobWidth, knobHeight);

    }

    /**
     * MyMouseListener private inner class.
     */

    private class MyMouseListener extends MouseAdapter
    {
        /**
         * mouseClicked method
         */

        public void mouseClicked(MouseEvent e)
        {
            //Determine whether the house is inside a window or door.

            if(isInLeftWindow(e.getX(), e.getY()))
                leftWindowClosed =!leftWindowClosed;
            else if(isInRightWindow(e.getX(), e.getY()))
                rightWindowClosed =!rightWindowClosed;
            else if (isInDoor(e.getX(), e.getY()))
                doorClosed = !doorClosed;

            //Force a repaint.
            repaint();
        }

        /**
         * isInleftWindow method returns true if the point specified by x,y
         * is inside the left window.
         */
        private boolean isInLeftWindow(int x, int y)
        {
            boolean status = false;
            if (x >= leftWindowX && x < (leftWindowX + windowWidth) &&
                    y >= leftWindowY && y < (leftWindowY + windowHeight))
                status = true;

            return status;
        }

        /**
         * isInRightWindow method returns true if the point specified by
         * , y is inside the right window.
         */

        private boolean isInRightWindow(int x, int y)
        {
            boolean status = false;
            if(x >= rightWindowX && x < (rightWindowX + windowWidth) &&
                    y >= rightWindowY && y < (rightWindowY + windowHeight))
                status = true;

            return status;
        }

        /**
         * isInDoor method returns true if the point specified
         * by x, y is inside the door.
         */

        private boolean isInDoor(int x, int y)
        {
            boolean status = false;
            if ((x >= doorX) && (x < (doorX + doorWidth)) &&
                    (y >= doorY) && (y < (doorY + doorHeight)))
                status = true;

            return status;

        }
    } //end inner class.

}
