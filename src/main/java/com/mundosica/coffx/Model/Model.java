/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mundosica.coffx.Model;

import com.mundosica.coffx.Datasource.BD;
import com.mundosica.coffx.utility.L18n.Inflector;
import static com.mundosica.coffx.utility.Util.echo;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Inspiron I5558
 */
public abstract class Model {
    public boolean load(){
        return false;
    }
    /**
     * Se encarga de cargar un registro a partir del objeto id del tipo "type"
     * 
     * @param id
     * @param type
     * @return 
     */
    public boolean load(Object id, String type) {
        loadSchema();
        String querry = "SELECT * FROM `%s` AS `%s` WHERE `?` = ? LIMIT 1";
        return false;
    }
 
    private boolean loadSchema() {
        return BD.loadTableSchema(this.tableName());
    }

/**
 * Regresa el nombre de la base de datos
 * 
 * @return 
 */
    public String tableName() {
        Class<? extends Model> clazz = getClass();
        String tableName = null;
        try {
            Field f = clazz.getDeclaredField("tableName");
            tableName = (String) f.get(this);
        } catch (Exception ex) {
            tableName = clazz.getSimpleName().toLowerCase();
            tableName = tableName.substring(0, tableName.length() - 5);
            tableName = Inflector.toPlural(tableName);
        }
        return tableName;
    }
}
