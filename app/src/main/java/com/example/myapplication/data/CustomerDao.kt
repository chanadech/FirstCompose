package com.example.myapplication.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.data.Customer
import dagger.Provides
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {
    @Query("SELECT * FROM customer")
    fun getAllCustomers(): Flow<List<Customer>>

    @Insert
    suspend fun insertCustomer(customer: Customer)

    @Update
    suspend fun updateCustomer(customer: Customer)

    @Delete
    suspend fun deleteCustomer(customer: Customer)
}
