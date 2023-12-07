package com.edu.uthermosillo.apps.valenciarochin.tableroscrumproyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation

class LoginFragment : Fragment() {
    private val usuario = "omar"
    private val pass = "1234"

    private lateinit var user: EditText
    private lateinit var contra: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val boton = view.findViewById<Button>(R.id.iniciar_sesion)
        val registro = view.findViewById<TextView>(R.id.registrarse_txt)

        user = view.findViewById(R.id.user)
        contra = view.findViewById(R.id.passw)

        boton.setOnClickListener {
            Login(it)
        }

        registro.setOnClickListener {
            val controller : NavController =
                Navigation.findNavController(view)
            controller.navigate(
                R.id.action_loginFragment_to_registerFragment)
        }

        return view
    }

    private fun Login(view: View) {
        if (view.id == R.id.iniciar_sesion) {
            val usernameInput = user.text.toString()
            val passwordInput = contra.text.toString()

            if (usernameInput.isNotEmpty() && passwordInput.isNotEmpty() &&
                usernameInput == usuario && passwordInput == pass
            ) {
                val controller: NavController = Navigation.findNavController(requireView())
                controller.navigate(R.id.action_loginFragment_to_homeFragment)
            } else {
                context?.let {
                    Toast.makeText(it, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}
