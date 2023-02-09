package com.bloodpressurechecker.bpblood.bptracker.screen

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bloodpressurechecker.bpblood.bptracker.Screens.*
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.google.accompanist.pager.ExperimentalPagerApi


@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNav(context: Context,window: Window) {


    val context1 = LocalContext.current
    val viewModel: AnasayfaViewModel = viewModel(
        factory = AnasayfaViewModelFactory(context1.applicationContext as Application)
    )

    val state1 = remember { mutableStateOf(0) }
    val state2 = remember { mutableStateOf(0) }
    val state3 = remember { mutableStateOf(0) }
    val navController = rememberNavController()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val navigationBarState = rememberSaveable { (mutableStateOf(true)) }






    Scaffold(

        bottomBar = { if (bottomBarState.value == true) {BottomBar(navController = navController)} }

    ) {



        NavHost(
            navController = navController,
            startDestination = Screen.Login.roote,

        ) {

            composable(
                route = Screen.Login.roote
            ) {
                navigationBarState.value = true
                bottomBarState.value = false
                Login(navController)
            }

            composable(
                route = Screen.BottomNav.roote
            )
            {
                navigationBarState.value = true
                BottomNav(context = context,window)
            }
            composable(
                route = BottomBarScreen.Home.roote
            ) {
                navigationBarState.value = true
                bottomBarState.value = true
                HomeScreen(navController)
            }
            composable(
                route = BottomBarScreen.Audience.roote
            ) {
                navigationBarState.value = true
                bottomBarState.value = true


                AudienceScreen(max_value =240,navController)

            }
            composable(
                route = BottomBarScreen.Informations.roote
            ) {
                navigationBarState.value = true
                bottomBarState.value = true
                InformationsScreen(navController)
            }
            composable(
                route = BottomBarScreen.Profile.roote
            ) {
                navigationBarState.value = true
                bottomBarState.value = true
                ProfileScreen(navController)
            }

            composable(
                route = Screen.InfoDetails.roote
            ) {
                /*window.setFlags(
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,


                )

                 */

               /* window.apply {
                    clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    statusBarColor = Color.Transparent.toArgb()
                }

                */
                navigationBarState.value = false
                bottomBarState.value = false

                val json = it.arguments?.getString("data")
                val mapper = jacksonObjectMapper()
                val gonder: Data = mapper.readValue(json!!)

                if (gonder != null) {
                    InfoDetails(window,gonder)
                }
            }


             composable(route = Screen.AddValue.roote){


                 bottomBarState.value = false
                 AddValue(navController, state1,state2,state3)
             }


            composable(route = Screen.TabLayout.roote){
                bottomBarState.value = false
                TabLayout(navController)
            }

            composable(route = Screen.Understand.roote){
                bottomBarState.value = false
                Understand(navController)
            }

        }
    }
}