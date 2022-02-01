package com.preprod.movieapp.wigets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation

@Composable
fun HorizontalScrollableImageView(images: List<String>) {
    LazyRow {
        items(images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp
            ) {
                Image(
                    painter = rememberImagePainter(data = image,
                        builder = {
                            transformations(RoundedCornersTransformation(0.4f))
                        }),
                    contentDescription = "Movie Image"
                )
            }
        }
    }
}