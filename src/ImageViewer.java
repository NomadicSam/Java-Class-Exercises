
/**
 * March 13, 2017
 *This class will demonstrate how to use an ImageIcon and Jlabel to display an image
 *with the following modifications added:
 * 1. Add a File menu with two submenus, Open and Exit.
 * 2. The Open submenu should have Mnemonic “O” to open an image file.
 * 3. The Exit submenu should have a Mnemonic “x” to exit the application.
 * 4. Tool Tips for the two submenu items.
 */


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class ImageViewer extends JFrame {

    private JPanel imagePanel;			//panel to hold an image label
    private JPanel buttonPanel;			// panel to hold a button.
    private JLabel imageLabel;			// label to hold an image.
    private JButton button; 			//button to get an image.
    private JFileChooser fileChooser;	//for the open dialog box.
    private JMenuBar menuBar;   		// The menu bar
    private JMenu fileMenu;     		// The File menu
    //private JMenu textMenu;     		// The Text menu build menu..
    private JMenuItem exitItem; 		// An item to exit the application
    private JMenuItem openItem;

    /**
     * Constructor
     */

    public ImageViewer()
    {  	//Set the title.
        setTitle("Image Viewer");

        // Build the menu bar.
        buildMenuBar();

        //Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a BorderLayout manager for the content pane.
        setLayout(new BorderLayout());

        //Build the panels
        buildButtonPanel();
        buildImagePanel();
        buildMenuBar();

        //Add the panels to the content pane.
        add(imagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        //Create a file chooser.
        fileChooser = new JFileChooser(".");

        //Pack and display the window.
        pack();
        setVisible(true);

    }

    /**
     *  The buildMenuBar method builds the menu bar.
     */

    private void buildMenuBar()
    {
        // Create the menu bar.
        menuBar = new JMenuBar();

        // Create the file and text menus.
        buildFileMenu();

        // Add the file and text menus to the menu bar.
        menuBar.add(fileMenu);
        // menuBar.add(textMenu);

        // Set the window's menu bar.
        setJMenuBar(menuBar);
    }

    private void buildFileMenu()
    {
        // Create an Exit menu item.
        exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new ExitListener());
        // Create an open menu item.
        openItem = new JMenuItem("Open");
        openItem.setMnemonic(KeyEvent.VK_X);
        openItem.addActionListener(new ExitListener());

        // Create a JMenu object for the File menu.
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        // Add the open menu item to the File menu.
        fileMenu.add(openItem);
        // Add the Exit menu item to the File menu.
        fileMenu.add(exitItem);
        // if open is selected, it calls the ButtonListener to open the filemenu.
        openItem.addActionListener(new ButtonListener());
    }

    /**
     * The buildImagePanel method adds an empty label to a panel.
     */

    private void buildImagePanel()
    {
        //Create a panel
        imagePanel = new JPanel();

        //Create a label
        imageLabel = new JLabel ("Click the button to get an image.");

        //Add the label to the panel.
        imagePanel.add(imageLabel);

    }

    /**The buildButtonPanel method adds a button to a panel.
     *
     */

    private void buildButtonPanel()
    {
        //Create a panel.
        buttonPanel = new JPanel();

        //Create a button.
        button = new JButton("Get Image");

        //Register an action listener with the button.
        button.addActionListener(new ButtonListener());

        //Add the button to the panel.
        buttonPanel.add(button);

    }

    /**
     * Private inner class that handles the event that
     * is generated when the user selects Exit from
     * the File menu.
     */

    private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }



    /**Private inner class that handles the event when the user clicks the button.
     */

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            File selectedFile;			//To reference the selected image file.
            ImageIcon image;			//To read the image from the file.
            String filename;			//To hold the name and path of the file.
            int fileChooserStatus;		//Indicates status of the open dialog box.

            //Display an open dialog box.
            fileChooserStatus = fileChooser.showOpenDialog(ImageViewer.this);

            if(fileChooserStatus == JFileChooser.APPROVE_OPTION)
            {
                //Get the reference to the selected file.
                selectedFile = fileChooser.getSelectedFile();

                //Read the path of the selected file.
                filename = selectedFile.getPath();

                //Read the image from the file.
                image = new ImageIcon(filename);

                //Store the image in the label.
                imageLabel.setIcon(image);

                //If the label display text, remove it.
                imageLabel.setText(null);

                //Pack the frame again to match the new size of the label.
                pack();
            }
        }
    }
    /**
     * The main method creates an instance of the ImgViewer class, causing it to
     * display its window.
     */
    public static void main(String[]args)
    {
        ImageViewer i = new ImageViewer();

    } //close main method.
} //close the program.

