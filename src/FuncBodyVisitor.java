import grammar.ini.node.*;

import java.io.BufferedWriter;
import java.util.Hashtable;

/**
 * Created by august on 18/04/16.
 */
public class FuncBodyVisitor extends VisitorBase {
    public FuncBodyVisitor(BufferedWriter bw, Hashtable<Node, String> typeTable, Hashtable<String, String> superTable) {
        super(bw, typeTable, superTable);
    }

    public void outAVarPdcl(AVarPdcl node) {
        if(!node.visited){
            node.visited = true;

            switch (node.getType().toString().trim()) {
                case ("num"):
                    emitnl("float " + node.getId().getText() + ";");
                    break;
                case ("text"):
                    emitnl("String " + node.getId().getText() + ";");
                    break;
                case ("bool"):
                    emitnl("bool " + node.getId().getText() + ";");
                    break;
                default:
                    emitnl(node.getType().toString().trim() + " " + node.getId().getText() + ";");
                    break;
            }
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

    public void inAAssignmentStmt(AAssignmentStmt node) {
        if(!node.visited){
            node.visited = true;

            emit(node.getId() + " = ");
            node.getExpr().apply(new ExpressionVisitor(bw, typeTable, superTable));
            emitnl(";");
        }

    }

    public void inAFuncCall(AFuncCall node) {
        if (!node.visited && !(node.parent().parent() instanceof AVarasgPdcl) && !(node.parent().parent() instanceof AAssignmentStmt)) {
            node.visited = true;

            emit(node.getId().getText());
            emit("(");

            for (Node p : node.getParams()) {
                p.apply(new ExpressionVisitor(bw, typeTable, superTable));

                if (!p.equals(node.getParams().getLast())) {
                    emit(", ");
                }
            }

            emitnl(");");
        }
    }

    public void inAWhileStmt(AWhileStmt node){
        emit("while(");
        node.getExpr().apply(new ExpressionVisitor(bw, typeTable, superTable));
        emitnl("){");

        for(Node n : node.getStmt()){
            n.apply(this);
        }

        emitnl("}");
    }

    public void inAForupStmt(AForupStmt node){
        emit("for(" + node.getId().getText() + " ; " + node.getId().getText() + " < ");
        node.getExpr().apply(new ExpressionVisitor(bw, typeTable, superTable));
        emitnl(" ; " + node.getId().getText() + "++){");

        for(Node n : node.getStmt()){
            n.apply(this);
        }

        emitnl("}");
    }

    public void inAFordownStmt(AFordownStmt node){
        emit("for(" + node.getId().getText() + " ; " + node.getId().getText() + " > ");
        node.getExpr().apply(new ExpressionVisitor(bw, typeTable, superTable));
        emitnl(" ; " + node.getId().getText() + "--){");

        for(Node n : node.getStmt()){
            n.apply(this);
        }

        emitnl("}");
    }

    public void inAListPdcl(AListPdcl node){
        if (!node.visited){
            node.visited = true;
            emitnl(" ArrayList<" + node.getType().toString().trim() + "> " + node.getId().getText() + " = new ArrayList<>();");

        }
    }
}
