package com.example.quickprojectlearning.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.quickprojectlearning.R
import com.example.quickprojectlearning.databinding.ActivityMainBinding
import com.example.quickprojectlearning.domain.model.PictureDomain
import com.example.quickprojectlearning.presentation.list.ListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ListFragment.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.nav_host_fragment_container)
    }

    override fun onPicClick(item: PictureDomain) {
        val args = Bundle()
        args.putString("title", item.title)
        args.putString("explanation", item.explanation)
        args.putString("url", item.url)
        navController.navigate(R.id.action_listFragment_to_detailsFragment,args)
    }
}