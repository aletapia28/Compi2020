package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RestOfIfElsifCommand extends Command {

    public RestOfIfElsifCommand( Expression eAST, Command cAST,Command c2AST, SourcePosition thePosition) {
        super(thePosition);
        E = eAST;
        C = cAST;
        C2 = c2AST;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitRestOfIfElsifCommand(this, o);
    }
    
    public Expression E;
    public Command C;
    public Command C2;
}