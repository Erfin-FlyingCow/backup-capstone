package com.example.exploreindonesia.ui.auth_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.exploreindonesia.R
import com.example.exploreindonesia.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var authViewModel: AuthViewModel

    lateinit var submitButton: Button

    lateinit var edt_login_email: EditText
    lateinit var edt_login_password: EditText

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val viewModel: AuthViewModel by viewModels()
    lateinit var button: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        edt_login_email = binding.edtLoginEmail
        edt_login_password = binding.edtLoginPassword

        button = binding.imageView2

        button.setOnClickListener {
            Toast.makeText(context, "Halo", Toast.LENGTH_SHORT).show()
        }



        return inflater.inflate(R.layout.fragment_login, container, false)
    }

}