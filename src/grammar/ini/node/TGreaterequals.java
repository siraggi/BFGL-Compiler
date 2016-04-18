/* This file was generated by SableCC (http://www.sablecc.org/). */

package grammar.ini.node;

import grammar.ini.analysis.Analysis;

@SuppressWarnings("nls")
public final class TGreaterequals extends Token
{
    public TGreaterequals()
    {
        super.setText(">=");
    }

    public TGreaterequals(int line, int pos)
    {
        super.setText(">=");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TGreaterequals(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTGreaterequals(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TGreaterequals text.");
    }
}
