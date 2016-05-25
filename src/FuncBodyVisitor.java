
import grammar.ini.node.*;

import java.io.BufferedWriter;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by august on 18/04/16.
 */
public class FuncBodyVisitor extends VisitorBase {
    public FuncBodyVisitor(BufferedWriter bw, Hashtable<Node, String> typeTable, Hashtable<String, String> superTable) {
        super(bw, typeTable, superTable);
    }

    public void inAVarPdcl(AVarPdcl node) {
        if (!node.visited) {
            node.visited = true;

            switch (node.getType().toString().trim()) {
                case ("num"):
                    emitnl("float " + "_" + node.getId().getText() + " = 0;");
                    break;
                case ("text"):
                    emitnl("String " + "_" + node.getId().getText() + " = \"\";");
                    break;
                case ("bool"):
                    emitnl("bool " + "_" + node.getId().getText() + " = false;");
                    break;
                default:
                    emitnl("_" + node.getType().toString().trim() + " " + "_" + node.getId().getText() + ";");
                    break;
            }
        }


    }

    public void inAVarasgPdcl(AVarasgPdcl node) {
        if (!node.visited) {
            node.visited = true;

            switch (node.getType().toString().trim()) {
                case ("num"):
                    emit("float " + "_" + node.getId().getText() + " = ");
                    node.apply(new ExpressionVisitor(bw, typeTable, superTable));
                    emitnl(";");
                    break;
                case ("text"):
                    emit("String " + "_" + node.getId().getText() + " = ");
                    node.apply(new ExpressionVisitor(bw, typeTable, superTable));
                    emitnl(";");
                    break;
                case ("bool"):
                    emit("bool " + "_" + node.getId().getText() + " = ");
                    node.apply(new ExpressionVisitor(bw, typeTable, superTable));
                    emitnl(";");
                    break;
                default:
                    emit("_" + node.getType().toString().trim() + " " + "_" + node.getId().getText() + " = ");
                    node.apply(new ExpressionVisitor(bw, typeTable, superTable));
                    emitnl(";");
                    break;
            }
        }
    }

    public void inAAssignmentStmt(AAssignmentStmt node) {
        if (!node.visited) {
            node.visited = true;

            GlobalCheck gc = new GlobalCheck(node.getId().getText(), node, superTable);

            getRoot(node).apply(gc);

            if (gc.global)
                emit("Global.");

            emit("_" + node.getId().getText() + " = ");
            node.getExpr().apply(new ExpressionVisitor(bw, typeTable, superTable));
            emitnl(";");
        }

    }

    public void inAFuncCall(AFuncCall node) {
        if (!node.visited && !(node.parent().parent() instanceof AVarasgPdcl) && !(node.parent().parent() instanceof AAssignmentStmt)) {
            node.visited = true;

            if(node.parent() instanceof ADotCall){
                LinkedList<PCall> temp = new LinkedList<>();
                ADotCall c = (ADotCall) node.parent();

                temp.add(c.getFirst());
                temp.addAll(c.getRest());

                if(temp.size() > 2 && temp.get(temp.size() - 2) instanceof AVarCall){
                    AVarCall v =  (AVarCall) c.getRest().get(c.getRest().size() - 2);

                    if(!typeTable.get(v).equals("List"))
                        emit("_");
                }
                else
                    emit("_");
            }
            else
                emit("_");

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

    public void inAWhileStmt(AWhileStmt node) {
        if (!node.visited) {
            emit("while(");
            node.getExpr().apply(new ExpressionVisitor(bw, typeTable, superTable));
            emitnl("){");

            for (Node n : node.getStmt()) {
                n.apply(this);
            }

            emitnl("}");
        }
    }

    public void inAForupStmt(AForupStmt node) {
        if (!node.visited) {
            emit("float _exprval" + node.getId().getText() + " = ");
            node.getExpr().apply(new ExpressionVisitor(bw, typeTable, superTable));
            emitnl(";");

            emit("for(" + "_" + node.getId().getText() + " = " + "_" + node.getId().getText() + " ; " + "_" + node.getId().getText() + " <= _exprval" + node.getId().getText());

            emitnl(" ; " + "_" + node.getId().getText() + "++){");

            for (Node n : node.getStmt()) {
                n.apply(this);
            }

            emitnl("}");
        }
    }

    public void inAFordownStmt(AFordownStmt node) {
        if (!node.visited) {
            emit("float _exprval" + node.getId().getText() + " = ");
            node.getExpr().apply(new ExpressionVisitor(bw, typeTable, superTable));
            emitnl(";");

            emit("for(" + "_" + node.getId().getText() + " = " + "_" + node.getId().getText() + " ; " + "_" + node.getId().getText() + " >= _exprval" + node.getId().getText());

            emitnl(" ; " + "_" + node.getId().getText() + "--){");

            for (Node n : node.getStmt()) {
                n.apply(this);
            }

            emitnl("}");
        }
    }

    public void inAListPdcl(AListPdcl node) {
        if (!node.visited) {
            node.visited = true;
            emitnl("ArrayList<" + "_" + node.getType().toString().trim() + "> " + "_" + node.getId().getText() + " = new ArrayList<>();");

        }
    }

    public void inADotCall(ADotCall node) {
        if (!node.visited) {
            node.visited = true;
            //for handling global var/method
            if (node.getFirst() instanceof AFuncCall) {
                AFuncCall f = (AFuncCall) node.getFirst();

                GlobalCheck gc = new GlobalCheck(f.getId().getText(), f, superTable);

                getRoot(node).apply(gc);

                if (gc.global)
                    emit("Global.");

                emit("_" + f.getId().getText());
                emit("(");

                for (Node p : f.getParams()) {
                    p.apply(this);

                    if (!p.equals(f.getParams().getLast())) {
                        emit(", ");
                    }
                }

                emit(")");
            } else if (node.getFirst() instanceof AVarCall) {
                AVarCall v = (AVarCall) node.getFirst();

                GlobalCheck gc = new GlobalCheck(v.getId().getText(), v, superTable);

                getRoot(node).apply(gc);

                if (gc.global)
                    emit("Global.");

                emit("_" + v.getId().getText());
            }

            emit(".");
            //for handling non global
            for (Node n : node.getRest()) {
                if (n instanceof AVarCall) {
                    AVarCall v = (AVarCall) n;

                    emit("_" + v.getId().getText());
                }

                if (n != node.getRest().getLast()) {
                    emit(".");
                }
            }
        }
    }

    public void inAIfConditional(AIfConditional node) {
        if (!node.visited) {
            node.visited = true;

            emit("if(");
            node.getExpr().apply(new ExpressionVisitor(bw, typeTable, superTable));
            emitnl("){");

            for (Node n : node.getStmt()) {
                n.apply(this);
            }

            emitnl("}");
        }
    }

    public void inAElseBranch(AElseBranch node) {
        if (!node.visited) {
            node.visited = true;

            emitnl("else{");

            for (Node n : node.getStmt()) {
                n.apply(this);
            }

            emitnl("}");
        }
    }

    public void inAElseifBranch(AElseifBranch node) {
        if (!node.visited) {
            node.visited = true;

            emit("else if(");
            node.getExpr().apply(new ExpressionVisitor(bw, typeTable, superTable));
            emitnl("){");

            for (Node n : node.getStmt()) {
                n.apply(this);
            }

            emitnl("}");
        }
    }

    public void inAIdReturn(AIdReturn node){
        if (!node.visited) {
            node.visited = true;

            emit("return ");
            node.getExpr().apply(new ExpressionVisitor(bw, typeTable, superTable));
            emitnl(";");
        }
    }
}
