package com.example.wordgusser.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val _currentWord = MutableLiveData<String>()
    val currentWord : LiveData<String>
        get() = _currentWord

    private val _score = MutableLiveData<Int>()
    val score : LiveData<Int>
        get() = _score

    private val _gameComplete = MutableLiveData<Boolean>()
    val gameComplete : LiveData<Boolean>
        get() = _gameComplete

    init {
        resetList()
        nextWord()
        _score.value = 0
    }

    private lateinit var wordList : MutableList<String>

    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    private fun nextWord() {
        if(wordList.isEmpty()){
            resetList()
            _gameComplete.value = true
        }
        _currentWord.value = wordList.removeAt(0)
    }

    fun onNext(){
        _score.value = _score.value?.plus(1)
        nextWord()
    }

    fun onSkip(){
        _score.value = _score.value?.minus(1)
        nextWord()
    }

    fun eventGameComplete(){
        _gameComplete.value = false
    }

}

