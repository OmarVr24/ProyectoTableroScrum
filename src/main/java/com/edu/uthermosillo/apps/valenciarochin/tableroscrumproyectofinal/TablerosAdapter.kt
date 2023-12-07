package com.edu.uthermosillo.apps.valenciarochin.tableroscrumproyectofinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class TablerosAdapter(private var passwords: List<Tableros>): RecyclerView.Adapter<TablerosAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.card_layout, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val password = passwords[position]
        holder.render(password)

    }

    override fun getItemCount(): Int {
        return passwords.size
    }

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.pass_title)
        val team: TextView = view.findViewById(R.id.app_name)
        val image: ImageView = view.findViewById(R.id.pass_image)


        fun render(password: Tableros) {
            name.text = password.name
            team.text = password.team
            Picasso.get().load(password.image).into(image)
        }
    }
}
