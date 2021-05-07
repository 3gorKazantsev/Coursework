package org.kazantsev.coursework.viewmodels

import androidx.lifecycle.ViewModel
import org.kazantsev.coursework.data.Product
import org.kazantsev.coursework.database.CourseworkRepository

class ProductViewModel() : ViewModel() {
    private val courseworkRepository = CourseworkRepository.get()

    val productListLiveData = courseworkRepository.getAllProducts()

    fun insertProduct(product: Product) {
        courseworkRepository.insertProduct(product)
    }

    fun deleteAll() {
        courseworkRepository.deleteAll()
    }
}

