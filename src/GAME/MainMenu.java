
package GAME;

import static GAME.Launcher.w;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author mosta
 */
public class MainMenu extends JFrame {
    private JLabel startlbl =new JLabel("Start a new game");
    private JLabel scorelbl = new JLabel("Show Scores");
    private JLabel survivallbl = new JLabel("Start a survival game");
    
    private JButton start = new JButton("Start");
    private JButton score = new JButton("Scores"); 
    private JButton survival = new JButton("Survival game");
    
    MainMenu(){
        init();
    }

    private void init() {
        this.setSize(400,600);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        startlbl.setSize(250,50);
        startlbl.setLocation(80, 30);
        startlbl.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(startlbl);
        
        start.setSize(100,80);
        start.setLocation(150, 80);
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Launcher.mode=1;
                w = new window();
                w.setVisible(true);
                close();
            }
        });
        this.add(start);
        start.setFont(new Font("Arial", Font.PLAIN, 30));
        
        scorelbl.setSize(180,50);
        scorelbl.setLocation(110,160);
        scorelbl.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(scorelbl);
        
        score.setSize(150,80);
        score.setLocation(125,230);
        score.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(score);
        
        survivallbl.setSize(300,50);
        survivallbl.setLocation(50,320);
        survivallbl.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(survivallbl);
        
        survival.setSize(250,80);
        survival.setLocation(65,390);
        survival.setFont(new Font("Arial", Font.PLAIN, 30));
        survival.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Launcher.mode=0;
                w = new window();
                w.setVisible(true);
                close();
            }
        });
        this.add(survival);
    }
    public void close(){
        this.dispose();
    }
}
