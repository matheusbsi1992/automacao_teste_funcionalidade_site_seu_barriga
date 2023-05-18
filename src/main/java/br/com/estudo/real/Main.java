package br.com.estudo.real;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println("A{123456".matches("(?=.*[}{,.^?~=+\\-_\\/*\\-+.\\|])(?=.*[a-zA-Z])(?=.*[0-9]).{8,}")); //exemplo que passa
        System.out.println("ASD1ASDA".matches("(?=.*[}{,.^?~=+\\-_\\/*\\-+.\\|])(?=.*[a-zA-Z])(?=.*[0-9]).{8,}")); //exemplo que nao passa (falta caractere especial)
        System.out.println("ASDAS^^?".matches("(?=.*[}{,.^?~=+\\-_\\/*\\-+.\\|])(?=.*[a-zA-Z])(?=.*[0-9]).{8,}")); //exemplo que nao passa (falta numero)
        System.out.println("123^8542".matches("(?=.*[}{,.^?~=+\\-_\\/*\\-+.\\|])(?=.*[a-zA-Z])(?=.*[0-9]).{8,}")); //exemplo que nao passa (falta letra)
        System.out.println("WWEA^^1".matches("(?=.*[}{,.^?~=+\\-_\\/*\\-+.\\|])(?=.*[a-zA-Z])(?=.*[0-9]).{8,}")); //exemplo que nao passa (nao tem minimo de 8 caracteres)
    }
}