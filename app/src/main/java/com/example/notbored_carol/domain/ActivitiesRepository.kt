package com.example.notbored_carol.domain

import com.example.notbored_carol.data.Activity
import com.example.notbored_carol.data.Category

class ActivitiesRepository {

    fun getCategories(): List<Category> {
        return listOf(
            Category("Education", getEducation()),
            Category("Recreational", getRecreational()),
            Category("Social", getSocial()),
            Category("DIY", getDIY()),
            Category("Charity", getCharity()),
            Category("Cooking", getCooking()),
            Category("Relaxation", getRelaxation()),
            Category("Music", getMusic()),
            Category("Busywork", getBusywork())
        )
    }

    private fun getEducation(): List<Activity> {
        return listOf(
            Activity( action = "Learn origami", price = 0.2, participants = 1),
            Activity( action = "Learn how to write in shorthand", price = 0.0, participants = 1),
            Activity( action = "Learn about the Golden Ratio", price = 0.1, participants = 1),
        )
    }

    private fun getRecreational(): List<Activity> {
        return listOf(
            Activity( action = "Start a garden", price = 0.3, participants = 1),
            Activity( action = "Go see a Broadway production", price = 0.8, participants = 4),
            Activity( action = "Paint the first thing you see", price = 0.25, participants = 1),
        )
    }

    private fun getSocial(): List<Activity> {
        return listOf(
            Activity( action = "Go see a movie in theaters with a few friends", price = 0.2, participants = 4),
            Activity( action = "Compliment someone", price = 0.0, participants = 2),
            Activity( action = "Do something nice for someone you care about", price = 0.0, participants = 1),
        )
    }

    private fun getDIY(): List<Activity> {
        return listOf(
            Activity( action = "Make a scrapbook with pictures of your favorite memories", price = 0.1, participants = 1),
            Activity( action = "Find a DIY to do", price = 0.4, participants = 1),
            Activity( action = "Learn woodworking", price = 0.3, participants = 1),
        )
    }

    private fun getCharity(): List<Activity> {
        return listOf(
            Activity( action = "Mow your neighbor's lawn", price = 0.0, participants = 1),
            Activity( action = "Donate blood at a local blood center", price = 0.5, participants = 2),
            Activity( action = "Find a charity and donate to it", price = 0.9, participants = 3),
        )
    }

    private fun getCooking(): List<Activity> {
        return listOf(
            Activity( action = "Create a meal plan for the coming week", price = 0.0, participants = 1),
            Activity( action = "Make bread from scratch", price = 0.2, participants = 1),
            Activity( action = "Learn a new recipe", price = 0.1, participants = 1),
        )
    }

    private fun getRelaxation(): List<Activity> {
        return listOf(
            Activity( action = "Take a caffeine nap", price = 0.3, participants = 1),
            Activity( action = "Go stargazing", price = 0.6, participants = 1),
            Activity( action = "Watch a movie you'd never usually watch", price = 0.1, participants = 1),
        )
    }

    private fun getMusic(): List<Activity> {
        return listOf(
            Activity( action = "Have a jam session with your friends", price = 0.7, participants = 4),
            Activity( action = "Start a band", price = 1.0, participants = 4),
            Activity( action = "Write a song", price = 0.0, participants = 1),
        )
    }

    private fun getBusywork(): List<Activity> {
        return listOf(
            Activity( action = "Draft your living will", price = 0.2, participants = 1),
            Activity( action = "Organize your dresser", price = 0.0, participants = 1),
            Activity( action = "Create and follow a savings plan", price = 0.6, participants = 1),
        )
    }
}