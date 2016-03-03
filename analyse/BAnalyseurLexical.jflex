package plic.analyse ;

import java_cup.runtime.*;
import plic.exceptions.AnalyseLexicaleException;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

commentaireSlashSlash = [/][/].*

csteE = [0-9]+
csteB = "vrai" | "faux"
csteC = ["][a-zA-Z]["]

finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]

//idf = [a-z]+
idf = [a-zA-Z][a-zA-Z0-9]*


%%

<YYINITIAL>{commentaireSlashSlash}  {}

"+"                	{ return symbol(CodesLexicaux.PLUS); }
"-"                	{ return symbol(CodesLexicaux.MOINS); }
"*"                	{ return symbol(CodesLexicaux.MULT); }
"/"                	{ return symbol(CodesLexicaux.DIV); }
"="			{return symbol(CodesLexicaux.EGAL); }
";"			{return symbol(CodesLexicaux.POINTVIRGULE); }
","			{return symbol(CodesLexicaux.VIRGULE); }

"=="                    { return symbol(CodesLexicaux.EGALEGAL); }
"!="                    { return symbol(CodesLexicaux.DIFF); }
"<"                	{ return symbol(CodesLexicaux.INF); }
">"                	{ return symbol(CodesLexicaux.SUP); }

"et"                	{ return symbol(CodesLexicaux.ET); }
"ou"                	{ return symbol(CodesLexicaux.OU); }
"non"                	{ return symbol(CodesLexicaux.NON); }

"("                	{ return symbol(CodesLexicaux.PAROUV); }
")"                	{ return symbol(CodesLexicaux.PARFER); }

"entier"		{ return symbol(CodesLexicaux.entier); }
"publique"		{ return symbol(CodesLexicaux.publique); }
"privee"		{ return symbol(CodesLexicaux.privee); }

"classe"		{ return symbol(CodesLexicaux.classe); }
"ecrire"		{ return symbol(CodesLexicaux.ecrire); }
"fin"			{ return symbol(CodesLexicaux.fin); }



{csteE}      		{ return symbol(CodesLexicaux.CSTINT, yytext()); }
{csteB}      		{ return symbol(CodesLexicaux.CSTBOOL, yytext()); }
{csteC}			{ return symbol(CodesLexicaux.CSTCHAINE, yytext() ); }

{idf} 			{return symbol(CodesLexicaux.idf,yytext());}



{espace}                { }
{finDeLigne}		{ }

.                       { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }
