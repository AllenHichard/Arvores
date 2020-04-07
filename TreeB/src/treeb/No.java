/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */
package treeb;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Allen Hichard
 */
public class No {
     
    private List elemento;
    private No pai;
    private List filhos;
    private boolean isFolha;
    private int qtdElementos;
   
   
    public No(int ordem){
        this.elemento = new ArrayList<Integer>(ordem - 1);
        this.filhos = new ArrayList <No>(ordem);
        this.isFolha = true;
    }
    
    public void inicializar(int ordem){
        for(int i = 0; i<ordem-1 ; i++){
            elemento.add(null);
        }
        for(int i = 0; i<ordem ; i++){
            filhos.add(null);
        }
    }

    /**
     * @return the elemento
     */
    public List getElemento() {
        return elemento;
    }

    /**
     * @param elemento the elemento to set
     */
    public void setElemento(List elemento) {
        this.elemento = elemento;
    }

    /**
     * @return the filhos
     */
    public List getFilhos() {
        return filhos;
    }

    /**
     * @param filhos the filhos to set
     */
    public void setFilhos(List filhos) {
        this.filhos = filhos;
    }

    /**
     * @return the isFolha
     */
    public boolean isIsFolha() {
        return isFolha;
    }

    /**
     * @param isFolha the isFolha to set
     */
    public void setIsFolha(boolean isFolha) {
        this.isFolha = isFolha;
    }

    /**
     * @return the qtdElementos
     */
    public int getQtdElementos() {
        return qtdElementos;
    }

    /**
     * @param qtdElementos the qtdElementos to set
     */
    public void setQtdElementos(int qtdElementos) {
        this.qtdElementos = qtdElementos;
    }

    /**
     * @return the pai
     */
    public No getPai() {
        return pai;
    }

    /**
     * @param pai the pai to set
     */
    public void setPai(No pai) {
        this.pai = pai;
    }
    
 
    public static void main(String[] args) {
        List a = new ArrayList();
        a.add(0, 1);
        a.add(0, 2);
        
       
    }
}
