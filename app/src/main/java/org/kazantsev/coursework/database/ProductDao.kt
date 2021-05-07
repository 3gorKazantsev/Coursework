package org.kazantsev.coursework.database

import androidx.lifecycle.LiveData
import androidx.room.*
import org.kazantsev.coursework.data.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM product_table")
    fun getAllProducts(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProduct(product: Product)

    @Query("DELETE FROM product_table")
    fun deleteAll()
}