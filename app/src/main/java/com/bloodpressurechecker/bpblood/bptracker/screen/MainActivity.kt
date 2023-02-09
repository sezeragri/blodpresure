package com.bloodpressurechecker.bpblood.bptracker.screen

import android.app.Application
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bloodpressurechecker.bpblood.bptracker.R
import com.bloodpressurechecker.bpblood.bptracker.Screens.DataInfo


import com.bloodpressurechecker.bpblood.bptracker.ui.theme.BloodPressureTheme
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import java.util.*

class MainActivity : ComponentActivity() {
    lateinit var vt: AppDatabase






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vt = AppDatabase.veritabaniErisim(this)!!
        MobileAds.initialize(this) {}
        adsLoaded(this)


        setContent {

            BloodPressureTheme {
                val context = LocalContext.current
                val viewModel: AnasayfaViewModel = viewModel(
                    factory = AnasayfaViewModelFactory(context.applicationContext as Application)
                )
                LaunchedEffect(key1 = true){
                    viewModel.LoadPerson()
                    viewModel.LoadPersonbTan()
                    viewModel.LoadPersonkTan()

                }

                BottomNav(this, window)
            }


        }



    }

   /* override fun onDestroy() {
        removeInterstitial()
        super.onDestroy()
    }

    */



}








