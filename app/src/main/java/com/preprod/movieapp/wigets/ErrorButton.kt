package com.preprod.movieapp.wigets

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ErrorButton(onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Nothing was found!"
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = { }) {
            Row {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Refresh button"
                )
                Text(text = "Refresh")
            }
        }
    }
}