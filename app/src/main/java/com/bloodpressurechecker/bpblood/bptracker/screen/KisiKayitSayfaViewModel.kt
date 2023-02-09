package com.bloodpressurechecker.bpblood.bptracker.screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class KisiKayitSayfaViewModel(application: Application) : AndroidViewModel(application) {
    var krepo = BPTrackerDaoRepository(application)

    fun kayit(person_id : Int , bTan : Int , ktan : Int , nabiz : Int,date : String){
        krepo.kisiKayit(person_id, bTan,ktan,nabiz,date)
    }



}

class KisiSilSayfaViewModel(application: Application) : AndroidViewModel(application) {
    var krepo = BPTrackerDaoRepository(application)

    fun sil(person_id : Int , bTan : Int , ktan : Int , nabiz : Int,date : String){
        krepo.kisiSil(person_id, bTan,ktan,nabiz,date)

    }



}

