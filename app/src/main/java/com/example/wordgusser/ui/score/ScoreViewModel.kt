package com.example.wordgusser.ui.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore : Int) : ViewModel() {

    private var _score = MutableLiveData<Int>()
    val score : LiveData<Int>
        get() = _score

    private val _playAgain = MutableLiveData<Boolean>()
    val playAgain : LiveData<Boolean>
        get() = _playAgain

    init {
        _score.value = finalScore
    }

    fun onPlayAgain(){
        _playAgain.value = true
    }

    fun eventPlayAgainComplete(){
        _playAgain.value = false
    }

}