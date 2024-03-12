package com.ccg.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ccg.sunnyweather.logic.Repository
import com.ccg.sunnyweather.logic.model.Place

class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    val placelist = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData){ query->
        Repository.searchPlaces(query)
    }
    fun searchPlaces(query:String){
        searchLiveData.value = query
    }

    fun savePlace(place: Place) = Repository.savePlace(place)

    fun getSavedPlace() = Repository.getSavedPlace()

    fun isPlaceSaved() = Repository.isPlaceSaved()
}