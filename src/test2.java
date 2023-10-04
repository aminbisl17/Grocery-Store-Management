import javax.swing.*;
import java.awt.*;

class test2 extends JPanel{
   JLabel text;
    test2(){
     text = new JLabel();
     text.setBounds(200,50,50,50);
     text.setText("hi");
     setBackground(Color.red);
     setPreferredSize(new Dimension(100, 100));
     setLayout(null);
     add(text);
    }
}