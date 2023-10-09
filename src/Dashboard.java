import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class Dashboard extends JPanel{
   private JLabel text;
   private JPanel centerPanel, topBar, tablePanel, statisticsPanel;
   private Border borderwhite = BorderFactory.createMatteBorder(0,0, 1,0, new Color(46,47,53)),
                  border = BorderFactory.createMatteBorder(0,0, 1,0, new Color(192,192,192));

                 graphic graph1, graph2, graph3;

   static void panelCustomiser(JPanel panel, Color color, BorderLayout bl){
        panel.setLayout(bl);
        panel.setBackground(color);
   }
    Dashboard(){

     graph1 = new graphic();
     graph1.setBounds(40, 20, 170, 110);
     graph1.setColor(Color.red);

     graph2 = new graphic();
     graph2.setBounds(260, 20, 170, 110);
     graph2.setColor(Color.blue);

     graph3 = new graphic();
     graph3.setBounds(480, 20, 170, 110);
     graph3.setColor(Color.green);

     text = new JLabel();
     text.setBounds(20,40,100,20);
     text.setText("DashBoard");
     text.setFont(new Font("Monospaced", Font.BOLD, 17));
     text.setBorder(borderwhite);

     centerPanel = new JPanel();
     centerPanel.setLayout(new BorderLayout());
     centerPanel.setPreferredSize(new Dimension(0, 0));

     topBar = new JPanel();
     panelCustomiser(topBar, new Color(255,255,255), null);
     topBar.setPreferredSize(new Dimension(100, 80));
     topBar.add(text);
     topBar.setBorder(border);

     statisticsPanel = new JPanel();
     panelCustomiser(statisticsPanel, null, null);
     statisticsPanel.setBounds(0, 40, 1600, 150);
     statisticsPanel.setPreferredSize(new Dimension(100, 650));
     statisticsPanel.add(graph1);
     statisticsPanel.add(graph2);
     statisticsPanel.add(graph3);

     tablePanel = new JPanel();
     panelCustomiser(tablePanel, null, null);
     tablePanel.setPreferredSize(new Dimension(100, 650));
     tablePanel.add(statisticsPanel);

     centerPanel.add(topBar, BorderLayout.NORTH);
     centerPanel.add(statisticsPanel, BorderLayout.CENTER);


     setBackground(new Color(255,255,255));
     setPreferredSize(new Dimension(100, 100));
     setLayout(new BorderLayout());
     add(centerPanel, BorderLayout.CENTER);
    }
}
