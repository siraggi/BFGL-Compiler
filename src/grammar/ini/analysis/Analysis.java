/* This file was generated by SableCC (http://www.sablecc.org/). */

package grammar.ini.analysis;

import grammar.ini.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAProg(AProg node);
    void caseAVarPdcl(AVarPdcl node);
    void caseAVarasgPdcl(AVarasgPdcl node);
    void caseAListPdcl(AListPdcl node);
    void caseAClassPdcl(AClassPdcl node);
    void caseAMainPdcl(AMainPdcl node);
    void caseAEventPdcl(AEventPdcl node);
    void caseAFuncPdcl(AFuncPdcl node);
    void caseAFuncBody(AFuncBody node);
    void caseAEventdclBody(AEventdclBody node);
    void caseAClassBody(AClassBody node);
    void caseAIdReturn(AIdReturn node);
    void caseAEmptyReturn(AEmptyReturn node);
    void caseAMultiParam(AMultiParam node);
    void caseAFormalParam(AFormalParam node);
    void caseABaseBase(ABaseBase node);
    void caseAInherit(AInherit node);
    void caseANumType(ANumType node);
    void caseABoolType(ABoolType node);
    void caseATextType(ATextType node);
    void caseAObjectType(AObjectType node);
    void caseAFuncCall(AFuncCall node);
    void caseAClassCall(AClassCall node);
    void caseAValCall(AValCall node);
    void caseAVarCall(AVarCall node);
    void caseAMinusExpr(AMinusExpr node);
    void caseAPlusExpr(APlusExpr node);
    void caseADivideExpr(ADivideExpr node);
    void caseAMultExpr(AMultExpr node);
    void caseAModExpr(AModExpr node);
    void caseAOrExpr(AOrExpr node);
    void caseAAndExpr(AAndExpr node);
    void caseAEqualsExpr(AEqualsExpr node);
    void caseANotequalsExpr(ANotequalsExpr node);
    void caseAGreaterExpr(AGreaterExpr node);
    void caseALessExpr(ALessExpr node);
    void caseAGreaterequalsExpr(AGreaterequalsExpr node);
    void caseALessequalsExpr(ALessequalsExpr node);
    void caseAUnaryExpr(AUnaryExpr node);
    void caseANotExpr(ANotExpr node);
    void caseAValExpr(AValExpr node);
    void caseACallExpr(ACallExpr node);
    void caseAIdExpr(AIdExpr node);
    void caseANumVal(ANumVal node);
    void caseATextVal(ATextVal node);
    void caseABoolVal(ABoolVal node);
    void caseAThisVal(AThisVal node);
    void caseAConstrVal(AConstrVal node);
    void caseAVardclStmt(AVardclStmt node);
    void caseAAssignmentStmt(AAssignmentStmt node);
    void caseAForupStmt(AForupStmt node);
    void caseAFordownStmt(AFordownStmt node);
    void caseAWhileStmt(AWhileStmt node);
    void caseAIfStmt(AIfStmt node);
    void caseAFunccallStmt(AFunccallStmt node);
    void caseAClasscallStmt(AClasscallStmt node);
    void caseAIfConditional(AIfConditional node);
    void caseAElseBranch(AElseBranch node);
    void caseAElseifBranch(AElseifBranch node);

    void caseTNum(TNum node);
    void caseTBool(TBool node);
    void caseTList(TList node);
    void caseTText(TText node);
    void caseTWhile(TWhile node);
    void caseTFor(TFor node);
    void caseTBegin(TBegin node);
    void caseTEnd(TEnd node);
    void caseTDo(TDo node);
    void caseTIf(TIf node);
    void caseTThen(TThen node);
    void caseTElse(TElse node);
    void caseTOr(TOr node);
    void caseTAnd(TAnd node);
    void caseTSet(TSet node);
    void caseTDcl(TDcl node);
    void caseTThis(TThis node);
    void caseTTbase(TTbase node);
    void caseTOf(TOf node);
    void caseTTo(TTo node);
    void caseTNew(TNew node);
    void caseTFunc(TFunc node);
    void caseTEclass(TEclass node);
    void caseTMain(TMain node);
    void caseTUpto(TUpto node);
    void caseTDownto(TDownto node);
    void caseTBoolval(TBoolval node);
    void caseTIs(TIs node);
    void caseTComma(TComma node);
    void caseTDot(TDot node);
    void caseTEquals(TEquals node);
    void caseTNotequals(TNotequals node);
    void caseTGreater(TGreater node);
    void caseTLess(TLess node);
    void caseTGreaterequals(TGreaterequals node);
    void caseTLessequals(TLessequals node);
    void caseTNot(TNot node);
    void caseTTreturn(TTreturn node);
    void caseTMinus(TMinus node);
    void caseTPlus(TPlus node);
    void caseTDivide(TDivide node);
    void caseTMult(TMult node);
    void caseTMod(TMod node);
    void caseTLparen(TLparen node);
    void caseTRparen(TRparen node);
    void caseTNumval(TNumval node);
    void caseTNewline(TNewline node);
    void caseTId(TId node);
    void caseTTextval(TTextval node);
    void caseTBlank(TBlank node);
    void caseTComment(TComment node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
