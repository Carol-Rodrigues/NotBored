package com.example.notbored_carol.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notbored_carol.R
import com.example.notbored_carol.data.ActivitiesModel
import com.example.notbored_carol.infra.ProjectConstants
import com.example.notbored_carol.infra.SecPreferences
import com.example.notbored_carol.infra.SecurityPreferences
import com.example.notbored_carol.presentation.SuggestionActivity

// O ViewHolder tbm é uma classe abstrata e por isso precisamos criá-la a parte (pois não pode ser
// instanciada)
// É a VH que tem a referência para os elementos de interface
class ActivitiesAdapter(private val actList: List<ActivitiesModel>):
  RecyclerView.Adapter<ActivitiesAdapter.ActivitiesViewHolder>() {

    // Crio o layout. É chamado para cada item da RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_category, parent, false)

        return ActivitiesViewHolder(view)
    }

    // Faz a conexão, atribuindo os valores para o Layout
    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val activitiesViewModel = actList[position]

        holder.actName.text = activitiesViewModel.type
        holder.imgNavigate.setImageResource(activitiesViewModel.image)

        holder.itemView.setOnClickListener {
            view: View -> Unit
            val context = holder.actName.context
            val intent = Intent(context, SuggestionActivity::class.java)
            val catTitle = activitiesViewModel.type

            if (catTitle != "") {
                SecPreferences().storeCategory(intent, "CATEGORY", catTitle)
                //SecurityPreferences(intent).storeCategory("CATEGORY", catTitle)
            } else {
                SecPreferences().storeCategory(intent, "CATEGORY", ProjectConstants.CATEGORY.RANDOM)
                //SecurityPreferences(context).storeCategory("CATEGORY", "Random")
            }
            //intent.putExtra("Category Title", catTitle)
            context.startActivity(intent)
        }


    }

    // Verifica o tamanho da listagem e "passa" pra RecyclerView alocar o espaço de memória necessário
    override fun getItemCount(): Int {
        return actList.size
    }

    // O itemView são os elementos que iremos definir em nosso Layout
    class ActivitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val actName: TextView = itemView.findViewById(R.id.tw_category)
        val imgNavigate: ImageView = itemView.findViewById(R.id.iw_navigate)

    }
}