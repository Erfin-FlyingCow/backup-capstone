package com.example.exploreindonesia.ui.main_ui.search.sub_ui.daerah.Quiz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.exploreindonesia.MainActivity
import com.example.exploreindonesia.R

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        supportActionBar?.apply {
            title = "Quiz Sumatra Utara"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val viewModel = ViewModelProvider(this)[QuizViewModel::class.java]



        val daerah = intent.getStringExtra("Daerah").toString()
        val kategori = intent.getStringExtra("kategori").toString()

        viewModel.setDaerah(daerah)
        viewModel.setKategori(kategori)

        Log.d("QuizActivity", "Daerah: $daerah, Kategori: $kategori")

        val bundle = Bundle()
        bundle.putString("daerah", daerah)
        bundle.putString("kategori", kategori)

        val quizFragment = QuizFragment()
        quizFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .add(R.id.container_quiz,quizFragment)
            .commitNow()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {

            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}