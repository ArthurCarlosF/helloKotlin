package com.arthurc.trackesp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arthurc.trackesp.data.RetrofitClient
import com.arthurc.trackesp.modelos.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class TelaInicialViewModel: ViewModel() {
    val users = MutableStateFlow(listOf<User>())

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                users.value = RetrofitClient.apiService.getUsers()
                // Handle the list of users, e.g., update LiveData or UI
            } catch (e: HttpException) {
                // Handle API error
            } catch (e: Exception) {
                // Handle other errors
            }
        }
    }

    init {
        fetchUsers()
    }
}