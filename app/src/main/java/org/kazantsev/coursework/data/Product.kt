package org.kazantsev.coursework.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product(
    val name: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)