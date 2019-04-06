package com.android.androidlatihan9.views.views_details

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.android.androidlatihan9.StartApp
import com.android.androidlatihan9.data.data_model.People

class PeopleDetailViewModel (application: Application) : AndroidViewModel(application){

    private val peopleRepository = getApplication<StartApp>().getPeopleRepo()
    private val peopleId = MutableLiveData<Int>()

    fun getPeopleDetails(id: Int): LiveData<People> {
        peopleId.value = id
        val peopleDetails = Transformations.switchMap<Int, People>(peopleId) {
            id -> peopleRepository.findPeople(id)
        }
        return peopleDetails
    }
}