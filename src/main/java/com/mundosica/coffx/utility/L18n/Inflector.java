/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mundosica.coffx.utility.L18n;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

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
    private static Map<String, String> irregularWords = new HashMap();

    public static boolean checkLoadLanguaje() {
        if (lang != null) {
            return true;
        }
        try {
            String className = "Es" + "Language";
            lang = (Language) Class.forName("com.mundosica.coffx.utility.L18n." + className).newInstance();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String toSingular(String plural) {
        if (!checkLoadLanguaje()) {
            return plural;
        }
        /////////////////////
        for (Entry<String, String> entry : irregularWords.entrySet()) {
            if (plural.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return lang.singular(plural);
    }
 
    public static String toPlural(String singular) {
        if (!checkLoadLanguaje()) {
            return singular;
        }
        String plural = irregularWords.get(singular);
        if (plural == null) {
            plural = lang.plural(singular);
        }
        return plural;
    }
   
    /**
     * Agrega un plural para el cual su conversión a singular es irregular
     * 
     * @param pluralKey
     * @param SingularValue 
     */
    public static void addIrregular(String singular, String plural) {
        irregularWords.put(singular, plural);
    }
}
