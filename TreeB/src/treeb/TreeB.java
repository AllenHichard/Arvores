/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Allen Hichard
 */
public class TreeB {
     
    private int filhos;
    private int elementos;
    private No raiz;
    private int posicaoInsere;
            
    public TreeB(int ordem){
        this.elementos = ordem - 1;
        this.filhos = ordem;
        this.raiz = new No(ordem);
    }
    public void inserir(int valor){
        this.insert(raiz, valor); 
    }
    public void insert (No atual, int valor){
        if(atual.isIsFolha() && atual.getElemento().size() < this.elementos){
           atual.getElemento().add(valor);
            
           Collections.sort(atual.getElemento());
        }
        
        else if(atual.getElemento().size() == this.elementos && atual.isIsFolha()){
            
            promover(atual, valor, posicaoInsere);
            
        }
        else if(!atual.isIsFolha()){
            posicaoInsere = buscar(atual, valor);
      
            atual = (No) atual.getFilhos().get(posicaoInsere);
            insert(atual, valor);
        }
        
        
        
        
    
    }
    
    public void promover(No atual, int valor, int posicao){
        
        No filho1 = new No(filhos);
        No filho2 = new No(filhos);
        No pai = atual.getPai();
        List aux = new ArrayList();
        aux.addAll(atual.getElemento());
        aux.add(valor);
        Collections.sort(aux);
        int centro = elementos/2;
        if(pai == null){
            
            pai = new No(filhos);
            
        }
        filho1.setPai(pai);
        filho2.setPai(pai);
        
        
       
        for(int i = 0; i < centro; i++){
            filho1.getElemento().add(aux.get(i));
            
        }
        for(int i = centro + 1; i < elementos + 1; i++){
            filho2.getElemento().add(aux.get(i));
            
        }
        
        //System.out.println(pai.getElemento().toString());
        //System.out.println(filho1.getElemento().toString());
        //System.out.println(filho2.getElemento().toString());
        
        
         
        
        pai.setIsFolha(false);
        if(posicao == 0){
            pai.getFilhos().add(posicao, filho1);
            pai.getFilhos().add(posicao+1, filho2);
        } else {
            pai.getFilhos().set(posicao, filho1);
            pai.getFilhos().add(posicao+1, filho2);
        }
       
        
        if(atual.getFilhos().size() > 0){
            System.out.println("uma vez");
            for(int i = 0; i < centro+1; i++){
                
                filho1.getFilhos().add(atual.getFilhos().get(i));
                ((No)atual.getFilhos().get(i)).setPai(filho1);
                filho1.setIsFolha(false);
            
            }
            for(int i = centro+1; i < filhos + 1; i++){
                
            filho2.getFilhos().add(atual.getFilhos().get(i));
            ((No)atual.getFilhos().get(i)).setPai(filho2);
            filho2.setIsFolha(false);
            
            }
        }
        
        if(valor == 30){
            System.out.println(raiz.getElemento().toString());
        }
       
        if(pai.getElemento().size() == elementos){
            promover(pai, (int)aux.get(centro), 0);  
             
        
            
        }else{
             
            pai.getElemento().add(aux.get(centro));
            Collections.sort(pai.getElemento());
        
            if(pai.getPai() == null){
                this.raiz = pai;
            }
        }
        
        
        /*
        if(valor == 30){
            System.out.println("aqui");
            System.out.println(pai.getElemento().toString());
            System.out.println(filho1.getElemento().toString());
            System.out.println(filho2.getElemento().toString());
        }
       */
        
        
       
        
    }
    
    public int buscar(No atual, int valor){
        int temp = 0;
        for(int i = 0; i<atual.getElemento().size(); i++){
            if((int)atual.getElemento().get(i) < valor){
                temp++;
            }
        }
        return temp;
        
    }
    public No getRaiz(){
        return this.raiz;
    }
    
            
            
    public static void main(String[] args) {
        TreeB b = new TreeB(5);
        b.inserir(2);
        b.inserir(3);
        b.inserir(1);
        b.inserir(6);
        b.inserir(5);
        b.inserir(0);
        b.inserir(8);
        b.inserir(9);
        b.inserir(10);
        b.inserir(5);
        b.inserir(6);
        b.inserir(7);
        b.inserir(11);
        b.inserir(12);
        b.inserir(13);
        b.inserir(9);
        b.inserir(13);
        b.inserir(14);
        b.inserir(15);
        b.inserir(5);
         b.inserir(5);
         b.inserir(65);
         b.inserir(40);
         b.inserir(30);
        
        
       
        
        
        
        
        System.out.println(b.getRaiz().getElemento().toString());
        No a = (No)b.getRaiz().getFilhos().get(0);
        No c = (No)b.getRaiz().getFilhos().get(1);
        System.out.println(a.getElemento().toString());
        System.out.println(c.getElemento().toString());

        No d = (No)b.getRaiz().getFilhos().get(0);
        No de = (No) d.getFilhos().get(0);
        System.out.println(de.getElemento().toString());
        
        No e = (No)b.getRaiz().getFilhos().get(0);
        No ee = (No) d.getFilhos().get(1);
        System.out.println(ee.getElemento().toString());
        
        No f = (No)b.getRaiz().getFilhos().get(0);
        No fe = (No) d.getFilhos().get(2);
        System.out.println(fe.getElemento().toString());
        
        d = (No)b.getRaiz().getFilhos().get(1);
        de = (No) d.getFilhos().get(0);
        System.out.println(de.getElemento().toString());
        
        e = (No)b.getRaiz().getFilhos().get(1);
        ee = (No) d.getFilhos().get(1);
        System.out.println(ee.getElemento().toString());
        
        f = (No)b.getRaiz().getFilhos().get(1);
        fe = (No) d.getFilhos().get(2);
        System.out.println(fe.getElemento().toString());
        
        
      
        
         
    }
    
    
}
