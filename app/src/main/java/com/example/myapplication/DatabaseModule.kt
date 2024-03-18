package com.example.myapplication

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.AppDatabase
import com.example.myapplication.data.CustomerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "your_database_name"
        ).build()
    }

    @Provides
    fun provideCustomerDao(appDatabase: AppDatabase): CustomerDao {
        return appDatabase.customerDao()
    }
}
