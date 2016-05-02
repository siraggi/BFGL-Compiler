import grammar.ini.analysis.DepthFirstAdapter;
import grammar.ini.node.Node;

import java.io.*;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by august on 18/04/16.
 */

public class VisitorBase extends DepthFirstAdapter {
    protected BufferedWriter bw;
    protected Hashtable<Node, String> typeTable;
    protected Hashtable<String, String> superTable;

    public VisitorBase(BufferedWriter bw, Hashtable<Node, String> typeTable, Hashtable<String, String> superTable){
        this.bw = bw;
        this.typeTable = typeTable;
        this.superTable = superTable;
    }

    protected void emitnl(String s){

        try {
            bw.write(s);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void emit(String s){

        try {
            bw.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void AddNameSpaces(){
        emitnl("import java.lang.*;");
        emitnl("import java.util.*;");
        emitnl("import java.io.*;");
        emitnl("import java.text.*;");
        emitnl("import java.awt.*;");
        emitnl("import java.nio.*;");
        emitnl("import java.math.*;");
        emitnl("import org.newdawn.slick.*;");
    }

    protected Node getRoot(Node node){
        Node root = node;

        while (root.parent() != null){
            root = root.parent();
        }

        return root;
    }

    protected boolean checkIfStatic(String nameOfClass){
        List<String> StaticClasses = Arrays.asList("Game", "Math.java", "Timer", "Input", "Keyboard", "Key", "Sprite", "List");
        for (String staticClass : StaticClasses) {
            if (nameOfClass.equals(staticClass)){
                return true;
            }
        }
        return false;
    }

    public static void addLibrary(String in, String out) throws IOException {
        FileInputStream instream = null;
        FileOutputStream outstream = null;

        try{
            File infile = new File("Library", in);
            File outfile = new File("Output", out + ".java");

            instream = new FileInputStream(infile);
            outstream = new FileOutputStream(outfile);

            byte[] buffer = new byte[1024];

            int length;
    	    /*copying the contents from input stream to
    	     * output stream using read and write methods
    	     */
            while ((length = instream.read(buffer)) > 0){
                outstream.write(buffer, 0, length);
            }

            //Closing the input/output file streams
            instream.close();
            outstream.close();

            System.out.println("File copied successfully: " + out);

        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
