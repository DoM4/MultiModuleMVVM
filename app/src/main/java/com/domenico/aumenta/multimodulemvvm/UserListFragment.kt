package com.domenico.aumenta.multimodulemvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.domenico.aumenta.core.utils.ApiResponse
import com.domenico.aumenta.multimodulemvvm.databinding.UserListFragmentBinding
import com.domenico.aumenta.multimodulemvvm.presentation.UserViewModel
import com.domenico.aumenta.multimodulemvvm.presentation.UsersAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class UserListFragment : Fragment() {

    private val viewModel: UserViewModel by viewModel()
    private lateinit var usersAdapter: UsersAdapter

    private var _binding: UserListFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = UserListFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
        setupUI()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.getUserListByReputation().observe(viewLifecycleOwner, {
            when (it.status) {
                ApiResponse.Status.SUCCESS -> {
                    binding.pbUserListFragment.visibility = View.GONE
                    it.data?.let { it1 -> usersAdapter.setUsers(it1) }
                }
                ApiResponse.Status.ERROR -> {
                    binding.pbUserListFragment.visibility = View.GONE
                    Toast.makeText(
                        context,
                        getString(R.string.general_error_message),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                ApiResponse.Status.LOADING -> {
                    binding.pbUserListFragment.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun setupUI() {
        usersAdapter = UsersAdapter()
        binding.rvUserListFragment.adapter = usersAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        val TAG: String = UserListFragment::class.java.simpleName
    }
}