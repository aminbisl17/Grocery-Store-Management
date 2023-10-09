import javax.swing.*;
import java.awt.*;

class test2 extends JPanel{

   JLabel text;
   JPanel centerPanel, topBar;
   Color whiteColor = new Color(255,255,255);

    test2(){
     text = new JLabel();
     text.setBounds(20,40,100,20);
     text.setText("hi");

     topBar = new JPanel();
     topBar.setPreferredSize(new Dimension(100, 80));
     topBar.setLayout(null);
     topBar.setBackground(whiteColor);
     topBar.add(text);
     
     centerPanel = new JPanel();
     centerPanel.setPreferredSize(new Dimension(100,100));
     centerPanel.setLayout(null);

     setLayout(new BorderLayout());
     setPreferredSize(new Dimension(100, 100));
     add(topBar, BorderLayout.NORTH);
    }
}