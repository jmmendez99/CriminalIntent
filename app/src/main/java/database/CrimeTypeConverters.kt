package database

import androidx.room.TypeConverter
import java.util.*

class CrimeTypeConverters {

    //We need these two different implementations to handle
    //putting the data into our Crime database and to also
    //handle retrieving the data and converting it
    //back to its original form before it was in the database.

    //Converts Date object to Long data type since the database
    //knows how to deal with longs
    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    //Coverts long data type to a Date object, which is our
    //original date
    @TypeConverter
    fun toDate(millisSinceEpoch: Long?): Date? {
        return millisSinceEpoch?.let {
            Date(it)
        }
    }

    //the process in the comment above explains the same
    //process that should be done for the UUID.

    //converts string to UUID object, which is our original data
    @TypeConverter
    fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }

    //converts UUID to a string since the database can handle
    //that data type
    @TypeConverter
    fun fromUUID(uuid: UUID?): String? {
        return uuid?.toString()
    }
}