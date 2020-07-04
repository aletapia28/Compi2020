/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class BecomesVarDeclaration extends Declaration {
	 
	 public Identifier I;
	 public Expression E;
	 
	 public BecomesVarDeclaration (Identifier iAST, Expression eAST, SourcePosition declarationPos) {
		 super (declarationPos);
		 I =iAST;
		 E=eAST;
	 }

	 public Object visit(Visitor v, Object o) {
		 return v.visitBecomesVarDeclaration(this, o);
	 }

 
}
