 import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

 class dataType {

    final int corner = 55 / 2;
          int positionX, positionY;

    final Font font = new Font("Serif", Font.BOLD, 14);

    final Color whiteColor = new Color(255, 255, 255),
    bTextColor = new Color(192, 192, 192),
    grayTextColor = new Color(55, 58, 65),
    darkerGrayTextColor = new Color(36,37,43),
    noCol = new Color(0,0,0);


    final Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, whiteColor),
                 borderwhite = BorderFactory.createMatteBorder(0,0, 1,0, new Color(192,192,192)),
                 border2 = BorderFactory.createLineBorder(Color.BLACK, 2),
                 sideBorder = BorderFactory.createMatteBorder(0,0, 0,1, new Color(192,192,192));
}
