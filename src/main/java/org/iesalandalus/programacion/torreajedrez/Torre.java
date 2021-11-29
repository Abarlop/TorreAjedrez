package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

public class Torre {

		private Color color;
		private Posicion posicion;
		
		
		
		
		// creamos el constructor de torre negra 
		
		public Torre() {
			setColor(Color.NEGRO);
			setPosicion(new Posicion(8, 'h'));
		}
		
		// crear constructor prar la clase que acepte como parametro el color
		
		public Torre (Color color) {
			setColor(color);
			if(color.equals(color.BLANCO)) {
				setPosicion(new Posicion(1, 'h'));
			} else {
				setPosicion(new Posicion(8, 'h'));
			}
		}
		
		
		//creamos constructor que tenga entrada de color y columna
		
		public Torre(Color color, char columna) {
			setColor(color);
			if(columna=='a'|| columna=='h')
			{
				if(color.equals(color.BLANCO)) {
				setPosicion(new Posicion(1, 'h'));
				} else {
				setPosicion(new Posicion(8, 'h'));
				}
			}else {
				throw new IllegalArgumentException("Error: Debe introducir una columna valida.");
			}
				
		}
		
		
		
		// creacion de los metodos 
		public void mover (Direccion direccion, int avance) throws IllegalArgumentException, OperationNotSupportedException{ // se pueden poner varios para no caer en error (no siendo necesario), si esto no se pone nos dara error las excepciones 
			
			
			if(avance<=0) {
				throw new IllegalArgumentException("Error: El numero ha de ser mayor que cero");
			}else if (direccion==null) {
				throw new NullPointerException("Error: La direccion no puede ser nula");
			}
				switch(direccion) { 
				case DERECHA:
					if (color==Color.NEGRO)
					{
						try {
							setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() -avance)));
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					} else
					{
						try {
							setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() +avance)));
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					}
					break;
				case IZQUIERDA:
					if (color==Color.NEGRO)
					{
						try {
							setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() +avance)));
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					} else
					{
						try {
							setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() -avance)));
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					}
					break;
				case ARRIBA:
					if (color==Color.NEGRO)
					{
						try {
							setPosicion(new Posicion(posicion.getFila() -avance, posicion.getColumna()));
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					} else
					{
						try {
							setPosicion(new Posicion(posicion.getFila() +avance, posicion.getColumna()));
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					}
				break;
				case ABAJO:
					if (color==Color.NEGRO)
					{
						try {
							setPosicion(new Posicion(posicion.getFila() +avance, posicion.getColumna()));
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					} else
					{
						try {
							setPosicion(new Posicion(posicion.getFila() -avance, posicion.getColumna()));
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					}
					break;
				default:
					throw new NullPointerException("Error: La dirección no puede ser nula");
				}
			
		}
		
		
		
		
		
		// Creamos los Getter y Setter [Recuerda que no aparecera la opcion si no guardas primero el archivo]
		
		public Color getColor() {
			return color;
		}
		public void setColor(Color color) {
			if (color == null) {
				throw new NullPointerException ("Error: No puede estar vacio el color"); // Preguntar a Andres como diferencia internamente la maquina o si simplemente asume el error (Plantear mejor la pregunta)
			}
			this.color = color;
		}
		public Posicion getPosicion() {
			return posicion;
		}
		public void setPosicion(Posicion posicion) {
			this.posicion = posicion;
		}
		
		
		
	
}
