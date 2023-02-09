package com.bloodpressurechecker.bpblood.bptracker.screen

import com.bloodpressurechecker.bpblood.bptracker.R

sealed class BottomBarScreen(
    val roote : String ,
    val title : String,
    val icon : Int,
    val icon_Focused : Int
)
{
    object Home : BottomBarScreen(
        roote = "home_screen",
        title = "Home",
        icon = R.drawable.ic_home,
        icon_Focused = R.drawable.ic_home_focused
    )
    // audience
    object Audience : BottomBarScreen(
        roote = "audience",
        title = "Tracker",
        icon = R.drawable.ic_audience,
        icon_Focused = R.drawable.ic_audience_focused
    )

    // Informations
    object Informations : BottomBarScreen(
        roote = "Informations",
        title = "Info",
        icon = R.drawable.information,
        icon_Focused = R.drawable.information_focused

    )

    // Profile

    object Profile :  BottomBarScreen(
        roote = "profile",
        title = "Settings",
        icon = R.drawable.ic_profile,
        icon_Focused = R.drawable.ic_profile_focused

    )
}
