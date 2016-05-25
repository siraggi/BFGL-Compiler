import grammar.ini.analysis.DepthFirstAdapter;
import grammar.ini.lexer.Lexer;
import grammar.ini.lexer.LexerException;
import grammar.ini.node.Start;
import grammar.ini.parser.Parser;
import grammar.ini.parser.ParserException;
import org.junit.Before;

import java.io.*;

/**
 * Created by krist on 10-05-2016.
 */
public class TestLineAndPos {


    //unfinished

    private static boolean setUpIsDone = false;
    Start tree;

    public void setUp(){
        if (!setUpIsDone) {

            File file = new File("Test/BFGLTest.bfgl");
            PushbackReader pushbackReader = null;
            try {
                pushbackReader = new PushbackReader(new FileReader(addLibrary(file)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parser parser = new Parser(new Lexer(pushbackReader));
            try {
                tree = parser.parse();
            } catch (ParserException e) {
                e.printStackTrace();
            } catch (LexerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            setUpIsDone = true;
        }

    }






    //The below methods are copied over from Main, could be put in the visitorbase or somewhere similar, was not put there because
    //the time was not there to refactor and test everything properly

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
