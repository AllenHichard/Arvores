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
public class LetraCod {
    
    String letra;
    String Cod;

    

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getCod() {
        return Cod;
    }

    public void setCod(String Cod) {
        this.Cod = Cod;
    }

    public LetraCod(String letra, String Cod) {
        this.letra = letra;
        this.Cod = Cod;
    }
    
    @Override
    public String toString(){
        return "Letra " + letra + " quantidade " + Cod;
    }
    
}
