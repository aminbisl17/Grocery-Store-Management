import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.Border;

// MAIN PANEL STARTS HERE ------------------------------------------------------
public class main extends JFrame implements ActionListener, MouseListener{

  private JPanel leftPanel, centerPanel, topBar, container, topPanel, bottomPanel;
  private JLabel text, dateText, timeText, adminText, categoriestxt;
  private JTextArea textarea;
  public JButton[] buttons = new JButton[4];
  private JButton dashBoardButton, categoriesButton, pijetButton, pemPerimetButton, close, iconify, fullsize;
  private Color whiteColor = new Color(255, 255, 255), bTextColor = new Color(192, 192, 192);
  private CardLayout cl = new CardLayout();
  private Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, whiteColor),
                 borderwhite = BorderFactory.createMatteBorder(0,0, 1,0, new Color(192,192,192)),
                 border2 = BorderFactory.createLineBorder(Color.BLACK, 2),
                 sideBorder = BorderFactory.createMatteBorder(0,0, 0,1, new Color(192,192,192));
                
  boolean check;
  int i = 55 / 2;              
  Timer timer;
  MouseAdapter mouseadapter;
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

    text = new JLabel("InnoviSoft");
    label(text, 17, 0, 20, whiteColor);

    adminText = new JLabel("Admin:");
    label(adminText, 25, 20,17, whiteColor);

    categoriestxt = new JLabel("Catalogue:");
    label(categoriestxt, 25, 180, 17, whiteColor);

    dateText = new JLabel();
    dateText.setBounds(180, 10, 100, 30);
    dateText.setFont(new Font("Monospaced", Font.BOLD, 15));
    dateText.setForeground(whiteColor);

    timeText = new JLabel();
    timeText.setBounds(191, 40, 100, 10);
    timeText.setFont(new Font("Monospaced", Font.BOLD, 12));
    timeText.setForeground(whiteColor);

    dashBoardButton = new JButton("Dashboard");
    buttonCustomiser(dashBoardButton, bTextColor, 60, 60, 160, 30, false, false, true, false);

    categoriesButton = new JButton("Categories");
    buttonCustomiser(categoriesButton, bTextColor, 60, 100, 160, 30, false, false, true, false);

    pijetButton = new JButton("Pijet");
    buttonCustomiser(pijetButton, bTextColor, 60, 230, 160, 30, false, false, true, false);

    pemPerimetButton = new JButton("Pemet");
    buttonCustomiser(pemPerimetButton, bTextColor, 60, 270, 160, 30, false, false, true, false);


    buttons[0] = dashBoardButton;
    buttons[1] = categoriesButton;
    buttons[2] = pijetButton;
    buttons[3] = pemPerimetButton;

    textarea = new JTextArea();
    textarea.setBounds(45, 25, 200, 100);
    textarea.setBorder(border2);
    textarea.setEditable(false);
    textarea.setFocusable(false);

    topPanel = new JPanel();
    panelCustomiser(topPanel,null, true, new Color(65, 68, 75), null, 100, 80);
    topPanel.add(text);

    container = new JPanel(); // this panel is within leftPanel and its served as an container for buttons so
                              // i can easily move them if wanted
    container.setBounds(30, 50, 240, 450);
    panelCustomiser(container, null,  false, new Color(46, 47, 53), null, 100, 100);
    container.add(dateText);
    container.add(adminText);
    container.add(categoriestxt);

    bottomPanel = new JPanel();
    panelCustomiser(bottomPanel, null,  true, new Color(65,68,75), null, 100, 150);
    bottomPanel.add(textarea);

    for (int x = 0; x < buttons.length; x++) { // this adds all buttons in container panel
      container.add(buttons[x]);
      buttons[x].setFont(new Font("Monospaced", Font.BOLD, 14));
      buttons[x].addActionListener(this);
      buttons[x].setBorder(borderwhite);
      buttons[x].addMouseListener(this);
    }
    
      dashBoardButton.setBorder(border);
    
      close = new JButton();
      close.addActionListener(this);
      close.setBounds(1300, 5, 50, 20);

      iconify = new JButton("iconify");
      iconify.addActionListener(this);
      iconify.setBounds(1170, 5, 50, 20);

      fullsize = new JButton();
      fullsize.addActionListener(this);
      fullsize.setBounds(1230, 5, 50, 20);
      topBar = new JPanel();
      panelCustomiser(topBar, null, true, new Color(65, 68,75), null, 50, 30);
      topBar.add(close);
      topBar.add(iconify);
      topBar.add(fullsize);

 
    centerPanel = new JPanel();
    panelCustomiser(centerPanel, cl, true, null, null, 400, 100);
    // ADMIN
    centerPanel.add(dashboard, "1");
    centerPanel.add(categories, "2");
    // Catalogue
    centerPanel.add(pijet, "3");
    centerPanel.add(test2, "4");

    leftPanel = new JPanel();
    panelCustomiser(leftPanel, new BorderLayout(), true, whiteColor, sideBorder, 300, 100);
    leftPanel.add(topPanel, BorderLayout.NORTH);
    leftPanel.add(container, BorderLayout.CENTER);

    setDefaultCloseOperation(main.EXIT_ON_CLOSE);
    setUndecorated(true);
    setShape(new RoundRectangle2D.Double(0, 0, 1400, 800, i, i));
    setSize(1400, 800);
    setLocationRelativeTo(null);
    setTitle("InnoviStore");
    addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                   positionX = e.getX();
                   positionY = e.getY();
            }
    });
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
             setLocation(e.getXOnScreen()-positionX, e.getYOnScreen()-positionY);
      }
    });

    revalidate();
    repaint();
    setLayout(new BorderLayout());
    showDate();
    showTime();
    add(topBar, BorderLayout.NORTH);
    add(centerPanel, BorderLayout.CENTER);
    add(leftPanel, BorderLayout.WEST);
   // cl.show(centerPanel, "1");
    setVisible(true);
  }
 // -------------------------------       this below is DATE/TIME
  public void showDate() {  // date 
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
    Date date = new Date();
    dateText.setText(sdf.format(date));
    topPanel.add(dateText);
  }

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
            buttons[i].setBorder(border);
            buttons[i].setForeground(whiteColor);}}}

    public void mouseExited(MouseEvent e)  {
    for(int i = 0; i < buttons.length; i++){
    if (e.getSource() == buttons[i])       {
            buttons[i].setBorder(borderwhite);
            buttons[i].setForeground(bTextColor);}}}  
 // ----------------------------------
    public void actionPerformed(ActionEvent e) {
    
    if(e.getSource().equals(close)){System.exit(0);}
    if(e.getSource().equals(fullsize)){ check = true; if(check){
      this.setShape(null);this.setExtendedState(JFrame.MAXIMIZED_BOTH); check = false;}}
    if(e.getSource() == fullsize){if(!check){ check = false; this.setShape(new RoundRectangle2D.Double(0, 0, 1400, 800, i, i)); check = true;}}
    if(e.getSource().equals(iconify)){this.setExtendedState(main.ICONIFIED);}

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
    if  (e.getSource().equals(dashBoardButton))  {cl.show(centerPanel, "1"); leftPanel.remove(bottomPanel);}
    if  (e.getSource().equals(categoriesButton)) {cl.show(centerPanel, "2");leftPanel.remove(bottomPanel);}
    if  (e.getSource().equals(pijetButton))      {cl.show(centerPanel, "3");leftPanel.add(bottomPanel, BorderLayout.SOUTH);}
    if  (e.getSource().equals(pemPerimetButton)) {cl.show(centerPanel, "4");leftPanel.add(bottomPanel, BorderLayout.SOUTH);}}}
    public void mouseClicked(MouseEvent e){}public void mouseReleased(MouseEvent e){}}