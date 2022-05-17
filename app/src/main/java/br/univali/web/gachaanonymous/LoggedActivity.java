package br.univali.web.gachaanonymous;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class LoggedActivity extends AppCompatActivity {
    private Menu mOptionsMenu;
    private NavigationBarView.OnItemSelectedListener navListener =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch(item.getItemId()) {
                        case R.id.nav_log_home:
                            selectedFragment = new LoggedFragment();
                            break;
                        case R.id.nav_log_chat:
                            selectedFragment = new ChatFragment();
                            break;
                        case R.id.nav_log_perfil:
                            selectedFragment = new ProfileFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(
                            R.id.fragment_container_logged, selectedFragment).commit();
                    return true;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_logged);
        bottomNav.setOnItemSelectedListener(navListener);



        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_logged,
                new LoggedFragment()).commit();
    }

}