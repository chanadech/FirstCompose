package com.example.myapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Use by viewModels() to get the ViewModel
                    val viewModel: CustomerViewModel by viewModels()
                    val customers = viewModel.allCustomers.collectAsState().value

                    LazyColumn {
                        items(customers.size) { index ->
                            val customer = customers[index]
                            // Update the text to display the customer properties you want to show
                            Text(text = "Name: ${customer.ownerName}, Phone: ${customer.phoneNumber}")
                        }
                    }
                }
            }
        }
    }
}



