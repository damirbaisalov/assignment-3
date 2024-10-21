package kz.app.assignment3.exercise2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    private val _text = MutableLiveData<String>()
    val text: MutableLiveData<String> = _text

    fun updateText(newText: String) {
        _text.value = newText
    }
}