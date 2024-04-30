package com.seismic.notes.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.seismic.notes.R
import com.seismic.notes.data.Note
import com.seismic.notes.data.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(
    navController: NavController,
    noteViewModel: NoteViewModel,
) {
    val customFontFamily = FontFamily(
        Font(R.font.product_sans_regular)
    )
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                title = {
                    Text(
                        text = "Add Note",
                        color = MaterialTheme.colorScheme.primary,
                        fontFamily = customFontFamily
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, top = 8.dp, end = 32.dp),
                value = title,
                onValueChange = { title = it },
                singleLine = true,
                textStyle = TextStyle(
                    fontFamily = customFontFamily,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground
                ),
                label = {
                    Text(
                        text = "Enter Title",
                        fontFamily = customFontFamily
                    )
                }

            )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, top = 8.dp, end = 32.dp, bottom = 16.dp),
                value = description,
                onValueChange = { description = it },
                textStyle = TextStyle(
                    fontFamily = customFontFamily,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground
                ),
                label = {
                    Text(
                        text = "Enter Description",
                        fontFamily = customFontFamily
                    )
                }
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    modifier = Modifier.padding(start = 100.dp),
                    onClick = {
                        noteViewModel.addNote(
                            Note(
                                title = title,
                                description = description
                            )
                        )
                        navController.navigateUp()
                    }
                ) {
                    Text(
                        text = "Save",
                        fontFamily = customFontFamily
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Button(
                    modifier = Modifier.padding(end = 100.dp),
                    onClick = {
                        navController.navigateUp()
                    }
                ) {
                    Text(
                        text = "Cancel",
                        fontFamily = customFontFamily
                    )
                }
            }
        }
    }
}