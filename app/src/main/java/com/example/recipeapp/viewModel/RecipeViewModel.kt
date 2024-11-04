package com.example.recipeapp.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.network.data.Category
import com.example.recipeapp.network.data.recipeService
import kotlinx.coroutines.launch
import java.lang.Exception

class RecipeViewModel: ViewModel() {

    private val _categoriesState = mutableStateOf(RecipeState())

    val categoriesState= _categoriesState

    init {
        fetchCategories()
    }

    private fun fetchCategories()
    {
        viewModelScope.launch {
            try
            {
                val categoriesResponse = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    list = categoriesResponse.categories
                )
            } catch (e: Exception)
            {
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "error fetching Categories ${e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )
}