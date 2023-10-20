import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.Border;

// MAIN PANEL STARTS HERE ------------------------------------------------------
 class main extends JFrame implements ActionListener, MouseListener{

  private JPanel leftPanel = new JPanel(),
                 centerPanel = new JPanel(),
                 topBar = new JPanel(),
                 container = new JPanel(),
                 topPanel = new JPanel();

  private JLabel text = new JLabel("InnoviSoft"),
                 dateText = new JLabel(),
                 timeText = new JLabel(),
                 adminText = new JLabel("Admin:"),
                 categoriestxt = new JLabel("Catalogue:");

  private JTextArea textarea = new JTextArea();

  private JButton[] buttons = new JButton[4],
                    topBarButtons = new JButton[3];

  private JButton dashBoardButton = new JButton("Dashboard"),
                  categoriesButton = new JButton("Categories"),
                  pijetButton = new JButton("Pijet"),
                  pemPerimetButton = new JButton("Pemet"),
                  close = new JButton(),
                  iconify = new JButton(),
                  resize = new JButton();

  private Color whiteColor = new Color(255, 255, 255),
                bTextColor = new Color(192, 192, 192),
                grayTextColor = new Color(55, 58, 65),
                darkerGrayTextColor = new Color(36,37,43);

  private CardLayout cl = new CardLayout();

  private Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, whiteColor),
                 borderwhite = BorderFactory.createMatteBorder(0,0, 1,0, new Color(192,192,192)),
                 border2 = BorderFactory.createLineBorder(Color.BLACK, 2),
                 sideBorder = BorderFactory.createMatteBorder(0,0, 0,1, new Color(192,192,192));

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
    Date date = new Date();
    SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss a");
    

  boolean expanded = false;
  int i = 55 / 2;       
  RoundRectangle2D.Double roundrectangle = new RoundRectangle2D.Double(0,0,1400,800,i,i);       
  BorderLayout borderlayout = new BorderLayout();

  Timer timer;
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

 private int positionX, positionY;

  Dashboard dashboard = new Dashboard();
  Categories categories = new Categories(); // classes
  test2 test2 = new test2();
  Pijet pijet = new Pijet();

  static void buttonCustomiser // --------------- this method is for button customisation
  (JButton button, Color colorf,
      int x, int y, int width, int height,
      boolean opaque, boolean areafilled,
      boolean borderpainted, boolean focusable) {
    button.setBackground(null);
    button.setForeground(colorf);
    button.setHorizontalTextPosition(SwingConstants.LEFT);
    button.setBounds(x, y, width, height);
    button.setOpaque(opaque);
    button.setContentAreaFilled(areafilled);
    button.setBorderPainted(borderpainted);
    button.setFocusable(focusable);
  }
  // ----------------------

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

  static void label(JLabel label,int x, int y, int size, Color color){
    label.setBounds(x, y, 150, 40);
    label.setFont(new Font("Monospaced", Font.BOLD, size));
    label.setForeground(color);
  }

  main() {

    setDefaultCloseOperation(main.EXIT_ON_CLOSE);
    setUndecorated(true);
    setShape(roundrectangle);
    setSize(1400, 800);
    setLocationRelativeTo(null);

    label(text, 17, 0, 20, whiteColor);
    label(adminText, 25, 20,17, whiteColor);
    label(categoriestxt, 25, 180, 17, whiteColor);
    label(dateText, 180, 0, 15, whiteColor);
    label(timeText, 191, 30, 12, whiteColor);
    // Leftpanel buttons.....................
    buttonCustomiser(dashBoardButton, bTextColor, 60, 60, 160, 30, false, false, true, false);
    buttonCustomiser(categoriesButton, bTextColor, 60, 100, 160, 30, false, false, true, false);
    buttonCustomiser(pijetButton, bTextColor, 60, 230, 160, 30, false, false, true, false);
    buttonCustomiser(pemPerimetButton, bTextColor, 60, 270, 160, 30, false, false, true, false);
    // top bar buttons ............
    buttonCustomiser(close, null, 1300, 5, 50, 20, false, false, true, false);
    buttonCustomiser(iconify, null, 1170, 5, 50, 20, false, false, true, false);
    buttonCustomiser(resize, null, 1230, 5, 50, 20, false, false, true, false);
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
    textarea.setBorder(border2);
    textarea.setEditable(false);
    textarea.setFocusable(false);

    panelCustomiser(topPanel,null, true, grayTextColor, null, 100, 80);
    topPanel.add(text);
    // this panel is within leftPanel and its served as an container for buttons so                              // i can easily move them if wanted
    container.setBounds(30, 50, 240, 450);
    panelCustomiser(container, null,  false, darkerGrayTextColor, null, 100, 100);
    container.add(dateText);
    container.add(adminText);
    container.add(categoriestxt);

      panelCustomiser(topBar, null, true, grayTextColor, null, 50, 30);

      for(int i = 0; i < topBarButtons.length; i++){
         topBarButtons[i].addActionListener(this);
         topBar.add(topBarButtons[i]);
      }
  
    for (int x = 0; x < buttons.length; x++) { // this adds all buttons in container panel
      buttons[x].setFont(new Font("Monospaced", Font.BOLD, 14));
      buttons[x].addActionListener(this);
      buttons[x].setBorder(borderwhite);
      buttons[x].addMouseListener(this);
      container.add(buttons[x]);
    }
    
      dashBoardButton.setBorder(border);
  
    panelCustomiser(centerPanel, cl, true, null, null, 400, 100);
    // ADMIN
    centerPanel.add(dashboard, "1");
    centerPanel.add(categories, "2");
    // Catalogue
    centerPanel.add(pijet, "3");
    centerPanel.add(test2, "4");

    panelCustomiser(leftPanel, borderlayout, true, null, sideBorder, 300, 100);
    leftPanel.add(topPanel, BorderLayout.NORTH);
    leftPanel.add(container, BorderLayout.CENTER);

    
    addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                   positionX = e.getX();
                   positionY = e.getY();
            }
    });
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
             expanded = false;
             setSize(1400, 800);
             setShape(roundrectangle);   
             setLocation(e.getXOnScreen()-positionX, e.getYOnScreen()-positionY);
      }
    });
    revalidate();
 //   repaint();
    setLayout(new BorderLayout());
    showDate();
 //    showTime();
    add(topBar, BorderLayout.NORTH);
    add(centerPanel, BorderLayout.CENTER);
    add(leftPanel, BorderLayout.WEST);
    setVisible(true);
  }
 // -------------------------------       this below is DATE/TIME
  public void showDate() {  // date 
    dateText.setText(sdf.format(date));
    topPanel.add(dateText);
  }
 /* 
  public void showTime(){  // time
    new Timer(0, new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        Date date1 = new Date();
        timeText.setText(sdf1.format(date1));
        topPanel.add(timeText);
      }
    }).start();
  }
// -------------------------------------- MAIN METHOD 

   public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new main();
      }
    });
  }
  */
    public void mousePressed(MouseEvent e)  {
    for (int i = 0; i < buttons.length; i++){
          buttons[i].removeMouseListener(this);}}

    public void mouseEntered(MouseEvent e) {
    for(int i = 0; i < buttons.length; i++){
    if (e.getSource().equals(buttons[i]))  {
            buttons[i].setBorder(border);
            buttons[i].setForeground(whiteColor);}}}

    public void mouseExited(MouseEvent e)  {
    for(int i = 0; i < buttons.length; i++){
    if (e.getSource() == buttons[i])       {
            buttons[i].setBorder(borderwhite);
            buttons[i].setForeground(bTextColor);}}}  
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
    } 
    if(e.getSource().equals(iconify)){this.setExtendedState(main.ICONIFIED);}
    // ends here ---...............
    for(int i = 0; i < buttons.length; i++){
    if  (e.getSource() == buttons[i]){  
            buttons[i].setBorder(border);
            buttons[i].setForeground(whiteColor);
            buttons[i].setOpaque(false);}
    else{
            buttons[i].addMouseListener(this);
            buttons[i].setBorder(borderwhite);
            buttons[i].setForeground(bTextColor);
            buttons[i].setOpaque(true);}

    if  (e.getSource().equals(dashBoardButton))  {cl.show(centerPanel, "1");} 
    if  (e.getSource().equals(categoriesButton)) {cl.show(centerPanel, "2");}
    if  (e.getSource().equals(pijetButton))      {cl.show(centerPanel, "3");}
    if  (e.getSource().equals(pemPerimetButton)) {cl.show(centerPanel, "4");}}}
    public void mouseClicked(MouseEvent e){}public void mouseReleased(MouseEvent e){}}