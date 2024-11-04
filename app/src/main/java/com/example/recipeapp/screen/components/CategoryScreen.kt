package com.example.recipeapp.screen.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.recipeapp.network.data.Category


@Composable
fun CategoryScreen(categories: List<Category>, navToCategoryDetail: (Category) -> Unit)
{
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ){
        items(categories) {category ->
            CategoryItem(category = category, navToCategoryDetail)
        }
    }
    
}
