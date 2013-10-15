package com.ads.proplan.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ads.proplan.entity.QuestionEntity;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	// name of the database file for your application -- change to something appropriate for your app
	private static final String DATABASE_NAME = "Proplan.sqlite";

	// any time you make changes to your database objects, you may have to increase the database version
	private static final int DATABASE_VERSION = 1;

	//TODO the DAO object we use to access the SimpleData table
	private Dao<QuestionEntity, Integer> dao = null;
	private RuntimeExceptionDao<QuestionEntity, Integer> runtimeDao = null;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database,ConnectionSource connectionSource) {
		try {
			//TODO
			Log.i(DatabaseHelper.class.getName(), "onCreate");
			TableUtils.createTable(connectionSource, QuestionEntity.class);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Não pode criar o database", e);
			throw new RuntimeException(e);
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// here we try inserting data in the on-create as a test
		//TODO
		// create some entries in the onCreate
		//TODO
	}

	@Override
	public void onUpgrade(SQLiteDatabase db,ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			List<String> allSql = new ArrayList<String>(); 
			switch(oldVersion) 
			{
			  case 1: 
				  //allSql.add("alter table AdData add column `new_col` VARCHAR");
				  //allSql.add("alter table AdData add column `new_col2` VARCHAR");
			}
			for (String sql : allSql) {
				db.execSQL(sql);
			}
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "exception during onUpgrade", e);
			throw new RuntimeException(e);
		}
		
	}

	public Dao<QuestionEntity, Integer> getQuestionDao() throws java.sql.SQLException{
        if (dao == null) {
        	dao = getDao(QuestionEntity.class);
        }
        return dao;
    }
	//TODO
	 public RuntimeExceptionDao<QuestionEntity, Integer> getQuestionDataDao() {
	        if (runtimeDao == null) {
	        	runtimeDao = getRuntimeExceptionDao(QuestionEntity.class);
	        }
	        return runtimeDao;
	    }
	
	@Override
	public void close() {
		super.close();
		dao = null;
	}
}
