package com.example.myapplication.domain

import com.example.myapplication.data.Customer
import com.example.myapplication.data.CustomerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCustomersUseCase @Inject constructor(private val repository: CustomerRepository) {
    operator fun invoke(): Flow<List<Customer>> = repository.allCustomers
}




