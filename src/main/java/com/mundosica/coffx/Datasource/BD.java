package com.mundosica.coffx.Datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.mundosica.coffx.utility.Util.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fitorec: Miguel Angel
 */
public class BD {
 /**
 * El <b>host</b> de la conexión
 */
	private static String host = "localhost";

/**
 * El <b>puerto</b> en el que se establece la conexión
 */
	public static String port = "3306";

/**
 * El nombre de la base de datos
 */
	private static String bd   = null;

/**
 * El nombre del <b>usuario</b> para la conexión
 */
	private static String user = null;

/**
 * El <b>password</b> del usuario
 */
	private static String password = null;

/**
 * La conexión.
 */
	private static Connection conection;
/**
 * 
 */
    private static HashMap<String, TableMetadata> tables = new HashMap<String, TableMetadata>();

/**
 *  Almacena los metadatos de las tablas
 */

/**
 * Setea una variable de configuración
 *
 * @param namesAndValues el campo de configuración
 * @return el valor final de campo
 */
    public static String config(String... namesAndValues) {
        if (empty(namesAndValues)) {
            return null;
        }
        if (namesAndValues.length == 1) {
            return configVal(namesAndValues[0]);
        }
        args(namesAndValues).forEach((k,v) -> BD.setConfig(k,v));
        return join(namesAndValues, ",");
    }

/**
 * Devuelve la variable de configuración con el nombre campo
 *
 * @param fieldName el nombre del campo
 * @return El valor del campo en caso de ser null devuelve un valor por defecto
 */
	private static String configVal(String fieldName) {
		switch (fieldName.toLowerCase()) {
			case "host":
				return BD.host;
			case "port":
				return BD.port;
			case "bd":
				return BD.bd;
			case "user":
				return BD.user;
			case "password":
				return BD.password;
			default:
				echo("Campo incorrecto de configuración : " + fieldName);
				return fieldName;
		}
	}

/**
 * Change the config to fieldName and value
 * @param fieldName
 * @param value
 * @return 
 */
	private static String setConfig(String fieldName, String value) {
		switch (fieldName.toLowerCase()) {
			case "host":
				BD.host = value;
				break;
			case "port":
				BD.port = value;
				break;
			case "bd":
				BD.bd = value;
				break;
			case "user":
				BD.user = value;
				break;
			case "password":
				BD.password = value;
		}
		return BD.configVal(fieldName);
	}

/**
 * Inicializa la conexión en caso que se encuentre cerrada
 *
 */
	public static boolean initBD() {
		if (BD.conection == null ) {
			try {
                            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                            BD.conection = DriverManager.getConnection (
				BD.url(),
				user,
				password
                            );
                            return true;
			} catch (Exception e) {
				echo("No se pudo conectar revise sus permisos, estado de la conexión: ");
				echo(BD.status());
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

/**
 * Regresa la URL para la conexión
 * 
 * Se a agregado campos para el TomeZone, ya que hay un bug en el driver de mySQL,
 * para mayor información consultar la URL:
 * 
 * @url https://bugs.mysql.com/bug.php?id=79343
 **/
	public static String url() {
            return "jdbc:mysql://" + BD.host + ":" + BD.port + "/" + BD.bd +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            /*return "jdbc:mysql://" + BD.host + ":" + BD.port + "/" + BD.bd
                + "?user=" + BD.user + "&password=" + BD.password;*/
	}

/**
 * Regresa el conexión.
 *
 * @return la conexión
 */
	public static Connection conection() {
		BD.initBD();
		return BD.conection;
	}

/**
 * Regresa un String que nos muestra el objeto BD
 * y el estado de la conexión que maneja
 *
 * @return status un string que contiene el edo de la conexión
 */
    public static String status() {
	String out =
            "host     : " + BD.config("host") +  "\n" +
            "port     : " + BD.config("port") +  "\n" +
            "Password : " + BD.config("password").replaceAll(".", "*") +  "\n" +
            "user     : " + BD.config("user") +  "\n" +
            "bd	  : " + BD.config("bd") +  "\n" +
            "URL      : " + BD.url()  +  "\n\n";
            if (BD.conection != null ) {
		out += "Conexión abierta";
            } else {
		out += "Conexión cerrada";
            }
            return out;
    }

/**
 * Cierra la conexión en la base de datos
 *
 **/
	public static void end() {
            if (BD.conection != null ) {
		try {
			BD.conection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
            }
	}

/**
 * Devuelve la meta información de una tabla.
 * 
 * @param tableName
 * @return 
 */
    public static TableMetadata getTable(String tableName) {
        if (!tables.containsKey(tableName)) {
            addTable(tableName);
        }
        return tables.get(tableName);
    }
/**
 * Agrega una nueva columna, si esta no existe.
 * 
 * @param column
 * @return 
 */
    public static boolean addTable(String tableName) {
        if (tables.containsKey(tableName)) {
            return false;
        }
        //tables.put(column.name(), column);
        return true;
    }
}