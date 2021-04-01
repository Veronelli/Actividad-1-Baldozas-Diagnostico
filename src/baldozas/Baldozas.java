/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baldozas;

import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author facu
 */
public class Baldozas {
    
    public static char[] colores = {'a','v','r'};
    public static int[] puntos = {0,0,0};
    
    public static PrintStream console = new PrintStream(System.out);
    public static Scanner terminal = new Scanner(System.in);
    
    public static void main(String[] args) {
        String baldozas;
        
        int longitud;
        int baldozaPintada = -1;
                
        int divicion;
        
        do{
            console.println("Ingrese las baldozas: ");
            baldozas = terminal.next();
            longitud = baldozas.length();
            baldozaPintada = buscarBaldoza(baldozas, longitud);
        
        
        }while(longitud%3 != 0 && baldozaPintada != -1); 
        
        divicion = getDivicion(longitud, baldozaPintada);
        
        //Muestra los resultados
        console.println("------Resultado:------");
        console.println("Cantidad de baldozas " + longitud);
        console.println("Nro. de diviciones " + longitud/3);
        console.println("Ubicacion de la divicion " + divicion);
        
        console.println("Baldoza pintada " + (baldozaPintada+1));
        console.println("Antes:       || " + baldozas);
        baldozas = pintarBaldozas(baldozas,longitud,baldozaPintada);
        console.println("Resultado:   || "+ baldozas);
        
    }
    
    public static int buscarBaldoza(String baldozas, int longitud){
        int posicion = 0;
        int n_colores = colores.length;
        char letra;
        
        for(int index = 0; index < longitud; index++){
            letra = baldozas.toLowerCase().charAt(index);
            
            for(int index_aux = 0; index_aux < n_colores; index_aux++){
                if(letra == colores[index_aux]){
                 console.println("Color: " + letra);
                 posicion = index;
                 index = longitud;
                 index_aux = n_colores;
                    
                }                
            }            
        }
        return posicion;
        
    }
    
    public static String pintarBaldozas(String baldozas, int longitud, int baldozaPintada){       
        int baldoza_tres =  ((baldozaPintada - (getDivicion(longitud,baldozaPintada)*3))+3);
        
        char letra = baldozas.toLowerCase().charAt(baldozaPintada);
        char[] baldozasFaltantes = buscarColoresFaltantes(baldozas,baldozaPintada);
        char[] baldozas_ordenadas = new char[3];
        
        int index1 = 0;
        String tres_baldozas;
        String baldozas_pintadas = "";
        
        baldozas_ordenadas[baldoza_tres] = letra;
        
        for(int i = 0; i < baldozasFaltantes.length; i++){
            if(i != baldoza_tres){
                baldozas_ordenadas[i] = baldozasFaltantes[index1];
                index1++;
                
            }            
        }
        
        tres_baldozas = String.valueOf(baldozas_ordenadas);
        
        for(int i = 0; i < longitud/3; i++){
            baldozas_pintadas += tres_baldozas;
            
        }
        return baldozas_pintadas;
    }
    
    public static char[] buscarColoresFaltantes(String baldozas, int baldozaPintada){
        char[] array = new char[3];
        char color = baldozas.toLowerCase().charAt(baldozaPintada);
        int index1 = 0;
        
        for(int index = 0; index < colores.length; index++){
            if(color != colores[index]){
               array[index1] = colores[index];
               index1++;
                
            }
        }
        return array;
        
    }
    
    public static int getDivicion(int longitud, int baldozaPintada){
        for(int i = 0; i <= longitud/3; i++){
            if(i*3 > baldozaPintada){
                return i;
                
            }            
        }
        return -1;
        
    }
    
    public static int scanearBaldozaMultiploTres(int longitud, int baldozaPintada){
        for(int index = 0; index <= longitud/3; index++){
            
            if(index*3 > baldozaPintada){
                return ((baldozaPintada - (index*3))+3);
                
            }            
            
        }
        return -1;
    }
}
