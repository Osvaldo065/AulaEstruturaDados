/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.atividadepilha;

/**
 *
 * @author osvaldo.junior
 */
public class AtividadePilha {

    public static void main(String[] args) {
        System.out.println("Testando Pilha");
        
        pilha novaPilha = new pilha();
        
        novaPilha.push(10);
        novaPilha.push(5);
        novaPilha.imprimeTopo();
        novaPilha.pop();
        novaPilha.imprimeTopo();
    }
}
