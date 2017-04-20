/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mundosica.coffx.Datasource;

import com.mundosica.coffx.Coffx;
import static com.mundosica.coffx.utility.Util.*;
import java.util.Map;
//import javafx.beans.property.BooleanProperty;

/**
 *
 * @author fitorec: Miguel Marcial
 */
public abstract class TableInfo {
    String type = "Mysql";
    String tableName = null;
    
    public abstract boolean load(String name);
    public TableInfo() {
    }
    public TableInfo(String tableName){
        this.type = Coffx.config("datasource");
        this.tableName = tableName;
        this.init();
    }
    
    public TableInfo(String tableName, String datasource){
        this.type = datasource;
        this.tableName = tableName;
        this.init();
    }

    
    public boolean init() {
        String className = "com.mundosica.coffx.Datasource." + camel(this.type + " table info");
        try {
            /*TableInfo info = (TableInfo) ClassLoader
                        .getSystemClassLoader()
                        .loadClass(className).newInstance();*/
           TableInfo info = (TableInfo) Class.forName(className).newInstance();
            info.load(this.tableName);
        } catch (Exception e) {
            echo("No se pudo cargar la clase: " + className);
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Genera una tabla de equivalencias.
     * 
     * Por favor revise la documentacion de javaFX properties
     * 
     * @param columnType
     * @url https://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/package-tree.html
     * @return 
     */
    public String defaultProperty(String columnType) {
        Map<String, String> types = args(
                "BOOL", "BooleanProperty",
                "TINYINT", "BooleanProperty",
                //
                "SMALLINT","IntegerProperty",
                "MEDIUMINT", "IntegerProperty",
                "INT", "IntegerProperty",
                "INTEGER", "IntegerProperty",
                "BIGINT", "IntegerProperty",
                //
                "FLOAT", "DoubleProperty",
                "DOUBLE", "DoubleProperty",
                //
                "VARCHAR", "StringProperty"
        );
        if (types.containsKey(columnType)) {
            return types.get(columnType);
        }
        return null;
    }

    public static Class<?> propertyClass(String propertyName){
        if (propertyName==null || propertyName.length() == 0) {
            return null;
        }
        String className = propertyName;
        try {
            className = "javafx.beans.property." + propertyName;
            return Class.forName(className);
        } catch (Exception ex) {
            echo("property no found: " + className);
            ex.printStackTrace();
        }
        return null;
    }

    public static String getColumType(String s){
        return s.toUpperCase();
    }

}
