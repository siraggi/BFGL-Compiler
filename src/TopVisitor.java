import grammar.ini.node.AClassPdcl;
import grammar.ini.node.AInherit;
import grammar.ini.node.AProg;
import grammar.ini.node.Node;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        File file;
        FileWriter fw;


        file = new File("Output/global");

        try{
            if (!file.exists()){
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);

            for(Node n : node.getGlobaldcl()){
                n.apply(new FuncBodyVisitor(bw, typeTable, superTable));
            }

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
