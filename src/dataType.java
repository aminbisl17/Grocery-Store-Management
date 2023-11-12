 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.python.util.PythonInterpreter;

 class dataType {
 
 //           JLabel icon = new JLabel(new ImageIcon(getClass().getResource("/Images/lIcon (1).png")));
                   
   //          ImageIcon closeIcon = new ImageIcon(getClass().getResource("/Images/close.png"));

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

            public PythonInterpreter interpreter = new PythonInterpreter(),
                                     interpreter1 = new PythonInterpreter();;

            final ImageIcon AIcon = imgi("/Images/adminIcon.png"), 
                       adminIcon = imgi("/Images/admin.png"),
                       categoryIcon = imgi("/Images/category.png"),
                       closeIcon = imgi("/Images/close.png"),
                       minimizeIcon = imgi("/Images/minimize.png"),
                       restore_down = imgi("/Images/restore-down.png"); 


                       JPanel topBar = new JPanel();

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
                Font font, Border border){
                label.setBounds(x, y, width, height);
                label.setForeground(color);
                label.setFont(font);
                label.setBorder(border);}

                MouseAdapter mouseadapter = new MouseAdapter() {
                  public void mousePressed(MouseEvent e){
                         positionX = e.getX();
                         positionY = e.getY();
                  }
          };

          public void graphCustomiser(JPanel graph, int x){
            graph.setBounds(x, 60, 230, 140);
           }
          public Dimension dimension(int width, int height){
            return new Dimension(width, height);
          }
          public RoundRectangle2D.Double roundrectangle(int width, int height, int corner){
                   return new RoundRectangle2D.Double(0,0,width,height,corner,corner);
          }
          public void setButton(JButton button, Color color, Border border){
         
            button.setForeground(color);
            button.setBorder(border);
            
 }
          dataType(){
                //         icon.setBounds(25,70,22,22);
                topBar.setPreferredSize(dimension(100, 80));
                topBar.setLayout(null);
                topBar.setBorder(borderwhite);
                topBar.setBackground(whiteColor);
                    }
}
