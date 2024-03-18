package com.example.myapplication

import androidx.lifecycle.ViewModel
import com.example.myapplication.presentation.CustomerViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import dagger.hilt.android.lifecycle.HiltViewModel

@Module
@InstallIn(SingletonComponent::class)
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CustomerViewModel::class)
    abstract fun bindCustomerViewModel(customerViewModel: CustomerViewModel): ViewModel
}

