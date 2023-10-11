import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

class test2 extends JPanel{

   JLabel text;
   JPanel centerPanel, topBar;
   Color whiteColor = new Color(255,255,255);
   Border borderwhite = BorderFactory.createMatteBorder(0,0,1,0, new Color(46,47,53)),
          border = BorderFactory.createMatteBorder(0,0, 1,0, new Color(192,192,192));

    test2(){
     text = new JLabel("Pemet");
     text.setBounds(20,40,100,20);
     text.setFont(new Font("Monospaced", Font.BOLD, 17));
     text.setBorder(borderwhite);

     topBar = new JPanel();
     topBar.setPreferredSize(new Dimension(100, 80));
     topBar.setLayout(null);
     topBar.setBackground(whiteColor);
     topBar.setBorder(border);
     topBar.add(text);
     
     centerPanel = new JPanel();
     centerPanel.setPreferredSize(new Dimension(100,100));
     centerPanel.setLayout(null);

     setLayout(new BorderLayout());
     setPreferredSize(new Dimension(100, 100));
     add(topBar, BorderLayout.NORTH);
    }
}