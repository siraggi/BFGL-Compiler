import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by august on 05/05/16.
 */
public class GUI extends JFrame{
    private JButton chooseFileButton;
    private JButton compileButton;
    private JPanel panel1;
    private JFileChooser fileDialog;
    private JLabel statusLabel;
    private File file;

    public GUI() {
        panel1 = new JPanel();
        chooseFileButton = new JButton("Choose file");
        compileButton = new JButton("Compile!");
        fileDialog = new JFileChooser();
        statusLabel = new JLabel();

        panel1.add(chooseFileButton);
        panel1.add(compileButton);
        panel1.add(statusLabel);

        add(panel1);

        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileDialog.showOpenDialog(panel1);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    file = fileDialog.getSelectedFile();
                    statusLabel.setText("File Selected :"
                            + file.getName());

                }
                else{
                    statusLabel.setText("Open command cancelled by user." );
                }
            }
        });

        compileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Main.compile(file);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });
    }
}
