package org.kazantsev.coursework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.kazantsev.coursework.R
import org.kazantsev.coursework.adapters.ProductAdapter
import org.kazantsev.coursework.data.Product
import org.kazantsev.coursework.viewmodels.ProductViewModel

class ProductListFragment : Fragment() {

    // RecyclerView
    private lateinit var recyclerView: RecyclerView
    private var adapter = ProductAdapter(emptyList())

    // ViewModel
    private val viewModel: ProductViewModel by lazy {
        ViewModelProvider(this).get(ProductViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)

        // find views by id
        recyclerView = view.findViewById(R.id.recyclerView)

        // setting the recycler view
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.productListLiveData
            .observe(viewLifecycleOwner) { products ->
                products?.let {
                    updateUI(products)
                }
            }
    }

    private fun updateUI(products: List<Product>) {
        adapter = ProductAdapter(products)
        recyclerView.adapter = adapter
    }
}