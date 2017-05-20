/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mundosica.coffx.utility.L18n;

import static com.mundosica.coffx.utility.Util.*;

/**
 *
 * @author Inspiron I5558
 */
public class EsLanguage implements Language {
    public EsLanguage () {
        Inflector.addIrregular("user", "users");
    }

    public  String singular(String pluralWord) {
	String singularWord = pluralWord
            //Las palabras que terminan en -Z, cambian a –CES
            .replaceAll("ces$", "z")
            .replaceAll("es$", "");
	return singularWord.replaceAll("s$", "");
    }

    public  String plural(String singularWord) {
        String pluralWord =  singularWord
        //Las palabras que terminan en -Z, cambian a –CES
        .replaceAll("z$", "ce")
        //Las palabras que terminan en x,s y son Agudas 
        .replaceAll("([áéíóú])([xs])$", "\1se")
        // Si termina en r,l,n,d se agrega una e p.e. edad, edade
        .replaceAll("([rlnd])$", "\1e");
        // Si acaba en t,j,a,e,i..., se agrega una s al final
        if (pluralWord.matches(".*[jtaeiou]$")) {
            return pluralWord + "s";
        }
        return pluralWord;
    }
}
