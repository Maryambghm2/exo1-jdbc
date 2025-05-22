package org.example;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        // String name = FigletFont.convertOneLine("Amy");
        String name = "";
        try {
           //  name = FigletFont.convertOneLine("/$é♫");
            name = FigletFont.convertOneLine("Maryam");
        } catch (IOException e) {
            System.out.println("Impossible de transformer en ASCII");
        }
        System.out.println(name);


    }
}