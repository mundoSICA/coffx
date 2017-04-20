/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mundosica.coffx;

import com.mundosica.coffx.Datasource.BD;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CxText {
    public static void initBD() {
        BD.config(
            "bd"   , "test",
            "user" , "root",
            "password" , ""
        );
        BD.initBD();
    }
 
    public static void endBD() {
        BD.end();
    }
    public static void initL18n() {
        
    }
}
