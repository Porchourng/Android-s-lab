package kh.edu.niptict.navigationdrawer;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import kh.edu.niptict.navigationdrawer.fragment.MyAppFragment;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_restaurant);

        fm = getSupportFragmentManager();
        MyAppFragment myAppFragment = MyAppFragment.newInstance();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.content_frame, myAppFragment).commit();

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                drawerLayout.closeDrawers();

                switch (item.getItemId()) {
                    case R.id.nav_game:
                        Toast.makeText(getApplicationContext(), "Navigation Game", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_notification:
                        Toast.makeText(getApplicationContext(), "Navigation Notification", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_subscriptions:
                        Toast.makeText(getApplicationContext(), "Navigation Subscriptions", Toast.LENGTH_SHORT).show();
                        return true;
                }

                return true;
            }
        });

        View headerView = navigationView.getHeaderView(0);
        TextView textView = headerView.findViewById(R.id.nameProfile);
        textView.setText("NewName");

        ImageView imageView = headerView.findViewById(R.id.imageView);
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.ic_restaurant);
        imageView.setImageDrawable(drawable);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void goToProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
