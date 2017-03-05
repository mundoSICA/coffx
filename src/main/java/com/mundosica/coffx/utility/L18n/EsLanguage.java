/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mundosica.coffx.utility.L18n;


/**
 *
 * @author Inspiron I5558
 */
public class EsLanguage implements Language {
    public EsLanguage () {
        Inflector.addIregularPlural("user", "users");
    }

    public  String singular(String pluralWord) {
	String singular = Inflector.iregularSingular(pluralWord);
        if (singular != null) {
            return singular;
        }
	pluralWord = pluralWord
            //Las palabras que terminan en -Z, cambian a –CES
            .replaceAll("ces$", "z")
            .replaceAll("es$", "");
	return pluralWord.replaceAll("s$", "");
    }

    public  String plural(String singularWord) {
        String plural = Inflector.iregularPlural(singularWord);
        if (plural != null) {
            return plural;
        }
        return singularWord
        //Las palabras que terminan en -Z, cambian a –CES
        .replaceAll("z$", "ce")
        //Las palabras que terminan en x,s y son Agudas 
        .replaceAll("([áéíóú])([xs])$", "\1se")
        // Si termina en r,l,n,d se agrega una e p.e. edad, edade
        .replaceAll("([rlnd])$", "\1e");
        // Si acaba en t,a,e,i...,j se agrega una s al final
        //.replaceAll("([taeiouj])$", "\1s");
        ///*/
    }
}
