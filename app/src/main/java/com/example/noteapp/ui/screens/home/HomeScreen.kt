package com.example.noteapp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.ui.theme.colorBlack
import com.example.noteapp.ui.theme.colorGrey
import com.example.noteapp.ui.theme.colorLightGray
import com.example.noteapp.ui.theme.colorRed

@Composable
@Preview
fun HomeScreen() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                containerColor = colorRed,
                shape = RoundedCornerShape(100.dp),
                onClick = { },
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Icon",
                    tint = Color.White
                )
            }
        }
    ) {innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(colorBlack)
        ) {
            Column(
                modifier = Modifier.padding(all = 20.dp)
            ) {
                Text(
                    text = "Create Notes\nCrud",
                    style = TextStyle(
                        fontSize = 32.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ),
                )
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                LazyColumn {
                    items(10) { index ->
                        ItemCard(index)
                    }
                }
            }
        }
    }
}

@Composable
fun ItemCard(index: Int) {
    Box(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .background(colorGrey, shape = RoundedCornerShape(10.dp))
    ) {
        Column(modifier = Modifier.padding(all = 10.dp)) {
            Text(
                text = "Item Number $index",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600
                )
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Text(
                text = "This is an item",
                style = TextStyle(
                    color = colorLightGray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400
                )
            )
        }
    }
}