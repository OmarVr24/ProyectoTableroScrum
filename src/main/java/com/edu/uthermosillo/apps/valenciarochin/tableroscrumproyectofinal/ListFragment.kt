package com.edu.uthermosillo.apps.valenciarochin.tableroscrumproyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private lateinit var button: FloatingActionButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TablerosAdapter
    private var tablerosList: MutableList<Tableros> = mutableListOf()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        recyclerView = view.findViewById(R.id.countriesRecycler)
        button = view.findViewById(R.id.fab_btn)

        button.setOnClickListener {
            showBottomSheet()
        }

        initData()

        adapter = TablerosAdapter(tablerosList)
        val layoutManager = LinearLayoutManager(requireContext())

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        return view
    }

    private fun initData() {
        tablerosList.addAll(
            listOf(
            Tableros(1, "Tablero Scrum: Escuela", "Alan, Omar EL ASESINO, Javier", "android.resource://${requireContext().packageName}/${R.drawable.tablero_scrum}"),
            Tableros(2, "Tablero Scrum: Trabajo", "Alan, Omar EL ASESINO, Javier", "android.resource://${requireContext().packageName}/${R.drawable.tablero_scrum}"),
            Tableros(3, "Tablero Scrum: Personal", "Alan, Omar EL ASESINO, Javier", "android.resource://${requireContext().packageName}/${R.drawable.tablero_scrum}"),
            Tableros(4, "Tablero Scrum: Tareas", "Alan, Omar EL ASESINO, Javier", "android.resource://${requireContext().packageName}/${R.drawable.tablero_scrum}"),
            Tableros(5, "Tablero Scrum: Maestros a los que odio", "Alan, Omar EL ASESINO, Javier", "android.resource://${requireContext().packageName}/${R.drawable.tablero_scrum}"),
            Tableros(6, "Tablero Scrum: Computadoras", "Alan, Omar EL ASESINO, Javier", "android.resource://${requireContext().packageName}/${R.drawable.tablero_scrum}"),
            Tableros(7, "Tablero Scrum: Materias reprobadas", "Alan, Omar EL ASESINO, Javier", "android.resource://${requireContext().packageName}/${R.drawable.tablero_scrum}"),
            Tableros(8, "Tablero Scrum: Juegos", "Alan, Omar EL ASESINO, Javier", "android.resource://${requireContext().packageName}/${R.drawable.tablero_scrum}"),
            Tableros(9, "Tablero Scrum: Casa", "Alan, Omar EL ASESINO, Javier", "android.resource://${requireContext().packageName}/${R.drawable.tablero_scrum}"),
            Tableros(10, "Tablero Scrum: Maestros a los que les disparere primero", "Alan, Omar EL ASESINO, Javier", "android.resource://${requireContext().packageName}/${R.drawable.tablero_scrum}"),
        )
        )
    }

    private fun showBottomSheet() {
        val bottomSheetView = layoutInflater.inflate(
            R.layout.bottom_sheet,
            view?.findViewById(R.id.bottomSheetContainer),
            false
        )
        val dialog = BottomSheetDialog(requireContext())
        dialog.setContentView(bottomSheetView)

        val name = bottomSheetView.findViewById<EditText>(R.id.tablero)
        val team = bottomSheetView.findViewById<EditText>(R.id.integrantes)
        val image = bottomSheetView.findViewById<EditText>(R.id.imagen)
        val agregarButton = bottomSheetView.findViewById<Button>(R.id.boton_agregar)

        agregarButton.setOnClickListener {
            val name = name.text.toString()
            val team = team.text.toString()
            val image = image.text.toString()

            if (name.isNotEmpty() && team.isNotEmpty() && image.isNotEmpty()) {
                // Asegúrate de agregar la extensión de archivo (.png, .jpg, etc.) al nombre de la imagen
                val nuevoTren = Tableros(
                    tablerosList.size + 1,
                    name,
                    team,
                    "android.resource://${requireContext().packageName}/drawable/$image"
                )
                tablerosList.add(nuevoTren)
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Completa todos los campos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        dialog.show()
    }
}