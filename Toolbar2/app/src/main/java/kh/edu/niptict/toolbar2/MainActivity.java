package kh.edu.niptict.toolbar2;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import kh.edu.niptict.toolbar2.fragment.FavFragment;
import kh.edu.niptict.toolbar2.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    FavFragment favFragment;// = FavFragment.newInstance();
    HomeFragment homeFragment;// = HomeFragment.newInstance();
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("CS3 miss class");
//        actionBar.setSubtitle("Visit somewhere");

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Toolbar Custom");
        toolbar.setSubtitle("Toolbar Subtitle");
        setSupportActionBar(toolbar);


        favFragment = FavFragment.newInstance();
        homeFragment = HomeFragment.newInstance();
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container, homeFragment).addToBackStack(null).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //Toast.makeText(this, super.onCreateOptionsMenu(menu)+"", Toast.LENGTH_LONG).show();
        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("Call", "onOptionsItemSelected");

        switch (item.getItemId()) {
            case R.id.fav:
                //Toast.makeText(MainActivity.this, "Favourite", Toast.LENGTH_SHORT).show();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, favFragment).addToBackStack(null).commit();
                return true;
            case R.id.search:
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
