/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mundosica.coffx;

import com.mundosica.coffx.Datasource.BD;
import static com.mundosica.coffx.utility.Util.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Inspiron I5558
 */
public class Coffx {
    // Coffx.config("datasource", "mysql")
    // Coffx.config("bd.username", "");
    // Coffx.config("bd.password", "");
     private static Map<String, String> cnf = args(
        "path", "",
        "locale", "ES_MX",
        "os", "",
        "datasource", "mysql"
    );

    public static String os() {
        String os = cnf.get("os");
	if ("".equals(os)) {
            String osCurrent = System.getProperty("os.name").toLowerCase();
            if (osCurrent.contains("win")) {// Windows OS
		os = "windows";
            } else {
		os = "linux";
            }
            cnf.put("os", os);
	}
	return os;
    }
	
    public static String config(String ...params) {
        if(params.length == 1) {
            return cnf.get(params[0]);
        }
        cnf.putAll(args(params));
        return join(params, ","); // data
    }

    public static Map<String, String> configByGroup(String group) {
        Map<String, String> elements = new HashMap();
        cnf.forEach((k,v) -> {
            if (k.indexOf(group+".") == 0) {
                elements.put(k.substring(group.length() +1), v);
            }
        });
        return elements;
    }

    public static void start() {
        configByGroup("bd").forEach((k,v)->BD.config(k,v));
    }
}