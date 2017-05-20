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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fitorec: Miguel Marcial
 * 
 * Esta clase es una clase del tipo 'Factory' que básicamente se va encargando
 * de obtener la información de las tablas.
 */
public class BDMetadata {
    /**
     * Contiene las tablas ya cargadas.
     */
    private static final Map<String, TableMetadata> tables = new HashMap();

    /**
     * Devuelve un objeto TableInfo de información de una tabla en especifica,
     *  si no puede cargar la información de la tabla devuelve null.
     * 
     * @param tableName
     * @return 
     */
    public static TableMetadata get(String tableName) {
        if (BDMetadata.tables.containsKey(tableName)) {
            return BDMetadata.tables.get(tableName);
        }
        String className = null;
        try {
            className = "com.mundosica.coffx.Datasource."
                + camel(BD.configVal("type").toLowerCase() + " table info");
           TableMetadata tableInfo = (TableMetadata) Class.forName(className).newInstance();
           tableInfo.load(tableName);
            return tableInfo;
        } catch (Exception e) {
            echo("No se pudo cargar la clase: " + className);
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean put(String tableName) {
        if (BDMetadata.tables.containsKey(tableName)) {
            return false;
        }
        return true;
    }
}
