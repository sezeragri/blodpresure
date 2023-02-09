package com.bloodpressurechecker.bpblood.bptracker.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.bloodpressurechecker.bpblood.bptracker.R
import com.bloodpressurechecker.bpblood.bptracker.screen.BottomBarScreen
import com.google.accompanist.pager.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch


@Preview
@Composable
fun DrawLine() {
    Canvas(modifier = Modifier.fillMaxWidth()) {
        val height = size.height
        val width = size.width

        drawLine(
            start = Offset(x= 0f, y = 0f),
            end = Offset(x = width, y = 0f),
            color = Color(0xFF616775),
            strokeWidth = 3.0f,
            pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(8f, 8f), phase = 0f)
        )
    }
}

@ExperimentalPagerApi
@Composable
fun TabLayout(navController: NavController) {


    val pagerState = rememberPagerState(initialPage = 2)
    val systemUiController = rememberSystemUiController()
    SideEffect {

        systemUiController.setStatusBarColor(
            Color.LightGray,
            darkIcons = false
        )
    }

    Column(

        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {

        TopAppBar(backgroundColor = Color.LightGray) {



            Row(modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "icon",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(start = 10.dp, top = 5.dp)
                        .clickable {
                            navController.navigate(BottomBarScreen.Audience.roote) {
                                popUpTo(
                                    0
                                )
                            }
                        }
                    , tint = Color.Black
                )

            }
        }

        Tabs(pagerState = pagerState)

        TabsContent(pagerState = pagerState,navController)
    }
}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {

    val list = listOf(
        stringResource(id = R.string.kayitlar) ,
        stringResource(id = R.string.gecmis),

    )
    val scope = rememberCoroutineScope()

    TabRow(

        selectedTabIndex = pagerState.currentPage,

        backgroundColor = Color.LightGray,

        contentColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 5.dp,
                color = colorResource(id = R.color.login)
            )
        }
    ) {

        list.forEachIndexed { index, _ ->

            Tab(
                text = {
                    Text(
                        list[index],
                        color = if (pagerState.currentPage == index) Color.Black else Color.DarkGray,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}


@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState,navController: NavController) {

    HorizontalPager(state = pagerState, count = 2) {

            page ->
        when (page) {
            0 -> Past()
            1 -> Records(navController)

        }
    }
}
