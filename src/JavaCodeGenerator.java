/**
 * Created by august on 14/04/16.
 */

import grammar.ini.node.*;

import java.io.*;
import java.util.*;

public class JavaCodeGenerator {

    private File file;
    private File outDir;


    public JavaCodeGenerator(Hashtable<Node, String> typeTable, Hashtable<String, String> superTable, Node node) throws IOException {

        outDir = new File("Output/");

        for (File file : outDir.listFiles()) file.delete();

        addLibrary("Scene", "Scene"); //Because the CODEGEN phase needs to know about scene before running its typechecks


        node.apply(new TopVisitor(typeTable, superTable));

        addLibrary("Main", "Main");
        addLibrary("_MathBFGL", "_MathBFGL");


    }

    public static void addLibrary(String in, String out) throws IOException {
        FileInputStream instream = null;
        FileOutputStream outstream = null;
//Adds in the specified BFGL library. Added as a seperate function to aid implementation
        try {
            File infile = new File("Library", in);
            File outfile = new File("Output", out + ".java");

            instream = new FileInputStream(infile);
            outstream = new FileOutputStream(outfile);

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