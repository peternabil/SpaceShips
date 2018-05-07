package GAME;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class TheGame extends JComponent implements ActionListener,KeyListener {
    boolean shot1 = false;
    boolean shot2 = false;
    Ships ship1 = new Ships(new ImageIcon("pictures/first.png"), 10, 400);
    Ships ship2 = new Ships(new ImageIcon("pictures/first copy.png"), 800-110, 400);

    static int ship1score=0;
    static int ship2score=0;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon("pictures/Wiki-background copy.jpg").getImage(), 0, 0, null);
        ship1.paintComponent(g);
        ship2.paintComponent(g);
        if (shot1) {
            if (ship1.posy >= ship2.posy-20 && ship1.posy <= ship2.posy+20) {
                g.drawImage(new ImageIcon("pictures/laserhit.png").getImage(),ship1.posx + 70, ship1.posy + 38,null);
                g.drawImage(new ImageIcon("pictures/thruster-spritesheet1 copy 2.png").getImage(),ship2.posx+40,ship1.posy + 28,null);
                ship1score+=2;
                Launcher.w.scorea.setText(""+ship1score);
                ship2.health-=1;
                if (ship2.health==0){
                    JOptionPane.showMessageDialog(null, "Ship 1 has won");
                    ship1score=0;
                    ship2score=0;
                    ship1.posx=10;
                    ship1.posy=400;
                    ship2.posx=800-110;
                    ship2.posy=400;
                    ship1.health=20;
                    ship2.health=20;
                    Launcher.w.close();
                    MainMenu m = new MainMenu();
                    m.setVisible(true);
                }
            }else{
                g.drawImage(new ImageIcon("pictures/lasernothit.png").getImage(),ship1.posx + 60, ship1.posy + 28,null);

            }
            shot1=false;
        }
        if (shot2) {
            if (ship1.posy >= ship2.posy-20 && ship1.posy <= ship2.posy+20) {
                g.drawImage(new ImageIcon("pictures/laserhit.png").getImage(),ship1.posx + 50, ship2.posy + 38,null);
                g.drawImage(new ImageIcon("pictures/thruster-spritesheet1 copy.png").getImage(),ship1.posx+40,ship2.posy + 28,null);
                ship2score+=2;
                if(Launcher.mode==1){
                    ship1.health-=1;
                }
                Launcher.w.scoreb.setText(""+ship2score);
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
            }else{
                g.drawImage(new ImageIcon("pictures/lasernothit.png").getImage(),10, ship2.posy + 38,null);
            }
            shot2=false;
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
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ship1.up=true;
            //code here
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ship1.down = true;
            //code here

        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            ship2.up = true;
            //code here
        } else if (e.getKeyCode() == KeyEvent.VK_X) {
            ship2.down = true;
            //code here
        }
        ship1.change();
        ship2.change();
        this.repaint();
    }



    @Override
    public void keyReleased(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//            shot1 = false;
//        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ship1.up=false;
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ship1.down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            ship2.up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_X) {
            ship2.down = false;
        }
//        if (e.getKeyCode() == KeyEvent.VK_S) {
//            shot2 = false;
//        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
