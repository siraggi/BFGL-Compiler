import grammar.ini.node.*;

import java.io.BufferedWriter;
import java.util.Hashtable;

/**
 * Created by august on 18/04/16.
 */
public class ClassBodyVisitor extends VisitorBase {

    private String className;

    public ClassBodyVisitor(BufferedWriter bw, Hashtable<Node, String> typeTable, Hashtable<String, String> superTable, String className) {
        super(bw, typeTable, superTable);

        this.className = className;
    }

    public void inAVarPdcl(AVarPdcl node) {
        switch (node.getType().toString().trim()) {
            case ("num"):
                emitnl("public float " + node.getId().getText() + ";");
                break;
            case ("text"):
                emitnl("public String " + node.getId().getText() + ";");
                break;
            case ("bool"):
                emitnl("public boolean " + node.getId().getText() + ";");
                break;
            default:
                emitnl("public " + node.getType().toString().trim() + " " + node.getId().getText() + ";");
                break;
        }
    }

    public void inAVarasgPdcl(AVarasgPdcl node) {
        if (!node.visited) {
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

    public void inAFuncPdcl(AFuncPdcl node) {
        emit("public " + (typeTable.get(node) == null ? "void " : getJavaType(typeTable.get(node)) + " ") + node.getId().getText() + "(");
        for (Node p : node.getParams()) {
            switch (((AFormalParam) p).getType().toString().trim()) {
                case ("num"):
                    emit("float ");
                    break;
                case ("text"):
                    emit("String ");
                    break;
                case ("bool"):
                    emit("boolean ");
                    break;
                default:
                    emit(((AFormalParam) p).getType().toString().trim() + " ");
                    break;
            }
            emit(((AFormalParam) p).getId().getText());

            if (!p.equals(node.getParams().getLast())) {
                emit(", ");
            }
        }

        emit(")");
        emitnl("{");

        node.apply(new FuncBodyVisitor(bw, typeTable, superTable));

        emitnl("");
        emitnl("}");
    }

    private String getJavaType(String BFGLtype){
        switch (BFGLtype){
            case("num"):
                return "float";
            case("text"):
                return "String";
            default:
                return BFGLtype;

        }
    }

    public void inAEventPdcl(AEventPdcl node) {
        String name = "event";

        switch (node.getId().getText()) {
            case ("OnUpdate"):
                name = "update(float delta)";
                emitnl("public void " + name + "{");
                break;
            case ("OnCollision"):
                name = "collision";
                emit("public void " + name + "(");

                for (Node p : node.getParams()) {
                    switch (((AFormalParam) p).getType().toString().trim()) {
                        case ("num"):
                            emit("float ");
                            break;
                        case ("text"):
                            emit("String ");
                            break;
                        case ("bool"):
                            emit("boolean ");
                            break;
                        default:
                            emit(((AFormalParam) p).getType().toString().trim() + " ");
                            break;
                    }
                    emit(((AFormalParam) p).getId().getText());

                    if (!p.equals(node.getParams().getLast())) {
                        emit(", ");
                    }
                }

                emitnl("){");
                break;
            case ("OnInput"):
                name = "input()";
                emitnl("public void " + name + "{");
                break;
            case ("OnConstruct"):
                name = className;

                emit("public " + name + "(");

                for (Node p : node.getParams()) {
                    switch (((AFormalParam) p).getType().toString().trim()) {
                        case ("num"):
                            emit("float ");
                            break;
                        case ("text"):
                            emit("String ");
                            break;
                        case ("bool"):
                            emit("boolean ");
                            break;
                        default:
                            emit(((AFormalParam) p).getType().toString().trim() + " ");
                            break;
                    }
                    emit(((AFormalParam) p).getId().getText());

                    if (!p.equals(node.getParams().getLast())) {
                        emit(", ");
                    }
                }

                emitnl("){");
                break;
        }


        if (node.getBase() != null && !node.getBase().visited) {
            node.getBase().visited = true;
            emit("super(");

            for (Node p : ((ABaseBase) node.getBase()).getParams()) {
                p.apply(new ExpressionVisitor(bw, typeTable, superTable));

                if (!p.equals(((ABaseBase) node.getBase()).getParams().getLast())) {
                    emit(", ");
                }
            }

            emit(");");
        }

        for (Node n : node.getBody()) {
            n.apply(new FuncBodyVisitor(bw, typeTable, superTable));
        }

        emitnl("}");
    }

    public void inAListPdcl(AListPdcl node) {
        if (!node.visited) {
            node.visited = true;
            emitnl("ArrayList<" + node.getType().toString().trim() + "> " + node.getId().getText() + " = new ArrayList<>();");

        }
    }
}
