/*
 * Licencia MIT
 *
 * Copyright (c) 2017 @Fitorec <chanerec at gmail.com>.
 *
 * Se concede permiso, de forma gratuita, a cualquier persona que obtenga una
 * copia de este software y de los archivos de documentación asociados
 * (el "Software"), para utilizar el Software sin restricción, incluyendo sin
 * limitación los derechos a usar, copiar, modificar, fusionar, publicar,
 * distribuir, sublicenciar, y/o vender copias del Software, y a permitir a las
 * personas a las que se les proporcione el Software a hacer lo mismo, sujeto a
 * las siguientes condiciones:
 *
 * El aviso de copyright anterior y este aviso de permiso se incluirán en todas
 * las copias o partes sustanciales del Software.
 *
 * EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO, EXPRESA O
 * IMPLÍCITA, INCLUYENDO PERO NO LIMITADO A GARANTÍAS DE COMERCIALIZACIÓN,
 * IDONEIDAD PARA UN PROPÓSITO PARTICULAR Y NO INFRACCIÓN. EN NINGÚN CASO LOS
 * AUTORES O TITULARES DEL COPYRIGHT SERÁN RESPONSABLES DE NINGUNA RECLAMACIÓN,
 * DAÑOS U OTRAS RESPONSABILIDADES, YA SEA EN UNA ACCIÓN DE CONTRATO, AGRAVIO O
 * CUALQUIER OTRO MOTIVO, QUE SURJA DE O EN CONEXIÓN CON EL SOFTWARE O EL USO U
 * OTRO TIPO DE ACCIONES EN EL SOFTWARE.
 *
 */

package com.mundosica.coffx.Datasource;

import static com.mundosica.coffx.utility.Util.args;
import static com.mundosica.coffx.utility.Util.empty;
import java.util.Map;

/**
 * 
 * @author @Fitorec <chanerec at gmail.com>
 */
public class ColumnMetadata {
	/**
	 * El <b>nombre</b> de la columna
	 */
	private String name;

	/**
	 * El tipo de columna p.e.: varchar, string, int, boolean, text, datetime, etc..
	 */
	private String type;

	/**
	 * El tamaño del dato
	 */
	private int size;

	/**
	 * La posición que tiene en la tabla
	 */
	private int position;

	/**
	 * Información si el campo es escribible
	 */
	public boolean isWrite = true;

        /**
	 * Información si el campo es algún tipo de clave
	 */

	public String key = null;
	/**
	 * Constructor vacio
	 */
	ColumnMetadata() {}

	/**
	 * Constructor
	 * 
	 * @param name el nombre de la columna
	 * @param type el tipo de dato
	 * @param size la longitud del dato
	 * @param position la posiciÃ³n de la columna en la tabla
	 */
	public ColumnMetadata(String name, String type, int size, int position) {
		this.name = name;
		this.type = type;
		this.size = size;
		this.position = position;
	}

	/**
	 * Crea y lo devuelve un ColumnMetadata a partir de params 
	 * 
	 * @param params parametros recibidos por pares nombreParametro, valorParametro.
	 * @return un ColumnMetadata de los parametros
	 */
	static public ColumnMetadata create(String... params) {
            ColumnMetadata c = new ColumnMetadata();
            if (params == null || params.length % 2 == 1) {
		return c;
            }
            args(params).forEach((k,v)->{
                if(empty(k)) {
                    throw new IllegalArgumentException("Los nombre de los atributos no pueden ser null");
                } else {
                    c.set(k, v.toLowerCase());
                }
            });
            /*for (int i = 0; i < params.length - 1; i += 2) {
                    if (params[i] == null) {
                        throw new IllegalArgumentException("Los nombre de los atributos no pueden ser null");
                }
                String atributeName = params[i].toLowerCase();
                String atributeValue = params[i + 1];
                c.set(atributeName, atributeValue);
            }*/
            return c;
	}

    /**
     * {@link ColumnMetadata#name}
     * 
     * @return name el nombre de la columna
     */
	public String name() { return this.name; }

	/**
     * {@link ColumnMetadata#type}
     * 
     * @return type el tipo de dato p.e. varchar, int, text, dateTime, etc...
     */
	public String type() { return this.type; }

	/**
     * {@link ColumnMetadata#size}
     * 
     * @return size la longitud del tipo de dato, p.e. para varchar(50) el valor es 50
     */
	public int size() { return this.size; }

	/**
     * {@link ColumnMetadata#position}
     * 
     * @return position la posicion de la columna en el esquema de la tabla
     */
	public int position() { return this.position; }

	public String toString() {
		return this.position() + " .- " + this.name() + " "
			+ this.type() + " (" + this.size() + ")";
	}

	/**
	 * Setea los atributos de un field.
	 * 
	 * @param nombre correspondiente al atributo de columna(name, type, position, isWrite)
	 * @param valor correspondiente a setear
	 * @return success, true si lo pudo setear, false en caso contrario
	 */
	public boolean set(String nombre, String valor) {
        if (nombre == null || valor == null) {
        	return false;
        }
        switch(nombre) {
	        case "name":
	        	this.name = valor;
	        	break;
	        case "type":
	        	this.type = valor;
	        	break;
	        case "size":
	        	this.size = Integer.parseInt(valor);
	        	break;
	        case "position":
	        	this.position = Integer.parseInt(valor);
	        	break;
	        case "isWrite":
	        	this.isWrite = new Boolean(valor);
	        	break;
	        default:
	        	return false;
        }
        return true;
	}
}
