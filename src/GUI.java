import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by august on 05/05/16.
 */
public class GUI extends JFrame{
    private JButton chooseFileButton;
    private JButton compileButton;
    private JPanel panel1;
    private JFileChooser fileDialog;
    private JLabel statusLabel;
    private JList errorList;
    private JButton gameButton;
    private File file;

    public GUI() {
        panel1 = new JPanel();
        chooseFileButton = new JButton("Choose file");
        compileButton = new JButton("Compile!");

        fileDialog = new JFileChooser();
        fileDialog.setCurrentDirectory(new File(System.getProperty("user.dir")));

        gameButton = new JButton("Run game");
        statusLabel = new JLabel();

        gameButton.setVisible(false);

        errorList = new JList();
        errorList.setPreferredSize(new Dimension(450, 300));

        panel1.add(chooseFileButton);
        panel1.add(compileButton);
        panel1.add(statusLabel);
        panel1.add(errorList);
        panel1.add(gameButton);

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
                    errorList.setListData(new String[0]);
                    //errorList.removeAll();
                    //errorList.clearSelection();
                    Main.compile(file);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });

        gameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ProcessBuilder pb = new ProcessBuilder("Java", "-jar", "CompiledGame/hax.jar");
                    pb.redirectOutput();
                    Process p = pb.start();
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    public void addErrors(ArrayList<String> errors){
        errorList.setListData(errors.toArray());
    }

    public void showGameButton(){
        gameButton.setVisible(true);
    }
}
