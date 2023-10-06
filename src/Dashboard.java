import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

class Dashboard extends JPanel{
   private JLabel text;
   private JPanel centerPanel, topBar;
  private Border borderwhite = BorderFactory.createMatteBorder(0,0, 1,0, new Color(46,47,53)),
                 border = BorderFactory.createMatteBorder(0,0, 1,0, new Color(192,192,192))  ;
   static void panelCustomiser(JPanel panel, Color color){
        panel.setLayout(null);
        panel.setBackground(color);
   }
    Dashboard(){

     text = new JLabel();
     text.setBounds(20,40,100,20);
     text.setText("DashBoard");
     text.setFont(new Font("Monospaced", Font.BOLD, 17));
     text.setBorder(borderwhite);

     centerPanel = new JPanel();
     centerPanel.setLayout(new BorderLayout());
     centerPanel.setPreferredSize(new Dimension(0, 0));

     topBar = new JPanel();
     topBar.setLayout(null);
     topBar.setBackground(new Color(255,255,255));
     topBar.setPreferredSize(new Dimension(100, 80));
     topBar.add(text);
     topBar.setBorder(border);

     centerPanel.add(topBar, BorderLayout.NORTH); 

     setBackground(new Color(255,255,255));
     setPreferredSize(new Dimension(100, 100));
     setLayout(new BorderLayout());
     add(centerPanel, BorderLayout.CENTER);
    }
}
