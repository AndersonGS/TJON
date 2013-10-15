package com.ads.proplan.db;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import android.content.Context;

public class DatabaseManager {

	private DatabaseHelper databaseHelper = null;

	public DatabaseHelper getHelper(Context context) {
		if (databaseHelper == null) {
			databaseHelper = OpenHelperManager.getHelper(context,
					DatabaseHelper.class);
		}
		return databaseHelper;
	}

	public void releaseHelper(DatabaseHelper helper) {
		if (databaseHelper != null) {
			OpenHelperManager.releaseHelper();
			databaseHelper = null;
		}
	}
}