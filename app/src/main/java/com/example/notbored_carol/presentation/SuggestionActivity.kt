package com.example.notbored_carol.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.notbored_carol.R
import com.example.notbored_carol.data.Category
import com.example.notbored_carol.databinding.ActivitySuggestionBinding
import com.example.notbored_carol.infra.ProjectConstants
import com.example.notbored_carol.infra.SecPreferences
import com.example.notbored_carol.infra.SecurityPreferences
import kotlin.random.Random

class SuggestionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivitySuggestionBinding

    // Instanciando classe repository
    private val ActivitiesRepository = com.example.notbored_carol.domain.ActivitiesRepository()
    private val categories = ActivitiesRepository.getCategories()

    //private val catTitle = SecPreferences().getCategory(intent, "CATEGORY")
    private lateinit var intentLate: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySuggestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btTry.setOnClickListener(this)

        //val intent = intent
        intentLate = intent
        //val catTitle = SecPreferences().getCategory(intentLate, "CATEGORY")
        //val catTitle = intent.getStringExtra("Category Title")
        //binding.twCatTitle.text = catTitle

        getRandomInfo()

    }

    override fun onClick(view: View) {
        if (view.id == R.id.bt_try) {
            getRandomInfo()
        }
    }

    private fun getRandomInfo() {

        val catTitle = SecPreferences().getCategory(intentLate, "CATEGORY")
        val filteredList = categories.filter { it.title == catTitle || catTitle == "Random"}


        /* Random */
        // Essa função vai de 0 a n, sendo n não inclusivo

        // Qd a lista é filtrada por categoria, a filteredList apenas terá o índice 0
        // Mas qd a categoria é Random, preciso gerar de modo random um índice para mostrar
        // Assim, a variável abaixo irá funcionar para ambos os casos
        val indexAllList  = Random.nextInt(filteredList.size)

        // Variável para índice random de Activities (ações)
        val indexActions = Random.nextInt(filteredList[indexAllList].activities.size)

        val actionsList = filteredList[indexAllList].activities

        binding.twCatTitle.text = catTitle
        binding.twActTitle.text = actionsList[indexActions].action
        binding.twPartQt.text = actionsList[indexActions].participants.toString()
        binding.twListTitle.text = filteredList[indexAllList].title

        when (actionsList[indexActions].price) {
            0.0 -> binding.twPriceType.text = ProjectConstants.PRICERANGE.FREE
            in 0.1..0.3 -> binding.twPriceType.text = ProjectConstants.PRICERANGE.LOW
            in 0.4..0.6 -> binding.twPriceType.text = ProjectConstants.PRICERANGE.MEDIUM
            in 0.7..1.0 -> binding.twPriceType.text = ProjectConstants.PRICERANGE.HIGH
        }
    }
}