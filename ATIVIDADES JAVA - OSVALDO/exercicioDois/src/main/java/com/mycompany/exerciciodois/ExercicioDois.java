/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exerciciodois;

import java.util.Scanner;

/**
 *
 * @author osvaldo.junior
 */
public class ExercicioDois {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite um valor:");
        int numUm = scanner.nextInt();
        
        System.out.println("Digite o segundo valor:");
        int numDois = scanner.nextInt();
        
        int resultado = numUm + numDois;
        
        System.out.println("O resultado e:" + resultado);
        
        
        
        
        
    }
}
