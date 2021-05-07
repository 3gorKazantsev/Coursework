package org.kazantsev.coursework.viewmodels

import androidx.lifecycle.ViewModel
import org.kazantsev.coursework.data.Product
import org.kazantsev.coursework.database.CourseworkRepository

class ProfileViewModel : ViewModel() {
    private val repository = CourseworkRepository.get()

    fun insertProduct(product: Product) {
        repository.insertProduct(product)
    }

    fun deleteAll() {
        repository.deleteAll()
    }
}