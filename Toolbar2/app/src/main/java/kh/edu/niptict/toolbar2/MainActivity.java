package kh.edu.niptict.toolbar2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("CS3 miss class");
        actionBar.setSubtitle("Visit somewhere");
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
        switch (item.getItemId()) {
            case R.id.fav:
                Toast.makeText(MainActivity.this, "Favourite", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search:
                Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
