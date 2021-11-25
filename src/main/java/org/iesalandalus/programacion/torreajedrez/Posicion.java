package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Posicion {
	
	private int fila;
	private char columna;
	
	
	// para evitar que si pone mayusculas tengamos que hacer mas comprobaciones lo pasamos para nosotros en minusculas todo directamente
	// asi solo tendremos que comprobarlo una vez 
	private char minuscula = Character.toLowerCase(columna);
	
    private int MAXIMO=8;
    private int MINIMO=1;
	
    //generamos el constructor:
    public Posicion (int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}
    
    
    // constructor copia 
    
    public Posicion (Posicion e)
    {
    	if (e==null) {
    		throw new NullPointerException("Error: No se admiten valores nulos");
    	}
    }
    
    

	// Generamos los Getters y Setters
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		if (fila<MINIMO || fila> MAXIMO) {
			
			//si la fila esta mal marcaremos el error con el argumento 
			throw new IllegalArgumentException("Error: La fila es eronea");
		}else 
		
			this.fila = fila;
	}
	public char getColumna() {
		return columna;
	}
	public void setColumna(char columna) {
		// comprobamos que se metan correctamente los datos
		if (minuscula!='a' && minuscula!='b' && minuscula!='c' && minuscula!='d' && minuscula!='e' && minuscula!='f' && minuscula!='g' && minuscula!='h') {
			throw new IllegalArgumentException("Error: La columna no es valida");
		}
		this.columna = columna;
	}
}
	
	
	
	
	

