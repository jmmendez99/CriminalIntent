package com.bignerdranch.android.criminalintent

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import database.CrimeDatabase
import java.util.*

private const val DATABASE_NAME = "crime-database"

class CrimeRepository private constructor(context: Context){

    //The database and crimeDao properties store references
    //to our database and DAO objects

    //.databaseBuilder created a concrete implementation of our
    //abstract CrimeDatabase using 3 parameters.
    private val database : CrimeDatabase = Room.databaseBuilder(
        context.applicationContext,
        CrimeDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val crimeDao = database.crimeDao()

    //Being able to call the DAO functions like this instead
    //of having their implementations in this class makes this
    //class cleaner and easier to understand.
    fun getCrimes(): LiveData<List<Crime>> = crimeDao.getCrimes()

    fun getCrime(id: UUID): LiveData<Crime?> = crimeDao.getCrime(id)

    //This code is to initialize CrimeRepository so that it can
    //be accessed by other components in our app.
    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context) {
            if(INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        //?: means take the right hand argument if the left hand
        //argument is null. In this case, INSTANCE can be null,
        //so that's why we do that.
        fun get(): CrimeRepository {
            return INSTANCE ?:
            throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}