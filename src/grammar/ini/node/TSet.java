/* This file was generated by SableCC (http://www.sablecc.org/). */

package grammar.ini.node;

import grammar.ini.analysis.Analysis;

@SuppressWarnings("nls")
public final class TSet extends Token
{
    public TSet()
    {
        super.setText("set");
    }

    public TSet(int line, int pos)
    {
        super.setText("set");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TSet(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTSet(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TSet text.");
    }
}
