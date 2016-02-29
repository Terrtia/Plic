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

csteE = [0-9]+
csteB = "vrai" | "faux"

finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]

statut = "privee" | "publique"
type = "entier"

//idf = [a-z]+
idf = [a-zA-Z][a-zA-Z0-9]*

%%

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

/*"classe"		{return symbol(CodesLexicaux.CLASS,yytext());}
"ecrire"		{return symbol(CodesLexicaux.ECR,yytext());}
"fin"			{return symbol(CodesLexicaux.FIN,yytext());}*/

"classe"		{return symbol(CodesLexicaux.CLASS);}
"ecrire"		{return symbol(CodesLexicaux.ECR);}
"fin"			{return symbol(CodesLexicaux.FIN);}


{statut}		{return symbol(CodesLexicaux.STATUT,yytext());}
{type}			{return symbol(CodesLexicaux.TYPE,yytext());}
{csteE}      	{ return symbol(CodesLexicaux.CONSTANTEINT, yytext()); }
{csteB}      	{ return symbol(CodesLexicaux.CONSTANTEBOOL, yytext()); }
{idf} 			{return symbol(CodesLexicaux.IDF,yytext());}



{espace}                { }


.                       { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }
