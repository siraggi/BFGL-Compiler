/* This file was generated by SableCC (http://www.sablecc.org/). */

package grammar.ini.analysis;

import grammar.ini.node.*;

import java.util.Hashtable;

public class AnalysisAdapter implements Analysis {
    private Hashtable<Node, Object> in;
    private Hashtable<Node, Object> out;

    @Override
    public Object getIn(Node node) {
        if (this.in == null) {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o) {
        if (this.in == null) {
            this.in = new Hashtable<Node, Object>(1);
        }

        if (o != null) {
            this.in.put(node, o);
        } else {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node) {
        if (this.out == null) {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o) {
        if (this.out == null) {
            this.out = new Hashtable<Node, Object>(1);
        }

        if (o != null) {
            this.out.put(node, o);
        } else {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node) {
        defaultCase(node);
    }

    @Override
    public void caseAProg(AProg node) {
        defaultCase(node);
    }

    @Override
    public void caseAVarPdcl(AVarPdcl node) {
        defaultCase(node);
    }

    @Override
    public void caseAVarasgPdcl(AVarasgPdcl node) {
        defaultCase(node);
    }

    @Override
    public void caseAListPdcl(AListPdcl node) {
        defaultCase(node);
    }

    @Override
    public void caseAClassPdcl(AClassPdcl node) {
        defaultCase(node);
    }

    @Override
    public void caseAMainPdcl(AMainPdcl node) {
        defaultCase(node);
    }

    @Override
    public void caseAEventPdcl(AEventPdcl node) {
        defaultCase(node);
    }

    @Override
    public void caseAFuncPdcl(AFuncPdcl node) {
        defaultCase(node);
    }

    @Override
    public void caseAFuncBody(AFuncBody node) {
        defaultCase(node);
    }

    @Override
    public void caseAEventdclBody(AEventdclBody node) {
        defaultCase(node);
    }

    @Override
    public void caseAClassBody(AClassBody node) {
        defaultCase(node);
    }

    @Override
    public void caseAIdReturn(AIdReturn node) {
        defaultCase(node);
    }

    @Override
    public void caseAEmptyReturn(AEmptyReturn node) {
        defaultCase(node);
    }

    @Override
    public void caseAMultiParam(AMultiParam node) {
        defaultCase(node);
    }

    @Override
    public void caseAFormalParam(AFormalParam node) {
        defaultCase(node);
    }

    @Override
    public void caseABaseBase(ABaseBase node) {
        defaultCase(node);
    }

    @Override
    public void caseAInherit(AInherit node) {
        defaultCase(node);
    }

    @Override
    public void caseANumType(ANumType node) {
        defaultCase(node);
    }

    @Override
    public void caseABoolType(ABoolType node) {
        defaultCase(node);
    }

    @Override
    public void caseATextType(ATextType node) {
        defaultCase(node);
    }

    @Override
    public void caseAObjectType(AObjectType node) {
        defaultCase(node);
    }

    @Override
    public void caseAFuncCall(AFuncCall node) {
        defaultCase(node);
    }

    @Override
    public void caseAClassCall(AClassCall node) {
        defaultCase(node);
    }

    @Override
    public void caseAValCall(AValCall node) {
        defaultCase(node);
    }

    @Override
    public void caseAVarCall(AVarCall node) {
        defaultCase(node);
    }

    @Override
    public void caseAMinusExpr(AMinusExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseAPlusExpr(APlusExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseADivideExpr(ADivideExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseAMultExpr(AMultExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseAModExpr(AModExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseAOrExpr(AOrExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseAAndExpr(AAndExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseAEqualsExpr(AEqualsExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseANotequalsExpr(ANotequalsExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseAGreaterExpr(AGreaterExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseALessExpr(ALessExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseAGreaterequalsExpr(AGreaterequalsExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseALessequalsExpr(ALessequalsExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseAUnaryExpr(AUnaryExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseANotExpr(ANotExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseAValExpr(AValExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseACallExpr(ACallExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseAIdExpr(AIdExpr node) {
        defaultCase(node);
    }

    @Override
    public void caseANumVal(ANumVal node) {
        defaultCase(node);
    }

    @Override
    public void caseATextVal(ATextVal node) {
        defaultCase(node);
    }

    @Override
    public void caseABoolVal(ABoolVal node) {
        defaultCase(node);
    }

    @Override
    public void caseAThisVal(AThisVal node) {
        defaultCase(node);
    }

    @Override
    public void caseAConstrVal(AConstrVal node) {
        defaultCase(node);
    }

    @Override
    public void caseAVardclStmt(AVardclStmt node) {
        defaultCase(node);
    }

    @Override
    public void caseAAssignmentStmt(AAssignmentStmt node) {
        defaultCase(node);
    }

    @Override
    public void caseAForupStmt(AForupStmt node) {
        defaultCase(node);
    }

    @Override
    public void caseAFordownStmt(AFordownStmt node) {
        defaultCase(node);
    }

    @Override
    public void caseAWhileStmt(AWhileStmt node) {
        defaultCase(node);
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        defaultCase(node);
    }

    @Override
    public void caseAFunccallStmt(AFunccallStmt node) {
        defaultCase(node);
    }

    @Override
    public void caseAClasscallStmt(AClasscallStmt node) {
        defaultCase(node);
    }

    @Override
    public void caseAIfConditional(AIfConditional node) {
        defaultCase(node);
    }

    @Override
    public void caseAElseBranch(AElseBranch node) {
        defaultCase(node);
    }

    @Override
    public void caseAElseifBranch(AElseifBranch node) {
        defaultCase(node);
    }

    @Override
    public void caseTNum(TNum node) {
        defaultCase(node);
    }

    @Override
    public void caseTBool(TBool node) {
        defaultCase(node);
    }

    @Override
    public void caseTList(TList node) {
        defaultCase(node);
    }

    @Override
    public void caseTText(TText node) {
        defaultCase(node);
    }

    @Override
    public void caseTWhile(TWhile node) {
        defaultCase(node);
    }

    @Override
    public void caseTFor(TFor node) {
        defaultCase(node);
    }

    @Override
    public void caseTBegin(TBegin node) {
        defaultCase(node);
    }

    @Override
    public void caseTEnd(TEnd node) {
        defaultCase(node);
    }

    @Override
    public void caseTDo(TDo node) {
        defaultCase(node);
    }

    @Override
    public void caseTIf(TIf node) {
        defaultCase(node);
    }

    @Override
    public void caseTThen(TThen node) {
        defaultCase(node);
    }

    @Override
    public void caseTElse(TElse node) {
        defaultCase(node);
    }

    @Override
    public void caseTOr(TOr node) {
        defaultCase(node);
    }

    @Override
    public void caseTAnd(TAnd node) {
        defaultCase(node);
    }

    @Override
    public void caseTSet(TSet node) {
        defaultCase(node);
    }

    @Override
    public void caseTDcl(TDcl node) {
        defaultCase(node);
    }

    @Override
    public void caseTThis(TThis node) {
        defaultCase(node);
    }

    @Override
    public void caseTTbase(TTbase node) {
        defaultCase(node);
    }

    @Override
    public void caseTOf(TOf node) {
        defaultCase(node);
    }

    @Override
    public void caseTTo(TTo node) {
        defaultCase(node);
    }

    @Override
    public void caseTNew(TNew node) {
        defaultCase(node);
    }

    @Override
    public void caseTFunc(TFunc node) {
        defaultCase(node);
    }

    @Override
    public void caseTEclass(TEclass node) {
        defaultCase(node);
    }

    @Override
    public void caseTMain(TMain node) {
        defaultCase(node);
    }

    @Override
    public void caseTUpto(TUpto node) {
        defaultCase(node);
    }

    @Override
    public void caseTDownto(TDownto node) {
        defaultCase(node);
    }

    @Override
    public void caseTBoolval(TBoolval node) {
        defaultCase(node);
    }

    @Override
    public void caseTIs(TIs node) {
        defaultCase(node);
    }

    @Override
    public void caseTComma(TComma node) {
        defaultCase(node);
    }

    @Override
    public void caseTDot(TDot node) {
        defaultCase(node);
    }

    @Override
    public void caseTEquals(TEquals node) {
        defaultCase(node);
    }

    @Override
    public void caseTNotequals(TNotequals node) {
        defaultCase(node);
    }

    @Override
    public void caseTGreater(TGreater node) {
        defaultCase(node);
    }

    @Override
    public void caseTLess(TLess node) {
        defaultCase(node);
    }

    @Override
    public void caseTGreaterequals(TGreaterequals node) {
        defaultCase(node);
    }

    @Override
    public void caseTLessequals(TLessequals node) {
        defaultCase(node);
    }

    @Override
    public void caseTNot(TNot node) {
        defaultCase(node);
    }

    @Override
    public void caseTTreturn(TTreturn node) {
        defaultCase(node);
    }

    @Override
    public void caseTMinus(TMinus node) {
        defaultCase(node);
    }

    @Override
    public void caseTPlus(TPlus node) {
        defaultCase(node);
    }

    @Override
    public void caseTDivide(TDivide node) {
        defaultCase(node);
    }

    @Override
    public void caseTMult(TMult node) {
        defaultCase(node);
    }

    @Override
    public void caseTMod(TMod node) {
        defaultCase(node);
    }

    @Override
    public void caseTLparen(TLparen node) {
        defaultCase(node);
    }

    @Override
    public void caseTRparen(TRparen node) {
        defaultCase(node);
    }

    @Override
    public void caseTNumval(TNumval node) {
        defaultCase(node);
    }

    @Override
    public void caseTNewline(TNewline node) {
        defaultCase(node);
    }

    @Override
    public void caseTId(TId node) {
        defaultCase(node);
    }

    @Override
    public void caseTTextval(TTextval node) {
        defaultCase(node);
    }

    @Override
    public void caseTBlank(TBlank node) {
        defaultCase(node);
    }

    @Override
    public void caseTComment(TComment node) {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node) {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node) {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node) {
        // do nothing
    }
}
