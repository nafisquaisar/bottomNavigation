package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.Bottom_navigation_bar);



        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id= item.getItemId();

                if(id==R.id.Home){
                    loadfragment(new BlankFragment1(),0);

                } else if (id==R.id.Serach) {
                    loadfragment(new BlankFragment2(),1);
                } else if (id==R.id.Contact) {
                    loadfragment(new BlankFragment3(),1);
                } else if (id==R.id.Setting) {
                    loadfragment(new BlankFragment4(),1);
                } else{
                    loadfragment(new BlankFragment5(),1);
                }

                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.Home);

    }

    public void loadfragment(Fragment fragment, int flag){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        if(flag==0) {
            fragmentTransaction.add(R.id.container, fragment);
        }else {
            fragmentTransaction.replace(R.id.container,fragment);
        }
        fragmentTransaction.commit();
    }

}