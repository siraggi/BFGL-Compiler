package grammar.ini;

import grammar.ini.analysis.DepthFirstAdapter;
import grammar.ini.analysis.ReversedDepthFirstAdapter;
import grammar.ini.node.*;

import java.util.ArrayList;
import java.util.Stack;

public class GlobalCheck extends DepthFirstAdapter {
    private String id;
    private Node nodeToCheck;
    private Stack<ArrayList<String>> scope;

    public boolean global = false;

    public GlobalCheck(String id, Node node){
        this.id = id;
        nodeToCheck = node;
        scope = new Stack<>();
    }

    private void openScope(){
        scope.push(new ArrayList<String>());
    }

    private void closeScope(){
        if(scope.size() > 0)
            scope.pop();
    }

    public void inAProg(AProg node){
        openScope();
    }

    public void outAProg(AProg node){
        closeScope();
    }

    public void inAClassPdcl(AClassPdcl node){
        openScope();
    }

    public void outAClassPdcl(AClassPdcl node){
        closeScope();
    }

    public void inAFuncPdcl(AFuncPdcl node){
        openScope();
    }

    public void outAFuncPdcl(AFuncPdcl node){
        closeScope();
    }

    public void inAEventPdcl(AEventPdcl node){
        openScope();
    }

    public void outAEventPdcl(AEventPdcl node){
        closeScope();
    }

    public void inAWhileStmt(AWhileStmt node){
        openScope();
    }

    public void outAWhileStmt(AWhileStmt node){
        closeScope();
    }

    public void inAForupStmt(AForupStmt node){
        openScope();
    }

    public void outAForupStmt(AForupStmt node){
        closeScope();
    }

    public void inAFordownStmt(AFordownStmt node){
        openScope();
    }

    public void outAFordownStmt(AFordownStmt node){
        closeScope();
    }

    public void defaultIn(Node node){
        if(node.equals(nodeToCheck)){
            while(scope.size() > 1){
                if(scope.pop().contains(id)){
                    global = false;
                    break;
                }
                else
                    global = true;
            }
        }
    }

    public void outAVarPdcl(AVarPdcl node){
        if(node.getId().getText().equals(id))
            scope.peek().add(node.getId().getText());

        /*if(node.getId().getText().equals(id)){
            if(node.parent() instanceof AProg)
                global = true;
            else
                global = false;
        }*/
    }

    public void outAVarasgPdcl(AVarasgPdcl node){
        if(node.getId().getText().equals(id))
            scope.peek().add(node.getId().getText());

        /*if(node.getId().getText().equals(id)){
            if(node.parent() instanceof AProg)
                global = true;
            else
                global = false;
        }*/
    }
}
