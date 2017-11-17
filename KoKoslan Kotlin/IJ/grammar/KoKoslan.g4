/**
  KoKoslan Grammar
  EIF400 II-2017
  @author loriacarlo@gmail.com
  @since 2017
*/

grammar KoKoslan;


program      : definition* expression
;

definition   : 'let' id '=' expression
;
expression   : part_expr 
;
part_expr    :  lambda_expr 
                | evaluable_expr 
                | bool_statement 
                | not_expr  
                | tern_oper 
                | primitive_expr 
                | fail_expr
                | cons_expr
;
fail_expr : primitive_oper '()'
;
cons_expr : primitive_oper '(' expression ',' expression ')'
;
primitive_expr: primitive_oper '('expression')'
;
primitive_oper: oper=('length'|'first'|'rest'|'print'|'fail'|'cons')
;
not_expr     : '!' expression
;
bool_statement	: bool_expr (logic_oper bool_expr)*
;
bool_expr	: value_expr (bool_oper value_expr)* //new
;
bool_oper	: oper=('<'|'>'|'=='|'!='|'<='|'>=') //new
;
logic_oper 	: oper=('&&'|'||') //new
;
lambda_expr  : '\\' pattern '.' '('? expression ')'? (call_args)?
;
lambda_eval :	 lambda_expr  (atomic_value|call_args)
;
evaluable_expr    :  add_expr test_expr?
;
add_expr          :  mult_expr (add_oper mult_expr)*
;
add_oper          : oper=('+' | '-')
;
mult_expr         :  value_expr (mult_oper value_expr)*
;
mult_oper          : oper=('*' | '/')
;

//tern_oper		:	bool_expr '?' expression ':' expression
tern_oper		:	bool_statement '?' expression ':' expression
;

test_expr         :  expression '?' expression ':' expression
;

// Value Expressions
value_expr   :   value_expr call_args	#CallValueExpr 
				         | '(' expression ')'	#ParentValueExpr
                 | (atomic_value|not_expr)			#AtomicValueExpr 
			          	 | list_value 			#ListValueExpr
                 | case_value			#CaseValueExpr
                 | primitive_expr #PrimitiveValueExpr
;
call_args	 : '(' list_expr? ')' ('(' list_expr? ')')*
;
atomic_value : id | number | bool 
;
// List expressions
list_value   :  '[' list_expr? ']'
; 
list_expr    :  expression ( ','  expression)*
;

// Case expressions
case_value   :  '{' case_expr? '}'
;
case_expr    :  lambda_expr ( '|'  lambda_expr)*
;

// Patterns
pattern      :   atomic_pat | list_pat
;
atomic_pat   : id | number | bool 
;
list_pat     : '[' list_body_pat? ']'
;
list_body_pat : pattern (',' pattern)* rest_body_pat?
;
rest_body_pat : '|' (id | list_pat)
;
id : ID
;
number : NUMBER
;
bool : TRUE | FALSE
;
////////////////////////////////////////////////////////////////
//                    Lexer    
///////////////////////////////////////////////////////////////
NUMBER : ('-')? INTEGER ('.' INTEGER)? 
;
fragment INTEGER : [0-9]+ ;

STRING : ('"' (~'"')* '"' )
;
DOT : '.'
;
BACK_SLASH : '\\'
;
COMMA : ','
;
COLON : ':'
;
QUESTION_MARK : '?'
;
LEFT_PAR : '('
;
RIGHT_PAR : ')'
;
LEFT_CURLY : '{'
;
RIGHT_CURLY : '}'
;
LEFT_BRACKET : '['
;
RIGHT_BRACKET : ']'
;
LET : 'let'
;
NOT : '!'
;
EQ : '='
;
NEQ : '!='
;
LEQ : '<='
;
OR : '||'
;
TRUE : 'true'
;
FALSE : 'false'
;
MUL :   '*' 
; 
DIV :   '/' 
;
ADD :   '+' 
;
SUB :   '-' 
;
ID : [a-zA-Z][a-zA-Z_0-9]* 
;
ARROW:	'->'
;
GR: '>'
;
LESS: '<'
;
EQUALS: '=='
;
AND: '&&'
;

////////////////////////////////////////////////
// Ignored tokens
SLC :   '/*'.*? '*/' -> skip
;
MLC : '//'.*?'\r'?'\n' -> skip
;         
WS  : [ \t\r\n]+ -> skip
; 


