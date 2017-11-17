// Generated from c:\Users\PC\Desktop\KOKOSLANPP-master\KoKoslan Kotlin\IJ\grammar\KoKoslan.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KoKoslanLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, NUMBER=9, 
		STRING=10, DOT=11, BACK_SLASH=12, COMMA=13, COLON=14, QUESTION_MARK=15, 
		LEFT_PAR=16, RIGHT_PAR=17, LEFT_CURLY=18, RIGHT_CURLY=19, LEFT_BRACKET=20, 
		RIGHT_BRACKET=21, LET=22, NOT=23, EQ=24, NEQ=25, LEQ=26, OR=27, TRUE=28, 
		FALSE=29, MUL=30, DIV=31, ADD=32, SUB=33, ID=34, ARROW=35, GR=36, LESS=37, 
		EQUALS=38, AND=39, SLC=40, MLC=41, WS=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "NUMBER", 
		"INTEGER", "STRING", "DOT", "BACK_SLASH", "COMMA", "COLON", "QUESTION_MARK", 
		"LEFT_PAR", "RIGHT_PAR", "LEFT_CURLY", "RIGHT_CURLY", "LEFT_BRACKET", 
		"RIGHT_BRACKET", "LET", "NOT", "EQ", "NEQ", "LEQ", "OR", "TRUE", "FALSE", 
		"MUL", "DIV", "ADD", "SUB", "ID", "ARROW", "GR", "LESS", "EQUALS", "AND", 
		"SLC", "MLC", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'()'", "'length'", "'first'", "'rest'", "'print'", "'fail'", "'cons'", 
		"'|'", null, null, "'.'", "'\\'", "','", "':'", "'?'", "'('", "')'", "'{'", 
		"'}'", "'['", "']'", "'let'", "'!'", "'='", "'!='", "'<='", "'||'", "'true'", 
		"'false'", "'*'", "'/'", "'+'", "'-'", null, "'->'", "'>'", "'<'", "'=='", 
		"'&&'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "NUMBER", "STRING", 
		"DOT", "BACK_SLASH", "COMMA", "COLON", "QUESTION_MARK", "LEFT_PAR", "RIGHT_PAR", 
		"LEFT_CURLY", "RIGHT_CURLY", "LEFT_BRACKET", "RIGHT_BRACKET", "LET", "NOT", 
		"EQ", "NEQ", "LEQ", "OR", "TRUE", "FALSE", "MUL", "DIV", "ADD", "SUB", 
		"ID", "ARROW", "GR", "LESS", "EQUALS", "AND", "SLC", "MLC", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public KoKoslanLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "KoKoslan.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u0109\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\n\5\n\u0082\n\n\3\n\3\n\3\n\5\n\u0087\n\n\3\13"+
		"\6\13\u008a\n\13\r\13\16\13\u008b\3\f\3\f\7\f\u0090\n\f\f\f\16\f\u0093"+
		"\13\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\""+
		"\3#\3#\3$\3$\7$\u00d3\n$\f$\16$\u00d6\13$\3%\3%\3%\3&\3&\3\'\3\'\3(\3"+
		"(\3(\3)\3)\3)\3*\3*\3*\3*\7*\u00e9\n*\f*\16*\u00ec\13*\3*\3*\3*\3*\3*"+
		"\3+\3+\3+\3+\7+\u00f7\n+\f+\16+\u00fa\13+\3+\5+\u00fd\n+\3+\3+\3+\3+\3"+
		",\6,\u0104\n,\r,\16,\u0105\3,\3,\4\u00ea\u00f8\2-\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\2\27\f\31\r\33\16\35\17\37\20!\21#\22%\23\'\24"+
		")\25+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36=\37? A!C\"E#G$I%K&M\'"+
		"O(Q)S*U+W,\3\2\7\3\2\62;\3\2$$\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f\17\17"+
		"\"\"\2\u0110\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5\\\3\2\2\2\7c\3\2\2\2\ti\3\2\2\2\13n\3"+
		"\2\2\2\rt\3\2\2\2\17y\3\2\2\2\21~\3\2\2\2\23\u0081\3\2\2\2\25\u0089\3"+
		"\2\2\2\27\u008d\3\2\2\2\31\u0096\3\2\2\2\33\u0098\3\2\2\2\35\u009a\3\2"+
		"\2\2\37\u009c\3\2\2\2!\u009e\3\2\2\2#\u00a0\3\2\2\2%\u00a2\3\2\2\2\'\u00a4"+
		"\3\2\2\2)\u00a6\3\2\2\2+\u00a8\3\2\2\2-\u00aa\3\2\2\2/\u00ac\3\2\2\2\61"+
		"\u00b0\3\2\2\2\63\u00b2\3\2\2\2\65\u00b4\3\2\2\2\67\u00b7\3\2\2\29\u00ba"+
		"\3\2\2\2;\u00bd\3\2\2\2=\u00c2\3\2\2\2?\u00c8\3\2\2\2A\u00ca\3\2\2\2C"+
		"\u00cc\3\2\2\2E\u00ce\3\2\2\2G\u00d0\3\2\2\2I\u00d7\3\2\2\2K\u00da\3\2"+
		"\2\2M\u00dc\3\2\2\2O\u00de\3\2\2\2Q\u00e1\3\2\2\2S\u00e4\3\2\2\2U\u00f2"+
		"\3\2\2\2W\u0103\3\2\2\2YZ\7*\2\2Z[\7+\2\2[\4\3\2\2\2\\]\7n\2\2]^\7g\2"+
		"\2^_\7p\2\2_`\7i\2\2`a\7v\2\2ab\7j\2\2b\6\3\2\2\2cd\7h\2\2de\7k\2\2ef"+
		"\7t\2\2fg\7u\2\2gh\7v\2\2h\b\3\2\2\2ij\7t\2\2jk\7g\2\2kl\7u\2\2lm\7v\2"+
		"\2m\n\3\2\2\2no\7r\2\2op\7t\2\2pq\7k\2\2qr\7p\2\2rs\7v\2\2s\f\3\2\2\2"+
		"tu\7h\2\2uv\7c\2\2vw\7k\2\2wx\7n\2\2x\16\3\2\2\2yz\7e\2\2z{\7q\2\2{|\7"+
		"p\2\2|}\7u\2\2}\20\3\2\2\2~\177\7~\2\2\177\22\3\2\2\2\u0080\u0082\7/\2"+
		"\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0086"+
		"\5\25\13\2\u0084\u0085\7\60\2\2\u0085\u0087\5\25\13\2\u0086\u0084\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\24\3\2\2\2\u0088\u008a\t\2\2\2\u0089\u0088"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\26\3\2\2\2\u008d\u0091\7$\2\2\u008e\u0090\n\3\2\2\u008f\u008e\3\2\2\2"+
		"\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094"+
		"\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7$\2\2\u0095\30\3\2\2\2\u0096"+
		"\u0097\7\60\2\2\u0097\32\3\2\2\2\u0098\u0099\7^\2\2\u0099\34\3\2\2\2\u009a"+
		"\u009b\7.\2\2\u009b\36\3\2\2\2\u009c\u009d\7<\2\2\u009d \3\2\2\2\u009e"+
		"\u009f\7A\2\2\u009f\"\3\2\2\2\u00a0\u00a1\7*\2\2\u00a1$\3\2\2\2\u00a2"+
		"\u00a3\7+\2\2\u00a3&\3\2\2\2\u00a4\u00a5\7}\2\2\u00a5(\3\2\2\2\u00a6\u00a7"+
		"\7\177\2\2\u00a7*\3\2\2\2\u00a8\u00a9\7]\2\2\u00a9,\3\2\2\2\u00aa\u00ab"+
		"\7_\2\2\u00ab.\3\2\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af"+
		"\7v\2\2\u00af\60\3\2\2\2\u00b0\u00b1\7#\2\2\u00b1\62\3\2\2\2\u00b2\u00b3"+
		"\7?\2\2\u00b3\64\3\2\2\2\u00b4\u00b5\7#\2\2\u00b5\u00b6\7?\2\2\u00b6\66"+
		"\3\2\2\2\u00b7\u00b8\7>\2\2\u00b8\u00b9\7?\2\2\u00b98\3\2\2\2\u00ba\u00bb"+
		"\7~\2\2\u00bb\u00bc\7~\2\2\u00bc:\3\2\2\2\u00bd\u00be\7v\2\2\u00be\u00bf"+
		"\7t\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1\7g\2\2\u00c1<\3\2\2\2\u00c2\u00c3"+
		"\7h\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7n\2\2\u00c5\u00c6\7u\2\2\u00c6"+
		"\u00c7\7g\2\2\u00c7>\3\2\2\2\u00c8\u00c9\7,\2\2\u00c9@\3\2\2\2\u00ca\u00cb"+
		"\7\61\2\2\u00cbB\3\2\2\2\u00cc\u00cd\7-\2\2\u00cdD\3\2\2\2\u00ce\u00cf"+
		"\7/\2\2\u00cfF\3\2\2\2\u00d0\u00d4\t\4\2\2\u00d1\u00d3\t\5\2\2\u00d2\u00d1"+
		"\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"H\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7/\2\2\u00d8\u00d9\7@\2\2\u00d9"+
		"J\3\2\2\2\u00da\u00db\7@\2\2\u00dbL\3\2\2\2\u00dc\u00dd\7>\2\2\u00ddN"+
		"\3\2\2\2\u00de\u00df\7?\2\2\u00df\u00e0\7?\2\2\u00e0P\3\2\2\2\u00e1\u00e2"+
		"\7(\2\2\u00e2\u00e3\7(\2\2\u00e3R\3\2\2\2\u00e4\u00e5\7\61\2\2\u00e5\u00e6"+
		"\7,\2\2\u00e6\u00ea\3\2\2\2\u00e7\u00e9\13\2\2\2\u00e8\u00e7\3\2\2\2\u00e9"+
		"\u00ec\3\2\2\2\u00ea\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ed\3\2"+
		"\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\7,\2\2\u00ee\u00ef\7\61\2\2\u00ef"+
		"\u00f0\3\2\2\2\u00f0\u00f1\b*\2\2\u00f1T\3\2\2\2\u00f2\u00f3\7\61\2\2"+
		"\u00f3\u00f4\7\61\2\2\u00f4\u00f8\3\2\2\2\u00f5\u00f7\13\2\2\2\u00f6\u00f5"+
		"\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9"+
		"\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fd\7\17\2\2\u00fc\u00fb\3"+
		"\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\7\f\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0101\b+\2\2\u0101V\3\2\2\2\u0102\u0104\t\6\2\2\u0103"+
		"\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\u0107\3\2\2\2\u0107\u0108\b,\2\2\u0108X\3\2\2\2\f\2\u0081\u0086"+
		"\u008b\u0091\u00d4\u00ea\u00f8\u00fc\u0105\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}