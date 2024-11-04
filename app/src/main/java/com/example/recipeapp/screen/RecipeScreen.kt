package com.example.recipeapp.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipeapp.network.data.Category
import com.example.recipeapp.screen.components.CategoryDetailScreen
import com.example.recipeapp.screen.components.CategoryScreen
import com.example.recipeapp.viewModel.RecipeViewModel

@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,
    navToCategoryDetail: (Category) -> Unit,
    viewState: RecipeViewModel.RecipeState
) {

    Box(modifier = Modifier.fillMaxSize())
    {
        when {
            viewState.loading -> {
                CircularProgressIndicator(
                    modifier = modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )
            }

            viewState.error != null -> {
                Text("Error Occurred")
            }

            else -> {
                CategoryScreen(categories = viewState.list, navToCategoryDetail = navToCategoryDetail )
            }

        }
    }
}