package com.ads.proplan.db;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.ads.proplan.db.config.DatabaseHelper;
import com.ads.proplan.db.entity.Jogador;
import com.j256.ormlite.dao.Dao;

public class JogadorRepository {

	/**
	 * A constante TAG_LOG do tipo String foi declarada. O objetivo dessa
	 * variavel abstrata é determina um titulo para o Log informativo desta
	 * classe.
	 */
	private static final String TAG_LOG = "JogadorRepository";

	private DatabaseHelper db;
	Dao<Jogador, Integer>  jogadorEntitysDao;

	public JogadorRepository(Context ctx) {

		try {
			jogadorEntitysDao = DatabaseHelper.getInstance(ctx).getJogadorDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.i(TAG_LOG, "JogadorRepository");
	}

	public int create(Jogador entity) {
		try {
			return jogadorEntitysDao.create(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int update(Jogador entity) {
		try {
			return jogadorEntitysDao.update(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(Jogador entity) {
		try {
			return jogadorEntitysDao.delete(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public List<Jogador> getAll() {
		Log.i(TAG_LOG, "getAll");
		try {
			return jogadorEntitysDao.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
