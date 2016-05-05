/* This file was generated by SableCC (http://www.sablecc.org/). */

package grammar.ini.node;

import grammar.ini.analysis.Analysis;

@SuppressWarnings("nls")
public final class ABoolVal extends PVal {
    private TBoolval _boolval_;

    public ABoolVal() {
        // Constructor
    }

    public ABoolVal(
            @SuppressWarnings("hiding") TBoolval _boolval_) {
        // Constructor
        setBoolval(_boolval_);

    }

    @Override
    public Object clone() {
        return new ABoolVal(
                cloneNode(this._boolval_));
    }

    @Override
    public void apply(Switch sw) {
        ((Analysis) sw).caseABoolVal(this);
    }

    public TBoolval getBoolval() {
        return this._boolval_;
    }

    public void setBoolval(TBoolval node) {
        if (this._boolval_ != null) {
            this._boolval_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._boolval_ = node;
    }

    @Override
    public String toString() {
        return ""
                + toString(this._boolval_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child) {
        // Remove child
        if (this._boolval_ == child) {
            this._boolval_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild) {
        // Replace child
        if (this._boolval_ == oldChild) {
            setBoolval((TBoolval) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
