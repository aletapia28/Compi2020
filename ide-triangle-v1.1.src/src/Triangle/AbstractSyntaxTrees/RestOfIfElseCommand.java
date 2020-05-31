package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RestOfIfElseCommand extends Command {

    public RestOfIfElseCommand( Command cAST, SourcePosition thePosition) {
        super(thePosition);
        C = cAST;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitRestOfIfElseCommand(this, o);
    }
    public Command C;
}