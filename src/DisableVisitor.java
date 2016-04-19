import grammar.ini.analysis.DepthFirstAdapter;
import grammar.ini.node.Node;

/**
 * Created by august on 19/04/16.
 */
public class DisableVisitor extends DepthFirstAdapter{
    private boolean visited;


    public DisableVisitor(boolean visited){
        this.visited = visited;
    }

    public void defaultIn(Node node){
        node.visited = visited;
    }
}
