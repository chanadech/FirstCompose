package com.example.myapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Customer(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: String,
    val time: String,
    val ownerName: String,
    val petName: String,
    val address: String,
    val phoneNumber: String,
    val symptoms: String,
    val petType: String,
    val petGender: String,
    val petColor: String,
    val petAge: String,
    val treatmentType: String,
    val paymentReceived: Double
)
