package com.bloodpressurechecker.bpblood.bptracker.screen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AnasayfaViewModelFactory(var application: Application) : ViewModelProvider.NewInstanceFactory() {  // bu sınıfın amacı abasaufaViewModele appliicationu göndermek olacak


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AnasayfaViewModel(application) as T
    }
}
