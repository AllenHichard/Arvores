/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerdicionario;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Allen Hichard
 */
public class Celula {
   char atual;//os atributos da celula
   List<Celula> derivada;//os atributos da celulas
   
   // o construtor da celula
    public Celula(char letra) {
        this.atual = letra;//atual recebe letra
        this.derivada = new LinkedList<>();//criar uma lista no formato de 
        //linkedList para fazer a arvore pois esse metodo cabe mais objetos
        // do que o arraylist
    }
    
   // aqui adiciona a letra/carcter na lista derivada formando a arvore prefixada
   public Celula add(char letra){
       Celula atual = new Celula(letra);// criar  celula com o parametro letra
       derivada.add(atual);//coloca atual na lista de derivada
       return atual;
   }
   // um contem parecendo um equals comparando
   //a letra de cada palavra com a lista de derivada
   public boolean contem(char letra){
       for(int i = 0; i < derivada.size(); i++){//um for para pecorre a lista derivada
           char a = derivada.get(i).getAtual();//pegar cada letra da lista e colocar no char de a
           if(a == letra){//compara se tem a letra na lista de derivada se for igual
               return true;//retorna true
           }
       }
       return false;// se nao for igual retorna false
   }
   
    public char getAtual() { //pegar ou retorna atual
        return atual;
    }
    
    
   //Aqui vai ate a proxima celula que esta na lista   
    public Celula proxCelula(char letra){
        for(int i = 0; i < derivada.size(); i++){//um for para pecorre a lista derivada
           char a = derivada.get(i).getAtual();//pegar cada letra da lista e colocar no char de a
           if(a == letra){//compara se tem a letra na lista de derivada se tiver
               return derivada.get(i);//andar para a proxima casa
           }
       }
       return null;//se nao tiver retorna null
    }
   
   
}
