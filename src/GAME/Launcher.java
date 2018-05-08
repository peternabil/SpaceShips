package GAME;

import javax.swing.*;
import java.awt.*;

public class Launcher {
        static window w;
        static int mode;
    public static void main(String[] args) {
        MainMenu m = new MainMenu();
        m.setVisible(true);
        
        
    }

}
class window extends JFrame{
    JPanel scorepnl = new JPanel(new FlowLayout());

        JLabel scorea = new JLabel("0          ");
        JLabel scoreb = new JLabel("0          ");
        JLabel a = new JLabel("Player A");
        JLabel b = new JLabel("Player B");
    window(){
        this.setLayout(new BorderLayout());
        scorea.setText(""+TheGame.ship1score);
        scoreb.setText(""+TheGame.ship2score);
        scorepnl.add(a);
        scorepnl.add(scorea);
        scorepnl.add(b);
        scorepnl.add(scoreb);

        this.add(scorepnl,BorderLayout.SOUTH);
        TheGame game = new TheGame();


        this.add(game);
        this.pack();
        this.setResizable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Timer t = new Timer(1000,game);

        this.addKeyListener(game);

        t.start();
    }
    public void close(){
        this.dispose();
    }
}
