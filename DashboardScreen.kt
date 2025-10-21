package com.example.uts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(
    studentList: List<Student>,
    onAddClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dashboard Siswa") },
                actions = {
                    IconButton(onClick = onAddClick) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Tambah Data"
                        )
                    }
                    IconButton(onClick = onLogoutClick) {
                        Icon(
                            imageVector = Icons.Filled.Logout,
                            contentDescription = "Logout"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TableHeader()
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(studentList) { student ->
                    StudentRow(student = student)
                    HorizontalDivider(thickness = 0.5.dp, color = Color.Gray)
                }
            }
        }
    }
}
@Composable
fun StudentRow(student: Student, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Text(text = student.id, modifier = Modifier.weight(0.7f))
        Text(text = student.name, modifier = Modifier.weight(1f))
        Text(text = student.phone, modifier = Modifier.weight(1f))
        Text(text = student.address, modifier = Modifier.weight(1.5f))
    }
}

@Composable
fun TableHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFF0F0F0))
            .padding(vertical = 10.dp, horizontal = 16.dp)
    ) {
        Text(
            text = "ID",
            modifier = Modifier.weight(0.7f),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Name",
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Phone",
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Address",
            modifier = Modifier.weight(1.5f),
            fontWeight = FontWeight.Bold
        )
    }
}