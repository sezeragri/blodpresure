package com.bloodpressurechecker.bpblood.bptracker.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(navController: NavController) {

    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Audience,
        BottomBarScreen.Informations,
        BottomBarScreen.Profile
    )
    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination


    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .height(60.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController as NavHostController
            )

        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {

    val selected = currentDestination?.hierarchy?.any { it.route == screen.roote } == true
    val background =
        if (selected) Color.White else Color.Transparent

    val contentColor =
        if (selected) Color.Black else  Color.Gray

    Column(
        modifier = Modifier
            .height(70.dp)
            .width(82.dp)
            //.fillMaxWidth(0.20f)
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = {
                navController.navigate(screen.roote) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        Column(
            modifier = Modifier
                .padding(start = 1.dp, end = 5.dp, top = 8.dp, bottom = 8.dp)
                .wrapContentSize(),
            verticalArrangement = Arrangement.spacedBy(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Icon(
                painter = painterResource(id = if (!selected) screen.icon_Focused else screen.icon),
                contentDescription = "icon",
                tint = contentColor
            )


        }
        Text(
            text = screen.title,
            color =contentColor,
            fontSize = 10.sp,
            textAlign = TextAlign.Center
        )
    }

}


