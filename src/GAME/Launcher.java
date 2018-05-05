package GAME;

import javax.swing.*;
import java.awt.*;

public class Launcher {

    public static void main(String[] args) {
        JFrame window = new JFrame("Space Wars");
        window.setLayout(new BorderLayout());
        JPanel scorepnl = new JPanel(new FlowLayout());

        JLabel scorea = new JLabel("0          ");
        JLabel scoreb = new JLabel("0          ");
        JLabel a = new JLabel("Player A");
        JLabel b = new JLabel("Player B");

        // here you will add the functionality of the score fields
        // save the score
        // when the someone wins you will close this window display a window with who won and the score with an option to rematch and another to go to main menu
        scorepnl.add(a);
        scorepnl.add(scorea);
        scorepnl.add(b);
        scorepnl.add(scoreb);

        window.add(scorepnl,BorderLayout.SOUTH);
        TheGame game = new TheGame();


        window.add(game);
        window.pack();
        window.setResizable(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        Timer t = new Timer(1000,game);

        window.addKeyListener(game);

        t.start();
    }
}
