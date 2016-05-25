import grammar.ini.analysis.DepthFirstAdapter;
import grammar.ini.node.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

/**
 * Created by august on 24/03/16.
 */
public class TableFiller extends DepthFirstAdapter {
    //When you meet for example a class, tablefiller is applied, and fills up all the different tables with content
    private static final String BOOL = "bool";
    private static final String NUM = "num";
    private static final String TEXT = "text";
    private static final String LIST = "List";
    private static final String VOID = "void";
    private static final String ERRORTYPE = "9"; //this was chosen randomly. Some other solution would be good, as this is not secure.


    public Stack<Hashtable<String, Node>> symStack; //Basically a scopestack. top scope on the stack is the current scope
    public Hashtable<String, Node> symbolTable;
    public Hashtable<Node, String> typeTable;
    public ArrayList<String> ErrorList;
    public Hashtable<String, String> superTable; //holding the superclasses of the currently analysed class

    private Node node;
    private LineAndPos lineAndPos;
    private boolean dotCall = false;

    public TableFiller(Node node, boolean dotCall, LineAndPos lineAndPos) {
        this.node = node;
        this.dotCall = dotCall;
        this.lineAndPos = lineAndPos;

        symStack = new Stack<>();
        symbolTable = new Hashtable<>();
        typeTable = new Hashtable<>();
        superTable = new Hashtable<>();
        ErrorList = new ArrayList<>();

        symStack.push(new Hashtable<String, Node>());
    }

    private void openScope() {
        symStack.push(new Hashtable<String, Node>());
    }

    private void closeScope() {
        symStack.pop();
    }

    //Symbol table methods
    private void addSymbol(String name, Node node) {
        if (!symStack.peek().containsKey(name)) {
            symStack.peek().put(name, node);
        } else
            ErrorList.add("ERROR: " + name + " is already defined in this scope " + symStack.peek().size());
    }

    private void addType(Node node, String type) {
        typeTable.put(node, type.trim());
    }

    //Class dcl
    public void inAClassPdcl(AClassPdcl node) {
        openScope();
    }

    public void outAClassPdcl(AClassPdcl node) {
        if (node != this.node) {
            closeScope();
            addSymbol(node.getId().getText(), node);
            addType(node, node.getId().getText());

            if (node.getInherit() != null)
                superTable.put(node.getId().getText().trim(), ((AInherit) node.getInherit()).getType().toString().trim());
        }

    }

    //Func dcl
    public void inAFuncPdcl(AFuncPdcl node) {
        openScope();
    }

    public void outAFuncPdcl(AFuncPdcl node) {
        closeScope();
        addSymbol(node.getId().getText(), node);
    }

    public void outAVarPdcl(AVarPdcl node) {
        if (dotCall) {
            addSymbol(node.getId().getText(), node);
            addType(node, node.getType().toString());
        }


    }

    public void outAVarasgPdcl(AVarasgPdcl node) {
        if (dotCall) {
            addSymbol(node.getId().getText(), node);
            addType(node, node.getType().toString());
        }

    }

    public void outAListPdcl(AListPdcl node) {
        if (dotCall) {
            addSymbol(node.getId().getText(), node);
            addType(node, LIST);
        }

    }
}
