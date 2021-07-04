package com.example.conduit

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import com.example.apii.model.entities.User
import com.example.conduit.Auth.AuthViewModel
import com.example.conduit.CreateArticles.CreateArticlesArtivity
import com.example.conduit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val PREFS_FILE_AUTH = "prefs_auth"
        const val PREFS_KEY_TOKEN = "token"
    }


    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var authViewModel: AuthViewModel
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(PREFS_FILE_AUTH, Context.MODE_PRIVATE)
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            val intent = Intent(this,CreateArticlesArtivity::class.java)
            startActivity(intent)
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.Feed,R.id.Auth,R.id.myfeed
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        sharedPreferences.getString(PREFS_KEY_TOKEN, null)?.let { t ->
            authViewModel.currentuser(t)
        }

        authViewModel._user.observe({lifecycle}){
            updatauser(it)
            it?.token?.let { t ->
                sharedPreferences.edit {
                    putString(PREFS_KEY_TOKEN, t)
                }
            }?: run {
                sharedPreferences.edit {
                    remove(PREFS_KEY_TOKEN)
                }
        }
        }
        navController.navigateUp()
    }
    private fun updatauser(user:User?)
    {
        when(user)
        {
            is User ->{
                binding.navView.menu.clear()
                binding.navView.inflateMenu(R.menu.menu_geust)
            }
            else ->{
                binding.navView.menu.clear()
                binding.navView.inflateMenu(R.menu.activity_main_drawer)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.logout-> {
                authViewModel.logout()
            }
        }
        return super.onOptionsItemSelected(item)

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}