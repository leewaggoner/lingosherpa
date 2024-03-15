package com.wreckingballsoftware.di

import com.wreckingballsoftware.lingosherpa.ui.mainscreen.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MainScreenViewModel(get())
    }
}