package de.telran.hw_2024_08_23.task1;

public class MainInterpreter {
    public static void main(String[] args) {
        Interpreter iRusEng = new InterpreterRusEng("Anna", 23, 'F');
        iRusEng.translate();

        Interpreter iGerRus = new InterpreterGerRus("Sebastian", 44, 'M');
        iGerRus.translate();

        Interpreter iGerEng = new InterpreterGerEng("Brunhilda", 55, 'F');
        iGerEng.translate();

        Interpreter iFraGer = new InterpreterFraGer("Matilda", 32, 'F');
        iFraGer.translate();

        Interpreter iEngFra = new InterpreterEngFra("John", 38, 'M');
        iEngFra.translate();

    }
}
