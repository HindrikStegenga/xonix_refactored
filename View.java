package xonix;

import xonix.viewclasses.MapView;
import xonix.viewclasses.ScoreView;

public class View extends javax.swing.JFrame {

    private final javax.swing.JPanel all;
    private final ScoreView score;
    private final MapView map;

    /**
     * Constructor of the View class, sets up the window etc.
     * Call update() with a Model to update the view
     * Intended for use with a Controller instance
     * @see Controller
     * @see Model
     * @see View#update(Model)
     * */
    public View ()
    {
        this.setTitle ("Xonix Game");
        all = new javax.swing.JPanel ();
        all.setLayout (new javax.swing.BoxLayout (all, javax.swing.BoxLayout.Y_AXIS));
        all.setBorder (new javax.swing.border.EmptyBorder (0, 30, 0, 30));
        score = new ScoreView ();
        all.add (score);
        map = new MapView ();
        map.setAlignmentX (CENTER_ALIGNMENT);
        all.add (map);
        this.add (all);
        this.setMenu ();
        this.pack ();
        this.setLocationRelativeTo (null);
        this.setDefaultCloseOperation (javax.swing.JFrame.EXIT_ON_CLOSE);
        this.setSize (new java.awt.Dimension (630, 610));
        this.setResizable (false);
        this.setVisible (true);
    }

    /**
     * Sets up the menu of the View class
     */
    private void setMenu ()
    {
        javax.swing.JMenuBar menuBar;
        javax.swing.JMenu menu;
        javax.swing.JMenuItem menuItem;
        menuBar = new javax.swing.JMenuBar ();
        menu = new javax.swing.JMenu ("File");
        menuItem = new javax.swing.JMenuItem ("New");
        menu.add (menuItem);
        menuItem = new javax.swing.JMenuItem ("Save");
        menu.add (menuItem);
        menuItem = new javax.swing.JMenuItem ("Undo");
        menu.add (menuItem);
        menuItem = new javax.swing.JMenuItem ("Sound");
        menu.add (menuItem);
        menuItem = new javax.swing.JMenuItem ("About");
        menu.add (menuItem);
        menuItem = new javax.swing.JMenuItem ("Quit");
        menu.add (menuItem);
        menuBar.add (menu);
        menu = new javax.swing.JMenu ("Command");
        menuItem = new javax.swing.JMenuItem ("Add bomb");
        menu.add (menuItem);
        menuItem = new javax.swing.JMenuItem ("Add smartbomb");
        menu.add (menuItem);
        menuItem = new javax.swing.JMenuItem ("Add timeticket");
        menu.add (menuItem);
        menuItem = new javax.swing.JMenuItem ("Switch bombstrategies ");
        menu.add (menuItem);
        menuBar.add (menu);
        this.setJMenuBar (menuBar);
    }

    /**
     * Updates internal data according to the model it receives from the controller
     * @see Controller
     * @see Model
     * @see MapView
     * @see ScoreView
     * @see View#updateScoreView(Model)
     * @see View#updateMapView(Model)
     * */
    public void update (Model model)
    {
        updateScoreView(model);
        updateMapView(model);
    }

    /**
     * Updates internal viewScore according to the model it receives from the controller
     * */
    public void updateScoreView(Model model)
    {
        score.update(model);
    }

    /**
     * Updates internal mapScore according to the model it receives from the controller
     * */
    public void updateMapView(Model model)
    {
        map.update(model);
    }
}