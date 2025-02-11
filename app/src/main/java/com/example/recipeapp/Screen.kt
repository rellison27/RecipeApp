package com.example.recipeapp

sealed class Screen(val route: String) {
    object RecipeScreen:Screen("recipescreen")
    object CategoryDetailScreen:Screen("categorydetailscreen")
}