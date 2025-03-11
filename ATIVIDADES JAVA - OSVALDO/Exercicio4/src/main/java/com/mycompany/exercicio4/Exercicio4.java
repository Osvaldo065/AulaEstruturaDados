/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exercicio4;

import java.util.Scanner;

/**
 *
 * @author osvaldo.junior
 */
public class Exercicio4 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o valor do raio:");
        int raio = scanner.nextInt();
        
        int area = (int) (3.14*Math.pow(raio, 2));
        
        System.out.println("O valor da area e:" + area);
        
        
        
    }
}
