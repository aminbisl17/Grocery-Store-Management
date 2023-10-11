import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

class Dashboard extends JPanel{
   private JLabel text;
   private JPanel centerPanel, topBar, tablePanel, statisticsPanel;
   private Border borderwhite = BorderFactory.createMatteBorder(0,0, 1,0, new Color(46,47,53)),
                  border = BorderFactory.createMatteBorder(0,0, 1,0, new Color(192,192,192));

                 graphic graph1, graph2, graph3, graph4;
                 tableData td = new tableData();
                 String[] name = {"Id","Produkti", "Numri i shitjes", "Qmimi"};
                 DefaultTableModel  model = new DefaultTableModel(td.data, name);
                 JTable table;

   static void panelCustomiser(JPanel panel, Color color, BorderLayout bl){
        panel.setLayout(bl);
        panel.setBackground(color);
   }
    Dashboard(){

     graph1 = new graphic();
     graph1.setBounds(40, 20, 170, 110);
     graph1.setColor(Color.red);
     graph1.setTxt("Totali i shitjeve (Sot)");

     graph2 = new graphic();
     graph2.setBounds(260, 20, 170, 110);
     graph2.setColor(Color.blue);
     graph2.setTxt("Totali Parave te fituara (Sot)");

     graph3 = new graphic();
     graph3.setBounds(480, 20, 170, 110);
     graph3.setColor(Color.green);
     graph3.setTxt("Totali i shtijeve gjat Muajit");

     graph4 = new graphic();
     graph4.setBounds(700, 20, 170, 110);
     graph4.setColor(Color.PINK);
     graph4.setTxt("Shuma e parave te fituara gjat \t Muajit");

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
     
     table = new JTable(model);
     table.setBounds(40, 200, 850, 150);
     table.setFocusable(false);
     table.setEnabled(false);
     validate();

     statisticsPanel = new JPanel();
     panelCustomiser(statisticsPanel, null, null);
     statisticsPanel.setBounds(0, 40, 1600, 150);
     statisticsPanel.setPreferredSize(new Dimension(100, 650));
     statisticsPanel.add(graph1);
     statisticsPanel.add(graph2);
     statisticsPanel.add(graph3);
     statisticsPanel.add(graph4);
     statisticsPanel.add(table);

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
        g2d.drawRoundRect(0, 0, 170, 110, i, i);
        g2d.fillRoundRect(0,0,170,110, i, i);
        g2d.setColor(Color.white);
        g2d.drawString(txt, 10, 20);
        g2d.drawString("100", 10, 40);
    }
}