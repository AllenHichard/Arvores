/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compactador;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Allen Hichard
 */
public class Compactador {

    private String textoCarregado ="";
    private ArrayList lista = new ArrayList();
    private Celula raiz;
    private ArrayList<LetraCod> tabelaCodificacao = new ArrayList<>();

    public void huffman() throws FileNotFoundException, IOException {
        int vetor[] = new int[256];
        BufferedReader arquivo = abrirArquivo();
        String linha = arquivo.readLine();
        while (linha != null) {
            textoCarregado += linha;
            for (int i = 0; i < linha.length(); i++) {
                vetor[(int) linha.charAt(i)]++;
            }
            linha = arquivo.readLine();
        }
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != 0) {
                Letra caracter = new Letra(vetor[i], ((char) i) + "");
                lista.add(new Celula(null, null, caracter));
            }
        }
        Collections.sort(lista);
        if (!lista.isEmpty()) {
            construirArvore();
        }

        this.raiz = (Celula) lista.get(0);
        preordem(raiz, "");
        // fazer a conversão
        System.out.println(textoCarregado);
        for (int i = 0; i < tabelaCodificacao.size(); i++) {
            System.out.println(tabelaCodificacao.get(i).toString());
        }
        System.out.println("Mudar as letras pelo seu codigo binario");

    }

    public void preordem(Celula no, String cod) {
        if (no.getEsquerda() == null) {
            LetraCod lcod = new LetraCod(no.getDentro().getLetra(), cod);
            tabelaCodificacao.add(lcod);
            return;
        }
        preordem(no.getEsquerda(), cod + "0");
        preordem(no.getDireita(), cod + "1");
    }

    public void construirArvore() {
        while (lista.size() > 1) {
            Celula a1 = (Celula) lista.remove(0);
            Celula a2 = (Celula) lista.remove(0);
            String juncao = a1.getDentro().getLetra() + a2.getDentro().getLetra();
            int soma = a1.getDentro().getQtd() + a2.getDentro().getQtd();
            Letra l = new Letra(soma, juncao);
            Celula nova = new Celula(a1, a2, l);
            lista.add(nova);
            Collections.sort(lista);

        }
    }

    public BufferedReader abrirArquivo() throws FileNotFoundException {
        File arquivo = new File("compactar.txt");
        if (arquivo.exists()) {
            FileReader compactar = new FileReader(arquivo);
            BufferedReader permanenciadados = new BufferedReader(compactar);
            return permanenciadados;

        }
        return null;
    }
    
    public void compactar(){
        for(int i = 0; i < textoCarregado.length() ; i++){
            
        }
    
    }

    public static void main(String[] args) throws IOException {
        Compactador comp = new Compactador();
        comp.huffman();
    }

}
/*
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
 */
 /*
        for (int i = 0; i < tabelaCodificacao.size(); i++) {
            System.out.println(tabelaCodificacao.get(i).toString());
        }
*/
