package GAME;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

class Game extends JFrame{

   public Game(){
       init();
   }

   public void init(){
       this.setTitle("The Game");
       this.add(new TheGame());
       this.setBounds(500 , 50 , 500 , 500);

       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
}

class ScoreBoard extends JFrame{

   public ScoreBoard(){
       init();
   }

   public void init(){
       this.setTitle("Score Board");
       this.setBounds(500 , 50 , 400 , 400);
       this.setResizable(false);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
}

public class StarWarsMainPage extends JFrame implements ActionListener{

   public static void main(String[] args) {
       StarWarsMain m = new StarWarsMain();
   }

   private JButton btnPlay = new JButton("Play");
   private JButton btnScore = new JButton("Score");

   public StarWarsMainPage(){
       init();
   }

   public void init(){
       this.setTitle("Star Wars V1.0");
       this.setBounds(500 , 50 , 500 , 500);
       this.setResizable(false);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       Container c = this.getContentPane();
       c.setLayout(null);

       btnPlay.setBounds(200 , 300 , 100 , 50);
       btnScore.setBounds(200 , 400 , 100 , 50);

       c.add(btnPlay);
       c.add(btnScore);

       btnPlay.addActionListener(this);
       btnScore.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e){
       Object o = e.getSource();

       if(o == btnPlay)
       {
           Game g = new Game();
           g.setVisible(true);
           this.dispose();
       }

       if(o == btnScore)
       {
           ScoreBoard s = new ScoreBoard();
           s.setVisible(true);
           this.dispose();
       }
   }
}
