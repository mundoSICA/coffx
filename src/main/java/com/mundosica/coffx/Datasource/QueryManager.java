/*
 * Licencia MIT
 *
 * Copyright (c) 2017 @Fitorec <chanerec at gmail.com>.
 *
 * Se concede permiso, de forma gratuita, a cualquier persona que obtenga una
 * copia de este software y de los archivos de documentación asociados
 * (el "Software"), para utilizar el Software sin restricción, incluyendo sin
 * limitación los derechos a usar, copiar, modificar, fusionar, publicar,
 * distribuir, sublicenciar, y/o vender copias del Software, y a permitir a las
 * personas a las que se les proporcione el Software a hacer lo mismo, sujeto a
 * las siguientes condiciones:
 *
 * El aviso de copyright anterior y este aviso de permiso se incluirán en todas
 * las copias o partes sustanciales del Software.
 *
 * EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO, EXPRESA O
 * IMPLÍCITA, INCLUYENDO PERO NO LIMITADO A GARANTÍAS DE COMERCIALIZACIÓN,
 * IDONEIDAD PARA UN PROPÓSITO PARTICULAR Y NO INFRACCIÓN. EN NINGÚN CASO LOS
 * AUTORES O TITULARES DEL COPYRIGHT SERÁN RESPONSABLES DE NINGUNA RECLAMACIÓN,
 * DAÑOS U OTRAS RESPONSABILIDADES, YA SEA EN UNA ACCIÓN DE CONTRATO, AGRAVIO O
 * CUALQUIER OTRO MOTIVO, QUE SURJA DE O EN CONEXIÓN CON EL SOFTWARE O EL USO U
 * OTRO TIPO DE ACCIONES EN EL SOFTWARE.
 *
 */

package com.mundosica.coffx.Datasource;

import static com.mundosica.coffx.utility.Util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author @Fitorec <chanerec at gmail.com>
 */
public class QueryManager {
    private boolean transactionIsOpen = false;

    /**
     * Ejecuta una consulta SQL
     * 
     * @param strQuery
     * @return 
     */
    static Object execute(String strQuery) {
        String[] sqlParts = strQuery.trim().split(" ");
        if (sqlParts.length<2) {
            throw new IllegalArgumentException("Consulta invalida " + strQuery);
        }
        switch(sqlParts[0].toUpperCase()){
            case "SELECT":
                return QueryManager.select(strQuery);
            case "SHOW":
                return QueryManager.select(strQuery);
            case "DROP":
                return QueryManager.update(strQuery);
            case "UPDATE":
                return QueryManager.update(strQuery);
            case "DELETE":
                return QueryManager.update(strQuery);
            default:
                throw new IllegalArgumentException("Consulta desconocida " + strQuery);
                //throw new SQLException("QueryManager Error:" + strQuery);
        }
    }
/**
 * Ejecuta una consulta del tipo SELECT
 * 
 * @param strQuery
 * @return 
 */
    public static ResultSet select(String strQuery) {
        try {
            return BD
                    .conection()
                    .createStatement()
                    .executeQuery(strQuery);
        } catch(SQLException e) {
            echo("Error al intentar ejecutar: " + strQuery);
        }
        return null;
    }

    /**
     * Ejecuta una consulta del tipo update
     * 
     * @param strQuery
     * @return 
     */
    public static Integer update(String strQuery) {
        try {
            return BD
                    .conection()
                    .createStatement()
                    .executeUpdate(strQuery);
        } catch(SQLException e) {
        }
        return null;
    }

    /**
     * Intenta abrir una transacción
     * 
     * @return true si la pudo abrir
     */
    public boolean startTransaction() {
        if (transactionIsOpen) {
            return false;
        }
        transactionIsOpen = true;
        return true;
    }
}
