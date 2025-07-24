package com.example.noteapp.ui.screens.add_edit_note

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.noteapp.model.Note
import com.example.noteapp.ui.components.NoteTextField
import com.example.noteapp.ui.theme.colorBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditNoteScreen(
    navController: NavController,
    note: Note?,
) {
    // Obtain FocusManager
    val focusManager = LocalFocusManager.current

    // Create FocusRequesters
    val titleFocusRequester = remember { FocusRequester() }
    val descriptionFocusRequester = remember { FocusRequester() }


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
                    IconButton(onClick = { navController.popBackStack() }) {
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

                    val isValid =
                        titleErrorState.value == null && descriptionErrorState.value == null
                    if (isValid) {
                        // Save note logic "
                        
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
                .clickable() {
                    focusManager.clearFocus()
                }
        ) {
            NoteTextField(
                value = titleState.value,
                onValueChange = {
                    titleState.value = it
                    titleErrorState.value = if (it.isBlank()) "Title cannot be empty" else null
                },
                label = "Title",
                minLines = 1,
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
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
                minLines = 1,
                maxLines = 5,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {

                        focusManager.clearFocus()
                    }
                ),
                isError = descriptionErrorState.value != null,
                errorMessage = descriptionErrorState.value,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
    }
}

