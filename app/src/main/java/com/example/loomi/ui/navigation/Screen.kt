package com.example.loomi.ui.navigation

import com.example.loomi.constant.Const

sealed class Screen(val route: String) {

    object HomeScreen : Screen(Const.Cons.HOME)
    object CourseScreen : Screen(Const.Cons.COURSE)
    object ProfileScreen : Screen(Const.Cons.PROFILE)

    // Dynamic route for DetailLearn
    object DetailCourse : Screen(Const.Cons.DETAIL_COURSE) {
        fun createRoute(courseId: Int) = "home/$courseId"  // Dynamic route with parameter
    }
}
