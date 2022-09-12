package com.example.notbored_carol.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.notbored_carol.R
import com.example.notbored_carol.databinding.ActivityTermsBinding

class TermsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityTermsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTermsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btX.setOnClickListener(this)
        //binding.checkbox.isChecked = true
    }

    override fun onClick(view: View) {
        if (view.id == R.id.bt_x) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}