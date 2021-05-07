package org.kazantsev.coursework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.kazantsev.coursework.R
import org.kazantsev.coursework.data.Product
import org.kazantsev.coursework.viewmodels.ProfileViewModel

class ProfileFragment : Fragment() {

    private lateinit var button: Button
    private lateinit var button1: Button

    private val viewModel: ProfileViewModel by lazy {
        ViewModelProvider(this).get(ProfileViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        button = view.findViewById(R.id.button)
        button1 = view.findViewById(R.id.button1)

        button.setOnClickListener {
            viewModel.insertProduct(Product("hi"))
        }
        button1.setOnClickListener {
            viewModel.deleteAll()
        }

        return view
    }
}