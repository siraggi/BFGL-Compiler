import grammar.ini.node.*;

import java.io.BufferedWriter;
import java.util.Hashtable;

/**
 * Created by august on 18/04/16.
 */
public class ClassBodyVisitor extends VisitorBase {

    private String className;

    public ClassBodyVisitor(BufferedWriter bw, Hashtable<Node, String> typeTable, Hashtable<String, String> superTable, String className){
        super(bw, typeTable, superTable);

        this.className = className;
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

    public void outAVarasgPdcl(AVarasgPdcl node) {
        if(!node.visited){
            node.visited = true;

            switch (node.getType().toString().trim()) {
                case ("num"):
                    emit("float " + node.getId().getText() + " = ");
                    node.apply(new ExpressionVisitor(bw, typeTable, superTable));
                    emitnl(";");
                    break;
                case ("text"):
                    emit("String " + node.getId().getText() + " = ");
                    node.apply(new ExpressionVisitor(bw, typeTable, superTable));
                    emitnl(";");
                    break;
                case ("bool"):
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
    }

    public void outAFuncPdcl(AFuncPdcl node){
        emit("public " + (typeTable.get(node) == null? "void" : typeTable.get(node)) + " " + node.getId().getText() + "(");

        for (Node p : node.getParams()){
            switch (((AFormalParam)p).getType().toString().trim()){
                case("num"):
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

        emitnl("");
        emitnl("}");
    }

    public void inAEventPdcl(AEventPdcl node){
        String name = "event";

        switch (node.getId().getText()){
            case("OnUpdate"):
                name = "update()"; break;
            case("OnCollision"):
                name = "collision()"; break;
            case("OnInput"):
                name = "input()"; break;
            case("OnConstruct"):
                name = className + "()"; break;
        }

        emitnl("public void " + name + "{");

        for(Node n : node.getBody()){
            n.apply(new FuncBodyVisitor(bw, typeTable, superTable));
        }

        emitnl("}");
    }
}
