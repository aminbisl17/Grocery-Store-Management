import javax.swing.*;
import java.awt.*;

class Dashboard extends JPanel{
   private JLabel text;
   private JPanel centerPanel, topBar;

   static void panelCustomiser(JPanel panel, Color color){
        panel.setLayout(null);
        panel.setBackground(color);
   }
    Dashboard(){

     text = new JLabel();
     text.setBounds(10,10,50,50);
     text.setText("hello");

     centerPanel = new JPanel();
     centerPanel.setLayout(new BorderLayout());
     centerPanel.setPreferredSize(new Dimension(0, 0));

     topBar = new JPanel();
     topBar.setLayout(null);
     topBar.setBackground(new Color(255,255,255));
     topBar.setPreferredSize(new Dimension(100, 80));
     topBar.add(text);

     centerPanel.add(topBar, BorderLayout.NORTH); 

     setBackground(new Color(255,255,255));
     setPreferredSize(new Dimension(100, 100));
     setLayout(new BorderLayout());
     add(centerPanel, BorderLayout.CENTER);
    }
}
