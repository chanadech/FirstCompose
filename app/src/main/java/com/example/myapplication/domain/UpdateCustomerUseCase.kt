package com.example.myapplication.domain

import com.example.myapplication.data.Customer
import com.example.myapplication.data.CustomerRepository
import javax.inject.Inject

class UpdateCustomerUseCase @Inject constructor(private val repository: CustomerRepository) {
    suspend operator fun invoke(customer: Customer) = repository.update(customer)
}
