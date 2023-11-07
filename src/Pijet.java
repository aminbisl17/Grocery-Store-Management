import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Pijet extends JPanel {

  dataType datatype = new dataType();

   JPanel topBar, centerPanel;
   JLabel text;
   Color whiteColor = new Color(255,255,255);
   Border borderwhite = BorderFactory.createMatteBorder(0,0,1,0, new Color(46,47,53)),
          border = BorderFactory.createMatteBorder(0,0, 1,0, new Color(192,192,192));

    Pijet(){

     text = new JLabel("Pijet");
     text.setBounds(20,40,100,20);
     text.setFont(new Font("Monospaced", Font.BOLD, 17));
     text.setBorder(borderwhite);

        topBar = new JPanel();
        topBar.setPreferredSize(new Dimension(100, 80));
        topBar.setLayout(null);
        topBar.setBackground(whiteColor);
        topBar.setBorder(border);
        datatype.topBar.add(text);
        topBar.add(text);

        centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(100,100));
        centerPanel.setLayout(null);

      setLayout(new BorderLayout());
      setPreferredSize(new Dimension(100, 100));
      add(datatype.topBar, BorderLayout.NORTH);
      add(centerPanel, BorderLayout.CENTER);
    }
}
