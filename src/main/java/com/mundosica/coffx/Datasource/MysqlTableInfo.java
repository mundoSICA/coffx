/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mundosica.coffx.Datasource;

import static com.mundosica.coffx.utility.Util.*;

/**
 *
 * @author Inspiron I5558
 */
public class MysqlTableInfo extends TableInfo {
    /** 
     * @return 
     * @url https://bitbucket.org/fitorec/core-java/src/488bd96d6ee11f9f132efb1767d0c1b93a4331f4/src/main/java/com/mundosica/core/Model/TableInfo.java?at=master&fileviewer=file-view-default
     */
    public boolean load(String tableName) {
        echo("cargando la tabla con nombre:" + tableName);
        return false;
    }
    
}
