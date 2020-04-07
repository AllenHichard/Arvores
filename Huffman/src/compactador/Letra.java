/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compactador;

/**
 *
 * @author Allen Hichard
 */
public class Letra {

    public int qtd;
    public String letra;

    public Letra(int qtd, String letra) {
        this.qtd = qtd;
        this.letra = letra;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

   
    public String toString(){
        return "Letra " + letra + " quantidade " + qtd;
    }

    

}
