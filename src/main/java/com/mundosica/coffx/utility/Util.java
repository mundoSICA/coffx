
package com.mundosica.coffx.utility;
import static com.mundosica.coffx.Datasource.TableInfo.propertyClass;
import java.util.*;
/**
 * Clase Util se encarga de utilerias en gral.
 *
 * @since 0.1
 * @author fitorec: Miguel Marcial
 * @author Edwin Snow
 */
public final class Util {
    private Util() {
        // not instantiable
    }
    /**
     * Regresa true si el arreglo esta vacio
     *
     * @since 0.1
     * @param array arreglo a revisar
     * @return true si el arreglo esta vacio, false en otro caso
     */
    public static boolean empty(Object[] array) {
        return array == null || array.length == 0;
    }
    /**
     * Regresa true si una colección esta vacia
     *
     * @since 0.1
     * @param collection colección a revisar
     * @return true si la colección esta vacia, false en otro caso
     */
    public static boolean empty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
    public static boolean empty(String str) {
        return str == null || str.length()== 0;
    }
    /**
     * Joins Une con un delimitador a los elementos de un arreglo un String
     *
     * @since 0.1
     * @param array arreglo a unir
     * @param delimiter delimitador a usar
     * @return str contiene el resultado del join
     */
    public static String join(String[] array, String delimiter) {
        if (empty(array)) {
            return "";
        }
        String str ="";
        str += array[0];
        for (int i = 1; i < array.length; i++) {
            str += delimiter;
            str += array[i];
        }
        return str;
    }
    /**
     * Joins Une con un delimitador a los elementos de un arreglo una colección
     *
     * @since 0.1
     * @param collection colección a unir
     * @param delimiter delimitador a usar
     * @return str contiene el resultado del join
     */
    public static String join(Collection<?> collection, String delimiter) {
        if (empty(collection)) {
            return "";
        }
        Iterator<?> it = collection.iterator();
        String str = "" + it.next();
        while (it.hasNext()) {
            str += delimiter;
            str += it.next();
        }
        return str;
    }

    public static void join(Map map, String delimiter){
        map.forEach((k,v)->System.out.println(k + " : " + v));
    }
    /**
     * Repite un texto de entrada un numero de veces indicadas.
     *
     * @param in texto de entrada a repetir
     * @param count El número de veces que se va a repetir in
     * @return str la cadena resultado.
     */
    public static String repeat(String in, int count) {
        String str = "";
        if (empty(in) || count<0){
            throw new IllegalArgumentException("The count must be zero or greater");
        }
        for (int i = 0; i < count; i++) {
            str += in;
        }
        return str;
    }
    /**
     * Repite un texto de entrada un numero de veces indicadas en un arreglo.
     *
     * @param in texto de entrada a repetir
     * @param count El número de veces que se va a repetir in
     * @return strArray un arreglo con el resultado.
     */
    public static String[] repeatInArray(String in, int count) {
        if (empty(in) || count<1) {
            return new String[0];
        }
        String strArray[] = new String[count];
        for (int i = 0; i < count; i++) {
            strArray[i] = in;
        }
        return strArray;
    }
    /**
     * Repite un str concatenado de un delimitador count veces
     *
     * <p>Ejemplo: <tt>joinAndRepeat("?", ",", 3)</tt> Nos genera <tt>"?,?,?"</tt>
     *
     * @param str El string a repetir
     * @param delimiter El delimitador
     * @param count El numero de veces a repetir
     * @return El String generado.
     */
    public static String joinAndRepeat(String str, String delimiter, int count) {
        if(empty(str) || empty(delimiter)) {
            throw new NullPointerException("str and delimiter cannot be null");
        }
        if(count<1){
            throw new IllegalArgumentException("The count must be greater than 5");
        }
        return repeat(str+delimiter, count -1)+str;
    }

    /**
     * Recibe un arreglo de Strings y devuelve un map, ideal para argumentos
     *
     * @param input arreglo de strings
     * @return un Map de pares ordenados clave, valor
     */
    public static Map<String, String> args(String ...input){
        if (empty(input) || input.length%2 == 1){
            throw new NullPointerException("input cannot be null");
        }
        Map<String, String> map = new HashMap();
        for (int i = 0; i < input.length-1; i++) {
            map.put(input[i], input[i+1]);
        }
        return map;
    }

    /**
     * Funciones echo, imprimen en la salida estandar.
     *
     * @param map
     */
    public static void echo(Map map){
        map.forEach((k,v)->System.out.println(k + " : " + v));
    }
    public static void echo(Collection<?> collection) {
        collection.forEach((v)->System.out.println(v));
    }
    public static void echo(String str) {
        System.out.println(str);
    }
    public static void echo(Object o) {
        System.out.println(o.toString());
    }
    /**
     * Recibe un string del tipo "hola mundo" y devuelve "HolaMundo"
     *
     * @param str El String a Convertir
     * @return el String en formato CamelCase
     */
    public static String camel(String str) {
        if(empty(str)) {
            return "";
        }
        String parts[] = str.replaceAll("_", " ").toLowerCase().split("\\s");
        String out = "";
        for (String part : parts) {
            out += Character.toUpperCase(part.charAt(0)) + part.charAt(0);
        }
        return out;
    }
    /**
     * Recibe un string en formato camelCase y lo devuelve en formato camel_case (underscore)
     *
     * @param str
     * @param delimiter
     * @return
     **/
    public static String under_score(String str) {
        if (str == null || str.length()<1) {
            return "";
        }
        String out = "" + Character.toLowerCase(str.charAt(0));
        for (int i =1; i<str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                out += "_";
                c = Character.toLowerCase(c);
            }
            out += c;
        }
        return out;
    }
    public static String under_score2(String str) {
        if (str == null || str.length()<1) {
            return "";
        }
        String out = Character.toLowerCase(str.charAt(0)) + str.substring(1);
        return out.replaceAll("(.)(\\p{Upper})", "$1_$2").toLowerCase();
    }
    public static void main(String arg[]){
        Map<String, String> as = args(
                "nombre" , "valor"
        );
        echo(as);
        echo(propertyClass("StringProperty"));
        echo(under_score("HolaMundoFeliz"));
        echo(under_score2("HolaMundoFeliz"));
    }
}