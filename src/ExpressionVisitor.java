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


    public void outAMinusExpr(AMinusExpr node){
        node.getLeft().apply(this);
        emit(" - ");
        node.getRight().apply(this);

    }

    public void outAPlusExpr(APlusExpr node){
        node.getLeft().apply(this);
        emit(" + ");
        node.getRight().apply(this);

    }

    public void outADivideExpr(ADivideExpr node){
        node.getLeft().apply(this);
        emit(" / ");
        node.getRight().apply(this);

    }

    public void outAMultExpr(AMultExpr node){
        node.getLeft().apply(this);
        emit(" * ");
        node.getRight().apply(this);

    }

    public void outAModExpr(AModExpr node){
        node.getLeft().apply(this);
        emit(" % ");
        node.getRight().apply(this);

    }

    public void outAOrExpr(AOrExpr node){
        node.getLeft().apply(this);
        emit(" || ");
        node.getRight().apply(this);

    }

    public void outAAndExpr(AAndExpr node){
        node.getLeft().apply(this);
        emit(" && ");
        node.getRight().apply(this);

    }

    public void outAEqualsExpr(AEqualsExpr node){
        node.getLeft().apply(this);
        emit(" == ");
        node.getRight().apply(this);

    }

    public void outANotequalsExpr(ANotequalsExpr node){
        node.getLeft().apply(this);
        emit(" != ");
        node.getRight().apply(this);

    }

    public void outAGreaterExpr(AGreaterExpr node){
        node.getLeft().apply(this);
        emit(" > ");
        node.getRight().apply(this);

    }

    public void outALessExpr(ALessExpr node){
        node.getLeft().apply(this);
        emit(" < ");
        node.getRight().apply(this);

    }

    public void outAGreaterequalsExpr(AGreaterequalsExpr node){
        node.getLeft().apply(this);
        emit(" >= ");
        node.getRight().apply(this);

    }

    public void outALessequalsExpr(ALessequalsExpr node){
        node.getLeft().apply(this);
        emit(" <= ");
        node.getRight().apply(this);
    }

    public void outAUnaryExpr(AUnaryExpr node){
        emit("(-");
        node.apply(this);
        emit(")");
    }

    public void outANotExpr(ANotExpr node){
        emit("!");
        node.apply(this);
        emit(" ");
    }

    public void outAValExpr(AValExpr node){
        emit(node.getVal().toString());
    }

    public void outAIdExpr(AIdExpr node){
        emit(node.getId().getText());
    }
}
