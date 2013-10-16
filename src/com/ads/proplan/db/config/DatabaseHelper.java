package com.ads.proplan.db.config;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ads.proplan.db.entity.QuestionEntity;
import com.ads.proplan.db.json.ListEntityGson;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	/**
	 * A constante TAG_LOG do tipo String foi declarada. O objetivo dessa
	 * variavel abstrata é determina um titulo para o Log informativo desta
	 * classe.
	 */
	private static final String TAG_LOG = "DatabaseHelper";

	// name of the database file for your application -- change to something
	// appropriate for your app
	private static final String DATABASE_NAME = "Proplan.sqlite";

	// any time you make changes to your database objects, you may have to
	// increase the database version
	private static final int DATABASE_VERSION = 2;

	// TODO the DAO object we use to access the SimpleData table
	private Dao<QuestionEntity, Integer> dao = null;
	private RuntimeExceptionDao<QuestionEntity, Integer> runtimeDao = null;
	
	private static DatabaseHelper mInstance = null;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database,
			ConnectionSource connectionSource) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onCreate");
			TableUtils.createTable(connectionSource, QuestionEntity.class);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Não pode criar o database",
					e);
			throw new RuntimeException(e);
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// here we try inserting data in the on-create as a test
		RuntimeExceptionDao<QuestionEntity, Integer> dao = getQuestionDataDao();
		ListEntityGson gson = new ListEntityGson();
		List<QuestionEntity> list = gson.getListEntity(gson.QUESTION);
		for (QuestionEntity questionEntity : list) {
			dao.create(questionEntity);
		}
		// TODO
		// create some entries in the onCreate
		// TODO

		Log.i(TAG_LOG, "onCreate");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
			int oldVersion, int newVersion) {
		try {
			List<String> allSql = new ArrayList<String>();
			switch (oldVersion) {
			case 1:
				// allSql.add("alter table AdData add column `new_col` VARCHAR");
				// allSql.add("alter table AdData add column `new_col2` VARCHAR");
			}
			for (String sql : allSql) {
				db.execSQL(sql);
			}
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "exception during onUpgrade",
					e);
			throw new RuntimeException(e);
		}

	}

	public Dao<QuestionEntity, Integer> getQuestionDao()
			throws java.sql.SQLException {
		if (dao == null) {
			dao = getDao(QuestionEntity.class);
		}
		Log.i(TAG_LOG, "getQuestionDao");
		return dao;
	}

	// TODO
	public RuntimeExceptionDao<QuestionEntity, Integer> getQuestionDataDao() {
		if (runtimeDao == null) {
			runtimeDao = getRuntimeExceptionDao(QuestionEntity.class);
		}
		Log.i(TAG_LOG, "getQuestionDataDao");
		return runtimeDao;
	}
	
	public static DatabaseHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DatabaseHelper(context);
            Log.i(TAG_LOG, "getInstanceNew");
        }
        Log.i(TAG_LOG, "getInstanceReturn");
        return mInstance;
    }

	@Override
	public void close() {
		super.close();
		dao = null;
	}
}
