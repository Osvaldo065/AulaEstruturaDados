/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exercicio7;

import java.util.Scanner;

/**
 *
 * @author osvaldo.junior
 */
public class Exercicio7 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int listaValores;
        int soma = 0;
        int i, valor;
        
        System.out.println("Digite o número de valores que você vai inserir:");
        listaValores = scanner.nextInt();
        
        // Verificar se o número de valores é maior que zero
        if (listaValores <= 0) {
            System.out.println("O número de valores deve ser maior que zero!");
        } else {
            // Loop para adicionar valores à lista e ir somando
            for (i = 1; i <= listaValores; i++) {
                System.out.println("Digite o " + i + "º valor:");
                valor = scanner.nextInt();
                soma += valor;    
            }
            
            // Calcula o valor da média
            double media = (double) soma / listaValores;
            
            System.out.println("O valor da média da lista é: " + media);
        }
        
        scanner.close();
    }
}
