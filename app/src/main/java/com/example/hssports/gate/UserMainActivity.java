package com.example.hssports.gate;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarBadge;
import com.roughike.bottombar.OnMenuTabSelectedListener;

public class UserMainActivity extends AppCompatActivity {

    BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomBar=BottomBar.attach(this, savedInstanceState);

        mBottomBar.setItemsFromMenu(R.menu.five_buttons_menu, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(@IdRes int menuItemId) {

                if (menuItemId == R.id.search_item){

                    search f = new search();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer ,f).commit();
                }

                else if (menuItemId == R.id.friends_item){

                    friends f = new friends();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer ,f).commit();

                }
                else if (menuItemId == R.id.whosHere_item){

                    whosHere f = new whosHere();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer ,f).commit();
                }


                else if (menuItemId == R.id.notification_item){

                    notification f = new notification();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer ,f).commit();
                }
                else if (menuItemId == R.id.profile_item){

                    profile f = new profile();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer ,f).commit();
                }


            }
        });

        mBottomBar.setDefaultTabPosition(2);

        mBottomBar.mapColorForTab(0,"#ae02d9");
        mBottomBar.mapColorForTab(1,"#7cd2f7");
        mBottomBar.mapColorForTab(2,"#da8eed");
        mBottomBar.mapColorForTab(3,"#0096d6");
        mBottomBar.mapColorForTab(4,"#ad62bf");



        // Set the color for the active tab. Ignored on mobile when there are more than three tabs.


        // Use the dark theme. Ignored on mobile when there are more than three tabs.
        //bottomBar.useDarkTheme(true);

        // Use custom text appearance in tab titles.
        //mBottomBar.setTextAppearance(R.style.AppTheme);

        // Use custom typeface that's located at the "/src/main/assets" directory. If using with
        // custom text appearance, set the text appearance first.
        //mBottomBar.setTypeFace("MyFont.ttf");


    }



    public boolean onCreateOptionMenu (Menu menu){


        getMenuInflater().inflate(R.menu.five_buttons_menu,menu);

       // getMenuInflater().inflate(R.menu.options_menu,menu);

        return  true;

    }




}
