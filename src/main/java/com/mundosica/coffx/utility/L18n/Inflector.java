/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mundosica.coffx.utility.L18n;

import java.util.function.Predicate;

/**
 *
 * @author Inspiron I5558
 */
public class Inflector {
    Plural singular;
    Plural plural;
    
    public Inflector() {
        Plural p = (String s) -> {return s + "s";};
        p.eval("Juane");
    }
}
