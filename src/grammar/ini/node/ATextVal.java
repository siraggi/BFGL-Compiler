/* This file was generated by SableCC (http://www.sablecc.org/). */

package grammar.ini.node;

import grammar.ini.analysis.Analysis;

@SuppressWarnings("nls")
public final class ATextVal extends PVal {
    private TTextval _textval_;

    public ATextVal() {
        // Constructor
    }

    public ATextVal(
            @SuppressWarnings("hiding") TTextval _textval_) {
        // Constructor
        setTextval(_textval_);

    }

    @Override
    public Object clone() {
        return new ATextVal(
                cloneNode(this._textval_));
    }

    @Override
    public void apply(Switch sw) {
        ((Analysis) sw).caseATextVal(this);
    }

    public TTextval getTextval() {
        return this._textval_;
    }

    public void setTextval(TTextval node) {
        if (this._textval_ != null) {
            this._textval_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._textval_ = node;
    }

    @Override
    public String toString() {
        return ""
                + toString(this._textval_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child) {
        // Remove child
        if (this._textval_ == child) {
            this._textval_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild) {
        // Replace child
        if (this._textval_ == oldChild) {
            setTextval((TTextval) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
