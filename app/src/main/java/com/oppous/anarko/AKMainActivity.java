package com.oppous.anarko;

/**
 * Created by peter on 9/13/2016.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.oppous.anarko.classes.APIManger;
import com.oppous.anarko.classes.AppManager;

public class AKMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        /*---------------FullScreen Mode------------------*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /*------------------------------------------------*/

        //Team working branches
        int i = 2; // 1:peter 2:Wang 3:combine
        Intent intent;

        if (i == 1) {
            intent = new Intent(this, SettingsMainActivity.class);
        } else if (i == 2) {
			intent = new Intent(this, RegTourActivity.class);
		} else{
            intent = new Intent(this, CamCaptureActivity.class);
        }

        startActivity(intent);
    }
}
