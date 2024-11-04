package com.example.recipeapp.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.recipeapp.network.data.Category

@Composable
fun CategoryItem(category: Category, navToCategoryDetail: (Category) -> Unit)
{
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navToCategoryDetail(category)
            }
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Image(
                painter = rememberAsyncImagePainter(category.strCategoryThumb),
                contentDescription = category.strCategoryDescription,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)
            )
            Text(
                text = category.strCategory,
                color = Color.Black,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 4.dp)
            )
    }
}