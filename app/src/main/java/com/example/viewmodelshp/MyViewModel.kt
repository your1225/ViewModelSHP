package com.example.viewmodelshp

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.*

class MyViewModel(application: Application, handle: SavedStateHandle) :
    AndroidViewModel(application) {
    lateinit var handle: SavedStateHandle

    private val key: String = application.resources.getString(R.string.data_key)
    private val shpName = application.resources.getString(R.string.shp_name)

    init {
        this.handle = handle

        if (!handle.contains(key)) {
            load()
        }
    }

    private var _number = MutableLiveData<Int>().apply {
        value = handle.get(key)
    }

    var number: MutableLiveData<Int> = _number

//    var number: MutableLiveData<Int> = MutableLiveData(0)

//    fun getNumber(): LiveData<Int> {
//        return handle.getLiveData(key)
//    }

    fun load() {
        var shp: SharedPreferences =
            getApplication<Application>().getSharedPreferences(shpName, Context.MODE_PRIVATE)
        var x: Int = shp.getInt(key, 0)
        handle.set(key, x)
    }

    fun save() {
        var shp: SharedPreferences =
            getApplication<Application>().getSharedPreferences(shpName, Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor = shp.edit()
        editor.putInt(key, number.value!!)
        editor.apply()
    }

    fun add(x: Int) {
        number.value = number.value!!.plus(x)

        handle.set(key, number.value)
    }
}