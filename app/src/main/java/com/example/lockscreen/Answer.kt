package com.example.lockscreen

class Answer {

    companion object {
        private var instance: Answer? = null
        fun getInstance(): Answer = instance?: Answer().also {
            instance = it
        }
    }

    var answer : String = ""

}