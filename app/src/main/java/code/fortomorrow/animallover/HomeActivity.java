package code.fortomorrow.animallover;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import code.fortomorrow.animallover.fragments.AboutFragment;
import code.fortomorrow.animallover.fragments.HomeFragment;
import code.fortomorrow.animallover.utils.SharedPref;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
   // private ImageView imginhome;
    private DrawerLayout drawerLayout;
    Toolbar toolbar;
    MenuItem menuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //imginhome = findViewById(R.id.imginhome);
        SharedPref.init(HomeActivity.this);

//        if(selected.contains("dog")){
//            imginhome.setImageResource(R.drawable.dog);
//        }
//        else if(selected.contains("cat")){
//            imginhome.setImageResource(R.drawable.cat);
//        }
//        else if(selected.contains("rabbit")){
//            imginhome.setImageResource(R.drawable.rabbit);
//        }
        drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        ActionBarDrawerToggle actionBarDrawerToggle =new ActionBarDrawerToggle(HomeActivity.this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(HomeActivity.this);
        if(SharedPref.read("LOGGEDIN","").contains("Y")){
            navigationView.getMenu().setGroupVisible(R.id.grouplogin,false);
            navigationView.getMenu().setGroupVisible(R.id.groupmyprofile,true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getColor(R.color.white));
        } else {
            actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.framelayout, new HomeFragment());
        ft.commit();
    }


    @SuppressLint("LongLogTag")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.my_profile){
            startActivity(new Intent(HomeActivity.this,MyprofileActivity.class));
        }
        if(id == R.id.log_out){
            SharedPref.write("Visited","");
            SharedPref.write("LOGGEDIN","");
            startActivity(new Intent(this,MainActivity.class));
        }
        if(id == R.id.nav_home){
            toolbar.setTitle("Home");
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.framelayout, new HomeFragment());
            ft.commit();
        }
        else if(id == R.id.log_in){

            startActivity(new Intent(HomeActivity.this,LoginActivity.class));

        }
        else if(id == R.id.settings){

        }
        else if(id == R.id.feedback){
            String[] TO = {""};
            String[] CC = {""};
            Intent emailIntent = new Intent(Intent.ACTION_SEND);

            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            emailIntent.putExtra(Intent.EXTRA_CC, CC);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

            try {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));

                Log.i("Finished sending email...", "");
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(HomeActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }
        }
        else if(id == R.id.share){
            String[] TO = {""};
            String[] CC = {""};
            Intent emailIntent = new Intent(Intent.ACTION_SEND);

            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            emailIntent.putExtra(Intent.EXTRA_CC, CC);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
            try {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                Log.i("Finished sending email...", "");
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(HomeActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }
        }
        else if(id == R.id.about){
            toolbar.setTitle("About");
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
// Replace the contents of the container with the new fragment
            ft.replace(R.id.framelayout, new AboutFragment());
// or ft.add(R.id.your_placeholder, new FooFragment());
// Complete the changes added above
            ft.commit();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
        super.onBackPressed();
    }
}