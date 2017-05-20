/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mundosica.coffx.Datasource;

import static com.mundosica.coffx.utility.Util.*;
import java.util.HashMap;
import java.util.Map;
//import javafx.beans.property.BooleanProperty;

/**
 *
 * @author fitorec: Miguel Marcial
 * 
 * Esta clase es una clase del tipo 'Factory' que básicamente se va encargando
 * de obtener la información de las tablas.
 */
public abstract class TableMetadata {
    private static String type = "Mysql";
    String tableName = null;
    private HashMap<String, ColumnMetadata> columns = new HashMap<String, ColumnMetadata>();
    public abstract boolean load(String tableName);
/**
 * Agrega una nueva columna, si esta no existe.
 * 
 * @param column
 * @return 
 */
    public boolean addColumn(ColumnMetadata column) {
        if (columns.containsKey(column.name())) {
            return false;
        }
        columns.put(column.name(), column);
        return true;
    }

    public ColumnMetadata getColumn(String name) {
        if (columns.containsKey(name)) {
            return columns.get(name);
        }
        return null;
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
