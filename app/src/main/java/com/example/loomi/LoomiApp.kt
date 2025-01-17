package com.example.loomi

import androidx.compose.foundation.background
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.loomi.ui.navigation.Screen
//import androidx.compose.material.BottomNavigation
import androidx.compose.material3.MaterialTheme
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.google.android.material.bottomnavigation.BottomNavigationView


@Composable
fun LoomiApp(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
//
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


//    Scaffold(
//        bottomBar = {
//            if (currentRoute != Screen.DetailLearn.route) {
//
//
//            }
//        }
//    )

}

//@Composable
//fun BottomBarNavigation(
//    navController: NavHostController,
//    modifier: Modifier = Modifier
//) {
//    BottomNavigation (
//        modifier = modifier
//    ) {
//        val navBackStackEntry by navController.currentBackStackEntryAsState()
//        val currentRoute = navBackStackEntry?.destination?.route
//
//        Screen.values().forEach { screen ->
//            BottomNavigationItem(
//                icon = {
//                    screen.icon?.let { icon ->
//                        Icon(
//                            imageVector = icon,
//                            contentDescription = screen.title
//                        )
//                    }
//                },
//                label = { Text(text = screen.title) },
//                selected = currentRoute == screen.route,
//                onClick = {
//                    navController.navigate(screen.route) {
//                        popUpTo(navController.graph.findStartDestination().id) {
//                            saveState = true
//                        }
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                }
//            )
//        }
//    }
//}


