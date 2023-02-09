package com.bloodpressurechecker.bpblood.bptracker.screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class AnasayfaViewModel(application: Application) : AndroidViewModel(application) {

    var personList = MutableLiveData<List<BPTracker>>()
    var personbTan = MutableLiveData<List<BPTracker>>()
    var personkTan = MutableLiveData<Int>()
    var personMaxBtan = MutableLiveData<Int>()
    var personMaxKtan = MutableLiveData<Int>()
    var personMaxNabiz = MutableLiveData<Int>()
    var personMinBtan = MutableLiveData<Int>()
    var personMinKtan = MutableLiveData<Int>()
    var personMinNabiz = MutableLiveData<Int>()





    var personRepo = BPTrackerDaoRepository(application)

    init {

        LoadPerson()
        LoadPersonbTan()
        LoadPersonkTan()
        LoadMaxBtan()
        LoadMaxKtan()
        LoadMaxNabiz()
        LoadMinBtan()
        LoadMinKtan()
        LoadMinNabiz()
        personList = personRepo.getPersonList()
        personbTan = personRepo.getpersonbTan()
        personkTan = personRepo.getpersonkTan()
        personMaxBtan = personRepo.getPersonMaxbTan()
        personMaxKtan = personRepo.getPersonMaxkTan()
        personMaxNabiz = personRepo.getPersonMaxnabiz()
        personMinBtan = personRepo.getPersonMinbTan()
        personMinKtan = personRepo.getPersonMinkTan()
        personMinNabiz = personRepo.getPersonMinnabiz()




    }

    fun LoadPerson() {

        personRepo.tumPersonAl()

    }

    fun LoadPersonbTan(){
        personRepo.buyukTansiyonAl()
    }

    fun LoadPersonkTan(){
        personRepo.kucukTansiyonAl()
    }

    fun LoadMaxBtan(){
        personRepo.maxBtanAlma()
    }

    fun LoadMaxKtan(){
        personRepo.maxKtanAlma()
    }
    fun LoadMaxNabiz(){
        personRepo.maxNabizAlma()
    }
    fun LoadMinBtan(){
        personRepo.minBtanAlma()
    }
    fun LoadMinKtan(){
        personRepo.minKtanAlma()
    } fun LoadMinNabiz(){
        personRepo.minNanbizAlma()
    }





}