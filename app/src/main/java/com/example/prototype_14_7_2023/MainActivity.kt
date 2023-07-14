package com.example.prototype_14_7_2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var  bottomNav : BottomNavigationView

    //declare new view


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(fragment_home())

        bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNav.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.home -> {

                    loadFragment(fragment_home())
                    true
                }

                R.id.dashboard -> {

                    loadFragment(fragment_dashboard())
                    true

                }

                R.id.control -> {

                    loadFragment(fragment_control())
                    true
                }

                R.id.about -> {

                    loadFragment(fragment_about())
                    true

                }

                else -> {false}
            }


        }
    }


    //creating a function to load fragment
    private fun loadFragment(fragment: Fragment){

        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.container , fragment)

        transaction.commit()


    }




}