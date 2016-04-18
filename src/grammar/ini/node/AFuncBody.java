/* This file was generated by SableCC (http://www.sablecc.org/). */

package grammar.ini.node;

import grammar.ini.analysis.Analysis;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

@SuppressWarnings("nls")
public final class AFuncBody extends PBody
{
    private final LinkedList<PStmt> _stmt_ = new LinkedList<PStmt>();
    private PReturn _return_;

    public AFuncBody()
    {
        // Constructor
    }

    public AFuncBody(
        @SuppressWarnings("hiding") List<?> _stmt_,
        @SuppressWarnings("hiding") PReturn _return_)
    {
        // Constructor
        setStmt(_stmt_);

        setReturn(_return_);

    }

    @Override
    public Object clone()
    {
        return new AFuncBody(
            cloneList(this._stmt_),
            cloneNode(this._return_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFuncBody(this);
    }

    public LinkedList<PStmt> getStmt()
    {
        return this._stmt_;
    }

    public void setStmt(List<?> list)
    {
        for(PStmt e : this._stmt_)
        {
            e.parent(null);
        }
        this._stmt_.clear();

        for(Object obj_e : list)
        {
            PStmt e = (PStmt) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._stmt_.add(e);
        }
    }

    public PReturn getReturn()
    {
        return this._return_;
    }

    public void setReturn(PReturn node)
    {
        if(this._return_ != null)
        {
            this._return_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._return_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._stmt_)
            + toString(this._return_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._stmt_.remove(child))
        {
            return;
        }

        if(this._return_ == child)
        {
            this._return_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PStmt> i = this._stmt_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PStmt) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._return_ == oldChild)
        {
            setReturn((PReturn) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
