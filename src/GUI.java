import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by august on 05/05/16.
 */
public class GUI {
    private JButton compileButton;
    private JPanel panel1;

    public GUI() {
        compileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Click!");
            }
        });
    }
}
