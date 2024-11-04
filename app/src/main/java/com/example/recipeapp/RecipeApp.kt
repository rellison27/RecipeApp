package com.example.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipeapp.network.data.Category
import com.example.recipeapp.screen.RecipeScreen
import com.example.recipeapp.screen.components.CategoryDetailScreen
import com.example.recipeapp.screen.components.CategoryScreen
import com.example.recipeapp.viewModel.RecipeViewModel

@Composable
fun RecipeApp(navController: NavHostController) {
    val recipeViewModel: RecipeViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(
                navToCategoryDetail = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                    navController.navigate(Screen.CategoryDetailScreen.route)
                },
                viewState = viewState
            )
        }
        composable(route = Screen.CategoryDetailScreen.route) {
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")
                    ?: Category("", "", "", "")
            CategoryDetailScreen(category = category)
        }
    }
}