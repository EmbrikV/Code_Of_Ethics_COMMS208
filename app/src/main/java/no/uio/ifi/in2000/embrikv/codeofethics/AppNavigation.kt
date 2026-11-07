package no.uio.ifi.in2000.embrikv.codeofethics

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import no.uio.ifi.in2000.embrikv.codeofethics.ui.viewModels.HomeViewModel
import no.uio.ifi.in2000.embrikv.codeofethics.ui.composables.DetailScreen
import no.uio.ifi.in2000.embrikv.codeofethics.ui.composables.HomeScreen


object Routes {
    const val HOME = "home"
    const val DETAIL = "detail/{number}"
    fun detail(number: Int) = "detail/$number"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val viewModel: HomeViewModel = viewModel()

    NavHost(navController = navController, startDestination = Routes.HOME) {

        composable(Routes.HOME) {
            HomeScreen(
                viewModel = viewModel,
                onCodeClick = { number -> navController.navigate(Routes.detail(number)) }
            )
        }

        composable(
            route = Routes.DETAIL,
            arguments = listOf(navArgument("number") { type = NavType.IntType })
        ) { backStackEntry ->
            val number = backStackEntry.arguments?.getInt("number") ?: 0
            val code = viewModel.uiState.items.find { it.number == number }
            DetailScreen(
                code = code,
                onBack = { navController.popBackStack() }
            )
        }
    }
}