package com.ads.proplan.db;

import android.content.Context;

public class DatabaseManager {

	static private DatabaseManager instance;

	static public void init(Context ctx) {
		if (null==instance) {
			instance = new DatabaseManager(ctx);
		}
	}

	static public DatabaseManager getInstance() {
		return instance;
	}

	private DatabaseHelper helper;
	private DatabaseManager(Context ctx) {
		helper = new DatabaseHelper(ctx);
	}

	private DatabaseHelper getHelper() {
		return helper;
	}

	//TODO


}