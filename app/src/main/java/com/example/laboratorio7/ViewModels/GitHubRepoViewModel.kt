package com.example.laboratorio7.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.laboratorio7.Database.GithubRepo
import com.example.laboratorio7.Database.RoomDB
import com.example.laboratorio7.Repositorio.GitHubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitHubRepoViewModel(app: Application): AndroidViewModel(app){
    private val repository: GitHubRepoRepository

    init {
        val repoDao = RoomDB.getInstance(app).repoDao()

        repository = GitHubRepoRepository(repoDao)
    }

    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repository.getAll()

    fun nuke() = repository.nuke()
}