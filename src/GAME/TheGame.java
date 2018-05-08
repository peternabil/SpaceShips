package GAME;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



public class TheGame extends JComponent implements ActionListener,KeyListener {
    boolean shot1 = false;
    boolean shot2 = false;
    Ships ship1 = new Ships(new ImageIcon("G:\\Programming Project\\pictures\\first.png"), 10, 400);
    Ships ship2 = new Ships(new ImageIcon("G:\\Programming Project\\pictures\\fourth.png"), 800-110, 400);

    static int ship1score=0;
    static int ship2score=0;

    private int lasersize = 800;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon("G:\\Programming Project\\pictures\\Wiki-background copy.jpg").getImage(), 0, 0, null);
        ship1.paintComponent(g);
        ship2.paintComponent(g);
        if (shot1) {
            int range = 710;
            Laser l = new Laser(ship1.posx + 70, ship1.posy + 38, Color.red);
            if (l.y<=ship2.posy+70 && l.y >= ship2.posy) {
                range = 680;
                g.drawImage(new ImageIcon("G:\\Programming Project\\pictures\\thruster-spritesheet1 copy.png").getImage(),ship2.posx+50,ship2.posy+10,null);
                ship1score+=10;
                Launcher.w.scorea.setText(""+ship1score);
                ship1.health-=1;
                if (ship1.health==0){
                    JOptionPane.showMessageDialog(null, "Ship 2 has won");
                    ship1score=0;
                    ship2score=0;
                    ship1.posx=10;
                    ship1.posy=400;
                    ship2.posx=800-110;
                    ship2.posy=400;
                    ship1.health=10;
                    ship2.health=10;
                    Launcher.w.close();
                    MainMenu m = new MainMenu();
                    m.setVisible(true);
                }
            }
            for (int i = 0; i < range; i++) {
                l.x += 1;
                l.paint(g);
            }
            shot1=false;
            repaint();
        }
        if (shot2) {
            int range = 710;
            Laser l = new Laser(ship2.posx + 27, ship2.posy + 36, Color.red);
            if (l.y<=ship1.posy+70 && l.y >= ship1.posy) {
                range = 680;
                g.drawImage(new ImageIcon("/Users/peternabil/Desktop/Programming Project/pictures/thruster-spritesheet1 copy.png").getImage(),ship1.posx+50,ship2.posy+10,null);
                ship2score+=10;
                if(Launcher.mode==1){
                    ship2.health-=1;
                }
                Launcher.w.scoreb.setText(""+ship2score);
                if (ship2.health==0){
                    JOptionPane.showMessageDialog(null, "Ship 1 has won");
                    ship1score=0;
                    ship2score=0;
                    ship1.posx=10;
                    ship1.posy=400;
                    ship2.posx=800-110;
                    ship2.posy=400;
                    ship1.health=10;
                    ship2.health=10;
                    Launcher.w.close();
                    MainMenu m = new MainMenu();
                    m.setVisible(true);
                }
            }
            for (int i = 0; i < range; i++) {
                l.x -= 1;
                l.paint(g);
            }
            shot2=false;
            repaint();
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            shot1 = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            shot2 = true;
        }


    }



    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ship1.posy -= 10;
            //code here
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ship1.posy += 10;
            //code here
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            ship2.posy -= 10;
            //code here
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_X) {
            ship2.posy += 10;
            //code here
            repaint();
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
