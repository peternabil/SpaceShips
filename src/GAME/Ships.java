package GAME;

import javax.swing.*;
import java.awt.*;

public class Ships extends JComponent{
    ImageIcon i;
    public int posx;
    public int posy;
    public boolean dead = false;
    public Ships(ImageIcon i,int posx,int posy){
        this.i=i;this.posx=posx;this.posy=posy;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(i.getImage(),posx,posy,null);
    }
}
