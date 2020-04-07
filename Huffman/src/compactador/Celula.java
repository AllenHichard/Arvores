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
public class Celula implements Comparable{
    private Celula esquerda;
    private Celula direita;
    private Letra dentro;

    public Celula(Celula esquerda, Celula direita, Letra dentro) {
        this.esquerda = esquerda;
        this.direita = direita;
        this.dentro = dentro;
    }

    public Letra getDentro() {
        return dentro;
    }

    public void setDentro(Letra dentro) {
        this.dentro = dentro;
    }

    public Celula getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Celula esquerda) {
        this.esquerda = esquerda;
    }

    public Celula getDireita() {
        return direita;
    }

    public void setDireita(Celula direita) {
        this.direita = direita;
    }

    @Override
    public int compareTo(Object o) {
        Celula a = (Celula) o;
        if(dentro.qtd == a.dentro.qtd){
            return 0;
        } else if(dentro.qtd > a.dentro.qtd){
            return 1;
        } else {
            return -1;
        }
    }
 
     public String toString(){
        return "Letra " + dentro.getLetra() + " quantidade " + dentro.qtd;
    }
}
