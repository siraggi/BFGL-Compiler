import grammar.ini.analysis.DepthFirstAdapter;
import grammar.ini.node.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

public class GlobalCheck extends DepthFirstAdapter {
    private String id;
    private Node nodeToCheck;
    private Stack<ArrayList<String>> scope;
    private Hashtable<String, String> superTable;

    public boolean global = false;

    public GlobalCheck(String id, Node node, Hashtable<String, String> superTable) {
        this.id = id;
        nodeToCheck = node;
        scope = new Stack<>();

        this.superTable = superTable;
    }

    private void openScope() {
        scope.push(new ArrayList<String>());
    }

    private void closeScope() {
        if (scope.size() > 0)
            scope.pop();
    }

    public void inAProg(AProg node) {
        openScope();
    }

    public void outAProg(AProg node) {
        closeScope();
    }

    public void inAClassPdcl(AClassPdcl node) {
        DclFinder df;
        openScope();

        if (node.getInherit() != null) {
            AInherit i = (AInherit) node.getInherit();
            df = new DclFinder(node, i.getType().toString().trim(), id);

            df.root.apply(df);

            scope.peek().addAll(df.ids);
        }

    }

    public void outAClassPdcl(AClassPdcl node) {
        closeScope();
    }

    public void inAFuncPdcl(AFuncPdcl node) {
        openScope();

        for (Node p : node.getParams()) {
            if (p instanceof AFormalParam) {
                if (((AFormalParam) p).getId().getText().equals(id))
                    scope.peek().add(((AFormalParam) p).getId().getText());
            }
        }
    }

    public void outAFuncPdcl(AFuncPdcl node) {
        closeScope();
    }

    public void inAEventPdcl(AEventPdcl node) {
        openScope();

        for (Node p : node.getParams()) {
            if (p instanceof AFormalParam) {
                if (((AFormalParam) p).getId().getText().equals(id))
                    scope.peek().add(((AFormalParam) p).getId().getText());
            }
        }

    }

    public void outAEventPdcl(AEventPdcl node) {
        closeScope();
    }

    public void inAWhileStmt(AWhileStmt node) {
        openScope();
    }

    public void outAWhileStmt(AWhileStmt node) {
        closeScope();
    }

    public void inAForupStmt(AForupStmt node) {
        openScope();
    }

    public void outAForupStmt(AForupStmt node) {
        closeScope();
    }

    public void inAFordownStmt(AFordownStmt node) {
        openScope();
    }

    public void outAFordownStmt(AFordownStmt node) {
        closeScope();
    }

    public void defaultIn(Node node) {
        if (node.equals(nodeToCheck)) {
            while (scope.size() > 1) {
                if (scope.pop().contains(id)) {
                    global = false;
                    break;
                } else
                    global = true;
            }
        }
    }

    public void outAVarPdcl(AVarPdcl node) {
        if (node.getId().getText().equals(id))
            scope.peek().add(node.getId().getText());
    }

    public void outAVarasgPdcl(AVarasgPdcl node) {
        if (node.getId().getText().equals(id))
            scope.peek().add(node.getId().getText());
    }
}
