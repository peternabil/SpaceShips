package GAME;

import javax.swing.*;
import java.awt.*;

public class Ships extends JComponent{
    ImageIcon i;
    public int posx;
    public int posy;
    public int health=20;
    public boolean up = false;
    public boolean down = false;
    public int speed = 5;
    public int dy;

    public Ships(ImageIcon i,int posx,int posy){
        this.i=i;this.posx=posx;this.posy=posy;
    }

    public void change(){
        if (up){
            dy=-speed;
        }
        if (down){
            dy = speed;
        }
        if (posy <= 16){
            posy = 16;
        }
        if (posy >= 510){
            posy=510;
        }
        posy += dy;
        dy = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(i.getImage(),posx,posy,null);
    }
}
