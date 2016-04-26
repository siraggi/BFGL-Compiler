
import grammar.ini.node.AClassPdcl;
import grammar.ini.node.AInherit;
import grammar.ini.node.AProg;
import grammar.ini.node.Node;

import java.io.*;
import java.util.Hashtable;

/**
 * Created by august on 18/04/16.
 */
public class TopVisitor extends VisitorBase{

    public TopVisitor(Hashtable<Node, String> typeTable, Hashtable<String, String> superTable){
        super(null, typeTable, superTable);
    }

    private void newCLass(String className, Node node, String name){
        File file;
        FileWriter fw;


        file = new File("Output/" + className + ".java");

        try{
            if (!file.exists()){
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);

            AddNameSpaces();

            emitnl("public class " + className + "{");
            node.apply(new ClassBodyVisitor(bw, typeTable, superTable, name));
            emitnl("}");

            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void newCLass(String className, String inherit, Node node, String name){
        File file;
        FileWriter fw;


        file = new File("Output/" + className + ".java");

        try{
            if (!file.exists()){
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);

            AddNameSpaces();


            emitnl("public class " + className + " extends " + inherit + "{");
            node.apply(new ClassBodyVisitor(bw, typeTable, superTable, name));
            emitnl("}");

            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void inAProg(AProg node){
        File dump;
        File global;
        FileWriter fw;
        FileReader fr;

        dump = new File("Output/global");

        try{
            if (!dump.exists()){
                dump.createNewFile();
            }

            fw = new FileWriter(dump.getAbsoluteFile());
            bw = new BufferedWriter(fw);



            for(Node n : node.getGlobaldcl()){
                n.apply(new FuncBodyVisitor(bw, typeTable, superTable));
            }

            bw.close();

            global = new File("Output/Global.java");

            if (!global.exists()){
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
            while ((s = br.readLine()) != null){
                bw.write("public static " + s);
                bw.newLine();
            }

            bw.write("}");
            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void inAClassPdcl(AClassPdcl node){
        if(node.getInherit() == null)
            newCLass(node.getId().getText(), node, node.getId().getText());
        else
            newCLass(node.getId().getText(), ((AInherit)node.getInherit()).getType().toString(), node, node.getId().getText());
    }


}
