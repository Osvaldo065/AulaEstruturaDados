/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exercicio3;

import java.util.Scanner;

/**
 *
 * @author osvaldo.junior
 */
public class Exercicio3 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        //Solicitando valor 
        System.out.println("Digite um valor a ser comparado:");
        int valor = scanner.nextInt();
        
        //Condicional para ver se é Par
        if(valor %2 == 0){
            
            System.out.println("O valor e par!!");
        } else{
            System.out.println("O valor e impar!!");
        }
        
        
    }
}
