import grammar.ini.analysis.DepthFirstAdapter;
import grammar.ini.node.AFormalParam;
import grammar.ini.node.AFuncPdcl;
import grammar.ini.node.AVarPdcl;
import grammar.ini.node.Node;

import java.io.BufferedWriter;
import java.util.Hashtable;

/**
 * Created by august on 18/04/16.
 */
public class ClassBodyVisitor extends VisitorBase {

    public ClassBodyVisitor(BufferedWriter bw, Hashtable<Node, String> typeTable, Hashtable<String, String> superTable){
        super(bw, typeTable, superTable);
    }

    public void outAVarPdcl(AVarPdcl node){
        switch (node.getType().toString().trim()){
            case("num"):
                emitnl("public float " + node.getId().getText() + ";"); break;
            case("text"):
                emitnl("public String " + node.getId().getText() + ";"); break;
            case("bool"):
                emitnl("public boolean " + node.getId().getText() + ";"); break;
            default:
                emitnl("public " + node.getType().toString().trim() + " " + node.getId().getText() + ";"); break;
        }
    }

    public void outAFuncPdcl(AFuncPdcl node){
        emit("public " + (typeTable.get(node) == null? "void" : typeTable.get(node)) + " " + node.getId().getText() + "(");

        for (Node p : node.getParams()){
            switch (((AFormalParam)p).getType().toString().trim()){
                case("num "):
                    emit("float "); break;
                case("text"):
                    emit("String "); break;
                case("bool"):
                    emit("boolean "); break;
                default:
                    emit(((AFormalParam)p).getType().toString().trim() + " "); break;
            }
            emit(((AFormalParam)p).getId().getText());

            if(!p.equals(node.getParams().getLast())){
                emit(", ");
            }
        }

        emit(")");
        emitnl("{");

        node.apply(new FuncBodyVisitor(bw, typeTable, superTable));

        emitnl("}");
    }
}
