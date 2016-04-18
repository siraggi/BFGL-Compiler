import grammar.ini.node.AFuncCall;
import grammar.ini.node.AVarPdcl;
import grammar.ini.node.AVarasgPdcl;
import grammar.ini.node.Node;

import java.io.BufferedWriter;
import java.util.Hashtable;

/**
 * Created by august on 18/04/16.
 */
public class FuncBodyVisitor extends VisitorBase {
    public FuncBodyVisitor(BufferedWriter bw, Hashtable<Node, String> typeTable, Hashtable<String, String> superTable) {
        super(bw, typeTable, superTable);
    }

    public void outAVarPdcl(AVarPdcl node){
        switch (node.getType().toString().trim()){
            case("num"):
                emitnl("float " + node.getId().getText() + ";"); break;
            case("text"):
                emitnl("String " + node.getId().getText() + ";"); break;
            case("bool"):
                emitnl("bool " + node.getId().getText() + ";"); break;
            default:
                emitnl(node.getType().toString().trim() + " " + node.getId().getText() + ";"); break;
        }
    }

    public void outAVarasgPdcl(AVarasgPdcl node){
        switch (node.getType().toString().trim()){
            case("num"):
                emit("float " + node.getId().getText() + " = ");
                node.apply(new ExpressionVisitor(bw, typeTable, superTable));
                emitnl(";");
                break;
            case("text"):
                emit("String " + node.getId().getText() + " = ");
                node.apply(new ExpressionVisitor(bw, typeTable, superTable));
                emitnl(";");
                break;
            case("bool"):
                emit("bool " + node.getId().getText() + " = ");
                node.apply(new ExpressionVisitor(bw, typeTable, superTable));
                emitnl(";");
                break;
            default:
                emit(node.getType().toString().trim() + " " + node.getId().getText() + " = ");
                node.apply(new ExpressionVisitor(bw, typeTable, superTable));
                emitnl(";");
                break;
        }
    }

    public void outAFuncCall(AFuncCall node){
        emit(node.getId().getText());
        emit("(");

        for (Node p : node.getParams()){
            p.apply(new ExpressionVisitor(bw, typeTable, superTable));

            if(!p.equals(node.getParams().getLast())){
                emit(", ");
            }
        }

        emitnl(");");
    }
}
