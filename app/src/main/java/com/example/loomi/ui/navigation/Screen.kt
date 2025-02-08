package com.example.loomi.ui.navigation

import com.example.loomi.constant.Const

sealed class Screen(val route: String) {

    data object HomeScreen : Screen(Const.Cons.HOME)
    data object CourseScreen : Screen(Const.Cons.COURSE)
    data object ProfileScreen : Screen(Const.Cons.PROFILE)
    data object LoginScreen : Screen(Const.Cons.LOGIN)

    data object RegisterScreen : Screen(Const.Cons.REGISTER)

    // Dynamic route for DetailLearn
    data object DetailCourse : Screen(Const.Cons.DETAIL_COURSE) {
        fun createRoute(courseId: Int) = "home/$courseId"  // Dynamic route with parameter
    }
}
