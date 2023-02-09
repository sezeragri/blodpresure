package com.bloodpressurechecker.bpblood.bptracker.screen

sealed class Screen(val roote : String) {


    object Login : Screen("login")
    object  BottomNav : Screen("bottom_nav")
    object InfoDetails : Screen("info_details/data={data}")
    object TabLayout : Screen ("tab_layout")
    object AddValue : Screen ("add_value")
    object Understand : Screen ("understand")




}