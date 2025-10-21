package com.example.uts

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class Student(
    val id: String,
    val name: String,
    val phone: String,
    val address: String
)
data class StudentUiState(
    val isLoggedIn: Boolean = false,
    val showAddForm: Boolean = false,
    val students: List<Student> = emptyList()
)

class StudentViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(StudentUiState())
    val uiState: StateFlow<StudentUiState> = _uiState.asStateFlow()
    init {
        loadInitialStudents()
    }

    private fun loadInitialStudents() {
        val initialList = listOf(
            Student("1001", "Aselole", "08123456", "Jl. Jalan 1"),
            Student("1002", "Anjay", "08234567", "Jl. Jalan 2"),
            Student("1003", "Sybau", "08345678", "Jl. Jalan 3")
        )
        _uiState.update { it.copy(students = initialList) }
    }
    fun onLogin(username: String, password: String): Boolean {
        val correctUsername = "admin"
        val correctPassword = "password123"

        if (username == correctUsername && password == correctPassword) {
            _uiState.update { it.copy(isLoggedIn = true) }
            return true
        }
        return false
    }
    fun onLogout() {
        _uiState.update {
            it.copy(
                isLoggedIn = false,
                showAddForm = false
            )
        }
    }
    fun onShowAddForm() {
        _uiState.update { it.copy(showAddForm = true) }
    }

    fun onHideAddForm() {
        _uiState.update { it.copy(showAddForm = false) }
    }

    fun onRegisterStudent(newStudent: Student) {
        // Update state:
        _uiState.update { currentState ->
            currentState.copy(
                students = currentState.students + newStudent,
                showAddForm = false
            )
        }
    }
}