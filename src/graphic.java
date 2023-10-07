import java.awt.*;

import javax.swing.*;

public class graphic extends JPanel {

    Color color;
    int i = 50 / 2;

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    graphic(){
        this.setPreferredSize(new Dimension(100, 100));
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(color);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRoundRect(0, 0, 170, 110, i, i);
        g2d.fillRoundRect(0,0,170,110, i, i);
    }
}
