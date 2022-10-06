package database

import androidx.room.TypeConverter
import java.util.*

class CrimeTypeConverters {

    //We need these two different implementations to handle
    //putting the data into our Crime database and to also
    //handle retrieving the data and converting it
    //back to its original form before it was in the database.
    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toDate(millisSinceEpoch: Long?): Date? {
        return millisSinceEpoch?.let {
            Date(it)
        }
    }

    //the process in the comment above explains the same
    //process that should be done for the UUID.
    @TypeConverter
    fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?): String? {
        return uuid?.toString()
    }
}