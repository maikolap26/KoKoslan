/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.compile


import kokoslan.ast.*
import kokoslan.parser.*

import org.antlr.v4.runtime.tree.ParseTree

import java.util.*
import java.util.stream.*
import java.io.*

class KoKoCompiler (outputFile: String? = null) : KoKoslanBaseVisitor<KoKoAst>(), KoKoEmiter {

    protected var outputFile: String? = null
    protected var program: KoKoAst? = null
    private val ids = ArrayList<KoKoAst>()
    protected var statements: MutableList<KoKoAst> = ArrayList()

    init {
        this.outputFile = outputFile
    }

    fun getProgram(): KoKoProgram {
        return PROGRAM(this.statements)
    }

    fun genCode() {
        try {
            genCode(if (outputFile == null) System.out else PrintStream(outputFile!!))
        } catch (e: Exception) {
            throw RuntimeException(e.message)
        }

    }

    fun genCode(out: PrintStream) {
        this.statements.stream()
                .forEach { t -> t.genCode(out) }
    }

    fun eval(): KoKoValue? {
        return getProgram().eval()
    }

    fun compile(tree: ParseTree): KoKoAst {
        return visit(tree)
    }

    override fun visitProgram(ctx: KoKoslanParser.ProgramContext): KoKoAst? {
        ctx.definition()
                .map { `fun` -> visit(`fun`) }
                .forEach { `fun` -> this.statements.add(`fun`) }
        this.program = PROGRAM(this.statements)
        val expr = visit(ctx.expression())
        this.statements.add(expr)
        return this.program
    }

    override fun visitDefinition(ctx: KoKoslanParser.DefinitionContext): KoKoAst {
        val id = visit(ctx.id())
        val expr = visit(ctx.expression())
        ids.add(id)
        return LET(id, expr)
    }

    override fun visitAdd_expr(ctx: KoKoslanParser.Add_exprContext): KoKoAst {
        // Check if only one operand. Then just visit down
        if (ctx.add_oper() == null) {
            return visit(ctx.mult_expr(0))
        }

        val operators = ctx.add_oper()
                .map { e -> visit(e) }

        val operands = ctx.mult_expr()
                .map { e -> visit(e) }

        val r = arrayOf(operands[0])
        /*java.util.stream.IntStream.range(1,operands.size)
                .forEach { i -> r[0] = BI_OPERATION(operators[i - 1], r[0], operands[i]) }*/
          IntRange(1,operands.size-1)
                .forEach { i -> r[0] = BI_OPERATION(operators[i - 1], r[0], operands[i]) }      
        return r[0]
    }

    override fun visitAdd_oper(ctx: KoKoslanParser.Add_operContext): KoKoAst {
        return OPERATOR(ctx.oper.text)
    }

    override fun visitMult_oper(ctx: KoKoslanParser.Mult_operContext): KoKoAst {
        return OPERATOR(ctx.oper.text)
    }

    override fun visitLogic_oper(ctx: KoKoslanParser.Logic_operContext): KoKoAst {
        return OPERATOR(ctx.oper.getText())
    }


    override fun visitId(ctx: KoKoslanParser.IdContext): KoKoAst {
        return ID(ctx.ID().text)
    }

    override fun visitNumber(ctx: KoKoslanParser.NumberContext): KoKoAst {
        return NUM(java.lang.Double.valueOf(ctx.NUMBER().text))
    }

    override fun visitBool(ctx: KoKoslanParser.BoolContext): KoKoAst {
        return if (ctx.TRUE() != null) KoKoEmiter.TRUE else KoKoEmiter.FALSE
    }

    //
    override fun visitMult_expr(ctx: KoKoslanParser.Mult_exprContext): KoKoAst {
        if (ctx.mult_oper() == null) {
            return visit(ctx.value_expr(0))
        }

        val operators = ctx.mult_oper()
                .map { e -> visit(e) }

        val operands = ctx.value_expr()
                .map { e -> visit(e) }


        var r = arrayOf(operands[0])

        /*java.util.stream.IntStream.range(1,operands.size)
                .forEach { i -> r[0] = BI_OPERATION(operators[i - 1], r[0], operands[i]) }*/
        IntRange(1,operands.size-1)
                .forEach { i -> r[0] = BI_OPERATION(operators[i - 1], r[0], operands[i]) }
        return r[0]
    }

    override fun visitCallValueExpr(ctx: KoKoslanParser.CallValueExprContext): KoKoAst {
        //println("CallValue_expr")
        val head = visit(ctx.value_expr())
        val args = visit(ctx.call_args()) as KoKoList
        return CALL(head, args)
    }

    override fun visitCall_args(ctx: KoKoslanParser.Call_argsContext): KoKoAst {
        //println("Call_args")
        return if (ctx.list_expr() != null)
            LIST(ctx.list_expr()
                .map { e -> visit(e) })
        else
            LIST()
    }

    override fun visitListValueExpr(ctx: KoKoslanParser.ListValueExprContext): KoKoAst {
        val exprs = ctx.list_value().list_expr().expression()
                .map { e ->visit(e)}
        return LIST(exprs)
    }


    override fun visitList_expr(ctx: KoKoslanParser.List_exprContext): KoKoAst {
        val exprs = ctx.expression()
                .map { e -> visit(e) }
        return LIST(exprs)
    }

    override fun visitLambda_expr(ctx: KoKoslanParser.Lambda_exprContext): KoKoAst {
        val pattern = visit(ctx.pattern()) 
        val expr = visit(ctx.expression())
        var args: KoKoAst? = null //args para evaluar sin let
        if (ctx.call_args() != null) {
            args = visit(ctx.call_args())  
        }
        
        return LAMBDA(pattern, expr, args) //sino hay args los manda null
    }


//NSU
    override fun visitLambda_eval(ctx: KoKoslanParser.Lambda_evalContext): KoKoAst {
        val pattern = visit(ctx.lambda_expr().pattern()) 
        val expression = visit(ctx.lambda_expr().expression())
        val args: KoKoAst
        if (ctx.call_args() != null)
            args = (visit(ctx.call_args()) as KoKoList).f
        else
            args = visit(ctx.atomic_value())
        return LAMBDACALL(pattern, expression, args)
    }

   override fun visitBool_statement(ctx: KoKoslanParser.Bool_statementContext): KoKoAst {
        if (ctx.logic_oper() == null) {
            return visit(ctx.bool_expr(0))
        }

        val operators = ctx.logic_oper()
                .map({ e -> visit(e) })


        val operands = ctx.bool_expr()
                .map({ e -> visit(e) })


        val r = arrayOf<KoKoAst>(operands.get(0))
       /*java.util.stream.IntStream.range(1,operands.size)
               .forEach { i -> r[0] = BI_OPERATION(operators[i - 1], r[0], operands[i]) }*/
        IntRange(1,operands.size-1)
                .forEach { i -> r[0] = BI_OPERATION(operators[i - 1], r[0], operands[i]) }
        return r[0]
    }

    override fun visitBool_expr(ctx: KoKoslanParser.Bool_exprContext): KoKoAst {
        if (ctx.bool_oper() == null) {
            return visit(ctx.value_expr(0))
        }

        val operators = ctx.bool_oper()
                .map { e -> visit(e) }

        val operands = ctx.value_expr()
                .map { e -> visit(e) }


        val r = arrayOf(operands[0])
        /*java.util.stream.IntStream.range(1,operands.size)
                .forEach { i -> r[0] = BI_OPERATION(operators[i - 1], r[0], operands[i]) }*/
         IntRange(1,operands.size-1)
                .forEach { i -> r[0] = BI_OPERATION(operators[i - 1], r[0], operands[i]) }        
        return r[0]
    }

    override fun visitBool_oper(ctx: KoKoslanParser.Bool_operContext): KoKoAst {
        return OPERATOR(ctx.oper.text)
    }

    override fun visitParentValueExpr(ctx: KoKoslanParser.ParentValueExprContext): KoKoAst {
        val expression = visit(ctx.expression())
        return PARENT(expression)
    }
    override fun visitPrimitive_oper(ctx: KoKoslanParser.Primitive_operContext): KoKoAst {
        return OPERATOR(ctx.oper.text)
    }

    override fun visitNot_expr(ctx: KoKoslanParser.Not_exprContext): KoKoAst {
        val expression = visit(ctx.expression())
        return NOT(expression)
    }

    override fun visitTern_oper(ctx: KoKoslanParser.Tern_operContext): KoKoAst {
        val expressions = ctx.expression()
                .map({ e -> visit(e) })

        val condition = visit(ctx.bool_statement())
        return Tern_expr(condition, expressions.get(0), expressions.get(1))
    }

    override fun visitList_pat(ctx: KoKoslanParser.List_patContext): KoKoAst{
        val expression = visit(ctx.list_body_pat())
        return LISTPAT(expression)
    }

    override fun visitList_body_pat(ctx: KoKoslanParser.List_body_patContext): KoKoAst{
        val pat = visit(ctx.pattern(0))
        val rest = visit(ctx.rest_body_pat())
        return ListBodyPat(pat,rest)
    }

    override fun visitPrimitiveValueExpr(ctx: KoKoslanParser.PrimitiveValueExprContext): KoKoAst {
        val operators = ctx.primitive_expr().primitive_oper()              
        val arr=visit(ctx.primitive_expr().expression())
		val oper = visitPrimitive_oper(operators)
		return PRIMITIVE_OPERATION(oper, arr)
    }

    override fun visitPrimitive_expr(ctx: KoKoslanParser.Primitive_exprContext): KoKoAst { 
        val operators = ctx.primitive_oper()              
        val arr=visit(ctx.expression())
		val oper = visitPrimitive_oper(operators)
		return PRIMITIVE_OPERATION(oper, arr)
	}

    override fun visitFail_expr(ctx: KoKoslanParser.Fail_exprContext): KoKoAst{
        val operators = ctx.primitive_oper() 
		val oper = visitPrimitive_oper(operators)
		return FAILEXPR(oper)
    }

    override fun visitCons_expr(ctx: KoKoslanParser.Cons_exprContext): KoKoAst{
        val FArgs = visit(ctx.expression(0))
        val SArgs = visit(ctx.expression(1))
		return CONSEXPR(FArgs,SArgs)
    }
    override fun visitCaseValueExpr(ctx: KoKoslanParser.CaseValueExprContext): KoKoAst{
        if(ctx.case_value().case_expr().lambda_expr() != null){
            val exprs = ctx.case_value().case_expr().lambda_expr()
            .map {
                e -> visit(e)
            }
            println(exprs)
            return LIST(exprs)   
        }
        else{
            return LIST()
        }
    }
}




