package com.example.exploreindonesia.ui.main_ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.exploreindonesia.R
import com.example.exploreindonesia.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    lateinit var button_home_first: LinearLayout
    lateinit var button_home_second: LinearLayout
    lateinit var button_home_third: LinearLayout

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        button_home_first = binding.buttonHomeFirst
        button_home_second =binding.buttonHomeSecond
        button_home_third = binding.buttonHomeThird

        button_home_first.setOnClickListener {
            Toast.makeText(context, "button_home_first", Toast.LENGTH_SHORT).show()
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        View.GONE
    }
}