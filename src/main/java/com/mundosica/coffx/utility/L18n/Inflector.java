/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mundosica.coffx.utility.L18n;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 *
 * @author Inspiron I5558
 */
public class Inflector {
    private static Language lang;
    /**
     * Contiene una lista de palabras irregulares en plural de la forma:
     *  pluralkey, singularValue
     */
    private static Map<String, String> pluralIrregular = new HashMap();
    /**
     * Contiene una lista de palabras irregulares en singular de la forma:
     *  Singularkey, pluralValue
     */
    private static Map<String, String> singularIrregular = new HashMap();

    public static boolean checkLoadLanguaje() {
        if (lang != null) {
            return true;
        }
        try {
            String className = "Es" + "Language";
            lang = (Language) Class.forName(className).newInstance();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String singular(String str) {
        if (!checkLoadLanguaje()) {
            return str;
        }
        return lang.singular(str);
    }
 
    public static String plural(String str) {
        if (!checkLoadLanguaje()) {
            return str;
        }
        return lang.plural(str);
    }
   
    /**
     * Agrega un plural para el cual su conversión a singular es irregular
     * 
     * @param pluralKey
     * @param SingularValue 
     */
    public static void addIregularPlural(String pluralKey, String SingularValue) {
        pluralIrregular.put(pluralKey, SingularValue);
    }
    /**
     * Devuelve el valor de un plural en forma singular si este existe
     * en el map de irregular
     * 
     * @param pluralKey
     * @return El singular en irregular, null si no existe
     */
    public static String iregularPlural(String pluralKey) {
        return pluralIrregular.get(pluralKey);
    }
     /**
     * Agrega un singular para el cual su conversión a plural es irregular
     * 
     */
    public static void addIregularSingular(String singularKey, String pluralValue) {
        singularIrregular.put(singularKey, pluralValue);
    }
    /**
     * Devuelve el valor de un singular en forma plural si este existe
     * en el map de irregular
     * 
     * @param singularKey
     * @return El singular en irregular, null si no existe
     */
    public static String iregularSingular(String singularKey) {
        return singularIrregular.get(singularKey);
    }
}
