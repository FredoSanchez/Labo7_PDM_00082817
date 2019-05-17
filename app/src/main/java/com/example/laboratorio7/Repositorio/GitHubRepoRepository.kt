package com.example.laboratorio7.Repositorio

import androidx.lifecycle.LiveData
import com.example.laboratorio7.Database.GithubDAO
import com.example.laboratorio7.Database.GithubRepo

class GitHubRepoRepository(private val repoDao: GithubDAO)
{
    suspend fun insert(repo: GithubRepo){
        repoDao.insert(repo)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nuke() = repoDao.nukeTable()


}