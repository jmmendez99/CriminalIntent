package com.bignerdranch.android.criminalintent

import android.app.Application

//This allows us to do work as soon as our application is ready.
//This gives us access to lifecycle info about the app itself.

class CriminalIntentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}