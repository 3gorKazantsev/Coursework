package org.kazantsev.coursework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavView()
    }

    private fun setupBottomNavView() {
        // find by id
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        // set navigation controller
        val navController = navHostFragment.navController
        bottomNavView.setupWithNavController(navController)
    }
}