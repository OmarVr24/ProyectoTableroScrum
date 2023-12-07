package com.edu.uthermosillo.apps.valenciarochin.tableroscrumproyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register  , container, false)
        val boton = view.findViewById<Button>(R.id.iniciar_sesion)
        val iniciar = view.findViewById<TextView>(R.id.registrarse_txt)

        boton.setOnClickListener {
            val controller: NavController = Navigation.findNavController(view)
            controller.navigate(R.id.action_registerFragment_to_loginFragment)
        }

        iniciar.setOnClickListener {
            val controller: NavController = Navigation.findNavController(view)
            controller.navigate(R.id.action_registerFragment_to_loginFragment)
        }

        return view
    }
}