package com.oppous.anarko;

import android.app.Application;

import com.oppous.anarko.classes.APIManger;
import com.oppous.anarko.classes.AppManager;

/**
 * Created by peter on 11/2/2016.
 */
public class AKApplication extends Application {

    private static final String TAG = "AKApplication";

    @Override
    public void onCreate() {
        super.onCreate();

        AppManager.getInstance().setContext(getApplicationContext());
        APIManger.getInstance().setContext(getApplicationContext());

    }

}
