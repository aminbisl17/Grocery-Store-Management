import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;



class Dashboard extends JPanel{

    dataType datatype = new dataType();

   private JLabel  text = new JLabel("DashBoard"),
                   text2 = new JLabel("Përmbledhje"),
                   text3 = new JLabel("Tabela"),
                   Aicon = new JLabel(datatype.imgi("/Images/adminIcon.png"));

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
            

    Dashboard(){
     
     datatype.panelCustomiser(tablePanel, null, true, null, null,100,650);

     datatype.graphCustomiser(graph1, 60);
     graph1.setColor1(new Color(240, 138, 138));
     graph1.setColor2(new Color(255, 51, 51));
     graph1.setTxt("Totali i shitjeve\n(Sot)");
     graph1.setImage(datatype.imgi("/Images/Cart.png").getImage());

     datatype.graphCustomiser(graph2, 310);
     graph2.setColor1(new Color(132, 177, 255));
     graph2.setColor2(new Color(80, 130, 220));
     graph2.setTxt("Totali Parave te fituara (Sot)");
     graph2.setImage(datatype.imgi("/Images/Money.png").getImage());

     datatype.graphCustomiser(graph3, 560);
     graph3.setColor1(new Color(122, 202, 154));
     graph3.setColor2(new Color(70, 135, 95));
     graph3.setTxt("Totali i shtijeve gjat Muajit");
     graph3.setImage(datatype.imgi("/Images/Monthly.png").getImage());

     datatype.graphCustomiser(graph4, 810);
     graph4.setColor1(new Color(214, 155, 229));
     graph4.setColor2(new Color(155, 100, 170));
     graph4.setTxt("Shuma e parave te fituara gjat \t Muajit");
     graph4.setImage(datatype.imgi("/Images/sMoney.png").getImage());

     datatype.textCustomiser(text, 20, 40, 100, 20, datatype.grayTextColor, datatype.fontS17);
     datatype.textCustomiser(text2, 40, 15, 150, 30, datatype.grayTextColor, datatype.fontS17p);
     datatype.textCustomiser(text3, 40, 220, 150, 30, datatype.grayTextColor, datatype.fontS17p);
     text.setBorder(datatype.Blackborder);
     text2.setBorder(datatype.Blackborder);
     text3.setBorder(datatype.Blackborder);

     datatype.panelCustomiser(centerPanel, borderLayout, true, null, null, 0,0);

     datatype.panelCustomiser(topBar, null, true, datatype.whiteColor, datatype.borderwhite, 100, 80);
     topBar.add(text);
     Aicon.setBounds(950, 10, 100,50);
     Aicon.setText("Admin");
     Aicon.setFont(datatype.fontS15);
     Aicon.setBorder(datatype.Blackborder);
     topBar.add(Aicon);
     
     table.setBounds(0, 0, 950, 330);
     table.setRowHeight(30);
     table.setAutoCreateRowSorter(true);
     table.setFocusable(false);
     table.setEnabled(false);     
     table.setForeground(datatype.grayTextColor);
     table.getTableHeader().setPreferredSize(new Dimension(0,35));
     table.getTableHeader().setBackground(datatype.Col245);
     table.getTableHeader().setFont(datatype.fontS12);

    
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

    Color color1, color2;
    public Color getColor1() {
        return color1;
    }
    public void setColor1(Color color1) {
        this.color1 = color1;
    }
    public Color getColor2() {
        return color2;
    }
    public void setColor2(Color color2) {
        this.color2 = color2;
    }
    String txt;

    Image image;

    private void drawstring(Graphics g, String text, int x, int y){
        if(text.length() > 20){
             for(String line : text.split("\n")){
                  g.drawString(line, x, y += g.getFontMetrics().getHeight());
             }
             return;
            } else{
         g.drawString(text, x, y);
            }
    }


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
 
    graphic(){
        this.setPreferredSize(new Dimension(100, 100));
    }
    Point2D.Double p1 = new Point2D.Double(120, 20);
    Point2D.Double p2 = new Point2D.Double(90, 115);

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new GradientPaint(p1, color1, p2, color2));
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRoundRect(0, 0, 230, 140, datatype.corner, datatype.corner);
        g2d.fillRoundRect(0,0,230,140, datatype.corner, datatype.corner);
        g2d.setColor(datatype.whiteColor);
        g2d.setFont(datatype.fontS14);
        drawstring(g2d, txt, 10, 10);
      //  g2d.drawString(txt, 10, 30);
        g2d.drawString("100", 40, 80);
        g2d.drawImage(image, 120,45, null);
    }
}