package com.bloodpressurechecker.bpblood.bptracker.screen

import android.app.Application
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class BPTrackerDaoRepository(var application: Application) {
    private var personList = MutableLiveData<List<BPTracker>>()
    private var personSil = MutableLiveData<List<BPTracker>>()
    private var personbTan = MutableLiveData<List<BPTracker>>()
    private var personkTan = MutableLiveData<Int>()
    private var personmaxbTan = MutableLiveData<Int>()
    private var personmaxkTan = MutableLiveData<Int>()
    private var personmaxNabiz = MutableLiveData<Int>()
    private var personminbTan = MutableLiveData<Int>()
    private var personminkTan = MutableLiveData<Int>()
    private var personminNabiz = MutableLiveData<Int>()



    var vt : AppDatabase


    init {

        vt = AppDatabase.veritabaniErisim(application)!!
        personList = MutableLiveData()
        personSil = MutableLiveData()
        personbTan = MutableLiveData()
        personkTan = MutableLiveData()
        personmaxbTan = MutableLiveData()
        personmaxkTan = MutableLiveData()
        personmaxNabiz = MutableLiveData()
        personminbTan = MutableLiveData()
        personminkTan = MutableLiveData()
        personminNabiz = MutableLiveData()


    }

    fun getPersonList(): MutableLiveData<List<BPTracker>> {
        return personList
    }
    fun getPersonSil(): MutableLiveData<List<BPTracker>> {
        return personSil
    }


    fun getpersonbTan() : MutableLiveData<List<BPTracker>>
    {

        return personbTan
    }

    fun getpersonkTan() : MutableLiveData<Int>{

        return personkTan
    }
    fun getPersonMaxbTan() : MutableLiveData<Int>{
        return  personmaxbTan
    }
    fun getPersonMaxkTan() : MutableLiveData<Int>{
        return  personmaxkTan
    }
    fun getPersonMaxnabiz() : MutableLiveData<Int>{
        return  personmaxNabiz
    }
    fun getPersonMinbTan() : MutableLiveData<Int>{
        return  personminbTan
    }
    fun getPersonMinkTan() : MutableLiveData<Int>{
        return  personminkTan
    } fun getPersonMinnabiz() : MutableLiveData<Int>{
        return  personminNabiz
    }








    fun tumPersonAl(){

        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            personList.value = vt.kisilerDao().tumKisiler()
        }
    }

    fun buyukTansiyonAl() {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
           personbTan.value = vt.kisilerDao().buyukTansiyon()
        }
    }

    fun kucukTansiyonAl(){
        val job : Job = CoroutineScope(Dispatchers.Main).launch {

            personkTan.value = vt.kisilerDao().kucukTansiyon()
        }
    }

    fun kisiKayit(person_id : Int , bTan : Int , ktan : Int , nabiz : Int, date : String){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val yeniKisi = BPTracker(person_id, bTan,ktan,nabiz,date)
            vt.kisilerDao().kisiEkle(yeniKisi)

        }
    }

    fun kisiSil(person_id: Int,bTan: Int,ktan: Int,nabiz: Int,date: String){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val silinenKisi = BPTracker(person_id, bTan,ktan,nabiz,date)
            vt.kisilerDao().kisiSil(silinenKisi)
        }
    }




    fun maxBtanAlma(){
        val job : Job = CoroutineScope(Dispatchers.Main).launch {
            personmaxbTan.value = vt.kisilerDao().maxBtanAl()
        }
    }

    fun maxKtanAlma(){
        val job : Job = CoroutineScope(Dispatchers.Main).launch {
            personmaxkTan.value = vt.kisilerDao().maxKtanAl()
        }
    }

    fun maxNabizAlma(){
        val job : Job = CoroutineScope(Dispatchers.Main).launch {
            personmaxNabiz.value = vt.kisilerDao().maxNabizAl()
        }
    }

    fun minBtanAlma(){
        val job : Job = CoroutineScope(Dispatchers.Main).launch {
            personminbTan.value = vt.kisilerDao().minBtanAl()
        }
    }

    fun minKtanAlma(){
        val job : Job = CoroutineScope(Dispatchers.Main).launch {
            personminkTan.value = vt.kisilerDao().minKtanAl()
        }
    }

    fun minNanbizAlma(){
        val job : Job = CoroutineScope(Dispatchers.Main).launch {
            personminNabiz.value = vt.kisilerDao().minNabizAl()
        }
    }



}