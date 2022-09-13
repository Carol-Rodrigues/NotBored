package com.example.notbored_carol.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notbored_carol.R
import com.example.notbored_carol.adapter.ActivitiesAdapter
import com.example.notbored_carol.data.Category
import com.example.notbored_carol.databinding.ActivityActivitiesBinding
import com.example.notbored_carol.domain.ActivitiesRepository
import com.example.notbored_carol.infra.SecPreferences
import com.example.notbored_carol.infra.SecurityPreferences

class ActivitiesActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityActivitiesBinding

    // Instanciando classe repository
    private val ActivitiesRepository = ActivitiesRepository()

    // Array da classe Model
    private val activitiesData = ArrayList<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Layout da ViewGroup (RecyclerView)
        binding.recyclerActivities.layoutManager = LinearLayoutManager(this)

        // Adicionando as categorias para serem mostradas no RecyclerView
        showActivities()

        val adapter = ActivitiesAdapter(activitiesData)

        // Adapter -- quem faz a conexão entre o Layout e os itens da listagem
        // O adapter é uma classe abstrata, por isso, não conseguimos instancia-la. Por isso,
        // é preciso que criemos nosso próprio adapter.
        binding.recyclerActivities.adapter = adapter

        // Clicando para random
        binding.btRandom.setOnClickListener(this)

        Log.d("PARTICIPANTS",
            "Current value: ${SecurityPreferences(this).getParticipants("PARTICIPANTS")}")

    }

    override fun onClick(view: View) {
        if (view.id == R.id.bt_random) {
            val intent = Intent(this, SuggestionActivity::class.java)
            SecPreferences().storeCategory(intent, "CATEGORY", "Random")
            //intent.putExtra("Category Title", "Random")
            startActivity(intent)
        }
    }

    private fun showActivities() {

        val categories = ActivitiesRepository.getCategories()

        for (elements in categories) {
            activitiesData.add(Category(elements.title))
        }
    }
}