package com.ptut.uiprototype

import android.content.Context
import android.os.Bundle
import android.os.StrictMode
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.osmdroid.config.Configuration


class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: HomeViewModel

    private val navController: NavController by lazy {
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val ctx: Context = applicationContext
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        setUpNavigation()
    }

    private fun setUpNavigation() {
        bottomNavigationView = findViewById(R.id.bottomNavigationBar)

        NavigationUI.setupWithNavController(
            bottomNavigationView,
            navController
        )

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            bottomNavigationView.isVisible = destination.id == R.id.mapFragment
        }
    }

    fun goToSearch() {

    }
}