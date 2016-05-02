import grammar.ini.analysis.DepthFirstAdapter;
import grammar.ini.node.AClassPdcl;
import grammar.ini.node.AVarPdcl;
import grammar.ini.node.AVarasgPdcl;
import grammar.ini.node.Node;

import java.util.ArrayList;

/**
 * Created by august on 27/04/16.
 */
public class DclFinder extends DepthFirstAdapter {

    private String id;
    private String inherit;
    private boolean found = false;

    public Node dcl = null;
    public Node root;
    public ArrayList<String> ids;

    public DclFinder(Node node, String inherit, String id){
        this.id = id;
        this.inherit = inherit;

        ids = new ArrayList<>();

        while(node.parent() != null){
            node = node.parent();
        }

        root = node;
    }

    public void defaultIn(Node node){
        if(node instanceof AClassPdcl){
            if(((AClassPdcl)node).getId().getText().equals(inherit)){
                found = true;
            }
        }
    }

    public void defaultOut(Node node){
        if(node instanceof AClassPdcl){
            if(((AClassPdcl)node).getId().getText().equals(inherit)){
                found = false;
            }
        }
    }

    public void outAVarPdcl(AVarPdcl node){
        if(found && node.getId().getText().equals(id))
            ids.add(node.getId().getText());
    }

    public void outAVarasgPdcl(AVarasgPdcl node){
        if(found && node.getId().getText().equals(id))
            ids.add(node.getId().getText());
    }
}
