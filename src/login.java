import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.Border;

class login extends JFrame implements ActionListener{

       dataType datatype = new dataType();

    private JPanel rightPanel, leftPanel;
    private JButton close, submit;
    private JLabel icon, text1 = new JLabel("Emri"),
                         text2 = new JLabel("Password"),
                         text3 = new JLabel("Kyçu"),
                         softext = new JLabel("InnoviSoft.Co");

    private JTextField username_input;
    private JPasswordField password_input;

      Border border;


    login() {
            setLocation(500, 200);
            setSize(650, 400);
            setUndecorated(true);
            setShape(new RoundRectangle2D.Double(0,0,650,400,datatype.corner,datatype.corner));
            // this is a comment

            border = BorderFactory.createMatteBorder(0, 0, 2, 0, datatype.noCol);
 
            icon = new JLabel(new ImageIcon("lIcon (1).png"));
            icon.setBounds(25, 70, 250, 250); 
           
            close = new JButton(new ImageIcon("close.png"));
            datatype.buttonCustomiser(close, null, null, 255, 5, 40, 40, false, false, false, false, this);

            submit = new JButton("Vazhdo!");
            datatype.buttonCustomiser(submit, datatype.darkerGrayTextColor, datatype.bTextColor, 125, 250, 100, 33, true, true, false, false, this);
            submit.addMouseListener(new MouseAdapter(){
                      public void mousePressed(MouseEvent e){
                             submit.setContentAreaFilled(false);}
                      public void mouseReleased(MouseEvent e){
                             submit.setContentAreaFilled(true);
                      }});
                    
            datatype.textCustomiser(text1, 100, 110, 80, 20, datatype.bTextColor, datatype.fontS14);
            datatype.textCustomiser(text2, 100, 180, 80, 20, datatype.bTextColor, datatype.fontS14);    
            datatype.textCustomiser(text3, 150, 60, 80, 30, datatype.bTextColor, new Font("Monospaced", Font.BOLD, 22));
            datatype.textCustomiser(softext, 10, 370, 100, 20, datatype.bTextColor, datatype.fontS14);

            username_input = new JTextField();
            username_input.setBounds(100, 130, 150, 33);
            username_input.setBorder(null);
            username_input.setBackground(datatype.darkerGrayTextColor);
            username_input.setBorder(border);
            username_input.setFont(datatype.fontS14);
            username_input.setForeground(datatype.bTextColor);

            password_input = new JPasswordField();
            password_input.setBounds(100, 200, 150, 33);
            password_input.setBackground(datatype.darkerGrayTextColor);
      //      password_input.setBorder(null);
            password_input.setBorder(border);
            password_input.setFont(datatype.fontS14);
            password_input.setForeground(datatype.bTextColor);

            // rightpanel
            rightPanel = new JPanel();
            datatype.panelCustomiser(rightPanel, null, true, datatype.darkerGrayTextColor, null, 300, 100);
            rightPanel.add(close);
            rightPanel.add(icon);
  //________________________________________________________
            leftPanel = new JPanel();
            datatype.panelCustomiser(leftPanel, null, true, datatype.grayTextColor, null, 400, 100);
            leftPanel.add(username_input);
            leftPanel.add(password_input);
            leftPanel.add(text1);
            leftPanel.add(text2);
            leftPanel.add(text3);
            leftPanel.add(softext);
            leftPanel.add(submit);
       
            addMouseListener(datatype.mouseadapter);
      addMouseMotionListener(new MouseMotionAdapter() {
        public void mouseDragged(MouseEvent e) {
               setLocation(e.getXOnScreen()-datatype.positionX, e.getYOnScreen()-datatype.positionY);
        }
      });
      
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

      if(e.getSource() == close) {System.exit(0);}

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
                this.dispose();
                return;}
    }
}
