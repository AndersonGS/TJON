package com.ads.proplan.db;

import java.util.List;

import android.content.Context;

import com.ads.proplan.entity.QuestionEntity;
import com.j256.ormlite.dao.Dao;

public class QuestionRepository {

	private DatabaseHelper db;
	Dao<QuestionEntity, Integer> entitysDao;

	public QuestionRepository(Context ctx) {

		DatabaseManager dbManager = new DatabaseManager();
		db = dbManager.getHelper(ctx);
		try {
			entitysDao = db.getQuestionDao();
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int create(QuestionEntity entity) {
		try {
			return entitysDao.create(entity);
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int update(QuestionEntity entity) {
		try {
			return entitysDao.update(entity);
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(QuestionEntity entity) {
		try {
			return entitysDao.delete(entity);
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public List getAll() {
		try {
			return entitysDao.queryForAll();
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
