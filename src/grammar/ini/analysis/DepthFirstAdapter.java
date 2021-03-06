/* This file was generated by SableCC (http://www.sablecc.org/). */

package grammar.ini.analysis;

import java.util.*;
import grammar.ini.node.*;

public class DepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getPProg().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    public void inAProg(AProg node)
    {
        defaultIn(node);
    }

    public void outAProg(AProg node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAProg(AProg node)
    {
        inAProg(node);
        {
            List<PPdcl> copy = new ArrayList<PPdcl>(node.getGlobaldcl());
            for(PPdcl e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getMaindcl() != null)
        {
            node.getMaindcl().apply(this);
        }
        {
            List<PPdcl> copy = new ArrayList<PPdcl>(node.getClassdcl());
            for(PPdcl e : copy)
            {
                e.apply(this);
            }
        }
        outAProg(node);
    }

    public void inAVarPdcl(AVarPdcl node)
    {
        defaultIn(node);
    }

    public void outAVarPdcl(AVarPdcl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarPdcl(AVarPdcl node)
    {
        inAVarPdcl(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAVarPdcl(node);
    }

    public void inAVarasgPdcl(AVarasgPdcl node)
    {
        defaultIn(node);
    }

    public void outAVarasgPdcl(AVarasgPdcl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarasgPdcl(AVarasgPdcl node)
    {
        inAVarasgPdcl(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        outAVarasgPdcl(node);
    }

    public void inAListPdcl(AListPdcl node)
    {
        defaultIn(node);
    }

    public void outAListPdcl(AListPdcl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListPdcl(AListPdcl node)
    {
        inAListPdcl(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAListPdcl(node);
    }

    public void inAClassPdcl(AClassPdcl node)
    {
        defaultIn(node);
    }

    public void outAClassPdcl(AClassPdcl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAClassPdcl(AClassPdcl node)
    {
        inAClassPdcl(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            List<PBody> copy = new ArrayList<PBody>(node.getBody());
            for(PBody e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getInherit() != null)
        {
            node.getInherit().apply(this);
        }
        outAClassPdcl(node);
    }

    public void inAMainPdcl(AMainPdcl node)
    {
        defaultIn(node);
    }

    public void outAMainPdcl(AMainPdcl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMainPdcl(AMainPdcl node)
    {
        inAMainPdcl(node);
        {
            List<PStmt> copy = new ArrayList<PStmt>(node.getStmt());
            for(PStmt e : copy)
            {
                e.apply(this);
            }
        }
        outAMainPdcl(node);
    }

    public void inAEventPdcl(AEventPdcl node)
    {
        defaultIn(node);
    }

    public void outAEventPdcl(AEventPdcl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEventPdcl(AEventPdcl node)
    {
        inAEventPdcl(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            List<PParam> copy = new ArrayList<PParam>(node.getParams());
            for(PParam e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getBase() != null)
        {
            node.getBase().apply(this);
        }
        {
            List<PStmt> copy = new ArrayList<PStmt>(node.getBody());
            for(PStmt e : copy)
            {
                e.apply(this);
            }
        }
        outAEventPdcl(node);
    }

    public void inAFuncPdcl(AFuncPdcl node)
    {
        defaultIn(node);
    }

    public void outAFuncPdcl(AFuncPdcl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFuncPdcl(AFuncPdcl node)
    {
        inAFuncPdcl(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            List<PParam> copy = new ArrayList<PParam>(node.getParams());
            for(PParam e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getBody() != null)
        {
            node.getBody().apply(this);
        }
        outAFuncPdcl(node);
    }

    public void inAFuncBody(AFuncBody node)
    {
        defaultIn(node);
    }

    public void outAFuncBody(AFuncBody node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFuncBody(AFuncBody node)
    {
        inAFuncBody(node);
        {
            List<PStmt> copy = new ArrayList<PStmt>(node.getStmt());
            for(PStmt e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getReturn() != null)
        {
            node.getReturn().apply(this);
        }
        outAFuncBody(node);
    }

    public void inAEventdclBody(AEventdclBody node)
    {
        defaultIn(node);
    }

    public void outAEventdclBody(AEventdclBody node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEventdclBody(AEventdclBody node)
    {
        inAEventdclBody(node);
        if(node.getPdcl() != null)
        {
            node.getPdcl().apply(this);
        }
        outAEventdclBody(node);
    }

    public void inAClassBody(AClassBody node)
    {
        defaultIn(node);
    }

    public void outAClassBody(AClassBody node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAClassBody(AClassBody node)
    {
        inAClassBody(node);
        if(node.getPdcl() != null)
        {
            node.getPdcl().apply(this);
        }
        outAClassBody(node);
    }

    public void inAIdReturn(AIdReturn node)
    {
        defaultIn(node);
    }

    public void outAIdReturn(AIdReturn node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdReturn(AIdReturn node)
    {
        inAIdReturn(node);
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        outAIdReturn(node);
    }

    public void inAEmptyReturn(AEmptyReturn node)
    {
        defaultIn(node);
    }

    public void outAEmptyReturn(AEmptyReturn node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEmptyReturn(AEmptyReturn node)
    {
        inAEmptyReturn(node);
        outAEmptyReturn(node);
    }

    public void inAMultiParam(AMultiParam node)
    {
        defaultIn(node);
    }

    public void outAMultiParam(AMultiParam node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultiParam(AMultiParam node)
    {
        inAMultiParam(node);
        {
            List<PParam> copy = new ArrayList<PParam>(node.getParam());
            for(PParam e : copy)
            {
                e.apply(this);
            }
        }
        outAMultiParam(node);
    }

    public void inAFormalParam(AFormalParam node)
    {
        defaultIn(node);
    }

    public void outAFormalParam(AFormalParam node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFormalParam(AFormalParam node)
    {
        inAFormalParam(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAFormalParam(node);
    }

    public void inABaseBase(ABaseBase node)
    {
        defaultIn(node);
    }

    public void outABaseBase(ABaseBase node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABaseBase(ABaseBase node)
    {
        inABaseBase(node);
        {
            List<PExpr> copy = new ArrayList<PExpr>(node.getParams());
            for(PExpr e : copy)
            {
                e.apply(this);
            }
        }
        outABaseBase(node);
    }

    public void inAInherit(AInherit node)
    {
        defaultIn(node);
    }

    public void outAInherit(AInherit node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInherit(AInherit node)
    {
        inAInherit(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        outAInherit(node);
    }

    public void inANumType(ANumType node)
    {
        defaultIn(node);
    }

    public void outANumType(ANumType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANumType(ANumType node)
    {
        inANumType(node);
        if(node.getNum() != null)
        {
            node.getNum().apply(this);
        }
        outANumType(node);
    }

    public void inABoolType(ABoolType node)
    {
        defaultIn(node);
    }

    public void outABoolType(ABoolType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABoolType(ABoolType node)
    {
        inABoolType(node);
        if(node.getBool() != null)
        {
            node.getBool().apply(this);
        }
        outABoolType(node);
    }

    public void inATextType(ATextType node)
    {
        defaultIn(node);
    }

    public void outATextType(ATextType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATextType(ATextType node)
    {
        inATextType(node);
        if(node.getText() != null)
        {
            node.getText().apply(this);
        }
        outATextType(node);
    }

    public void inAObjectType(AObjectType node)
    {
        defaultIn(node);
    }

    public void outAObjectType(AObjectType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAObjectType(AObjectType node)
    {
        inAObjectType(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAObjectType(node);
    }

    public void inAFuncCall(AFuncCall node)
    {
        defaultIn(node);
    }

    public void outAFuncCall(AFuncCall node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFuncCall(AFuncCall node)
    {
        inAFuncCall(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            List<PExpr> copy = new ArrayList<PExpr>(node.getParams());
            for(PExpr e : copy)
            {
                e.apply(this);
            }
        }
        outAFuncCall(node);
    }

    public void inADotCall(ADotCall node)
    {
        defaultIn(node);
    }

    public void outADotCall(ADotCall node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADotCall(ADotCall node)
    {
        inADotCall(node);
        if(node.getFirst() != null)
        {
            node.getFirst().apply(this);
        }
        {
            List<PCall> copy = new ArrayList<PCall>(node.getRest());
            for(PCall e : copy)
            {
                e.apply(this);
            }
        }
        outADotCall(node);
    }

    public void inAValCall(AValCall node)
    {
        defaultIn(node);
    }

    public void outAValCall(AValCall node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAValCall(AValCall node)
    {
        inAValCall(node);
        if(node.getVal() != null)
        {
            node.getVal().apply(this);
        }
        outAValCall(node);
    }

    public void inAVarCall(AVarCall node)
    {
        defaultIn(node);
    }

    public void outAVarCall(AVarCall node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarCall(AVarCall node)
    {
        inAVarCall(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAVarCall(node);
    }

    public void inAMinusExpr(AMinusExpr node)
    {
        defaultIn(node);
    }

    public void outAMinusExpr(AMinusExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMinusExpr(AMinusExpr node)
    {
        inAMinusExpr(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAMinusExpr(node);
    }

    public void inAPlusExpr(APlusExpr node)
    {
        defaultIn(node);
    }

    public void outAPlusExpr(APlusExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPlusExpr(APlusExpr node)
    {
        inAPlusExpr(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAPlusExpr(node);
    }

    public void inADivideExpr(ADivideExpr node)
    {
        defaultIn(node);
    }

    public void outADivideExpr(ADivideExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivideExpr(ADivideExpr node)
    {
        inADivideExpr(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outADivideExpr(node);
    }

    public void inAMultExpr(AMultExpr node)
    {
        defaultIn(node);
    }

    public void outAMultExpr(AMultExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultExpr(AMultExpr node)
    {
        inAMultExpr(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAMultExpr(node);
    }

    public void inAModExpr(AModExpr node)
    {
        defaultIn(node);
    }

    public void outAModExpr(AModExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAModExpr(AModExpr node)
    {
        inAModExpr(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAModExpr(node);
    }

    public void inAOrExpr(AOrExpr node)
    {
        defaultIn(node);
    }

    public void outAOrExpr(AOrExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOrExpr(AOrExpr node)
    {
        inAOrExpr(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAOrExpr(node);
    }

    public void inAAndExpr(AAndExpr node)
    {
        defaultIn(node);
    }

    public void outAAndExpr(AAndExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAndExpr(AAndExpr node)
    {
        inAAndExpr(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAAndExpr(node);
    }

    public void inAEqualsExpr(AEqualsExpr node)
    {
        defaultIn(node);
    }

    public void outAEqualsExpr(AEqualsExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEqualsExpr(AEqualsExpr node)
    {
        inAEqualsExpr(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAEqualsExpr(node);
    }

    public void inANotequalsExpr(ANotequalsExpr node)
    {
        defaultIn(node);
    }

    public void outANotequalsExpr(ANotequalsExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANotequalsExpr(ANotequalsExpr node)
    {
        inANotequalsExpr(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outANotequalsExpr(node);
    }

    public void inAGreaterExpr(AGreaterExpr node)
    {
        defaultIn(node);
    }

    public void outAGreaterExpr(AGreaterExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGreaterExpr(AGreaterExpr node)
    {
        inAGreaterExpr(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAGreaterExpr(node);
    }

    public void inALessExpr(ALessExpr node)
    {
        defaultIn(node);
    }

    public void outALessExpr(ALessExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALessExpr(ALessExpr node)
    {
        inALessExpr(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outALessExpr(node);
    }

    public void inAGreaterequalsExpr(AGreaterequalsExpr node)
    {
        defaultIn(node);
    }

    public void outAGreaterequalsExpr(AGreaterequalsExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGreaterequalsExpr(AGreaterequalsExpr node)
    {
        inAGreaterequalsExpr(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAGreaterequalsExpr(node);
    }

    public void inALessequalsExpr(ALessequalsExpr node)
    {
        defaultIn(node);
    }

    public void outALessequalsExpr(ALessequalsExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALessequalsExpr(ALessequalsExpr node)
    {
        inALessequalsExpr(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outALessequalsExpr(node);
    }

    public void inAUnaryExpr(AUnaryExpr node)
    {
        defaultIn(node);
    }

    public void outAUnaryExpr(AUnaryExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAUnaryExpr(AUnaryExpr node)
    {
        inAUnaryExpr(node);
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        outAUnaryExpr(node);
    }

    public void inANotExpr(ANotExpr node)
    {
        defaultIn(node);
    }

    public void outANotExpr(ANotExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANotExpr(ANotExpr node)
    {
        inANotExpr(node);
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        outANotExpr(node);
    }

    public void inAParenExpr(AParenExpr node)
    {
        defaultIn(node);
    }

    public void outAParenExpr(AParenExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParenExpr(AParenExpr node)
    {
        inAParenExpr(node);
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        outAParenExpr(node);
    }

    public void inAValExpr(AValExpr node)
    {
        defaultIn(node);
    }

    public void outAValExpr(AValExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAValExpr(AValExpr node)
    {
        inAValExpr(node);
        if(node.getVal() != null)
        {
            node.getVal().apply(this);
        }
        outAValExpr(node);
    }

    public void inACallExpr(ACallExpr node)
    {
        defaultIn(node);
    }

    public void outACallExpr(ACallExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACallExpr(ACallExpr node)
    {
        inACallExpr(node);
        if(node.getCall() != null)
        {
            node.getCall().apply(this);
        }
        outACallExpr(node);
    }

    public void inAIdExpr(AIdExpr node)
    {
        defaultIn(node);
    }

    public void outAIdExpr(AIdExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdExpr(AIdExpr node)
    {
        inAIdExpr(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdExpr(node);
    }

    public void inANumVal(ANumVal node)
    {
        defaultIn(node);
    }

    public void outANumVal(ANumVal node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANumVal(ANumVal node)
    {
        inANumVal(node);
        if(node.getNumval() != null)
        {
            node.getNumval().apply(this);
        }
        outANumVal(node);
    }

    public void inATextVal(ATextVal node)
    {
        defaultIn(node);
    }

    public void outATextVal(ATextVal node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATextVal(ATextVal node)
    {
        inATextVal(node);
        if(node.getTextval() != null)
        {
            node.getTextval().apply(this);
        }
        outATextVal(node);
    }

    public void inABoolVal(ABoolVal node)
    {
        defaultIn(node);
    }

    public void outABoolVal(ABoolVal node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABoolVal(ABoolVal node)
    {
        inABoolVal(node);
        if(node.getBoolval() != null)
        {
            node.getBoolval().apply(this);
        }
        outABoolVal(node);
    }

    public void inAThisVal(AThisVal node)
    {
        defaultIn(node);
    }

    public void outAThisVal(AThisVal node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAThisVal(AThisVal node)
    {
        inAThisVal(node);
        if(node.getThis() != null)
        {
            node.getThis().apply(this);
        }
        outAThisVal(node);
    }

    public void inAConstrVal(AConstrVal node)
    {
        defaultIn(node);
    }

    public void outAConstrVal(AConstrVal node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAConstrVal(AConstrVal node)
    {
        inAConstrVal(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            List<PExpr> copy = new ArrayList<PExpr>(node.getParam());
            for(PExpr e : copy)
            {
                e.apply(this);
            }
        }
        outAConstrVal(node);
    }

    public void inAVardclStmt(AVardclStmt node)
    {
        defaultIn(node);
    }

    public void outAVardclStmt(AVardclStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVardclStmt(AVardclStmt node)
    {
        inAVardclStmt(node);
        if(node.getPdcl() != null)
        {
            node.getPdcl().apply(this);
        }
        outAVardclStmt(node);
    }

    public void inAAssignmentStmt(AAssignmentStmt node)
    {
        defaultIn(node);
    }

    public void outAAssignmentStmt(AAssignmentStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAssignmentStmt(AAssignmentStmt node)
    {
        inAAssignmentStmt(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        outAAssignmentStmt(node);
    }

    public void inAForupStmt(AForupStmt node)
    {
        defaultIn(node);
    }

    public void outAForupStmt(AForupStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAForupStmt(AForupStmt node)
    {
        inAForupStmt(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        {
            List<PStmt> copy = new ArrayList<PStmt>(node.getStmt());
            for(PStmt e : copy)
            {
                e.apply(this);
            }
        }
        outAForupStmt(node);
    }

    public void inAFordownStmt(AFordownStmt node)
    {
        defaultIn(node);
    }

    public void outAFordownStmt(AFordownStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFordownStmt(AFordownStmt node)
    {
        inAFordownStmt(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        {
            List<PStmt> copy = new ArrayList<PStmt>(node.getStmt());
            for(PStmt e : copy)
            {
                e.apply(this);
            }
        }
        outAFordownStmt(node);
    }

    public void inAWhileStmt(AWhileStmt node)
    {
        defaultIn(node);
    }

    public void outAWhileStmt(AWhileStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAWhileStmt(AWhileStmt node)
    {
        inAWhileStmt(node);
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        {
            List<PStmt> copy = new ArrayList<PStmt>(node.getStmt());
            for(PStmt e : copy)
            {
                e.apply(this);
            }
        }
        outAWhileStmt(node);
    }

    public void inAIfStmt(AIfStmt node)
    {
        defaultIn(node);
    }

    public void outAIfStmt(AIfStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfStmt(AIfStmt node)
    {
        inAIfStmt(node);
        if(node.getConditional() != null)
        {
            node.getConditional().apply(this);
        }
        outAIfStmt(node);
    }

    public void inAFuncdotcallStmt(AFuncdotcallStmt node)
    {
        defaultIn(node);
    }

    public void outAFuncdotcallStmt(AFuncdotcallStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFuncdotcallStmt(AFuncdotcallStmt node)
    {
        inAFuncdotcallStmt(node);
        if(node.getCall() != null)
        {
            node.getCall().apply(this);
        }
        outAFuncdotcallStmt(node);
    }

    public void inAIfConditional(AIfConditional node)
    {
        defaultIn(node);
    }

    public void outAIfConditional(AIfConditional node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfConditional(AIfConditional node)
    {
        inAIfConditional(node);
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        {
            List<PStmt> copy = new ArrayList<PStmt>(node.getStmt());
            for(PStmt e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getBranch() != null)
        {
            node.getBranch().apply(this);
        }
        outAIfConditional(node);
    }

    public void inAElseBranch(AElseBranch node)
    {
        defaultIn(node);
    }

    public void outAElseBranch(AElseBranch node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAElseBranch(AElseBranch node)
    {
        inAElseBranch(node);
        {
            List<PStmt> copy = new ArrayList<PStmt>(node.getStmt());
            for(PStmt e : copy)
            {
                e.apply(this);
            }
        }
        outAElseBranch(node);
    }

    public void inAElseifBranch(AElseifBranch node)
    {
        defaultIn(node);
    }

    public void outAElseifBranch(AElseifBranch node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAElseifBranch(AElseifBranch node)
    {
        inAElseifBranch(node);
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        {
            List<PStmt> copy = new ArrayList<PStmt>(node.getStmt());
            for(PStmt e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getBranch() != null)
        {
            node.getBranch().apply(this);
        }
        outAElseifBranch(node);
    }
}
