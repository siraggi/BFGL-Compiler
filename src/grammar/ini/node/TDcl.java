/* This file was generated by SableCC (http://www.sablecc.org/). */

package grammar.ini.node;

import grammar.ini.analysis.Analysis;

@SuppressWarnings("nls")
public final class TDcl extends Token {
    public TDcl() {
        super.setText("dcl");
    }

    public TDcl(int line, int pos) {
        super.setText("dcl");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone() {
        return new TDcl(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw) {
        ((Analysis) sw).caseTDcl(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text) {
        throw new RuntimeException("Cannot change TDcl text.");
    }
}
