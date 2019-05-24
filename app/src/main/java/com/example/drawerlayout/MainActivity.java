package com.example.drawerlayout;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private DrawerLayout drawerLayout;

//    private String generatedString;

     ImageView imageview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
  drawerLayout=findViewById(R.id.drawer_layout);
//imageview=findViewById(R.id.myimage);
//        Drawable myDrawable = getResources().getDrawable(R.drawable.star);
//
//        imageview.setImageDrawable(myDrawable);

//         imageView= findViewById(R.id.myimage);
//         imageView.setImageResource(R.drawable.star);

//        Resources res=getResources();
//
//        int resourceId= (int) res.getIdentifier(String.valueOf(R.drawable.star),"drawable",getPackageName());
//
//        imageView.setImageResource(resourceId);










        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        imageview=navigationView.getHeaderView(0).findViewById(R.id.myimage);
        imageview.setImageResource(R.drawable.star);

        getSupportFragmentManager().beginTransaction().replace(R.id.CONTAINER,new Fragment1()).commit();
        navigationView.setCheckedItem(R.id.first);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.first:
                getSupportFragmentManager().beginTransaction().replace(R.id.CONTAINER,new Fragment1()).commit();

                break;

            case R.id.second:
                getSupportFragmentManager().beginTransaction().replace(R.id.CONTAINER,new Fragment2()).commit();

                break;

            case R.id.third:
                getSupportFragmentManager().beginTransaction().replace(R.id.CONTAINER,new Fragment3()).commit();

                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
        super.onBackPressed();
    }}


}
