/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
        val intent = intent

        if (intent != null) {
            val info = intent.getStringExtra("info")
            Log.d("info :", "$info")
        } else {
            Log.d("Session_id :", "null")
        }

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

            val b = Bundle()
            b.putString("user", "steve")
            fragement.arguments = b

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.myNavHostFragment, fragement)
            transaction.commit()
        }
    }

   /* override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }*/
}
