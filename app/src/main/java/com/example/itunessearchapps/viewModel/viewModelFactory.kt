package com.example.itunessearchapps.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.itunessearchapps.repository.repository

class viewModelFactory(val repository: repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return mainViewModel(repository) as T

    }
}