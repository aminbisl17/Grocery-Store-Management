import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class Dashboard extends JPanel{
   private JLabel text, text2, text3;
   private JPanel centerPanel = new JPanel(),
                  topBar = new JPanel(),
                  tablePanel = new JPanel(),
                  statisticsPanel = new JPanel();
   private Border borderwhite = BorderFactory.createMatteBorder(0,0, 1,0, new Color(46,47,53)),
                  border = BorderFactory.createMatteBorder(0,0, 1,0, new Color(192,192,192));

                 BorderLayout borderLayout = new BorderLayout();
                 graphic graph1, graph2, graph3, graph4;
                 tableData td = new tableData();
                 JTable table = new JTable(td.data, td.columns);;
                 JScrollPane pane = new JScrollPane(table);
                 
  static void panelCustomiser( // this is a panel customiser
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
    return;
    }
  }
   static void graphCustomiser(JPanel graph, int x){
    graph.setBounds(x, 60, 230, 140);
   }
   static void textCustomiser(JLabel label, int x, int y, int width, int height, int size, Border border){
   Font font = new Font("Monospaced", Font.PLAIN, size);
    label.setBounds(x, y, width, height);
    label.setFont(font);
    label.setBorder(border);
   }
    Dashboard(){

     graph1 = new graphic();
     graphCustomiser(graph1, 60);
     graph1.setColor(new Color(255, 100, 100));
     graph1.setTxt("Totali i shitjeve (Sot)");

     graph2 = new graphic();
     graphCustomiser(graph2, 310);
     graph2.setColor(new Color(80, 130, 220));
     graph2.setTxt("Totali Parave te fituara (Sot)");

     graph3 = new graphic();
     graphCustomiser(graph3, 560);
     graph3.setColor(new Color(70, 135, 95));
     graph3.setTxt("Totali i shtijeve gjat Muajit");

     graph4 = new graphic();
     graphCustomiser(graph4, 810);
     graph4.setColor(new Color(155, 100, 170));
     graph4.setTxt("Shuma e parave te fituara gjat \t Muajit");

     text = new JLabel("DashBoard");
     textCustomiser(text, 20, 40, 100, 20, 17, borderwhite);
     text.setFont(new Font("Monospaced", Font.BOLD, 17));

     text2 = new JLabel("Përmbledhje");
     textCustomiser(text2, 40, 15, 150, 30, 18, borderwhite);

     text3 = new JLabel("Tabela");
     textCustomiser(text3, 40, 220, 150, 30, 18, borderwhite);

     panelCustomiser(centerPanel, borderLayout, true, null, null, 0,0);

     panelCustomiser(topBar, null, true, new Color(255,255,255), border, 100, 80);
     topBar.add(text);
     
     table.setBounds(0, 0, 950, 330);
     table.setRowHeight(30);
     table.setAutoCreateRowSorter(true);
     table.setFocusable(false);
     table.setEnabled(false);     
    
     pane.setBounds(60, 270, 980, 350);
     
     panelCustomiser(statisticsPanel, null, true, new Color(245,245,245), null, 100, 650);
     statisticsPanel.add(pane);
     statisticsPanel.add(text2);
     statisticsPanel.add(text3);
     statisticsPanel.add(graph1);
     statisticsPanel.add(graph2);
     statisticsPanel.add(graph3);
     statisticsPanel.add(graph4);
     statisticsPanel.validate();

     panelCustomiser(tablePanel, null, true, null, null,100,650);
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