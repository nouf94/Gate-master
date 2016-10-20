package com.example.hssports.gate;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class whosHere extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
        View rootView =inflater.inflate(R.layout.whos_here,container,false);
        setHasOptionsMenu(true);
        return  rootView;
    }

    @Override //create Options Menu button in action bar
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        menu.add("Add")
                .setIcon(R.drawable.ic_menu_white_24dp)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    @Override //Go to Options Menu
    public boolean onOptionsItemSelected(MenuItem item) {
        // use switch and item id if there more than one option
        // Intent intent = new Intent(getActivity().getApplicationContext(),options.class);
        Intent intent = new Intent(getActivity().getApplicationContext(),settings.class);
        startActivity(intent);
        return false;

    }

}


