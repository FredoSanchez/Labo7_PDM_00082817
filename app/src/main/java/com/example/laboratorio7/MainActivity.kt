package com.example.laboratorio7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.laboratorio7.Database.GithubRepo
import com.example.laboratorio7.ViewModels.GitHubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewModel = ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)

        bt_add.setOnClickListener{
            val name = et_name.text.toString()
            if (name.isNotEmpty() && name.isNotBlank()){
                viewModel.insert(GithubRepo(name))
            }
        }

        viewModel.getAll().observe(this, Observer { repos ->
            Log.d("Lista de repos", "_________________________________________")
            for (repo in repos){
                Log.d("Lista de repos", repo.name)
            }
        })
    }
}
