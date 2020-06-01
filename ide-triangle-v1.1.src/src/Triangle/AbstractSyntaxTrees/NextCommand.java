package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class NextCommand extends Command {

    public NextCommand( Identifier iAST, SourcePosition thePosition) {
        super(thePosition);
        I = iAST;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitNextCommand(this, o);
    }
    public Identifier I;
}