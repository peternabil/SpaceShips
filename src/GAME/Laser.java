package GAME;

import java.awt.*;

public class Laser {
    public int x;
    public int y;
    public Color c;
    Rectangle r;
    public Laser(int x,int y,Color c){
        this.x=x;this.y=y;this.c=c;
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(c);
        g2d.fillRect(x,y,10,2);
    }
}
