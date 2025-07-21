package com.example.noteapp.ui.screens.add_edit_note

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.ui.components.NoteTextField
import com.example.noteapp.ui.theme.colorBlack
import com.example.noteapp.ui.theme.colorGrey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun AddEditNoteScreen() {
    val titleState = remember { mutableStateOf("") }
    val titleErrorState = remember { mutableStateOf<String?>(null) }

    val descriptionState = remember { mutableStateOf("") }
    val descriptionErrorState = remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Add/Edit Note",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = colorBlack)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    titleErrorState.value =
                        if (titleState.value.isBlank()) "Title cannot be empty" else null
                    descriptionErrorState.value =
                        if (descriptionState.value.isBlank()) "Description cannot be empty" else null

                    val isValid = titleErrorState.value == null && descriptionErrorState.value == null
                    if (isValid) {
                        // Save note logic
                    }
                },
                containerColor = Color.Red,
                shape = RoundedCornerShape(100.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Save",
                    tint = Color.White
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(colorBlack)
                .padding(16.dp)
        ) {
            NoteTextField(
                value = titleState.value,
                onValueChange = {
                    titleState.value = it
                    titleErrorState.value = if (it.isBlank()) "Title cannot be empty" else null
                },
                label = "Title",
                isError = titleErrorState.value != null,
                errorMessage = titleErrorState.value,
                textStyle = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            NoteTextField(
                value = descriptionState.value,
                onValueChange = {
                    descriptionState.value = it
                    descriptionErrorState.value =
                        if (it.isBlank()) "Description cannot be empty" else null
                },
                label = "Description",
                isError = descriptionErrorState.value != null,
                errorMessage = descriptionErrorState.value,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
    }
}

