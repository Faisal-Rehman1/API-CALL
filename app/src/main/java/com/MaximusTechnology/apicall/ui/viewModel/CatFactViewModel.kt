package com.MaximusTechnology.apicall.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.MaximusTechnology.apicall.data.repository.CatFactRepository
import kotlinx.coroutines.launch

class CatFactViewModel : ViewModel() {
    private val repository = CatFactRepository()
    private val _fact = MutableLiveData<String>()
    val fact: LiveData<String> = _fact

    fun getCatFact() {
        viewModelScope.launch {
            val catFact = repository.getCatFact()
            _fact.value = catFact.fact
            _fact.value += "\n Length : " + catFact.length.toString()
        }
    }
}