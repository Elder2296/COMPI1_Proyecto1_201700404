package Analizadores;
import java_cup.runtime.*;

import Tools.error;
import Frame.Principal;
%%
%public 
%class A_lexico
%cupsym Simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode

digito              = [0-9]+
letra               = [a-zA-ZÑñ]+
raro                = [!,#,$,&,',-,/,<,=,>,@,_,`,]
id                  = {letra}({letra}|{digito}|"_")*
cadena              = [\"][^\"\n]+[\"]





LineTerminator = \r|\n|\r\n
inputstream = [^\r\n]


comentariosimple    = "//" {inputstream}* {LineTerminator}?
comentariomulti     = "<!"({inputstream}* {LineTerminator})+"!>"

%%


":"         { System.out.println("Reconocio "+yytext()+" dos_puntos"); return new Symbol(Simbolos.dos_puntos, yycolumn, yyline, yytext()); }
"-"        { System.out.println("Reconocio "+yytext()+" guion"); return new Symbol(Simbolos.guion, yycolumn, yyline, yytext()); }
">"        { System.out.println("Reconocio "+yytext()+" mayorque"); return new Symbol(Simbolos.mayorque, yycolumn, yyline, yytext()); }

"~"         { System.out.println("Reconocio "+yytext()+" del_al"); return new Symbol(Simbolos.del_al, yycolumn, yyline, yytext()); }
";"         { System.out.println("Reconocio "+yytext()+" puntoYcoma"); return new Symbol(Simbolos.puntoYcoma, yycolumn, yyline, yytext()); }
"."         { System.out.println("Reconocio "+yytext()+" concatenar"); return new Symbol(Simbolos.concatenar, yycolumn, yyline, yytext()); }
"*"         { System.out.println("Reconocio "+yytext()+" kleen"); return new Symbol(Simbolos.kleen, yycolumn, yyline, yytext()); }
"|"         { System.out.println("Reconocio "+yytext()+" or"); return new Symbol(Simbolos.or, yycolumn, yyline, yytext()); }
"{"         { System.out.println("Reconocio "+yytext()+" llaveAbre"); return new Symbol(Simbolos.llaveAbre, yycolumn, yyline, yytext()); }
"}"         { System.out.println("Reconocio "+yytext()+" llaveCierra"); return new Symbol(Simbolos.llaveCierra, yycolumn, yyline, yytext()); }
"%"         { System.out.println("Reconocio "+yytext()+" porciento"); return new Symbol(Simbolos.porciento, yycolumn, yyline, yytext()); }
"+"         { System.out.println("Reconocio "+yytext()+" suma"); return new Symbol(Simbolos.suma, yycolumn, yyline, yytext()); }
"?"         { System.out.println("Reconocio "+yytext()+" interrogacion"); return new Symbol(Simbolos.interrogacion, yycolumn, yyline, yytext()); }
","         { System.out.println("Reconocio "+yytext()+" coma"); return new Symbol(Simbolos.coma, yycolumn, yyline, yytext()); }



//----->Palabras Reservadas
"CONJ"  { System.out.println("Reconocio "+yytext()+" Palabra Reservada"); return new Symbol(Simbolos.conjunto, yycolumn, yyline, yytext()); }


  
{digito}    { System.out.println("Reconocio "+yytext()+" digito"); return new Symbol(Simbolos.digito, yycolumn, yyline, yytext()); }
{cadena}    { System.out.println("Reconocio "+yytext()+" cadena"); return new Symbol(Simbolos.cadena, yycolumn, yyline, yytext()); }
{raro}    { System.out.println("Reconocio "+yytext()+" raro"); return new Symbol(Simbolos.raro, yycolumn, yyline, yytext()); }



{id}        { System.out.println("Reconocio "+yytext()+" id"); return new Symbol(Simbolos.id, yycolumn, yyline, yytext()); }
{comentariosimple}      { System.out.println("Reconocio "+yytext()+" comenSimple"); }
{comentariomulti}       { System.out.println("Reconocio "+yytext()+" comenMulti");  }

[ \t\r\n\f]             {/*Espacios en blaco, se ignoran*/}

.                       { System.out.println("Error Lexico"+yytext()+" Linea "+yyline+" Columna "+yycolumn); 
                            error nuevo = new error("Error Sintactico (Recuperado)", yytext(), yyline, yycolumn);
                            Principal.listaErrores.add(nuevo);
                        }