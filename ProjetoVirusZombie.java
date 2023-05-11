/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetoviruszombie;

public class ProjetoVirusZombie {
    //public static final String ANSI_RESET = "\u001B[0m";
    //public static final String ANSI_RED = "\u001B[31m";
    //public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static void main(String[] args) {
        //System.out.println(ANSI_RED + ANSI_GREEN_BACKGROUND);
        //System.out.println(ANSI_GREEN_BACKGROUND + "Outro texto");
    //}
    Mundo m = new Mundo();
    while(true){
        m.desenhaMundo();
        m.atualizaMundo();
        try {
            Thread.sleep(300);
        } catch(Exception e){
             e.printStackTrace();
        }
    }
}
}
