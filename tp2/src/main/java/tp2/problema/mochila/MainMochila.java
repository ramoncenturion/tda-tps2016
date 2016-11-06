package tp2.problema.mochila;

import java.util.List; 

public class MainMochila {
    public static void main(String[] args) {
    	Mochila mochila = new Mochila(5);
    	
    	mochila.agregarItem(2, 3);
    	mochila.agregarItem(3, 4);
    	mochila.agregarItem(4, 5);
    	mochila.agregarItem(5, 6);
  
        System.out.println(mochila.toString()); 
        List<Item> solucion = mochila.resolver(); 
        System.out.println("Solución: " + solucion.toString()); 
    } 
}
