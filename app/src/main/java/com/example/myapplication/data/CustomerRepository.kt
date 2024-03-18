package com.example.myapplication.data

import com.example.myapplication.data.Customer
import com.example.myapplication.data.CustomerDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CustomerRepository @Inject constructor(private val customerDao: CustomerDao) {
    val allCustomers: Flow<List<Customer>> = customerDao.getAllCustomers()

    suspend fun insert(customer: Customer) = customerDao.insertCustomer(customer)

    suspend fun update(customer: Customer) = customerDao.updateCustomer(customer)

    suspend fun delete(customer: Customer) = customerDao.deleteCustomer(customer)
}
