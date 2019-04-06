package com.android.androidlatihan9

import android.app.Application
import com.android.androidlatihan9.data.ContactRepo

class StartApp:Application() {
    fun getPeopleRepo()= ContactRepo(this)
}