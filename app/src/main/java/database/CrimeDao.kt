package database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.bignerdranch.android.criminalintent.Crime
import java.util.*

//This is needed so that we can actually access the data that is
//held within out CrimeDatabase. Each function does a operation
// on the database.

@Dao
interface CrimeDao {
    //We change the return type of the query to a liveData object
    //that wraps the original return type. We do this so that we
    //can use a background thread to get data from our database
    //and then let the main thread know that those results are
    //ready to be retrieved.


    //The @Query annotation expects a string
    //containing a SQL command as input.

    //SELECT * FROM crime asks Room to pull
    // all columns for all rows in the crime database table.
    @Query("SELECT * FROM crime")
    fun getCrimes(): LiveData<List<Crime>>


    //SELECT * FROM crime WHERE id=(:id) asks Room to pull
    //all columns from only the row whose id matches
    //the ID value provided.
    @Query("SELECT * FROM crime WHERE id=(:id)")
    fun getCrime(id: UUID): LiveData<Crime?>
}