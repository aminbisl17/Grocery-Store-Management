import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;



class Dashboard extends JPanel{

    dataType datatype = new dataType();

   private JLabel  text = new JLabel("DashBoard"),
                   text2 = new JLabel("Përmbledhje"),
                   text3 = new JLabel("Tabela");

   private JPanel centerPanel = new JPanel(),
                  topBar = new JPanel(),
                  tablePanel = new JPanel(),
                  statisticsPanel = new JPanel();

                 BorderLayout borderLayout = new BorderLayout();
                 graphic graph1 = new graphic(),
                         graph2 = new graphic(),
                         graph3 = new graphic(),
                         graph4 = new graphic();
                 tableData td = new tableData();
                 JTable table = new JTable(td.data, td.columns);;
                 JScrollPane pane = new JScrollPane(table);
                 
   static void graphCustomiser(JPanel graph, int x){
    graph.setBounds(x, 60, 230, 140);
   }
    Dashboard(){
        datatype.panelCustomiser(tablePanel, null, true, null, null,100,650);
     graphCustomiser(graph1, 60);
     graph1.setColor(new Color(255, 100, 100));
     graph1.setTxt("Totali i shitjeve (Sot)");
     graph1.setImage(new ImageIcon(getClass().getResource("/Images/Cart.png")).getImage());

     graph2 = new graphic();
     graphCustomiser(graph2, 310);
     graph2.setColor(new Color(80, 130, 220));
     graph2.setTxt("Totali Parave te fituara (Sot)");
     graph2.setImage(new ImageIcon(getClass().getResource("/Images/Money.png")).getImage());

     graph3 = new graphic();
     graphCustomiser(graph3, 560);
     graph3.setColor(new Color(70, 135, 95));
     graph3.setTxt("Totali i shtijeve gjat Muajit");
     graph3.setImage(new ImageIcon(getClass().getResource("/Images/Monthly.png")).getImage());

     graph4 = new graphic();
     graphCustomiser(graph4, 810);
     graph4.setColor(new Color(155, 100, 170));
     graph4.setTxt("Shuma e parave te fituara gjat \t Muajit");
     graph4.setImage(new ImageIcon(getClass().getResource("/Images/sMoney.png")).getImage());

     datatype.textCustomiser(text, 20, 40, 100, 20, datatype.grayTextColor, datatype.fontS17);
     datatype.textCustomiser(text2, 40, 15, 150, 30, datatype.grayTextColor, datatype.fontS17p);
     datatype.textCustomiser(text3, 40, 220, 150, 30, datatype.grayTextColor, datatype.fontS17p);
     text.setBorder(datatype.Blackborder);
     text2.setBorder(datatype.Blackborder);
     text3.setBorder(datatype.Blackborder);

     datatype.panelCustomiser(centerPanel, borderLayout, true, null, null, 0,0);

     datatype.panelCustomiser(topBar, null, true, datatype.whiteColor, datatype.borderwhite, 100, 80);
     topBar.add(text);
     
     table.setBounds(0, 0, 950, 330);
     table.setRowHeight(30);
     table.setAutoCreateRowSorter(true);
     table.setFocusable(false);
     table.setEnabled(false);     
    
     pane.setBounds(60, 270, 980, 350);
     
     datatype.panelCustomiser(statisticsPanel, null, true, datatype.Col245, null, 100, 650);
     statisticsPanel.add(pane);
     statisticsPanel.add(text2);
     statisticsPanel.add(text3);
     statisticsPanel.add(graph1);
     statisticsPanel.add(graph2);
     statisticsPanel.add(graph3);
     statisticsPanel.add(graph4);
     statisticsPanel.validate();

     tablePanel.add(statisticsPanel);

     centerPanel.add(topBar, BorderLayout.NORTH);
     centerPanel.add(statisticsPanel, BorderLayout.CENTER);

     setPreferredSize(new Dimension(100, 100));
     setLayout(new BorderLayout());
     add(centerPanel, BorderLayout.CENTER);
    }
}
class graphic extends JPanel {

    dataType datatype = new dataType();

    Color color;
    String txt;

    Image image;


    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
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
        g2d.drawRoundRect(0, 0, 230, 140, datatype.corner, datatype.corner);
        g2d.fillRoundRect(0,0,230,140, datatype.corner, datatype.corner);
        g2d.setColor(datatype.whiteColor);
        g2d.setFont(datatype.fontS12);
        g2d.drawString(txt, 10, 20);
        g2d.drawString("100", 40, 80);
        g2d.drawImage(image, 120,45, null);
    }
}