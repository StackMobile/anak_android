package com.oppous.anarko;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.oppous.anarko.adapters.SettingsMenuAdapter;
import com.oppous.anarko.classes.AppManager;
import com.oppous.anarko.classes.FontManager;

public class SettingsMainActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView lvMenu;
    private int[] menus = new int[]{
            R.string.settings_payments,
            R.string.settings_purchases,
            R.string.settings_changeNumber,
            R.string.settings_guideline,
            R.string.settings_fag,
            R.string.settings_feedback,
            R.string.settings_inviteFriends,
            R.string.settings_terms,
            R.string.settings_privacy,
            R.string.settings_watchTour
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_main);

        TextView txtTitle = (TextView) findViewById(R.id.activity_settings_txtTitle);
        txtTitle.setTypeface(FontManager.getCustomFont(this, this.getResources().getString(R.string.font_roboto)));

        ImageView btnBack = (ImageView) findViewById(R.id.activity_settings_btnBack);
        btnBack.setOnClickListener(this);

        lvMenu = (ListView) findViewById(R.id.activity_settings_listMenu);
        SettingsMenuAdapter menuAdapter = new SettingsMenuAdapter(this, menus);
        lvMenu.setAdapter(menuAdapter);
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent;
                switch (menus[position]){
                    case R.string.settings_notification:
                        intent = new Intent(SettingsMainActivity.this, SettingsNotiActivity.class);
                        startActivity(intent);
                        break;
                    case R.string.settings_payments:
                        intent = new Intent(SettingsMainActivity.this, PayMethodActivity.class);
                        startActivity(intent);
                        break;
                    case R.string.settings_purchases:{
                        intent = new Intent(SettingsMainActivity.this, PayStoreActivity.class);
                        startActivity(intent);
                    }
                        break;
                    case R.string.settings_changeNumber:
                        intent = new Intent(SettingsMainActivity.this, SettingsChangeNumActivity.class);
                        startActivity(intent);
                        break;
                    case R.string.settings_guideline:{
                        String link = getResources().getString(R.string.settings_link_guideLine);
                        openLink(link);
                    }
                        break;
                    case R.string.settings_fag:{
                        String link = getResources().getString(R.string.settings_link_faq);
                        openLink(link);
                    }
                        break;
                    case R.string.settings_feedback:
                        intent = new Intent(SettingsMainActivity.this, SettingsFeedbackActivity.class);
                        startActivity(intent);
                        break;
                    case R.string.settings_inviteFriends:
                        intent = new Intent(SettingsMainActivity.this, PayInviteActivity.class);
                        startActivity(intent);
                        break;
                    case R.string.settings_terms:{
                        String link = getResources().getString(R.string.settings_link_terms);
                        openLink(link);
                    }
                        break;
                    case R.string.settings_privacy:{
                        String link = getResources().getString(R.string.settings_link_policy);
                        openLink(link);
                    }
                        break;
                    case R.string.settings_watchTour:
                        intent = new Intent(SettingsMainActivity.this, SettingsTourActivity.class);
                        startActivity(intent);
                        break;
                }

            }
        });
    }

    private void openLink(String link){
        String urlString=link;
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setPackage("com.android.chrome");
        try {
            this.startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            // Chrome browser presumably not installed so allow user to choose instead
            intent.setPackage(null);
            this.startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_settings_btnBack:
            {
                this.finish();
            }
            break;
        }
    }
}
