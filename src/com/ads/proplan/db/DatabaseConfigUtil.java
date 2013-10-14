package com.ads.proplan.db;

import java.io.IOException;
import java.sql.SQLException;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

/**
 * Esta é uma Class com nome DatabaseConfigUtil, criada dia 12/10/2013 as
 * 22:26:56, no projeto TJON e dentro do pacote com.ads.proplan.db. Usando a
 * verção da JRE 1.7.0_21. O objetivo dessa classe é auxiliar o banco de dados
 * usado para gerenciar a criação e atualização de seu banco de dados. Essa
 * classe também fornece geralmente o DAOs usado por outras classes.
 * 
 * @version 1.0.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {

	/**
	 * Main-Method Este é o metodo MAIN, ele é o metodo que inicia todo o
	 * programa. - void main(String[] args) é o parametro onde o metodo MAIN
	 * recebe uma String[].
	 * 
	 * @param args
	 *            - O parametro args é do tipo String[].
	 * @throws SQLException
	 *             the sQL exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws SQLException, IOException {
		writeConfigFile("ormlite_config.txt");
	}
}
