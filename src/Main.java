import grammar.ini.lexer.Lexer;
import grammar.ini.lexer.LexerException;
import grammar.ini.node.Start;
import grammar.ini.parser.Parser;
import grammar.ini.parser.ParserException;
import sun.misc.IOUtils;

import javax.swing.*;

import static java.nio.file.StandardCopyOption.*;

import java.io.*;
import java.nio.file.Files;


public class Main {

    public static void main(String[] args){

        /*
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI gui = new GUI();
                JFrame frame = gui;
                frame.setTitle("Program Title");
                frame.setSize(400, 400);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        */

        try{
            compile(new File("Test", "AggiPingPong.bfgl"));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }


    }

    public static void compile(File inFile)
            throws ParserException, LexerException, IOException {
        TypeChecker typeChecker = new TypeChecker();
        File file = inFile;

        PushbackReader pushbackReader = new PushbackReader(new FileReader(addLibrary(file)));
        Parser parser = new Parser(new Lexer(pushbackReader));
        Start tree = parser.parse();

        tree.apply(typeChecker);

        if (!typeChecker.ErrorList.isEmpty()) {
            for (String s :
                    typeChecker.ErrorList) {
                System.out.println(s);
            }
        } else {
            new JavaCodeGenerator(typeChecker.typeTable, typeChecker.superTable, tree);
            AntExecutor AEx = new AntExecutor();
            AEx.executeAntTask("CompileBFGL.xml", "jar");
        }
    }

    private static File addLibrary(File file) throws IOException {
        File outFile = new File("Test", "out.bfgl");

        FileInputStream instream = null;
        FileOutputStream outstream = null;

        try {
            File infile = new File("Library", "GameClasses");


            Files.copy(file.toPath(), outFile.toPath(), REPLACE_EXISTING);

            instream = new FileInputStream(infile);
            outstream = new FileOutputStream(outFile, true);

            byte[] buffer = new byte[1024];

            int length;
            /*copying the contents from input stream to
    	     * output stream using read and write methods
    	     */
            while ((length = instream.read(buffer)) > 0) {
                outstream.write(buffer, 0, length);
            }

            //Closing the input/output file streams
            instream.close();
            outstream.close();

            System.out.println("File copied successfully!!");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return outFile;
    }
}
