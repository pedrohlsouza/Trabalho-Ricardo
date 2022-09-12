
package com.mycompany.snaketrab;

import java.util.Scanner;

public class SnakeTrab {

    public static void main(String[] args) {
   
    String [][] tabuleiro = new String [9][9];
    String [] snake = new String [49];
    snake[0] = "C";
    String fruta = "F";
    String andar = "o";
    int [] vetorX = new int [49];
    int [] vetorY = new int [49];
    int [] frutaX = new int [1];
    int [] frutaY = new int [1];
    int corpo = 1;
    
        mapa(tabuleiro);
        snake(snake);
        posicionarCobra(vetorY, vetorX, tabuleiro, snake);
        posicionarFruta(fruta, frutaX, frutaY,tabuleiro);
        andarCobra(snake, corpo, andar, fruta, frutaX, frutaY, tabuleiro, vetorY, vetorX);
        
    }
    
    public static void mapa(String [][] tabuleiro){
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int j = 0; j < 9; j++) {
                System.out.print(" ");
                if( i == 0 || i == 8){
                    System.out.print(tabuleiro [i][j] = "X");
                }else if (j == 0 || j == 8){
                    System.out.print(tabuleiro [i][j] = "X");
                }else{
                    System.out.print(tabuleiro [i][j] = "0");
                }
            }
        }
    }
    
    public static void snake(String [] snake){
        for (int i = 1; i < 49; i++) {
            snake[i] = "Z";
        }
    }
    
    public static void repassarMapa(String [][] tabuleiro){
        for (int i = 0; i < 9; i++) {
            System.out.println("");
            for (int j = 0; j < 9; j++) {
                System.out.print(" ");
                System.out.print(tabuleiro[i][j]);
            }
        }
    }
    
    public static void posicionarCobra(int []vetorY, int [] vetorX, String [][] tabuleiro, String [] snake){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Bem - vindo ao nosso jogo Snake, Por favor insira as cordenadas (1 a 7).");
        System.out.println("Onde Você quer colocar a cobra ?");
        vetorX[0] = sc.nextInt();
        vetorY[0] = sc.nextInt();
        while(vetorX[0] < 1 || vetorX[0] > 7){
            System.out.println("Por favor, as cordenadas é de 1 a 7, insira novamente as Cordenadas do X: ");
            vetorX[0] = sc.nextInt();
        }
        
        while(vetorY[0] < 1 || vetorY[0] > 7){
            System.out.println("Por favor, as cordenadas é de 1 a 7, insira novamente as Cordenadas do Y: ");
            vetorY[0] = sc.nextInt();
        }
        
        tabuleiro[vetorX[0]][vetorY[0]] = snake[0];
        repassarMapa(tabuleiro);
        
        
        
    }
    
    public static void posicionarFruta(String fruta, int [] frutaX, int [] frutaY, String [][] tabuleiro){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Onde Você quer colocar a Fruta ?");
        frutaX[0] = sc.nextInt();
        frutaY[0] = sc.nextInt();
        
        while(frutaX[0] < 1 || frutaX[0] > 7){
            System.out.println("Por favor, as cordenadas é de 1 a 7, insira novamente as Cordenadas do X: ");
            frutaX[0] = sc.nextInt();
        }
        
        while(frutaY[0] < 1 || frutaY[0] > 7){
            System.out.println("Por favor, as cordenadas é de 1 a 7, insira novamente as Cordenadas do Y: ");
            frutaY[0] = sc.nextInt();
        }
        
        tabuleiro[frutaX[0]][frutaY[0]] = fruta;
        repassarMapa(tabuleiro);
    }
    
    public static void andarCobra(String [] snake, int corpo, String andar,String fruta, int [] frutaX, int [] frutaY, String [][] tabuleiro, int []vetorY, int [] vetorX){
        Scanner sc = new Scanner(System.in);
        
        while(vetorX[0] != frutaX[0] || vetorY[0] != frutaY[0] ){
            
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (tabuleiro[i][j].equals("Z")) {
                        tabuleiro[i][j] = "0";
                    }
                }
            }
            
            System.out.println();
            System.out.println(" Insira Para onde Qeur ir (w,a,s,d)");
            andar = sc.nextLine();
                       
           switch(andar){
            
            case "w" -> {
                tabuleiro[vetorX[0]][vetorY[0]] = "0";
                
                for (int i = corpo; i >= 1; i--) {
                    vetorX[i] = vetorX[(i-1)];
                    vetorY[i] = vetorY[(i-1)];
                }
               
                vetorX[0]--;
                tabuleiro[vetorX[0]][vetorY[0]] = snake[0];
                
                for (int i = 1; i < corpo; i++) {
                   tabuleiro[vetorX[i]][vetorY[i]] = snake[i];
                   
                   
                }
                }
            case "s" -> {
                
                tabuleiro[vetorX[0]][vetorY[0]] = "0";
                
                for (int i = corpo; i >= 1; i--) {
                    vetorX[i] = vetorX[(i-1)];
                    vetorY[i] = vetorY[(i-1)];
                }
                
                
                
                vetorX[0]++;
                tabuleiro[vetorX[0]][vetorY[0]] = snake[0];
                for (int i = 1; i < corpo; i++) {
                   tabuleiro[vetorX[i]][vetorY[i]] = snake[i];
                   
                   
                }
                
                }
            case "a" -> {
                tabuleiro[vetorX[0]][vetorY[0]] = "0";
                
                for (int i = corpo; i >= 1; i--) {
                    vetorX[i] = vetorX[(i-1)];
                    vetorY[i] = vetorY[(i-1)];
                }
                vetorY[0]--;
                tabuleiro[vetorX[0]][vetorY[0]] = snake[0];
                
                for (int i = 1; i < corpo; i++) {
                   tabuleiro[vetorX[i]][vetorY[i]] = snake[i];
                   
                   
                }
                }
            case "d" -> {
                tabuleiro[vetorX[0]][vetorY[0]] = "0";
                
                for (int i = corpo; i >= 1; i--) {
                    vetorX[i] = vetorX[(i-1)];
                    vetorY[i] = vetorY[(i-1)];
                }
                vetorY[0]++;
                tabuleiro[vetorX[0]][vetorY[0]] = snake[0];
                
                for (int i = 1; i < corpo; i++) {
                   tabuleiro[vetorX[i]][vetorY[i]] = snake[i];
                   
                   
                }
                }
                
        } 
           repassarMapa(tabuleiro);
           bateuCabeca(vetorX, vetorY);
           bateuCorpo(vetorX, vetorY, tabuleiro);
        } 
        
        comeuFruta(snake, andar, vetorX, vetorY, corpo, fruta, frutaX, frutaY, tabuleiro);
    }
    
    public static void comeuFruta(String [] snake, String andar, int [] vetorX, int [] vetorY,int corpo, String fruta, int [] frutaX, int [] frutaY, String [][] tabuleiro){
        System.out.println();
        System.out.println("Comeu a fruta");
        corpo++;
        
        
        
      
        
        
        posicionarFruta(fruta, frutaX, frutaY,tabuleiro);
        andarCobra(snake, corpo, andar, fruta, frutaX, frutaY, tabuleiro, vetorY, vetorX);
    }
    
    public static void bateuCabeca(int [] vetorX, int [] vetorY){
            if(vetorX[0] == 0 || vetorY[0] == 0 || vetorX[0] == 8 || vetorY[0] == 8 || vetorX[0] == 8 || vetorY[0] == 0 || vetorX[0] == 0 || vetorY[0] == 8 ){
            System.out.println();
            System.out.println();
            System.out.println("Game Over");
            System.out.println("A cobra bateu a cabeça");
            System.exit(0);
        }
    }
    
    public static void bateuCorpo(int [] vetorX, int [] vetorY, String [][] tabuleiro){
        if (tabuleiro[vetorX[0]][vetorY[0]].equals("Z")){
            
            System.out.println();
            System.out.println();
            System.out.println("Game Over");
            System.out.println("A cobra bateu a cabeça no corpo dela");
            System.exit(0);
            
        }
    }
    
    
}
