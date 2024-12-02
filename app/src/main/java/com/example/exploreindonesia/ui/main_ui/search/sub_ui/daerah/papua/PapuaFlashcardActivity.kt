package com.example.exploreindonesia.ui.main_ui.search.sub_ui.daerah.papua

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.exploreindonesia.R
import com.example.exploreindonesia.data.adapter.FlashcardAdapter
import com.example.exploreindonesia.data.request.AddRiwayatRequest
import com.example.exploreindonesia.ui.main_ui.search.sub_ui.daerah.DaerahViewModel
import com.example.exploreindonesia.ui.main_ui.search.sub_ui.daerah.sumatra_utara.SumateraUtaraFlashcardActivity.Companion.Medan

class PapuaFlashcardActivity : AppCompatActivity() {

    companion object {
        const val Papua = "Papua"
    }
    private var lastVisibleItemId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_papua_flashcard)

        val kategori = intent.getStringExtra("kategori")
        val rvPapua = findViewById<RecyclerView>(R.id.rv_papua_flashcard)
        rvPapua.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val viewModel = ViewModelProvider(this)[DaerahViewModel::class.java]

        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(rvPapua)

        val adapter = FlashcardAdapter()
        rvPapua.adapter = adapter

        viewModel.flashcards.observe(this, Observer { flashcards ->
            adapter.updateFlashcards(flashcards)
        })


        viewModel.getFlashCards(Papua, kategori ?: "")

        rvPapua.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

                if (lastVisibleItemPosition != RecyclerView.NO_POSITION) {
                    val lastVisibleItem = adapter.flashcards[lastVisibleItemPosition]
                    lastVisibleItemId = lastVisibleItem.id
                }
            }
        })

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Papua"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            val akunSharedPreferences = getSharedPreferences("akun", MODE_PRIVATE)
            val userId = akunSharedPreferences.getString("userId", null).toString()
            val viewModel = ViewModelProvider(this)[DaerahViewModel::class.java]

            lastVisibleItemId?.let { id ->
                val request = AddRiwayatRequest(userId, id)
                viewModel.addRiwayat(request)
            }
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}