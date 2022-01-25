package com.example.krsnaism.view.authorization.auth.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.krsnaism.Constants
import com.example.krsnaism.R
import com.example.krsnaism.databinding.FragmentRegistrationBinding
import com.example.krsnaism.view.authorization.auth.viewModel.RegistrationViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class RegistrationFragment : DaggerFragment() {

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
    private lateinit var nicknameEdit: AutoCompleteTextView
    var adapter: ArrayAdapter<String>? = null
    private var cities = ArrayList<String>()

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

        init()
        observeViewModel()
//        viewModel.getCityList()
        println("")


    }

    private fun observeViewModel() {

        viewModel.citiesAnswer.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer<ArrayList<String>> { citiesList ->
                adapter = ArrayAdapter(
                    requireContext(),
                    R.layout.custom_list_item,
                    R.id.text_view_list_item,
                    citiesList
                )
                nicknameEdit?.setAdapter(adapter)
                val str = nicknameEdit.text
//                nicknameEdit.text = str
                println("")
            })

    }

    private fun init() {
        nicknameEdit = binding.idFrRegistrationEditNickname
        nicknameEdit.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(
                s: CharSequence, start: Int, before: Int,
                count: Int
            ) {
                if (s != "") {

                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {

            }

            override fun afterTextChanged(s: Editable) {
                val lengthString = s.length
                if (lengthString > 2){
                    viewModel.getCityList(s.toString())
                }
            }
        })
    }


}


