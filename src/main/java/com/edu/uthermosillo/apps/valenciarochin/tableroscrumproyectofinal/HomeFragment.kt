package com.edu.uthermosillo.apps.valenciarochin.tableroscrumproyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_home, container, false)

        val ir = v.findViewById<Button>(R.id.button)

        ir.setOnClickListener {
            val controller : NavController =
                Navigation.findNavController(v)
            controller.navigate(
                R.id.action_homeFragment_to_listFragment)
        }

        return v
    }

}