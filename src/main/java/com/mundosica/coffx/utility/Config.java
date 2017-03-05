/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mundosica.coffx.utility;

import java.util.Map;
import static com.mundosica.coffx.utility.Util.*;

public class Config {
    static Map<String, String> data = args(
        "path", "",
        "locale", "ES_MX",
        "os", "",
        "datasource", "mysql"
    );

    public static String os() {
        String os = data.get("os");
	if ("".equals(os)) {
            String osCurrent = System.getProperty("os.name").toLowerCase();
            if (osCurrent.indexOf("win") >= 0) {// Windows OS
		os = "windows";
            } else {
		os = "linux";
            }
            data.put("os", os);
	}
	return os;
    }
	
    public static String config(String ...params) {
        if(params.length == 1) {
            return data.get(params[0]);
        }
        data.putAll(args(params));
        return join(params, ","); // data
    }
}