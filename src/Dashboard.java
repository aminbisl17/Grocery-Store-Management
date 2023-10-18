import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class Dashboard extends JPanel{
   private JLabel text, text2;
   private JPanel centerPanel, topBar, tablePanel, statisticsPanel;
   private JScrollPane pane;
   private Border borderwhite = BorderFactory.createMatteBorder(0,0, 1,0, new Color(46,47,53)),
                  border = BorderFactory.createMatteBorder(0,0, 1,0, new Color(192,192,192));

                 graphic graph1, graph2, graph3, graph4;
                 tableData td = new tableData();
                 JTable table;

   static void panelCustomiser(JPanel panel, Color color, BorderLayout bl){
        panel.setLayout(bl);
        panel.setBackground(color);
   }
   static void graphCustomiser(JPanel graph, int x){
    graph.setBounds(x, 60, 230, 140);

   }
    Dashboard(){

     graph1 = new graphic();
     graphCustomiser(graph1, 40);
     graph1.setColor(new Color(255, 100, 100));
     graph1.setTxt("Totali i shitjeve (Sot)");

     graph2 = new graphic();
     graphCustomiser(graph2, 290);
     graph2.setColor(new Color(89, 136, 229));
     graph2.setTxt("Totali Parave te fituara (Sot)");

     graph3 = new graphic();
     graphCustomiser(graph3, 540);
     graph3.setColor(new Color(77, 144, 106));
     graph3.setTxt("Totali i shtijeve gjat Muajit");

     graph4 = new graphic();
     graphCustomiser(graph4, 790);
     graph4.setColor(new Color(155, 100, 179));
     graph4.setTxt("Shuma e parave te fituara gjat \t Muajit");

     text = new JLabel("DashBoard");
     text.setBounds(20,40,100,20);
     text.setFont(new Font("Monospaced", Font.BOLD, 17));
     text.setBorder(borderwhite);

     text2 = new JLabel("Përmbledhje");
     text2.setBounds(40, 15, 150, 30);
     text2.setFont(new Font("Monospaced", Font.BOLD, 20));

     centerPanel = new JPanel();
     centerPanel.setLayout(new BorderLayout());
     centerPanel.setPreferredSize(new Dimension(0, 0));

     topBar = new JPanel();
     panelCustomiser(topBar, new Color(255,255,255), null);
     topBar.setPreferredSize(new Dimension(100, 80));
     topBar.add(text);
     topBar.setBorder(border);
     
     table = new JTable(td.data, td.columns);
     table.setBounds(40, 240, 950, 330);
     table.setRowHeight(30);
     table.setAutoCreateRowSorter(true);
     table.setFocusable(false);
     table.setEnabled(false);     
    
     pane = new JScrollPane(table);
     pane.setBounds(40, 240, 980, 350);
     
     statisticsPanel = new JPanel();
     panelCustomiser(statisticsPanel, new Color(246,245,245), null);
     statisticsPanel.setBounds(0, 40, 1600, 150);
     statisticsPanel.setPreferredSize(new Dimension(100, 650));
     statisticsPanel.add(pane);
     
     statisticsPanel.add(text2);
     statisticsPanel.add(graph1);
     statisticsPanel.add(graph2);
     statisticsPanel.add(graph3);
     statisticsPanel.add(graph4);
     statisticsPanel.validate();

     tablePanel = new JPanel();
     panelCustomiser(tablePanel, null, null);
     tablePanel.setPreferredSize(new Dimension(100, 650));
     tablePanel.add(statisticsPanel);

     centerPanel.add(topBar, BorderLayout.NORTH);
     centerPanel.add(statisticsPanel, BorderLayout.CENTER);

     setPreferredSize(new Dimension(100, 100));
     setLayout(new BorderLayout());
     add(centerPanel, BorderLayout.CENTER);
    }
}
class graphic extends JPanel {

    Color color;
    int i = 55 / 2;
    String txt;

    public String getTxt() {
        return txt;
    }
    public void setTxt(String text) {
        this.txt = text;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    graphic(){
        this.setPreferredSize(new Dimension(100, 100));
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(color);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRoundRect(0, 0, 230, 140, i, i);
        g2d.fillRoundRect(0,0,230,140, i, i);
        g2d.setColor(Color.white);
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 12));
        g2d.drawString(txt, 10, 20);
        g2d.drawString("100", 10, 40);
    }
}