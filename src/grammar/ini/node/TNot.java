/* This file was generated by SableCC (http://www.sablecc.org/). */

package grammar.ini.node;

import grammar.ini.analysis.*;

@SuppressWarnings("nls")
public final class TNot extends Token
{
    public TNot()
    {
        super.setText("not");
    }

    public TNot(int line, int pos)
    {
        super.setText("not");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TNot(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTNot(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TNot text.");
    }
}
