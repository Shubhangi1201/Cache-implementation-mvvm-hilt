package com.example.cacheproject.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cacheproject.R
import com.example.cacheproject.databinding.ActivityMainBinding
import com.example.cacheproject.feature.users.UserAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel : UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val userAdapter = UserAdapter()
        binding.apply {
            recyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                setHasFixedSize(true)
                adapter = userAdapter
            }
            viewModel.userLiveData.observe(this@MainActivity){users ->
                userAdapter.submitList(users)

            }

        }


    }
}