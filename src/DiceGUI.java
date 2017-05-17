
/**
 * March 13, 2017
 *This class below is building the interface for the dice.png images to display, and
 * adding an event listener to listen when the user clicks the “roll dice”
 */



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class DiceGUI extends JFrame{

    //An array that has the Dice images. Put the name of images.
    private String img[] = {"1Die.png", "2Die.png", "3Die.png", "4Die.png"
            , "5Die.png", "6Die.png"};
    private JPanel imgPanel; 	//holds the images.
    private JPanel bttnPanel;	//holds the buttons.
    private JButton rollBttn;	//Button used to roll dice.
    private JLabel imgLabel1 = new JLabel();
    private JLabel imgLabel2 = new JLabel();
    private ImageIcon dice1;
    private ImageIcon dice2;
    private Dice dice = new Dice(6);


			/*
			 * Constructor creates the 2 panels-- image panel and button panel.
			 */

    public DiceGUI()
    {
        setTitle("Dice Simulator"); //Sets title of menu bar.

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        buildImgPanel();
        buildBttnPanel();

        add(imgPanel, BorderLayout.CENTER);
        add(bttnPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }
	/*
	 * Method below builds the button panel. A button shall be implemented
	 * and the action listener will to.
	 */

    private void buildBttnPanel()
    {
        bttnPanel = new JPanel();
        rollBttn = new JButton("Roll");
        rollBttn.addActionListener(new ButtonListener());
        bttnPanel.add(rollBttn);

    }

	/*
	 * Implementing the action listener to listen when the button is pressed
	 * so it will randomly generate a number and change the images like rolling dice.
	 */

    private class ButtonListener implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            //this calls the roll method.
            dice.roll();

            //gets the random generated number from the dice.java
            dice1 = new ImageIcon(img[dice.getNum()]);

            dice.roll();
            //rolls the second dice image.

            dice2 = new ImageIcon(img[dice.getNum()]);
            imgLabel1.setIcon(dice1);
            imgLabel2.setIcon(dice2);


        }
    }
    private void buildImgPanel(){
        imgPanel = new JPanel();
        dice.roll();
        dice1 = new ImageIcon(img[dice.getNum()]);
        dice.roll();
        dice2 = new ImageIcon(img[dice.getNum()]);
        imgLabel1.setIcon(dice1);
        imgLabel2.setIcon(dice2);
        imgPanel.add(imgLabel1);
        imgPanel.add(imgLabel2);


    }

    public static void main(String[] args)
    {
        new DiceGUI();
    }

} // end entire program.