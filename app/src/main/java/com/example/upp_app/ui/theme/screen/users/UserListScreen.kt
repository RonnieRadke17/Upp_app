package com.example.upp_app.ui.theme.screen.users
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.upp_app.viewmodel.UserViewModel
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(userViewModel: UserViewModel = viewModel()) {

    LaunchedEffect(Unit) {
        userViewModel.fetchUsers()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Usuarios desde Laravel") }
            )
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(userViewModel.userList) { user ->
                ListItem(
                    headlineContent = { Text(user.name) },
                    supportingContent = { Text(user.email) }

                )
                HorizontalDivider()
            }
        }
    }
}

