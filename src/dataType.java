 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

 class dataType {

    final BorderLayout borderlayout = new BorderLayout();

    final        int corner = 55 / 2;
                 int positionX, positionY;

    final Font   font = new Font("Serif", Font.BOLD, 14);

    final Color  whiteColor = new Color(255, 255, 255),
                 bTextColor = new Color(192, 192, 192),
                 grayTextColor = new Color(55, 58, 65),
                 darkerGrayTextColor = new Color(36,37,43),
                 noCol = new Color(0,0,0);


    final Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, whiteColor),
                 borderwhite = BorderFactory.createMatteBorder(0,0, 1,0, new Color(192,192,192)),
                 border2 = BorderFactory.createLineBorder(Color.BLACK, 2),
                 sideBorder = BorderFactory.createMatteBorder(0,0, 0,1, new Color(192,192,192));

    public void buttonCustomiser(JButton button, Color Colorb, Color Colorf,
                 int x, int y, int width, int height,
                 boolean opaque, boolean areafilled,
                 boolean borderpainted, boolean focusable, ActionListener e) {
                 button.setBackground(Colorb);
                 button.setForeground(Colorf);
  //  button.setHorizontalTextPosition(SwingConstants.LEFT);
                 button.setBounds(x, y, width, height);
                 button.setOpaque(opaque);
                 button.setContentAreaFilled(areafilled);
                 button.setBorderPainted(borderpainted);
                 button.setFocusable(focusable);
                 button.addActionListener(e);}
  
    public void panelCustomiser( // this is a panel customiser
                 JPanel panel,
                 LayoutManager layout,
                 Boolean size,
                 Color color,
                 Border border,
                 int width, int height) {
                 panel.setBackground(color);
                 panel.setLayout(layout);
                 panel.setBorder(border);
       if(size){
                 panel.setPreferredSize(new Dimension(width, height));
       return;}}

    public void textCustomiser  //this method is to customise text
                (JLabel label,
                int x, int y, int width, int height,
                Color color,
                Font font){
                label.setBounds(x, y, width, height);
                label.setForeground(color);
                label.setFont(font);}

}
