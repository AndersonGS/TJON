package com.ads.proplan.db;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.ads.proplan.db.config.DatabaseHelper;
import com.ads.proplan.db.config.DatabaseManager;
import com.ads.proplan.db.entity.QuestionEntity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class QuestionRepository {

	/**
	 * A constante TAG_LOG do tipo String foi declarada. O objetivo dessa
	 * variavel abstrata é determina um titulo para o Log informativo desta
	 * classe.
	 */
	private static final String TAG_LOG = "QuestionRepository";

	private DatabaseHelper db;
	Dao<QuestionEntity, Integer>  questionEntitysDao;

	public QuestionRepository(Context ctx) {

		// DatabaseManager dbManager = new DatabaseManager();
		// db = dbManager.getHelper(ctx);
		try {
			questionEntitysDao = DatabaseHelper
					.getInstance(ctx).getQuestionDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.i(TAG_LOG, "QuestionRepository");
	}

	public int create(QuestionEntity entity) {
		try {
			return questionEntitysDao.create(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int update(QuestionEntity entity) {
		try {
			return questionEntitysDao.update(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(QuestionEntity entity) {
		try {
			return questionEntitysDao.delete(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public List<QuestionEntity> getAll() {
		Log.i(TAG_LOG, "getAll");
		try {
			return questionEntitysDao.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
