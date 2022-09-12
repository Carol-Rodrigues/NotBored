package com.example.notbored_carol.infra

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val security: SharedPreferences =
        context.getSharedPreferences("Not Bored", Context.MODE_PRIVATE)

    fun storeParticipants(key: String, str: String) {
        security.edit().putString(key, str).apply()
    }

    fun getParticipants(key: String): Int {
        return security.getString(key, "")?.toInt() ?: 0
    }
}

class SecPreferences {

    fun storeCategory(intent: Intent, key: String, category: String) {
        intent.putExtra(key, category)
    }

    fun getCategory(intent: Intent, key: String): String? {
        return intent.getStringExtra(key)
    }
}