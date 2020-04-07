/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerdicionario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Allen Hichard
 */
public class Lerdicionario {
    
    
  BufferedReader leitura;//atributos buffer 
  BufferedReader leituraTexto;//atributos buffer 
  public Lerdicionario(String nome) throws FileNotFoundException, IOException{
      FileReader lerDicionario = new FileReader("portuguese");// ler dicionario
      leitura = new BufferedReader(lerDicionario);//criar um buffer para o dicionario
      lerDicionario = new FileReader(nome);// ler o caminho de onde vem o texto
      leituraTexto = new BufferedReader(lerDicionario);// criar um buffer para o 
      //caminho de onde vem o texto
  }
    
  
   
    
}
