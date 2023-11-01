 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

 class dataType {
 
            JLabel icon = new JLabel(new ImageIcon(getClass().getResource("/Images/lIcon (1).png")));
                   
             ImageIcon closeIcon = new ImageIcon(getClass().getResource("/Images/close.png"));

             public ImageIcon imgi(String path){
              java.net.URL imgURL = getClass().getResource(path);
                 if(imgURL != null){
                     return new ImageIcon(imgURL);
                 }
                 else {
                     System.err.println("Couldn't find image");
                     return null;
                 }
             }

                    dataType(){
                         icon.setBounds(25,70,22,22);
                    }

    final BorderLayout borderlayout = new BorderLayout();

    final        int corner = 55 / 2;
                 int positionX, positionY;

    final Font   fontS12 =  new Font("Monospaced", Font.BOLD, 12),
                 fontS14 = new Font("Serif", Font.BOLD, 14),
                 fontS15 = new Font("Monospaced" , Font.BOLD, 15),
                 fontS17 = new Font("Monospaced", Font.BOLD, 17),
                 fontS17p = new Font("Monospaced", Font.PLAIN, 17),
                 fontS20 = new Font("Monospaced", Font.BOLD, 20),
                 fontS22 = new Font("Monospaced", Font.BOLD, 22);

    final Color  whiteColor = new Color(255, 255, 255),
                 Col245 = new Color(235,235,235),
                 bTextColor = new Color(192, 192, 192),
                 grayTextColor = new Color(55, 58, 65),
                 darkerGrayTextColor = new Color(43,44,50),
                 noCol = new Color(0,0,0);


    final Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, whiteColor),
                 Blackborder = BorderFactory.createMatteBorder(0, 0, 1, 0, noCol),
                 borderwhite = BorderFactory.createMatteBorder(0,0, 1,0, bTextColor),
                 border2 = BorderFactory.createLineBorder(Color.BLACK, 2),
                 sideBorder = BorderFactory.createMatteBorder(0,0, 0,1, bTextColor);

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

                MouseAdapter mouseadapter = new MouseAdapter() {
                  public void mousePressed(MouseEvent e){
                         positionX = e.getX();
                         positionY = e.getY();
                  }
          };

}
