/* This file was generated by SableCC (http://www.sablecc.org/). */

package grammar.ini.node;

import java.util.*;
import grammar.ini.analysis.*;

@SuppressWarnings("nls")
public final class AFuncPdcl extends PPdcl
{
    private TId _id_;
    private final LinkedList<PParam> _params_ = new LinkedList<PParam>();
    private PBody _body_;

    public AFuncPdcl()
    {
        // Constructor
    }

    public AFuncPdcl(
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") List<?> _params_,
        @SuppressWarnings("hiding") PBody _body_)
    {
        // Constructor
        setId(_id_);

        setParams(_params_);

        setBody(_body_);

    }

    @Override
    public Object clone()
    {
        return new AFuncPdcl(
            cloneNode(this._id_),
            cloneList(this._params_),
            cloneNode(this._body_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFuncPdcl(this);
    }

    public TId getId()
    {
        return this._id_;
    }

    public void setId(TId node)
    {
        if(this._id_ != null)
        {
            this._id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id_ = node;
    }

    public LinkedList<PParam> getParams()
    {
        return this._params_;
    }

    public void setParams(List<?> list)
    {
        for(PParam e : this._params_)
        {
            e.parent(null);
        }
        this._params_.clear();

        for(Object obj_e : list)
        {
            PParam e = (PParam) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._params_.add(e);
        }
    }

    public PBody getBody()
    {
        return this._body_;
    }

    public void setBody(PBody node)
    {
        if(this._body_ != null)
        {
            this._body_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._body_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._id_)
            + toString(this._params_)
            + toString(this._body_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        if(this._params_.remove(child))
        {
            return;
        }

        if(this._body_ == child)
        {
            this._body_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        for(ListIterator<PParam> i = this._params_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PParam) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._body_ == oldChild)
        {
            setBody((PBody) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
