package com.mysogni.mysogni;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mysogni.mysogni.fragments.DreamListFragment;
import com.mysogni.mysogni.fragments.DreamSavedFragment;
import com.mysogni.mysogni.fragments.MoodSelectionFragment;
import com.mysogni.mysogni.fragments.NewDreamFragment;
import com.mysogni.mysogni.fragments.TagSelectionFragment;

public class HomeActivity extends AppCompatActivity implements NewDreamFragment.OnFragmentInteractionListener,
        MoodSelectionFragment.OnFragmentInteractionListener,
        TagSelectionFragment.OnFragmentInteractionListener, DreamListFragment.OnFragmentInteractionListener,
        DreamSavedFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        displaySplashIfFirsTime();

        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displaySplashIfFirsTime(){
        SharedPreferences prefs = this.getSharedPreferences(getString(R.string.preferences_key), Context.MODE_PRIVATE);
        boolean firstTime = prefs.getBoolean(getString(R.string.first_time), true);

        if(firstTime){
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(getString(R.string.first_time), false);
            editor.commit();

            Intent intent = new Intent(this, SplashActivity.class);
            startActivity(intent);
            this.finish();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
