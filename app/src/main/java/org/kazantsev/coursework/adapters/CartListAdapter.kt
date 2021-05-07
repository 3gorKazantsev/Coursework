package org.kazantsev.coursework.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.kazantsev.coursework.R
import org.kazantsev.coursework.data.Product

class CartListAdapter(
    private val productList: List<Product>
) : RecyclerView.Adapter<CartListAdapter.CartViewHolder>() {

    inner class CartViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        // widgets
        private val nameTextView = item.findViewById<TextView>(R.id.itemName)
        private val idTextView = item.findViewById<TextView>(R.id.itemId)

        // function for binding item's widgets and instance's properties
        fun bind(product: Product) {
            nameTextView.text = product.name
            idTextView.text = product.id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        // inflating the item view
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)

        return CartViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        // binding item's widgets and instance's properties
        val product = productList[position]
        holder.bind(product)
    }

    override fun getItemCount() = productList.size
}