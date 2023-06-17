package com.example.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()


        // Set the initial fragment
        switchFragment(firstFragment)

        val onNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.miHome -> {
                        // Handle Home selection
                        switchFragment(firstFragment)
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.miMessages -> {
                        // Handle Home selection
                        switchFragment(secondFragment)
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.miProfile -> {
                        // Handle Home selection
                        switchFragment(thirdFragment)
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }



        val navigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)


    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragment, fragment)
            .commit()
    }
}