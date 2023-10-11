import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;

class login extends JFrame implements ActionListener{

    private JPanel rightPanel, leftPanel;
    private JButton close, submit;
    private JLabel icon, text1, text2, text3, softext;
    private JTextField username_input;
    private JPasswordField password_input;

      Font font;    
      Border border;
      Color Color1 = new Color(192,192,192), Color2 = new Color(46,47,53);

      static void buttonCustomiser  // --------------- this method is for button customisation
      (JButton button, Color colorb, Color colorf,
      int x, int y, int width, int height,
      boolean opaque, boolean areafilled, boolean borderpainted, boolean focusable,
      Border border,
      ActionListener e){
          button.setBackground(colorb);
          button.setForeground(colorf);
          button.setBounds(x, y, width, height);
          button.setOpaque(opaque);
          button.setContentAreaFilled(areafilled);
          button.setBorderPainted(borderpainted);
          button.setFocusable(focusable);
          button.setBorder(border);
          button.addActionListener(e);
      }

      static void textCustomiser  //this method is to customise text
      (JLabel label,
       int x, int y, int width, int height,
       Color color,
       Font font){
             label.setBounds(x, y, width, height);
             label.setForeground(color);
             label.setFont(font);
      }

      static void panelCustomiser(JPanel panel, Color color, int width, int height){ // this is for panel customisation
            panel.setPreferredSize(new Dimension(width, height));
            panel.setBackground(color);
            panel.setLayout(null);
      }

    login() {
            
            font = new Font("Serif", Font.BOLD, 14);
            // this is a comment

            border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0,0,0));
 
            icon = new JLabel(new ImageIcon("lIcon (1).png"));
            icon.setBounds(25, 70, 250, 250); 
           
            close = new JButton(new ImageIcon("close.png"));
            buttonCustomiser(close, null, null, 255, 5, 40, 40, false, false, false, false, null, this);

            submit = new JButton("Vazhdo!");
            buttonCustomiser(submit, Color2, Color1, 125, 250, 100, 33, true, true, false, false, null, this);
            submit.addMouseListener(new MouseAdapter(){
                      public void mousePressed(MouseEvent e){
                             submit.setContentAreaFilled(false);}
                      public void mouseReleased(MouseEvent e){
                             submit.setContentAreaFilled(true);
                      }});
                    
            text1 = new JLabel("Emri");
            textCustomiser(text1, 100, 110, 80, 20, Color1, font);

            text2 = new JLabel("Password");
            textCustomiser(text2, 100, 180, 80, 20, Color1, font);

            text3 = new JLabel("Kyçu");
            textCustomiser(text3, 150, 60, 80, 30, Color1, new Font("Monospaced", Font.BOLD, 22));

            softext = new JLabel("InnoviSoft.Co");
            textCustomiser(softext, 10, 370, 100, 20, Color1, font);

            username_input = new JTextField();
            username_input.setBounds(100, 130, 150, 33);
            username_input.setBorder(null);
            username_input.setBackground(Color2);
            username_input.setBorder(border);
            username_input.setFont(font);
            username_input.setForeground(Color1);

            password_input = new JPasswordField();
            password_input.setBounds(100, 200, 150, 33);
            password_input.setBackground(Color2);
            password_input.setBorder(null);
            password_input.setBorder(border);
            password_input.setFont(font);
            password_input.setForeground(Color1);

            // rightpanel
            rightPanel = new JPanel();
            panelCustomiser(rightPanel, new Color(46, 47, 53), 300, 100);
            rightPanel.add(close);
            rightPanel.add(icon);
  //________________________________________________________
            leftPanel = new JPanel();
            panelCustomiser(leftPanel, new Color(65,68,75), 400, 100);
         // user input--
            leftPanel.add(username_input);
            leftPanel.add(password_input);
        // texts
            leftPanel.add(text1);
            leftPanel.add(text2);
            leftPanel.add(text3);
            leftPanel.add(softext);
        // submit button
            leftPanel.add(submit);

            setBounds(550, 200, 650, 400);
            setUndecorated(true);
            setLayout(new BorderLayout());

            add(rightPanel, BorderLayout.EAST);
            add(leftPanel, BorderLayout.CENTER);
            setVisible(true);
    }
   public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){new login();}});
    }
    @Override
    public void actionPerformed(ActionEvent e) {

      if(e.getSource() == close) {this.dispose();}

      if(e.getSource() == submit){
             if(username_input.getText().isEmpty()
             || password_input.getText().isEmpty()
             ||!username_input.getText().equals("admin")
             ||!password_input.getText().equals("123")){
                JOptionPane.showMessageDialog(  
                null, 
                "Emri ose password nuk është korrekt!","Vërejtje",
                JOptionPane.ERROR_MESSAGE);
                username_input.setText("");  
                password_input.setText("");
                return;}
                new main();
                return;}
    }
}
