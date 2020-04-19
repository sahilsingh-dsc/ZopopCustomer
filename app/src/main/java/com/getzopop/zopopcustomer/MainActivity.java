package com.getzopop.zopopcustomer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.getzopop.zopopcustomer.R;
import com.getzopop.zopopcustomer.home.HomeFragment;
import com.getzopop.zopopcustomer.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        BottomNavigationView navFooter = findViewById(R.id.navFooter);
        navFooter.setOnNavigationItemSelectedListener(this);
        navFooter.setSelectedItemId(R.id.f_m_home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {

            case R.id.f_m_home:
                fragment = new HomeFragment();
                break;

            case R.id.f_m_profile:
                fragment = new ProfileFragment();
                break;
        }

        return loadFragment(fragment);

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_main, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
