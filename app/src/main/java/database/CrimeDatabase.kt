package database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bignerdranch.android.criminalintent.Crime

@Database(entities = [Crime::class], version = 1)
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDatabase : RoomDatabase() {

    //we do this so that Room will handle generating a concrete
    //version of the CrimeDao class. This line of code tells our
    //database class to generate an instance of the DAO.
    abstract fun crimeDao(): CrimeDao
}