package ua.edu.chnu.labo6.ui.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ua.edu.chnu.labo6.ui.about.AboutPage
import ua.edu.chnu.labo6.ui.home.HomePage

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier,
    ) {
        composable(Screen.Home.route) {
            HomePage(
                onAboutButtonClick = { navController.navigate(Screen.AboutDevice.route) }
            )
        }

        composable(Screen.AboutDevice.route) {
            AboutPage(
                onUpButtonClick = { navController.popBackStack() }
            )
        }
    }
}
