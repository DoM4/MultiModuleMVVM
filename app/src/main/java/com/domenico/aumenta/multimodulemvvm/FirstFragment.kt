package com.domenico.aumenta.multimodulemvvm

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.domenico.aumenta.core.utils.ApiResponse
import com.domenico.aumenta.multimodulemvvm.databinding.FragmentFirstBinding
import com.domenico.aumenta.multimodulemvvm.presentation.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val viewModel: UserViewModel by viewModel()

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.getUserListByReputation().observe(viewLifecycleOwner, {
            when (it.status) {
                ApiResponse.Status.SUCCESS -> {
                    Log.d(TAG, "userList ${it?.data}")
                }
                ApiResponse.Status.ERROR -> {
                    Log.d(TAG, "ERROR ${it?.message}")
                }
                ApiResponse.Status.LOADING -> {
                    Log.d(TAG, "Loading ${it?.message}")
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        val TAG: String = FirstFragment::class.java.simpleName
    }
}