package org.kazantsev.coursework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.kazantsev.coursework.R
import org.kazantsev.coursework.adapters.CartListAdapter
import org.kazantsev.coursework.data.Product

class CartFragment : Fragment() {

    // widgets
    private lateinit var recyclerView: RecyclerView
    private lateinit var pCountTV: TextView
    private lateinit var pCostTV: TextView
    private lateinit var discountTV: TextView
    private lateinit var amountTV: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        // find views by id
        findViews(view)

        // setting the recycler view
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CartListAdapter(listOf(
            Product("df"),
            Product("ff")
        ))

        // setting total amount etc.
        setTotalView(3, 1337, 322, 1015)

        return view
    }

    private fun findViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        pCountTV = view.findViewById(R.id.productsCount)
        pCostTV = view.findViewById(R.id.productsCost)
        discountTV = view.findViewById(R.id.discount)
        amountTV = view.findViewById(R.id.totalAmount)
    }

    private fun setTotalView(pCount: Int, pCost: Int, discount: Int, amount: Int) {
        pCountTV.text = getString(R.string.productsCount, pCount)
        pCostTV.text = getString(R.string.price, pCost)
        discountTV.text = getString(R.string.discountNum, discount)
        amountTV.text = getString(R.string.price, amount)
    }
}