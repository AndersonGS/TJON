package com.ads.proplan.db;

import java.io.IOException;
import java.sql.SQLException;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

/**
 * Esta � uma Class com nome DatabaseConfigUtil, criada dia 12/10/2013 as
 * 22:26:56, no projeto TJON e dentro do pacote com.ads.proplan.db. Usando a
 * ver��o da JRE 1.7.0_21. O objetivo dessa classe � auxiliar o banco de dados
 * usado para gerenciar a cria��o e atualiza��o de seu banco de dados. Essa
 * classe tamb�m fornece geralmente o DAOs usado por outras classes.
 * 
 * @version 1.0.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {

	/**
	 * Main-Method Este � o metodo MAIN, ele � o metodo que inicia todo o
	 * programa. - void main(String[] args) � o parametro onde o metodo MAIN
	 * recebe uma String[].
	 * 
	 * @param args
	 *            - O parametro args � do tipo String[].
	 * @throws SQLException
	 *             the sQL exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws SQLException, IOException {
		writeConfigFile("ormlite_config.txt");
	}
}
