
import grammar.ini.node.*;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by august on 18/04/16.
 */
public class TopVisitor extends VisitorBase {

    //TopVisitor takes care of the top level of the program. This includes Classses Main and the entry point of a program.

    public TopVisitor(Hashtable<Node, String> typeTable, Hashtable<String, String> superTable) {
        super(null, typeTable, superTable);
    }

    private void newCLass(String className, Node node) {
        File file;
        FileWriter fw;


        file = new File("Output/" + className + ".java");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);

            AddNameSpaces();

            emitnl("public class " + className + "{");
            node.apply(new ClassBodyVisitor(bw, typeTable, superTable, className));
            emitnl("}");

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void newCLass(String className, String inherit, Node node) {
        File file;
        FileWriter fw;


        file = new File("Output/" + className + ".java");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);

            AddNameSpaces();


            emitnl("public class " + className + " extends " + "_" + inherit + "{");
            node.apply(new ClassBodyVisitor(bw, typeTable, superTable, className));
            emitnl("}");

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inAProg(AProg node) {
        File dump;
        File global;
        FileWriter fw;
        FileReader fr;

        dump = new File("Output/global");

        try {
            if (!dump.exists()) {
                dump.createNewFile();
            }

            fw = new FileWriter(dump.getAbsoluteFile());
            bw = new BufferedWriter(fw);


            for (Node n : node.getGlobaldcl()) {
                n.apply(new FuncBodyVisitor(bw, typeTable, superTable));
            }

            bw.close();

            global = new File("Output/Global.java");

            if (!global.exists()) {
                global.createNewFile();
            }

            fw = new FileWriter(global.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            AddNameSpaces();
            bw.write("public final class Global {");
            bw.newLine();
            bw.write("private Global(){ }");
            bw.newLine();

            fr = new FileReader(dump);
            BufferedReader br = new BufferedReader(fr);

            String s;
            while ((s = br.readLine()) != null) {
                bw.write("public static " + s);
                bw.newLine();
            }

            bw.write("}");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inAClassPdcl(AClassPdcl node) {
        if (node.getInherit() == null)
            newCLass("_" + node.getId().getText(), node);
        else
            newCLass("_" + node.getId().getText(), ((AInherit) node.getInherit()).getType().toString(), node);
    }

    public void inAMainPdcl(AMainPdcl node) {
        File sceneFile = new File("Output/Scene.java");
        File tempSceneFile = new File("Output/tempSceneFile.java");


        try {
            List<String> lines = Files.readAllLines(sceneFile.toPath(), Charset.defaultCharset());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempSceneFile)));
            tempSceneFile.createNewFile();
            if (!sceneFile.exists()) {
                throw new IOException("Scene library not copied! fatal error");
            }

            for (int linepos = 0; linepos < lines.size(); linepos++) {

                if (lines.get(linepos).contains("/*TAGPUTMAINHERE*/")) { //Where this tag is located, is where the main of the BFGL source file is put. This tag is located in Scene.java
                    node.apply(new FuncBodyVisitor(bw, typeTable, superTable));
                } else {
                    bw.write(lines.get(linepos));
                    bw.newLine();
                }
            }
            Files.deleteIfExists(sceneFile.toPath());
            bw.close();
            if (!(tempSceneFile.renameTo(new File("Output/Scene.java")))) {
                throw new IOException("Could not rename scene.java!");
            }

        } catch (IOException ioerr) {
            ioerr.printStackTrace();
        }
    }
}
