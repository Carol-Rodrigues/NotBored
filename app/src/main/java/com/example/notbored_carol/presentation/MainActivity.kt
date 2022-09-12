package com.example.notbored_carol.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.notbored_carol.R
import com.example.notbored_carol.databinding.ActivityMainBinding
import com.example.notbored_carol.infra.SecurityPreferences

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /* Binding variable */
    // Precisamos colocar como lateinit, uma vez que no OnCreate ainda não foi criado o layout
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Atribuindo valor ao binding */
        // Explicar o inflate
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Explicar a alteração
        setContentView(binding.root)

        /* Evento de clique */
        binding.btStart.setOnClickListener(this)
        binding.twTerms.setOnClickListener(this)

        /* Ocultar a ActionBar. */
        // O Kotlin nos obriga a usar o NullSafety (?) para caso não haja ActionBar
        supportActionBar?.hide()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.bt_start) {
            val activitiesIntent = Intent(this, ActivitiesActivity::class.java)
            handleSave()
            startActivity(activitiesIntent)
        } else if (view.id == R.id.tw_terms) {
            val termsIntent = Intent(this, TermsActivity::class.java)
            startActivity(termsIntent)
        }
    }

    private fun handleSave() {
        val numberOfParticipants = binding.etNumberOfParticipants.text.toString()

        if (numberOfParticipants != "") {
            SecurityPreferences(this).storeParticipants("PARTICIPANTS", numberOfParticipants)
        } else {
            SecurityPreferences(this).storeParticipants("PARTICIPANTS", "0")
        }
    }
}