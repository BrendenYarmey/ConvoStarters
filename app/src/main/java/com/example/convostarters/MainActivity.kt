package com.example.convostarters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.convostarters.fragments.CommunicationFragment
import com.example.convostarters.fragments.HomeFragment
import com.example.convostarters.fragments.RandomFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val communicationFragment = CommunicationFragment()
        val homeFragment = HomeFragment()
        val randomFragment = RandomFragment()

        supportActionBar?.setTitle("Chatter")

        makeCurrentFragment(homeFragment)

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_communication -> makeCurrentFragment(communicationFragment)
                R.id.ic_random -> makeCurrentFragment(randomFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
             commit()
        }
}