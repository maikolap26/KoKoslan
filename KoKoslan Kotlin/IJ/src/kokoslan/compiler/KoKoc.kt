/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */

package kokoslan.compile

import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.ParseTree

import java.io.FileInputStream
import java.io.InputStream


import kokoslan.parser.*


    val VERSION = "KoKoc v0.0 CR EIF400.II-2017"
    var PROMPT = ">"


    fun main(args: Array<String>) {
        println("\n...............................................")
        println(">>> $VERSION <<<")
        println("...............................................\n")
        // Get parameters
        var inputFile: String/*? = null*/
        var outputFile: String? = null
        inputFile = args[0]
        var `is` = System.`in`
        if (inputFile != null) {
            `is` = FileInputStream(inputFile)
            println(">>> KoKoc Reading from $inputFile <<<")
        } else {
            println(">>> KoKoc Reading from console (enter CTRL-Z+ENTER to finish <<<")
        }
        // Setup Lexer/Parser
        //ANTLRInputStream input = new ANTLRInputStream(is);
        val input = CharStreams.fromStream(`is`)
        val lexer = KoKoslanLexer(input)
        val tokens = CommonTokenStream(lexer)
        val parser = KoKoslanParser(tokens)

        // Parse, Compile and Generate code
        // Starting point is rule (context) 'program' (See grammar KoKoslan.g4)
        val tree = parser.program()

        // Compile tree
        if (args.size > 1)
            outputFile = args[1]
        val compiler = KoKoCompiler(outputFile)
        compiler.compile(tree)

        // Write code
        println(">>> KoKoc is writing to $outputFile <<<")
        compiler.genCode()
        // Eval code
        println(">>> KoKoc starts evaluating to console <<<")
        println("$PROMPT ${compiler.eval()}\n")
        println("...............................................\n")

    }

