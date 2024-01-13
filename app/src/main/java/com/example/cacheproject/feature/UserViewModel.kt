package com.example.cacheproject.feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cacheproject.feature.api.UserApi
import com.example.cacheproject.feature.data.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    api: UserApi
): ViewModel() {

    private val _userLiveData = MutableLiveData<List<UserData>>()
    val userLiveData : LiveData<List<UserData>> = _userLiveData

    init {
        viewModelScope.launch {
            val users = api.getUserDetails()
            delay(2000)
            _userLiveData.value = users
        }
    }
}