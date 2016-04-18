import grammar.ini.node.*;

import java.io.BufferedWriter;
import java.util.Hashtable;

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

    public void outADivideExpr(ADivideExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" / ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void outAMultExpr(AMultExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" * ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void outAModExpr(AModExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" % ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void outAOrExpr(AOrExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" || ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void outAAndExpr(AAndExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" && ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void outAEqualsExpr(AEqualsExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" == ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void outANotequalsExpr(ANotequalsExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" != ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void outAGreaterExpr(AGreaterExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" > ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void outALessExpr(ALessExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" < ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void outAGreaterequalsExpr(AGreaterequalsExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" >= ");
            node.getRight().apply(this);
            node.visited = true;
        }

    }

    public void outALessequalsExpr(ALessequalsExpr node) {
        if (!node.visited) {
            node.getLeft().apply(this);
            emit(" <= ");
            node.getRight().apply(this);
            node.visited = true;
        }
    }

    public void outAUnaryExpr(AUnaryExpr node) {
        if (!node.visited) {
            emit("(-");
            node.apply(this);
            emit(")");
            node.visited = true;
        }
    }

    public void outANotExpr(ANotExpr node) {
        if (!node.visited) {
            emit("!");
            node.apply(this);
            emit(" ");
            node.visited = true;
        }
    }

    public void outAValExpr(AValExpr node) {
        if (!node.visited) {
            emit(node.getVal().toString());
            node.visited = true;
        }

    }

    public void outAIdExpr(AIdExpr node) {
        emit(node.getId().getText());
    }
}
