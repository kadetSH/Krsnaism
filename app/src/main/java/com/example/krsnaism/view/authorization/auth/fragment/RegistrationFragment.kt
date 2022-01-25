package com.example.krsnaism.view.authorization.auth.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.krsnaism.Constants
import com.example.krsnaism.databinding.FragmentRegistrationBinding
import com.example.krsnaism.view.authorization.auth.viewModel.RegistrationViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class RegistrationFragment: DaggerFragment() {

    companion object {
        fun newInstance(token: String?): RegistrationFragment {
            val args = Bundle()
            args.putString(Constants.TOKEN, token)
            val fragment = RegistrationFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: RegistrationViewModel by viewModels {
        viewModelFactory
    }

    var token: String? = null
    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let { arg ->
            token = arg.getString(Constants.TOKEN)
        }
        viewModel.getCityList()
        println("")



    }

}