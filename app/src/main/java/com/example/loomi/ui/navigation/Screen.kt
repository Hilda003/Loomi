package com.example.loomi.ui.navigation

sealed class Screen(val route: String) {

    object HomeScreen : Screen("home")
    object LearnScreen : Screen("favorite")
    object ProfileScreen : Screen("profile")
    object DetailLearn : Screen("home/{learnId}") {
        fun createRoute(foodId: Int) = "home/$foodId"
    }
}