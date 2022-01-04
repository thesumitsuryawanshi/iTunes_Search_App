package com.example.itunessearchapps

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.itunessearchapps.Utils.NetworkUtils
import com.example.itunessearchapps.adapters.rv_musicListAdapter
import com.example.itunessearchapps.databinding.ActivityMainBinding
import com.example.itunessearchapps.model.Result
import com.example.itunessearchapps.viewModel.mainViewModel
import com.example.itunessearchapps.viewModel.viewModelFactory

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fetchData()
    }

    private fun fetchData() {

        val repository = (application as MusicListApplication).repository


        val mainViewModel =
            ViewModelProvider(
                this,
                viewModelFactory(repository)
            ).get(mainViewModel::class.java)

        if (!NetworkUtils.isNetworkAvailable(applicationContext)) {

            mainViewModel.getListfromDatabase()
            Toast.makeText(
                this,
                "Please enable Internet connection to Search.",
                Toast.LENGTH_SHORT
            ).show()

            mainViewModel.MList.observe(this) {
                rvSetUp(it as ArrayList<Result>)
            }

        }

        binding.ivSearchbtn.setOnClickListener {
            val searchKeyword = binding.search.text.toString()

            mainViewModel.getList(searchKeyword)

            mainViewModel.MList.observe(this) {
                rvSetUp(it as ArrayList<Result>)
            }
        }
    }


    private fun rvSetUp(musicList: ArrayList<Result>) {
        val adapter = rv_musicListAdapter(musicList)

        binding.rvMusicList.layoutManager = GridLayoutManager(this, 2)
        binding.rvMusicList.adapter = adapter
        adapter.notifyItemInserted(musicList.size - 1)
    }

}

