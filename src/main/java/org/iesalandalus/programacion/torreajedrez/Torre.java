package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

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
		public void mover (Direccion direccion, int movimiento) throws IllegalArgumentException, OperationNotSupportedException{ // se pueden poner varios para no caer en error (no siendo necesario), si esto no se pone nos dara error las excepciones 
			
			
			if(movimiento<=0) {
				throw new IllegalArgumentException("Error: El numero ha de ser mayor que cero");
			}else if (direccion==null) {
				throw new NullPointerException("Error: La direccion no puede ser nula");
			}
				switch(direccion) { 
				case DERECHA:
					if (color==Color.NEGRO)
					{
						try {
							setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() -movimiento))); // si no pones el tipo de la columna da error!
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					} else
					{
						try {
							setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() +movimiento)));
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					}
					break;
				case IZQUIERDA:
					if (color==Color.NEGRO)
					{
						try {
							setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() +movimiento)));
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					} else
					{
						try {
							setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() -movimiento)));
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					}
					break;
				case ARRIBA:
					if (color==Color.NEGRO)
					{
						try {
							setPosicion(new Posicion(posicion.getFila() -movimiento, posicion.getColumna()));
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					} else
					{
						try {
							setPosicion(new Posicion(posicion.getFila() +movimiento, posicion.getColumna()));
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					}
				break;
				case ABAJO:
					if (color==Color.NEGRO)
					{
						try {
							setPosicion(new Posicion(posicion.getFila() +movimiento, posicion.getColumna()));
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					} else
					{
						try {
							setPosicion(new Posicion(posicion.getFila() -movimiento, posicion.getColumna()));
						} catch (IllegalArgumentException e) {
							throw new OperationNotSupportedException("Error: No te puedes salir del tablero");
						}
					}
					break;
				default:
					throw new NullPointerException("Error: La direcci�n no puede ser nula");
				}
			
		}
		
		
		//crear enroque,[ preguntar a Andres, si seria creando dos objetos y sobreponiendo o no la posicion el uno del otro o si han de moverse simplemente, o si se pueden amabos casos ]
		
		
		
		
		
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
		
		// creacion del metodo has y equals

		@Override
		public int hashCode() {
			return Objects.hash(color, posicion);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Torre other = (Torre) obj;
			return color == other.color && Objects.equals(posicion, other.posicion);
		}
		
		//creamos el string

		@Override
		public String toString() {
			return "Torre [color=" + color + ", posicion=" + posicion + "]";
		}
		
		
		
	
}
