package com.example.less_2.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.less_2.R.*
import com.example.less_2.R.color.*
import com.example.less_2.databinding.MainActivityBinding
import android.view.Menu
import android.view.MenuItem



class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(id.container, MainFragment.newInstance())
                .commitNow()
            binding.buttonHome.setTextColor(getColor(strong_pink))
            binding.buttonHome.setBackgroundColor(getColor(white))

        }
        initView()
    }

    private fun initView() {
        initToolbar()
        //todo
        binding.buttonHome.setOnClickListener {
            addFragment(MainFragment())
            binding.buttonHome.setTextColor(getColor(strong_pink))
            binding.buttonHome.setBackgroundColor(getColor(white))
            binding.buttonRat.setTextColor(getColor(white))
            binding.buttonRat.setBackgroundColor(getColor(purple_500))
            binding.buttonFav.setTextColor(getColor(white))
            binding.buttonFav.setBackgroundColor(getColor(purple_500))
        }
        binding.buttonFav.setOnClickListener {
            addFragment(FavoritesFragment())
            binding.buttonHome.setTextColor(getColor(white))
            binding.buttonHome.setBackgroundColor(getColor(purple_500))
            binding.buttonRat.setTextColor(getColor(white))
            binding.buttonRat.setBackgroundColor(getColor(purple_500))
            binding.buttonFav.setTextColor(getColor(strong_pink))
            binding.buttonFav.setBackgroundColor(getColor(white))
        }
        binding.buttonRat.setOnClickListener {
            addFragment(RatingsFragment())
            binding.buttonHome.setTextColor(getColor(white))
            binding.buttonHome.setBackgroundColor(getColor(purple_500))
            binding.buttonRat.setTextColor(getColor(strong_pink))
            binding.buttonRat.setBackgroundColor(getColor(white))
            binding.buttonFav.setTextColor(getColor(white))
            binding.buttonFav.setBackgroundColor(getColor(purple_500))
        }
    }

    private fun initToolbar() {
        val toolbar: androidx.appcompat.widget.Toolbar = binding.toolbar
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(com.example.less_2.R.menu.main, menu)
        //todo search
        return true
}

    private fun addFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(id.container, fragment).commit()
    }
}

