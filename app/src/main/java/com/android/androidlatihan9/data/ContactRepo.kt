package com.android.androidlatihan9.data

import android.app.Application
import android.arch.lifecycle.LiveData
import com.android.androidlatihan9.data.data_model.People
import com.android.androidlatihan9.data.data_net.PeopleListInfo
import com.android.androidlatihan9.data.db_only.PeopleDAO
import com.android.androidlatihan9.data.db_only.PeopleDb

class ContactRepo ( application: Application) {


    private val peopleDAO : PeopleDAO

    init {
        val peopledatabase=PeopleDb.getInstance(application)
        peopleDAO = peopledatabase.peopleDao()
    }
    /**
     *
     */
    fun getAllPeople() : LiveData<List<People>>{
//        val allpeople = PeopleListInfo.PeopleList
//        return  allpeople.reversed()
        return peopleDAO.getAll()
    }
    fun insertPeople(people: People){
//        PeopleListInfo.PeopleList.add(people)
        peopleDAO.insert(people)

    }
    fun findPeople(id : Int): LiveData<People>{
//        for (people in PeopleListInfo.PeopleList){
//            if (people.id==id){
//                return people
//            }
//        }
//        return null
        return peopleDAO.find(id)
    }
}
