package kz.app.assignment3.exerciseTwo

import androidx.lifecycle.ViewModel

class SharedViewModel(): ViewModel() {

    private var text = ""

    fun updateText(newText: String) {
        text = newText
    }

    fun getText(): String = text

    override fun onCleared() {
        super.onCleared()
    }
}