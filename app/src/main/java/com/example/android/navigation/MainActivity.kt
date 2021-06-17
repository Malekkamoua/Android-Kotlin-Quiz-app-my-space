package com.example.android.navigation

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration : AppBarConfiguration
    private val HomeFrag = RulesFragment()
    private val SpaceFrag = AboutFragment()
    private val GameFrag = TitleFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val navController = this.findNavController(R.id.myNavHostFragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.buttom_navigation)

        replaceFragment(HomeFrag)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_dashboard -> replaceFragment(HomeFrag)
                R.id.ic_settings -> replaceFragment(SpaceFrag)
                R.id.ic_info -> replaceFragment(GameFrag)

            }
            true
        }
    }

    private fun replaceFragment(fragement: Fragment) {
        if (fragement != null) {

            val intent = intent
            val b = Bundle()

            if (intent != null) {
                val info = intent.getStringExtra("info")
                b.putString("user", info)
                fragement.arguments = b
            } else {
                Log.d("info :", "null")
            }

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.myNavHostFragment, fragement)
            transaction.commit()
        }
    }

}
