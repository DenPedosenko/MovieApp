package com.preprod.movieapp.wigets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.preprod.movieapp.model.Movie
import com.preprod.movieapp.model.getMovies

@ExperimentalAnimationApi
@Preview
@Composable
fun MovieRow(
    movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}
) {
    var expended by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable { onItemClick(movie.id) },
        shape = RoundedCornerShape(CornerSize(16.dp)),
        elevation = 6.dp,

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = CircleShape,
                elevation = 4.dp
            ) {

                Image(
                    painter = rememberImagePainter(
                        data = movie.images[0],
                        builder = {
                            crossfade(true)
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(128.dp)
                )
            }
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Rate: ${movie.rating}", style = MaterialTheme.typography.caption)
                Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.caption)
                AnimatedVisibility(visible = expended) {
                    Column {
                        Text(buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontSize = 13.sp
                                )
                            ) {
                                append("Plot: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Light
                                )
                            ) {
                                append(movie.plot)
                            }
                        }, modifier = Modifier.padding(6.dp))
                        Divider(modifier = Modifier.padding(3.dp))
                        Text(
                            text = "Director: ${movie.director}",
                            style = MaterialTheme.typography.caption
                        )
                        Text(
                            text = "Actors: ${movie.actors}",
                            style = MaterialTheme.typography.caption
                        )

                    }
                }
                Icon(
                    imageVector = if (expended) Icons.Filled.KeyboardArrowUp else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down arrow",
                    modifier = Modifier
                        .size(25.dp)
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            expended = !expended
                        },
                    tint = Color.DarkGray
                )
            }
        }
    }
}