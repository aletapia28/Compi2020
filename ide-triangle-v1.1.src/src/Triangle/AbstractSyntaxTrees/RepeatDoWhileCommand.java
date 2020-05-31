package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatDoWhileCommand extends Command {

    public RepeatDoWhileCommand(Command cAST, Expression eAST, SourcePosition thePosition) {
        super(thePosition);
        C = cAST;
        E = eAST;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitRepeatDoWhileCommand(this, o);
    }

    public Command C;
    public Expression E;

}
