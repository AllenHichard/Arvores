/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerdicionario;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Allen Hichard
 */
public class arvoreDigital {

    // comentario de linha e de bloco
    
    Celula raiz; // criar a celula raiz
    Lerdicionario ler;//ler dicionario
    BufferedReader leitura;// Ler dicionario
    BufferedReader leTuxto;//ler texto
    List<String> erro;//Lista de String para o erro
    int quantidadeNo = -1;//quantidade de nos na arvores

    /*
    
    */
    public arvoreDigital() throws IOException {//contrutor para  arvore digital
        this.raiz = new Celula(' '); //
        quantidadeNo = 0; //
        ler = new Lerdicionario("texto.txt"); //
        leitura = ler.leitura;                                                                                                    
        leTuxto = ler.leituraTexto;
        this.erro = new LinkedList<>();
    }

    public void carregarArvore() throws IOException {//aqui carrega o dicionario na arvore prefixada 
        Celula no = raiz;//no recebe raiz no tipo celula
        String palavra = leitura.readLine();//pegar a linha
        while (palavra != null) {//saltar linha
            char letras[] = palavra.toCharArray();//quebra a palavra em caracteres ou em letra por letra
            for (int i = 0; i < letras.length; i++) {//contas as letras
                if (no.contem(letras[i])) {//verifica se tem a letra se tever nao inserir 
                    no = no.proxCelula(letras[i]);
                } else {
                    no = no.add(letras[i]);// inserir na arvore
                    quantidadeNo++;
                }
            }
            no = raiz;//o no voltar para a raiz
            palavra = leitura.readLine();//palavra aqui ler a linha
        }
    }

    public void validacao() throws IOException {//
        Celula no = raiz;//no recebe raiz no tipo celula
        String linha = leTuxto.readLine();//pegar a linha
        String palavras[];
        //saltar
        while (linha != null) {//aqui verifica se tem linha e saltar a linha
            palavras = linha.split(" ");// dividir a linha em palavra
            // dividimos a linha em palavras
            for (int j = 0; j < palavras.length; j++) {
                String palavra = palavras[j];// pegar cada palavra da linha 
                //e começa a verificaçao desta palavra
                char letras[] = palavra.toCharArray();//quebra a palavra em caracteres ou em letra por letra
                // analisa caracter por caracter cada palavra para ver se pertense
                for (int i = 0; i < letras.length; i++) {
                    if (no.contem(letras[i])) {// verifica se contem deixando passa 
                        //se for igual ao dicionario
                        no = no.proxCelula(letras[i]);
                    } else {
                        erro.add(palavra);//salvar os erros
                        break;//quebra o fluxo de dados
                    }
                }
                no = raiz;
            }

            linha = leTuxto.readLine();
        }
    }
    
    public int quantidadeNos(){
        return quantidadeNo; //conta a quantidade de nos
    }
//esse metodo mostra o erro do programar
    public void mostrarErro() {
        System.out.println("Visualizar os erros");
        for (int i = 0; i < erro.size(); i++) {//um for para contas os erros do sistema da lista
            System.out.println(erro.get(i).toString());//imprimir o erro gravado na lista de erro do texto
        }
    }
    //

    public static void main(String[] args) throws IOException {
        arvoreDigital arvore = new arvoreDigital();
        arvore.carregarArvore();
        arvore.validacao();
        arvore.mostrarErro();
        System.out.println(arvore.quantidadeNos());
    }

}
