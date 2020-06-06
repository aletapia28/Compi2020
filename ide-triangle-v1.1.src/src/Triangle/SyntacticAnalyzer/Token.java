/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // reserved words - must be in alphabetical order...
    AND     = 4, //nueva palabra reservada
    ARRAY		= 5,
    //BEGIN	= 5, se elimina palabra reservada
    CONST		= 6,
    DO	  	= 7,  
    ELSE	  = 8,  
    ELSIF   = 9, //nueva palabra reservada
    END			= 10,
    EXIT    = 11, //nueva palabra reservada 
    FUNC		= 12,
    IF		  = 13,  
    IN		  = 14,  
    LET	    = 15,
    NEXT    = 16 ,
    NIL     = 17 , //nueva palabra reservada
    OF			= 18 ,
    PRIVATE = 19, //nueva palabra reservada
    PROC		= 20,
    REC     = 21, //nueva palabra reservada
    RECORD	= 22,
    REPEAT  = 23, //nueva palabra reservada
    RETURN  = 24, //nueva palabra reservada
    THEN	  = 25,  
    TO      = 26, //nueva palabra reservada
    TYPE		= 27,
    UNTIL   = 28, //nueva palabra reservada
    VAR			= 29,
    WHILE =   30,

    // punctuation...
    DOT			  = 31,
    COLON		  = 32,
    SEMICOLON	= 33,
    COMMA		  = 34,
    BECOMES		= 35,
    IS			  = 36,
 
    // brackets 37...
    LPAREN		= 37,
    RPAREN		= 38,
    LBRACKET	= 39,
    RBRACKET 	= 40,
    LCURLY	  = 41,
    RCURLY		= 42,

    // special tokens...
    EOT			= 43,
    ERROR		= 44;

  private static String[] tokenTable = new String[] {
    "<int>", //0
    "<char>", //1
    "<identifier>", //2
    "<operator>", //3
    "and", //nueva palabra reservada //4 
    "array",// 5 
    "const",// 6 
    "do", //7 
    "else", //8 
    "elsif", //nueva palabra reservada //9 
    "end", //0
    "exit", //nueva palabra reservada 11
    "func", //12
    "if", //13
    "in", //14
    "let", //15 
    "next", //16
    "nil", //nueva palabra reservada //17
    "of", //18
    "private", //nueva palabra reservada //19
    "proc", //20
    "rec", //nueva palabra reservada 21 
    "record", //22
    "repeat", //nueva palabra reservada //23
    "return", //nueva palabra reservada //24 
    "then", //25 
    "to", //nueva palabra reservada //26 
    "type", //27
    "until", //nueva palabra reservada //28
    "var", //29
    "while", //30
    ".", //31
    ":", //32
    ";", //33
    ",", //34
    ":=", //35 
    "~", //36
    "(", //37
    ")", //38
    "[", //39
    "]", //40
    "{", //41
    "}", //42
    "", //43
    "<error>" //44
  };

  private final static int	firstReservedWord = Token.ARRAY,
          lastReservedWord  = Token.WHILE;
          


  //funcion para verificar que es una palabra reservada, retorna boolean
  public static boolean isReservedWord(String token) {
	  boolean answer = false;
	  for(int i = 4;i<30;i++) { //asegurar que concuerde
		  if(tokenTable[i].equals(token)) {
			  answer = true;
			  break;
		  }
	  }
	  return answer;
  }

}

