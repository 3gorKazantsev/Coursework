package org.kazantsev.coursework.data

import java.util.*

data class Product(
    val id: UUID = UUID.randomUUID(),
    val name: String = ""
) {
    // temporary list for testing a recycler view
    companion object {
        fun getProductList(): List<Product> {
            val productList = mutableListOf<Product>()
            for (i in 1..21) {
                val test = Product(name = "Product item #$i")
                productList.add(test)
            }
            return productList
        }
    }
}