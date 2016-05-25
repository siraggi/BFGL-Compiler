
import grammar.ini.node.*;

import java.io.BufferedWriter;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by august on 18/04/16.
 */
public class ExpressionVisitor extends VisitorBase {

    public ExpressionVisitor(BufferedWriter bw, Hashtable<Node, String> typeTable, Hashtable<String, String> superTable) {
        super(bw, typeTable, superTable);
    }


    public void inAMinusExpr(AMinusExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" - ");
            node.getRight().apply(this);
            node.visited = true;
        }


    }

    public void inAPlusExpr(APlusExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" + ");
            node.getRight().apply(this);
            node.visited = true;
        }
    }

    public void inADivideExpr(ADivideExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" / ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void inAMultExpr(AMultExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" * ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void inAModExpr(AModExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" % ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void inAOrExpr(AOrExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" || ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void inAAndExpr(AAndExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" && ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void inAEqualsExpr(AEqualsExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" == ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void inANotequalsExpr(ANotequalsExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" != ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void inAGreaterExpr(AGreaterExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" > ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void inALessExpr(ALessExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" < ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void inAGreaterequalsExpr(AGreaterequalsExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" >= ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void inALessequalsExpr(ALessequalsExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" <= ");
            node.getRight().apply(this);
            node.visited = true;
        }
    }

    public void inAUnaryExpr(AUnaryExpr node) {
        if (!node.visited) {
            node.visited = true;
            emit("(-");
            node.apply(this);
            emit(")");
        }
    }

    public void inANotExpr(ANotExpr node) {
        if (!node.visited) {
            node.visited = true;
            emit("!");
            node.apply(this);
            emit(" ");
        }
    }

    public void inAParenExpr(AParenExpr node){
        if (!node.visited) {
            node.visited = true;
            emit("(");
            node.apply(this);
            emit(")");
        }
    }


    public void inAConstrVal(AConstrVal node) {
        if (!node.visited) {
            node.visited = true;

            emit(" new " + "_" + node.getId().getText() + "(");

            for (Node p : node.getParam()) {
                p.apply(this);

                if (!p.equals(node.getParam().getLast())) {
                    emit(", ");
                }
            }

            emit(")");
        }
    }

    public void inANumVal(ANumVal node) {
        if (!node.visited) {
            emit(node.getNumval().getText() + "f");
            node.visited = true;
        }
    }

    public void inATextVal(ATextVal node) {
        if (!node.visited) {
            emit(node.getTextval().getText());
            node.visited = true;
        }
    }

    public void inABoolVal(ABoolVal node) {
        if (!node.visited) {
            emit(node.getBoolval().getText());
            node.visited = true;
        }
    }

    public void inAThisVal(AThisVal node) {
        if (!node.visited) {
            emit(node.getThis().getText());
            node.visited = true;
        }
    }

    public void inAIdExpr(AIdExpr node) {
        GlobalCheck gc = new GlobalCheck(node.getId().getText(), node, superTable);

        if (!node.visited) {
            node.visited = true;
            getRoot(node).apply(gc);

            if (gc.global)
                emit("Global." + "_" + node.getId().getText());
            else
                emit("_" + node.getId().getText());

        }
    }

    public void inADotCall(ADotCall node) {
        if (!node.visited) {
            node.visited = true;
            //First part checks if there is a global call
            if (node.getFirst() instanceof AFuncCall) {
                AFuncCall f = (AFuncCall) node.getFirst();

                GlobalCheck gc = new GlobalCheck(f.getId().getText(), node.getFirst(), superTable);
                getRoot(node).apply(gc);

                if (gc.global)
                    emit("Global.");

                emit(f.getId().getText());
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

                GlobalCheck gc = new GlobalCheck(v.getId().getText(), node.getFirst(), superTable);
                getRoot(node).apply(gc);

                if (gc.global)
                    emit("Global.");

                emit("_" + v.getId().getText());
            }

            emit(".");
            //for normal non global variables and methods
            for (Node n : node.getRest()) {
                if (n instanceof AFuncCall) {
                    AFuncCall f = (AFuncCall) n;

                    if(node.getRest().indexOf(n) - 1 >= 0&& node.getRest().get(node.getRest().indexOf(n) - 1) instanceof AVarCall){
                        AVarCall v =  (AVarCall) node.getRest().get(node.getRest().indexOf(n) - 1);

                        if(!typeTable.get(v).equals("List"))
                            emit("_");
                    }
                    else
                        emit("_");

                    emit(f.getId().getText());
                    emit("(");

                    for (Node p : f.getParams()) {
                        p.apply(this);

                        if (!p.equals(f.getParams().getLast())) {
                            emit(", ");
                        }
                    }

                    emit(")");
                } else if (n instanceof AVarCall) {
                    AVarCall v = (AVarCall) n;

                    emit("_" + v.getId().getText());
                }

                if (n != node.getRest().getLast()) {
                    emit(".");
                }
            }
        }

        node.apply(new DisableVisitor(true));
    }

    public void inAFuncCall(AFuncCall node) {
        if (!node.visited) {
            node.visited = true;

            emit("_" + node.getId().getText());
            emit("(");

            for (Node p : node.getParams()) {
                p.apply(this);

                if (!p.equals(node.getParams().getLast())) {
                    emit(", ");
                }
            }

            emit(")");
        }
    }


}
