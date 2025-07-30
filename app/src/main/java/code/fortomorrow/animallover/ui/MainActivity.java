package code.fortomorrow.animallover.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import code.fortomorrow.animallover.R;
import com.google.firebase.FirebaseApp;

import code.fortomorrow.animallover.adapters.ViewPagerAdapter;
import code.fortomorrow.animallover.utils.SharedPref;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ImageView imageView1, imageView2, imageView3, imageView4,imageView5,imageView6;
    private TextView skiptext;
    private String loginstatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this); // Initialize Firebase
        SharedPref.init(MainActivity.this);
        SharedPref.write("LOGGEDIN","Y");
        SharedPref.write("Phone","01684762673");
        SharedPref.write("Password","12345678");


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        SharedPref.init(MainActivity.this);
        init();
        loginstatus =SharedPref.read("Visited","");
        if(loginstatus.contains("Yes")){
            startActivity(new Intent(MainActivity.this,HomeActivity.class));
            finish();
        }

        skiptext.setOnClickListener(v ->{
            skip_preview();
        });
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position == 0) {
                    imageView1.setColorFilter(getResources().getColor(R.color.red));
                    imageView2.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView3.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView4.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView5.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView6.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                } else if (position == 1) {
                    imageView1.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView2.setColorFilter(getResources().getColor(R.color.red));
                    imageView3.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView4.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView5.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView6.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                }
                if (position == 2) {
                    skiptext.setVisibility(View.VISIBLE);
                    imageView1.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView2.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView3.setColorFilter(getResources().getColor(R.color.red));
                    imageView4.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView5.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView6.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                } else if (position == 3) {
                    imageView1.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView2.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView3.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView4.setColorFilter(getResources().getColor(R.color.red));
                    imageView5.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView6.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                }
                else if (position == 4) {
                    imageView1.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView2.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView3.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView4.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                    imageView5.setColorFilter(getResources().getColor(R.color.red));
                    imageView6.setColorFilter(getResources().getColor(R.color.overlay_dark_30));
                }
                else {
                    
                }


            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        setBackgroundColor();

    }


    private void init() {
        viewPager = findViewById(R.id.view_pager);
        imageView1 = findViewById(R.id.imageview1);
        imageView2 = findViewById(R.id.imageview2);
        imageView3 = findViewById(R.id.imageview3);
        imageView4 = findViewById(R.id.imageview4);
        imageView5 = findViewById(R.id.imageview5);
        imageView6 = findViewById(R.id.imageview6);
        skiptext = findViewById(R.id.skiptext);
    }

    private void setBackgroundColor() {

    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }

    }
    public void nextfragment(){
        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
        SharedPref.write("Visited","Yes");
    }
    private void skip_preview() {
        startActivity(new Intent(MainActivity.this,HomeActivity.class));
        SharedPref.write("Visited","Yes");
        //finish();

    }

}