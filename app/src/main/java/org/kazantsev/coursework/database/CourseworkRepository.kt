package org.kazantsev.coursework.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import org.kazantsev.coursework.data.Product
import java.lang.IllegalStateException
import java.util.concurrent.Executors

private const val DATABASE_NAME = "coursework_database"

class CourseworkRepository private constructor (context: Context) {

    // building a database
    private val database = Room.databaseBuilder(
        context.applicationContext,
        CourseworkDatabase::class.java,
        DATABASE_NAME
    ).build()

    // DAO
    private val productDao = database.productDao()

    // Executor
    private val executor = Executors.newSingleThreadExecutor()

    fun getAllProducts(): LiveData<List<Product>> = productDao.getAllProducts()

    fun insertProduct(product: Product) {
        executor.execute {
            productDao.insertProduct(product)
        }
    }

    fun deleteAll() {
        executor.execute {
            productDao.deleteAll()
        }
    }

    // singleton
    companion object {
        private  var INSTANCE: CourseworkRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null)
                INSTANCE = CourseworkRepository(context)
        }

        fun get(): CourseworkRepository {
            return INSTANCE ?: throw IllegalStateException("CourseworkRepository must be initialized")
        }
    }
}