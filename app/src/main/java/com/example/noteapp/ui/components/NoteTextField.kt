package com.example.noteapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.noteapp.ui.theme.colorBlack
import com.example.noteapp.ui.theme.colorGrey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isError: Boolean = false,
    errorMessage: String? = null,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default
) {
    Column {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label, style = TextStyle(color = Color.White)) },
            modifier = modifier,
            shape = RoundedCornerShape(10.dp),
            textStyle = textStyle,
            isError = isError,
            colors = TextFieldDefaults.colors(
                focusedTextColor = colorBlack,
                unfocusedTextColor = colorBlack,
                focusedContainerColor = colorGrey,
                unfocusedContainerColor = colorGrey,
                focusedIndicatorColor = if (isError) MaterialTheme.colorScheme.error else Color.Transparent,
                unfocusedIndicatorColor = if (isError) MaterialTheme.colorScheme.error else Color.Transparent
            )
        )
        if (isError && errorMessage != null) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 4.dp, top = 4.dp)
            )
        }
    }
}
