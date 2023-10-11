import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.Border;

// MAIN PANEL STARTS HERE ------------------------------------------------------
public class main extends JFrame implements ActionListener, MouseListener{

  private JPanel leftPanel, centerPanel, container, topPanel, bottomPanel;
  private JLabel text, dateText, timeText;
  private JTextArea textarea;
  public JButton[] buttons = new JButton[3];
  private JButton b1, b2, b3;
  private Color whiteColor = new Color(255, 255, 255), blackColor = new Color(0, 0, 0), bTextColor = new Color(192, 192, 192);
  private CardLayout cl = new CardLayout();
  private Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, whiteColor),
                 borderwhite = BorderFactory.createMatteBorder(0,0, 1,0, new Color(192,192,192)),
                 border2 = BorderFactory.createLineBorder(Color.BLACK, 2);
                            
  Timer timer;
  MouseAdapter mouseadapter;

  Dashboard dashboard = new Dashboard(); // classes
  test2 test2 = new test2();

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
      Color color) {
    panel.setBackground(color);
    panel.setLayout(null);
  }

  main() {

    text = new JLabel("InnoviSoft");
    text.setBounds(10, 10, 100, 50);
    text.setForeground(whiteColor);
    text.setFont(new Font("Monospaced", Font.BOLD, 17));

    dateText = new JLabel();
    dateText.setBounds(180, 10, 100, 30);
    dateText.setFont(new Font("Monospaced", Font.BOLD, 15));
    dateText.setForeground(whiteColor);

    timeText = new JLabel();
    timeText.setBounds(191, 40, 100, 10);
    timeText.setFont(new Font("Monospaced", Font.BOLD, 12));
    timeText.setForeground(whiteColor);

    b1 = new JButton("Dashboard >");
    buttonCustomiser(b1, bTextColor, 60, 60, 160, 30, false, false, true, false);

    b2 = new JButton("Pemet >");
    buttonCustomiser(b2, bTextColor, 60, 130, 160, 30, false, false, true, false);

    b3 = new JButton("Ushqimet >");
    buttonCustomiser(b3, bTextColor, 60, 180, 160, 30, false, false, true, false);

    buttons[0] = b1;
    buttons[1] = b2;
    buttons[2] = b3;

    textarea = new JTextArea();
    textarea.setBounds(45, 25, 200, 100);
    textarea.setBorder(border2);
    textarea.setEditable(false);
    textarea.setFocusable(false);

    topPanel = new JPanel();
    topPanel.setLayout(null);
    panelCustomiser(topPanel, new Color(65, 68, 75));
    topPanel.setPreferredSize(new Dimension(100, 80));
    topPanel.add(text);

    container = new JPanel(); // this panel is within leftPanel and its served as an container for buttons so
                              // i can easily move them if wanted
    container.setBounds(30, 50, 240, 450);
    panelCustomiser(container, new Color(46, 47, 53));
    container.add(dateText);

    bottomPanel = new JPanel();
    panelCustomiser(bottomPanel, new Color(65,68,75));
    bottomPanel.setPreferredSize(new Dimension(100, 150));
    bottomPanel.add(textarea);
/* 
    mouseadapter = new MouseAdapter(){
    public void mousePressed(MouseEvent e){
      for (int i = 0; i < buttons.length; i++) {
        buttons[i].removeMouseListener(mouseadapter); 
      }
    }
  public void mouseEntered(MouseEvent e) {
    for (int i = 0; i < buttons.length; i++) {
      if (e.getSource().equals(buttons[i])) {
       buttons[i].setBorder(border);
       buttons[i].setForeground(whiteColor);
    }
    }
  }
      public void mouseExited(MouseEvent e) {
    for (int i = 0; i < buttons.length; i++) {
      if (e.getSource() == buttons[i]) {
       buttons[i].setBorder(borderwhite);
       buttons[i].setForeground(bTextColor);
    }
    }
  }  
};*/

    for (int x = 0; x < buttons.length; x++) { // this adds all buttons in container panel
      container.add(buttons[x]);
      buttons[x].setFont(new Font("Monospaced", Font.BOLD, 14));
      buttons[x].addActionListener(this);
      buttons[x].setBorder(borderwhite);
      buttons[x].addMouseListener(this);
    }
    
      b1.setBorder(border);

    centerPanel = new JPanel();
    centerPanel.setLayout(cl);
    centerPanel.add(dashboard, "1");
    centerPanel.add(test2, "2");
    centerPanel.setPreferredSize(new Dimension(400, 100));

    leftPanel = new JPanel();
    leftPanel.setLayout(new BorderLayout());
    leftPanel.setBackground(whiteColor);
    leftPanel.setPreferredSize(new Dimension(300, 100));
    leftPanel.add(topPanel, BorderLayout.NORTH);
    leftPanel.add(container, BorderLayout.CENTER);
    leftPanel.add(bottomPanel, BorderLayout.SOUTH);

    setDefaultCloseOperation(main.EXIT_ON_CLOSE);
    setBounds(100, 50, 1400, 800);
    setTitle("InnoviStore");
    revalidate();
    repaint();
    setLayout(new BorderLayout());
    showDate();
    showTime();

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

  public void mousePressed(MouseEvent e){
      for (int i = 0; i < buttons.length; i++) {
        buttons[i].removeMouseListener(this); 
      }
    }
  public void mouseEntered(MouseEvent e) {
    for (int i = 0; i < buttons.length; i++) {
      if (e.getSource().equals(buttons[i])) {
       buttons[i].setBorder(border);
       buttons[i].setForeground(whiteColor);
    }
    }
  }
      public void mouseExited(MouseEvent e) {
    for (int i = 0; i < buttons.length; i++) {
      if (e.getSource() == buttons[i]) {
       buttons[i].setBorder(borderwhite);
       buttons[i].setForeground(bTextColor);
    }
    }
  }  
 // ----------------------------------
  public void actionPerformed(ActionEvent e) {

 for(int i = 0; i < buttons.length; i++){
    if(e.getSource() == buttons[i]){  
            buttons[i].setBorder(border);
            buttons[i].setForeground(whiteColor);
            buttons[i].setOpaque(false); 
    } else {
      buttons[i].addMouseListener(this);
      buttons[i].setBorder(borderwhite);
      buttons[i].setForeground(bTextColor);
      buttons[i].setOpaque(true);
    }
    if (e.getSource() == b1) {
      cl.show(centerPanel, "1");
       leftPanel.add(bottomPanel, BorderLayout.SOUTH);
    } else{
      leftPanel.remove(bottomPanel);
    }
    if (e.getSource() == b2) {
      cl.show(centerPanel, "2");
    }
  }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
  }
}