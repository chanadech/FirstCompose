package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.Customer
import com.example.myapplication.domain.DeleteCustomerUseCase
import com.example.myapplication.domain.GetCustomersUseCase
import com.example.myapplication.domain.InsertCustomerUseCase
import com.example.myapplication.domain.UpdateCustomerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomerViewModel @Inject constructor(
    private val getCustomersUseCase: GetCustomersUseCase,
    private val insertCustomerUseCase: InsertCustomerUseCase,
    private val updateCustomerUseCase: UpdateCustomerUseCase,
    private val deleteCustomerUseCase: DeleteCustomerUseCase
) : ViewModel() {

    private val _allCustomers = MutableStateFlow<List<Customer>>(emptyList())
    val allCustomers: StateFlow<List<Customer>> = _allCustomers.asStateFlow()

    init {
        viewModelScope.launch {
            getCustomersUseCase().collect { customers ->
                _allCustomers.value = customers
            }
        }
    }

    fun insert(customer: Customer) = viewModelScope.launch {
        insertCustomerUseCase(customer)
    }

    fun update(customer: Customer) = viewModelScope.launch {
        updateCustomerUseCase(customer)
    }

    fun delete(customer: Customer) = viewModelScope.launch {
        deleteCustomerUseCase(customer)
    }
}
