package com.example.itunessearchapps.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itunessearchapps.model.Result
import com.example.itunessearchapps.repository.repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class mainViewModel(val repo: repository) : ViewModel() {


    val MList: LiveData<List<Result>>
        get() = repo.musicList

    fun getList(keyword: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getMusicList(keyword)
        }
    }

    fun getListfromDatabase() {

        viewModelScope.launch(Dispatchers.IO) {
            repo.getListfromDatabase()
        }
    }

}