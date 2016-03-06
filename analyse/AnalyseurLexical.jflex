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
csteC = \"[a-zA-Z0-9]*\" 
finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]



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

"classe"                { return symbol(CodesLexicaux.CLASS); }
"debut"            	{ return symbol(CodesLexicaux.DEBUT); }
"fin"             	{ return symbol(CodesLexicaux.FIN); }

//{statut}		{return symbol(CodesLexicaux.STATUT,yytext());}
//{type}			{return symbol(CodesLexicaux.TYPE,yytext());}
"publique"              { return symbol(CodesLexicaux.PUBLIQUE); }
"privee"                { return symbol(CodesLexicaux.PRIVEE); }

"entier"                { return symbol(CodesLexicaux.ENTIER); }

"pour"                  { return symbol(CodesLexicaux.POUR); }
"tantque"               { return symbol(CodesLexicaux.TANTQUE); }
"repeter"               { return symbol(CodesLexicaux.REPETER); }
"fintantque"            { return symbol(CodesLexicaux.FINTANTQUE); }
"si"                    { return symbol(CodesLexicaux.SI); }
"alors"                 { return symbol(CodesLexicaux.ALORS); }
"sinon"                 { return symbol(CodesLexicaux.SINON); }
"fsi"                   { return symbol(CodesLexicaux.FSI); }

"lire"                  { return symbol(CodesLexicaux.LIR); }
"ecrire"                { return symbol(CodesLexicaux.ECRIR); }


{csteE}      		{ return symbol(CodesLexicaux.CSTEINT, yytext()); }
{csteB}      		{ return symbol(CodesLexicaux.CSTEBOOL, yytext()); }
{csteC}			{ return symbol(CodesLexicaux.CSTECHAINE, yytext() ); }

{idf} 			{return symbol(CodesLexicaux.IDF,yytext());}



{espace}                { }

.                       { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }
