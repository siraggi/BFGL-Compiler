/* This file was generated by SableCC (http://www.sablecc.org/). */

package grammar.ini.node;

import grammar.ini.analysis.Analysis;

@SuppressWarnings("nls")
public final class TNotequals extends Token {
    public TNotequals() {
        super.setText("!=");
    }

    public TNotequals(int line, int pos) {
        super.setText("!=");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone() {
        return new TNotequals(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw) {
        ((Analysis) sw).caseTNotequals(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text) {
        throw new RuntimeException("Cannot change TNotequals text.");
    }
}
