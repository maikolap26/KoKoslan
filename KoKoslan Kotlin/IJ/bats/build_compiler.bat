@echo off
REM compila modelo (parser, value, ast y compilador )
REM javac -cp .;classes;lib;%CLASSPATH%  -d classes src/java/parser/*.java src/java/ast/*.java src/java/eval/*.java  src/java/exception/*.java src/java/compiler/*.java 
javac -cp .;classes;lib;%CLASSPATH%  -d src/kokoslan/parser/*.java
kotlinc -cp .;classes;lib;%CLASSPATH%  -d classes src/kokoslan/ast/*.kt src/kokoslan/eval/*.kt  src/kokoslan/exception/*.kt src/kokoslan/compiler/*.kt 
