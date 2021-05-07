package org.kazantsev.coursework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.kazantsev.coursework.data.Product

@Database(entities = [Product::class], version = 1)
abstract class CourseworkDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

}