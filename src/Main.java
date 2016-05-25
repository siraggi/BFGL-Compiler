import grammar.ini.lexer.Lexer;
import grammar.ini.lexer.LexerException;
import grammar.ini.node.Start;
import grammar.ini.parser.Parser;
import grammar.ini.parser.ParserException;

import javax.swing.*;

import static java.nio.file.StandardCopyOption.*;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;


public class Main {
    public static ArrayList<String> ErrorList = new ArrayList<>();
    private static GUI gui;

    public static void main(String[] args){


        //Simple GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gui = new GUI();
                JFrame frame = gui;
                frame.setTitle("Program Title");
                frame.setSize(480, 640);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });


        /*try{
            compile(new File("Test", "BFGLtest.bfgl"));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }*/


    }

    public static void compile(File inFile)
            throws ParserException, LexerException, IOException {
        //start compilation process
        TypeChecker typeChecker = new TypeChecker();
        File file = inFile;
        Start tree = null;
        ErrorList.clear();
        try {
            PushbackReader pushbackReader = new PushbackReader(new FileReader(addLibrary(file)));
            Parser parser = new Parser(new Lexer(pushbackReader));
            tree = parser.parse(); //tree is the final AST to be analysed in the semantic phase
        }
        catch(LexerException | ParserException ex){
            if(ex instanceof LexerException){
                LexerException le = (LexerException) ex;
                int line = le.getToken().getLine();
                int pos = le.getToken().getPos();
                String error = ex.getLocalizedMessage().split("]")[ex.getLocalizedMessage().split("]").length - 1];
                ErrorList.add("Lexer Error: Line: " + line + " Pos: " + pos + ", " + error);
            }
            else{
                ParserException pe = (ParserException) ex;
                int line = pe.getToken().getLine();
                int pos = pe.getToken().getPos();
                String error = ex.getLocalizedMessage().split("]")[ex.getLocalizedMessage().split("]").length - 1];
                ErrorList.add("Lexer Error: Line: " + line + " Pos: " + pos + ", " + error);
            }


        }

        if(ErrorList.size() == 0)
            tree.apply(typeChecker);

        ErrorList.addAll(typeChecker.ErrorList);

        if (!ErrorList.isEmpty()) {
            gui.addErrors(ErrorList);
            for (String s :
                    typeChecker.ErrorList) {
                System.out.println(s);
            }
        } else {
            new JavaCodeGenerator(typeChecker.typeTable, typeChecker.superTable, tree); // starting codegen phase
            AntExecutor AEx = new AntExecutor(); //compiles and executes the produced java code, into an executable file
            AEx.executeAntTask("CompileBFGL.xml", "jar"); //this also copies libraries into the right folders, to actuall let the game run properly.
            //These libraries has to be contained in the same folder as the game Jar.
        }
        Desktop.getDesktop().open(new File("CompiledGame/"));
        //gui.showGameButton();
    }

    private static File addLibrary(File file) throws IOException {
        File outFile = new File("Test", "out.bfgl");

        FileWriter fw = new FileWriter(outFile);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("dcl Game game to new Game()");
        bw.newLine();
        bw.write("dcl InputBFGL input to new InputBFGL()");
        bw.newLine();
        bw.write("dcl MathBFGL math to new MathBFGL()");
        bw.newLine();

        bw.close();
        fw.close();

        try {


            copyFileContentAppend(file, outFile);
            copyFileContentAppend(new File("Library", "GameClasses"), outFile);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return outFile;
    }

    private static void copyFileContentAppend(File inFile, File outFile) throws IOException {
        FileInputStream instream = null;
        FileOutputStream outstream = null;

        try {
            instream = new FileInputStream(inFile);
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
    }
}
