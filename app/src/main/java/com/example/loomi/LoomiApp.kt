package com.example.loomi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.loomi.ui.navigation.Navigation
import com.example.loomi.ui.navigation.Screen
import com.example.loomi.ui.screen.CourseScreen
import com.example.loomi.ui.screen.HomeScreen
import com.example.loomi.ui.screen.ProfileScreen
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.example.loomi.data.repository.FirebaseAuthRepository
import com.example.loomi.ui.screen.LoginScreen
import com.example.loomi.ui.screen.RegisterScreen
import com.google.firebase.auth.FirebaseAuth


@Composable
fun LoomiApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val firebaseAuth = FirebaseAuth.getInstance()
    val firebaseAuthRepository = FirebaseAuthRepository(firebaseAuth)
    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            if (currentRoute != Screen.RegisterScreen.route && currentRoute != Screen.LoginScreen.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.RegisterScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.HomeScreen.route) {
                HomeScreen()
            }
            composable(Screen.CourseScreen.route) {
                CourseScreen()
            }
            composable(Screen.ProfileScreen.route) {
                ProfileScreen()
            }
            composable(Screen.LoginScreen.route) {
                LoginScreen(navController = navController, firebaseAuthRepository = firebaseAuthRepository)
            }
            composable(Screen.RegisterScreen.route) {
                RegisterScreen(navController = navController, firebaseAuthRepository = firebaseAuthRepository)
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navigationItems = listOf(
        Navigation(
            title = stringResource(R.string.home),
            selectedIcon = painterResource(id = R.drawable.ic_home_selected), // Icon for selected state
            unselectedIcon = painterResource(id = R.drawable.ic_home_unselected), // Icon for unselected state
            screen = Screen.HomeScreen // Correct screen reference
        ),
        Navigation(
            title = stringResource(R.string.Courses),
            selectedIcon = painterResource(id = R.drawable.ic_course_selected),
            unselectedIcon = painterResource(id = R.drawable.ic_course_unselected),
            screen = Screen.CourseScreen
        ),
        Navigation(
            title = stringResource(R.string.profile),
            selectedIcon = painterResource(id = R.drawable.ic_person_selected),
            unselectedIcon = painterResource(id = R.drawable.ic_person_unselected),
            screen = Screen.ProfileScreen
        ),
    )

    Box(modifier = modifier
        .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp),
            shape = RoundedCornerShape(8.dp),
        ){
            BottomNavigation(
                modifier = modifier.navigationBarsPadding(),
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            ) {
                navigationItems.map { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter = if (currentRoute == item.screen.route) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.title,
                                modifier = Modifier.size(27.dp)
                            )
                        },
                        label = {
                            Text(
                                text = item.title,
                                fontSize = 12.sp
                            )
                        },
                        selected = currentRoute == item.screen.route,
                        onClick = {
                            navController.navigate(item.screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                restoreState = true
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }

    }
}