package com.android.androidlatihan9.views.views_add

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.android.androidlatihan9.StartApp
import com.android.androidlatihan9.data.data_model.People

class AddPeopleViewModel (application: Application) : AndroidViewModel(application){

    private val peopleRepository = getApplication<StartApp>().getPeopleRepo()
    fun addpeople(people : People){
        peopleRepository.insertPeople(people)
    }
}



