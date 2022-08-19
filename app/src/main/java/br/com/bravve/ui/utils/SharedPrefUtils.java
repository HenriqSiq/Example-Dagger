package br.com.bravve.ui.utils;

import android.content.Context;
import android.preference.PreferenceManager;

public class SharedPrefUtils {
    public static String CAT_FACT_KEY = "catFact";
    public static String LOGIN_TOKEN_KEY = "loginToken";

    static public boolean getBooleanData(Context context, String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(key, false);
    }

    static public int getIntData(Context context, String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(key, 0);
    }

    static public String getStringData(Context context, String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(key, null);
    }

    static public void saveData(Context context, String key, String val) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(key, val)
                .apply();
    }

    static public void saveData(Context context, String key, int val) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(key, val)
                .apply();
    }

    static public void saveData(Context context, String key, boolean val) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(key, val)
                .apply();
    }
}
