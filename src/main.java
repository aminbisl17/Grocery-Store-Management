import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.management.timer.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

// MAIN PANEL STARTS HERE ------------------------------------------------------
 class main extends JFrame implements ActionListener, MouseListener{

  dataType datatype = new dataType();

  private JPanel    leftPanel = new JPanel(),
                    centerPanel = new JPanel(),
                    topBar = new JPanel(),
                    container = new JPanel(),
                    topPanel = new JPanel();

  private JLabel    text = new JLabel("InnoviSoft"),
                    dateText = new JLabel(),
                    timeText = new JLabel(),
                    adminText = new JLabel("Admin"),
                    categoriestxt = new JLabel("Categories");

  private JTextArea textarea = new JTextArea();

  private JButton[] buttons = new JButton[4],
                    topBarButtons = new JButton[3];

  private JButton   dashBoardButton = new JButton("Dashboard"),
                    categoriesButton = new JButton("Categories"),
                    pijetButton = new JButton("sector 1"),
                    pemPerimetButton = new JButton("sector 2"),
                    close = new JButton(datatype.closeIcon),
                    iconify = new JButton(datatype.minimizeIcon),
                    resize = new JButton(datatype.restore_down);

  private CardLayout cl = new CardLayout();

  protected boolean expanded = false;
              
  Timer timer;
//  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  Dashboard dashboard = new Dashboard();
  Categories categories = new Categories(); // classes
  test2 test2 = new test2();
  Pijet pijet = new Pijet();
  // ----------------------
int posX, posY;

  private void initialiseGUI(Component component){
    //<editor-fold defaultstate="collapsed" desc="code">
    component.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            posX = e.getX();
            posY = e.getY();
        }
    });

    component.addMouseMotionListener(new MouseAdapter() {
        public void mouseDragged(MouseEvent evt) {
            //sets frame position when mouse dragged            
            Rectangle rectangle = getBounds();
            setBounds(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY, rectangle.width, rectangle.height);
        }
    });
    //</editor-fold>
}



  main() {
    setDefaultCloseOperation(main.EXIT_ON_CLOSE);
    setUndecorated(true);
  //  setLocationByPlatform(true);
    setShape(datatype.roundrectangle(1400,800,datatype.corner));
    setLocationRelativeTo(null);

    datatype.textCustomiser(text, 17, 0, 150, 30, datatype.whiteColor, datatype.fontS20, null);
    adminText.setIcon(datatype.adminIcon);
    datatype.textCustomiser(adminText, 25, 30, 245, 35, datatype.Col245, datatype.fontS17p, datatype.borderwhite);
    categoriestxt.setIcon(datatype.categoryIcon);
    datatype.textCustomiser(categoriestxt, 25, 200, 245, 30, datatype.Col245, datatype.fontS17p, datatype.borderwhite);
    datatype.textCustomiser(dateText, 180, 0, 150, 40, datatype.whiteColor, datatype.fontS15, null);
    datatype.textCustomiser(timeText, 191, 30, 150, 40, datatype.whiteColor, datatype.fontS12, null);
    // Leftpanel buttons.....................
    datatype.buttonCustomiser(dashBoardButton, null, datatype.bTextColor, 60, 80, 160, 30, false, false, true, false, this);
    datatype.buttonCustomiser(categoriesButton, null, datatype.bTextColor, 60, 120, 160, 30, false, false, true, false, this);
    datatype.buttonCustomiser(pijetButton, null, datatype.bTextColor, 60, 250, 160, 30, false, false, true, false, this);
    datatype.buttonCustomiser(pemPerimetButton, null, datatype.bTextColor, 60, 290, 160, 30, false, false, true, false, this);
    // top bar buttons ............
    datatype.buttonCustomiser(close, null, null, 0, 0, 0, 0, false, false, false, false, this);
    datatype.buttonCustomiser(iconify, null, null, 0, 0, 0, 0, false, false, false, false, this);
    datatype.buttonCustomiser(resize, null, null, 0, 0, 0, 0, false, false, false, false, this);
    //-------------------------
    buttons[0] = dashBoardButton;
    buttons[1] = categoriesButton;
    buttons[2] = pijetButton;
    buttons[3] = pemPerimetButton;
    // ----------
    topBarButtons[2] = close;
    topBarButtons[0] = iconify;
    topBarButtons[1] = resize;

    textarea.setBounds(45, 25, 200, 100);
    textarea.setBorder(datatype.border2);
    textarea.setEditable(false);
    textarea.setFocusable(false);

    datatype.panelCustomiser(topPanel,null, true, datatype.grayTextColor, null, 100, 80);
    topPanel.add(text);
    // this panel is within leftPanel and its served as an container for buttons so                              // i can easily move them if wanted
    container.setBounds(30, 50, 240, 450);
    datatype.panelCustomiser(container, null,  false, datatype.darkerGrayTextColor, null, 100, 100);
    container.add(dateText);
    container.add(adminText);
    container.add(categoriestxt);

    datatype.panelCustomiser(topBar, new FlowLayout(FlowLayout.RIGHT, 3, 0), true, datatype.grayTextColor, null, 0, 30);

    for(int i = 0; i < topBarButtons.length; i++){
     topBar.add(topBarButtons[i]);
      }
  
    for (int x = 0; x < buttons.length; x++) { // this adds all buttons in container panel
      buttons[x].setFont(datatype.fontS14);
      buttons[x].setBorder(datatype.borderwhite);
      buttons[x].addMouseListener(this);
      container.add(buttons[x]);
    }
    
    dashBoardButton.setBorder(datatype.border);
  
    datatype.panelCustomiser(centerPanel, cl, true, null, null, 400, 100);
    // ADMIN
    centerPanel.add(dashboard, "1");
    centerPanel.add(categories, "2");
    // Catalogue
    centerPanel.add(pijet, "3");
    centerPanel.add(test2, "4");

    datatype.panelCustomiser(leftPanel, datatype.borderlayout, true, null, datatype.sideBorder, 300, 100);
    leftPanel.add(topPanel, BorderLayout.NORTH);
    leftPanel.add(container, BorderLayout.CENTER);

    
    addMouseListener(datatype.mouseadapter);
  /*   addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) { 
              SwingUtilities.invokeLater(()-> {
                expanded = false; 
                 setLocation(e.getXOnScreen()-datatype.positionX, e.getYOnScreen()-datatype.positionY);
              if(!expanded){
             setSize(1400, 800);
             setShape(datatype.roundrectangle(1400,800,datatype.corner));  
             return;
              }
              });
      }
    });
    */
    initialiseGUI(this);

   setIconImage(datatype.imgi("/Images/icons8-cart-48.png").getImage());
    revalidate();
    repaint();
    showDate();
    setLayout(new BorderLayout());
   // showTime();
    add(topBar, BorderLayout.NORTH);
    add(centerPanel, BorderLayout.CENTER);
    add(leftPanel, BorderLayout.WEST);
    setSize(1400, 800);
    setVisible(true);

  }
 // -------------------------------       this below is DATE/TIME
  public void showDate() {  // date 
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
    Date date = new Date();
    dateText.setText(sdf.format(date));
    topPanel.add(dateText);
  }
  /* 
  public void showTime(){  // time
    new Timer(0, new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        timeText.setText(sdf.format(date));
        topPanel.add(timeText);
      }
    }).start();
  }
  */
// -------------------------------------- MAIN METHOD
   public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new main();
            }
    });
  }

    public void mousePressed(MouseEvent e)  {
    for (int i = 0; i < buttons.length; i++){
          buttons[i].removeMouseListener(this);}}

    public void mouseEntered(MouseEvent e) {
    for(int i = 0; i < buttons.length; i++){
    if (e.getSource().equals(buttons[i]))  {
            buttons[i].setBorder(datatype.border);
            buttons[i].setForeground(datatype.whiteColor);}}}

    public void mouseExited(MouseEvent e)  {
    for(int i = 0; i < buttons.length; i++){
    if (e.getSource() == buttons[i])       {
            buttons[i].setBorder(datatype.borderwhite);
            buttons[i].setForeground(datatype.bTextColor);}}}  
 // ----------------------------------
    public void actionPerformed(ActionEvent e) {
    // this are the buttons to resize, iconify and close the program... -- it starts here  

   if(e.getSource().equals(close)){System.exit(0);}
   if(e.getSource().equals(resize)){ if(!expanded){  
      setShape(null);
      setExtendedState(main.MAXIMIZED_BOTH); 
      setLocation(0,0);
      expanded = true;
      return;
    }
      expanded = false;
      setSize(1400, 800); 
      setShape(datatype.roundrectangle(1400,800,datatype.corner));
      setLocationRelativeTo(null);
      return;
    } 
    if(e.getSource().equals(iconify)){this.setExtendedState(main.ICONIFIED);}
    // ends here ---...............
    for(int i = 0; i < buttons.length; i++){
    if  (e.getSource() == buttons[i]){  
            buttons[i].setBorder(datatype.border);
            buttons[i].setForeground(datatype.whiteColor);
            buttons[i].setOpaque(false);}
    else{
            buttons[i].addMouseListener(this);
            buttons[i].setBorder(datatype.borderwhite);
            buttons[i].setForeground(datatype.bTextColor);
            buttons[i].setOpaque(true);}

    if  (e.getSource().equals(dashBoardButton))  {cl.show(centerPanel, "1");} 
    if  (e.getSource().equals(categoriesButton)) {cl.show(centerPanel, "2");}
    if  (e.getSource().equals(pijetButton))      {cl.show(centerPanel, "3");}
    if  (e.getSource().equals(pemPerimetButton)) {cl.show(centerPanel, "4");}}
    }
    public void mouseClicked(MouseEvent e){}public void mouseReleased(MouseEvent e){}}    