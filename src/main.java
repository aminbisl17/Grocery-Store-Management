import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

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
                    adminText = new JLabel("Admin:"),
                    categoriestxt = new JLabel("Catalogue:");

  private JTextArea textarea = new JTextArea();

  private JButton[] buttons = new JButton[4],
                    topBarButtons = new JButton[3];

  private JButton   dashBoardButton = new JButton("Dashboard"),
                    categoriesButton = new JButton("Categories"),
                    pijetButton = new JButton("Pijet"),
                    pemPerimetButton = new JButton("Pemet"),
                    close = new JButton(),
                    iconify = new JButton(),
                    resize = new JButton();

  private CardLayout cl = new CardLayout();

  boolean expanded = false;
        
  RoundRectangle2D.Double roundrectangle = new RoundRectangle2D.Double(0,0,1400,800,datatype.corner,datatype.corner);       
 

  Timer timer;
//  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int positionX, positionY;
  Dashboard dashboard = new Dashboard();
  Categories categories = new Categories(); // classes
  test2 test2 = new test2();
  Pijet pijet = new Pijet();
  // ----------------------

  main() {
    setDefaultCloseOperation(main.EXIT_ON_CLOSE);
    setUndecorated(true);
    setShape(roundrectangle);
    setSize(1400, 800);
    setLocationRelativeTo(null);

    datatype.textCustomiser(text, 17, 0, 150, 40, datatype.whiteColor, new Font("Monospaced", Font.BOLD, 20));
    datatype.textCustomiser(adminText, 25, 20, 150, 40, datatype.whiteColor, new Font("Monospaced", Font.BOLD, 17));
    datatype.textCustomiser(categoriestxt, 25, 180, 150, 40, datatype.whiteColor, new Font("Monospaced", Font.BOLD, 17));
    datatype.textCustomiser(dateText, 180, 0, 150, 40, datatype.whiteColor, new Font("Monospaced", Font.BOLD, 15));
    datatype.textCustomiser(timeText, 191, 30, 150, 40, datatype.whiteColor, new Font("Monospaced", Font.BOLD, 12));
    // Leftpanel buttons.....................
    datatype.buttonCustomiser(dashBoardButton, null, datatype.bTextColor, 60, 60, 160, 30, false, false, true, false, this);
    datatype.buttonCustomiser(categoriesButton, null, datatype.bTextColor, 60, 100, 160, 30, false, false, true, false, this);
    datatype.buttonCustomiser(pijetButton, null, datatype.bTextColor, 60, 230, 160, 30, false, false, true, false, this);
    datatype.buttonCustomiser(pemPerimetButton, null, datatype.bTextColor, 60, 270, 160, 30, false, false, true, false, this);
    // top bar buttons ............
    datatype.buttonCustomiser(close, null, null, 1300, 5, 50, 20, false, false, true, false, this);
    datatype.buttonCustomiser(iconify, null, null, 1170, 5, 50, 20, false, false, true, false, this);
    datatype.buttonCustomiser(resize, null, null, 1230, 5, 50, 20, false, false, true, false, this);
    //-------------------------
    buttons[0] = dashBoardButton;
    buttons[1] = categoriesButton;
    buttons[2] = pijetButton;
    buttons[3] = pemPerimetButton;
    // ----------
    topBarButtons[0] = close;
    topBarButtons[1] = iconify;
    topBarButtons[2] = resize;

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

    datatype.panelCustomiser(topBar, null, true, datatype.grayTextColor, null, 50, 30);

    for(int i = 0; i < topBarButtons.length; i++){
     topBar.add(topBarButtons[i]);
      }
  
    for (int x = 0; x < buttons.length; x++) { // this adds all buttons in container panel
      buttons[x].setFont(new Font("Monospaced", Font.BOLD, 14));
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

    
    addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                   datatype.positionX = e.getX();
                   datatype.positionY = e.getY();
            }
    });
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
             expanded = false;
             setSize(1400, 800);
             setShape(roundrectangle);   
             setLocation(e.getXOnScreen()-datatype.positionX, e.getYOnScreen()-datatype.positionY);
      }
    });
    revalidate();
    repaint();
    showDate();
    setLayout(new BorderLayout());
   // showTime();
    add(topBar, BorderLayout.NORTH);
    add(centerPanel, BorderLayout.CENTER);
    add(leftPanel, BorderLayout.WEST);
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
      setShape(roundrectangle);
      setLocation(100, 200);
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
    if  (e.getSource().equals(pemPerimetButton)) {cl.show(centerPanel, "4");}}}
    public void mouseClicked(MouseEvent e){}public void mouseReleased(MouseEvent e){}}    