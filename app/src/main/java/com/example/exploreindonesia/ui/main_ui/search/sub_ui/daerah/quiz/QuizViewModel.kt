package com.example.exploreindonesia.ui.main_ui.search.sub_ui.daerah.quiz

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exploreindonesia.data.response.QuizResponse
import com.example.exploreindonesia.data.retrofit.ApiConfig
import kotlinx.coroutines.launch
import retrofit2.HttpException

class QuizViewModel : ViewModel() {

    private val _quizList = MutableLiveData<List<QuizResponse>>()
    val quizList: LiveData<List<QuizResponse>> get() = _quizList

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val _daerah = MutableLiveData<String>()
    val daerah: LiveData<String> get() = _daerah

    private val _kategori = MutableLiveData<String>()
    val kategori: LiveData<String> get() = _kategori


    fun setDaerah(daerah: String) {
        _daerah.value = daerah
    }

    fun setKategori(kategori: String) {
        _kategori.value = kategori
    }


    fun getQuiz(daerah: String, kategori: String) {
        viewModelScope.launch {
            try {
                val response = ApiConfig.getApiService().getQuiz(daerah, kategori)
                _quizList.postValue(response)
            } catch (e: HttpException) {
                Log.e("error", e.message.toString())
            } catch (e: NullPointerException) {
                Log.e("error", e.message.toString())
            } catch (e: Exception) {
                Log.e("error", e.message.toString())
            }
        }
    }

    fun getQuizCategory(kategori: String) {
        viewModelScope.launch {
            try {
                val response1 = ApiConfig.getApiService().getQuiz("Medan", kategori)
                val response2 = ApiConfig.getApiService().getQuiz("Makassar", kategori)
                val response3 = ApiConfig.getApiService().getQuiz("Papua", kategori)

                val response = response1 + response2 + response3
                _quizList.postValue(response)
            } catch (e: HttpException) {
                Log.e("error", e.message.toString())
            } catch (e: NullPointerException) {
                Log.e("error", e.message.toString())
            } catch (e: Exception) {
                Log.e("error", e.message.toString())
            }
        }
    }

    fun getQuizAkhir(daerah: String) {
        viewModelScope.launch {
            try {
                val response = ApiConfig.getApiService().getQuizAkhir(daerah)
                _quizList.postValue(response)
            } catch (e: HttpException) {
                Log.e("error", e.message.toString())
            } catch (e: NullPointerException) {
                Log.e("error", e.message.toString())
            } catch (e: Exception) {
                Log.e("error", e.message.toString())
            }
        }
    }
}