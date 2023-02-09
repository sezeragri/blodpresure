package com.bloodpressurechecker.bpblood.bptracker.Screens

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.icu.text.SimpleDateFormat
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.isPopupLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bloodpressurechecker.bpblood.bptracker.R
import com.bloodpressurechecker.bpblood.bptracker.screen.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import java.util.*

var counterAu = 1
@SuppressLint("NewApi")
@Composable
fun AudienceScreen(
    max_value: Int,
    navController: NavController,


    ) {


    val context = LocalContext.current
    val viewModel: AnasayfaViewModel = viewModel(
        factory = AnasayfaViewModelFactory(context.applicationContext as Application)
    )
    val bTan = viewModel.personbTan.observeAsState(listOf())
    val enSon = viewModel.personbTan.observeAsState(listOf())

    val sdfr = remember {
        mutableStateOf(SimpleDateFormat("dd-MM-yyyy"))
    }

    val currentDateAndTime = sdfr.value.format(Date())
    val scrollState = rememberScrollState()
    val systemUiController = rememberSystemUiController()




    LaunchedEffect(key1 = true) {

        viewModel.LoadPerson()
    }

    SideEffect {

        systemUiController.setStatusBarColor(
            Color(0xFF292F3B),
            darkIcons = false
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF292F3B)),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 20.dp)
        ) {

            Text(
                text = stringResource(id = R.string.izleyici),
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Text(
                text = stringResource(id = R.string.kayitlar),
                fontSize = 16.sp,
                color = Color.White,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.TabLayout.roote) {
                        popUpTo(
                            0
                        )
                    }
                }
            )

        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 30.dp)
        ) {

            Box(
                modifier = Modifier
                    .width(105.dp)
                    .height(0.5.dp)
                    .background(color = Color.LightGray)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ) {
                for (s in enSon.value) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_green_circle),
                        contentDescription = "",
                        tint = if (s.bTan < 90 || s.kTan < 60) {
                            colorResource(id = R.color.tan1)
                        } else if (s.bTan >= 90 && s.bTan <= 119 && s.kTan >= 60 && s.kTan <= 79) {
                            colorResource(id = R.color.tan2)
                        } else if (s.bTan >= 120 && s.bTan <= 129 && s.kTan >= 60 && s.kTan <= 79) {
                            colorResource(id = R.color.tan3)
                        } else if (s.bTan >= 130 && s.bTan <= 139 || s.kTan >= 80 && s.kTan <= 89) {
                            colorResource(id = R.color.tan4)
                        } else if (s.bTan >= 140 && s.bTan <= 180 || s.kTan >= 90 && s.kTan <= 120) {
                            colorResource(id = R.color.tan5)
                        } else if (s.bTan > 180 || s.kTan > 120) {
                            colorResource(id = R.color.tan6)
                        } else colorResource(id = R.color.white),
                        modifier = Modifier.size(12.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(3.dp))
                Text(
                    text = stringResource(id = R.string.en_son),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(3.dp))

                Icon(
                    painter = painterResource(id = R.drawable.arrow_icon),
                    contentDescription = "",
                    modifier = Modifier.size(12.dp),
                    tint = Color.LightGray
                )
            }


            Box(
                modifier = Modifier
                    .width(105.dp)
                    .height(0.5.dp)
                    .background(color = Color.LightGray)
            )


        }

        Spacer(modifier = Modifier.padding(8.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(310.dp)
                .padding(start = 5.dp, end = 5.dp)
        ) {

            Text(
                text = stringResource(id = R.string.buyuk_tansiyon),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                text = stringResource(id = R.string.kucuk_tansiyon),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                text = stringResource(id = R.string.nabiz),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.padding(2.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(330.dp)
                .padding(start = 5.dp)
        ) {

            for (k in bTan.value) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier.padding(start = 2.dp)
                ) {


                    Text(
                        text = k.bTan.toString(),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )




                    Spacer(modifier = Modifier.padding(6.dp))
                    Text(
                        text = "mmHg",
                        fontSize = 15.sp,
                        color = Color.LightGray,
                        textAlign = TextAlign.End
                    )

                }

                Spacer(modifier = Modifier.padding(13.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Bottom
                ) {

                    Text(
                        text = k.kTan.toString(),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    Text(
                        text = "mmHg",
                        fontSize = 15.sp,
                        color = Color.LightGray,
                        textAlign = TextAlign.End
                    )

                }
                Spacer(modifier = Modifier.padding(14.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Bottom
                ) {

                    Text(
                        text = k.nabiz.toString(),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    Text(
                        text = "BPM",
                        fontSize = 15.sp,
                        color = Color.LightGray,
                        textAlign = TextAlign.End
                    )

                }

            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .horizontalScroll(state = scrollState),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(350.dp),
                contentAlignment = Alignment.BottomStart
            )
            {
                // Scale
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.Start
                ) {

                    Row(
                        modifier = Modifier.padding(start = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "240", color = Color.White, fontSize = 11.sp)
                        Spacer(modifier = Modifier.padding(5.dp))
                        DrawLine()
                    }

                    Spacer(modifier = Modifier.fillMaxHeight())

                }


                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.Start
                ) {

                    Row(
                        modifier = Modifier.padding(start = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "180", color = Color.White, fontSize = 11.sp)
                        Spacer(modifier = Modifier.padding(5.dp))
                        DrawLine()
                    }
                    Spacer(modifier = Modifier.fillMaxHeight(0.7500f))
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        modifier = Modifier.padding(start = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "120", color = Color.White, fontSize = 11.sp)
                        Spacer(modifier = Modifier.padding(5.dp))
                        DrawLine()
                    }
                    Spacer(modifier = Modifier.fillMaxHeight(0.5000f))
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.Start
                ) {

                    Row(
                        modifier = Modifier.padding(start = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = " 60", color = Color.White, fontSize = 11.sp)
                        Spacer(modifier = Modifier.padding(5.dp))
                        DrawLine()
                    }
                    Spacer(modifier = Modifier.fillMaxHeight(0.2500f))
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        modifier = Modifier.padding(start = 15.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(
                            text = " 00",
                            color = Color.White,
                            fontSize = 11.sp,
                            textAlign = TextAlign.End
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        DrawLine()
                    }
                    Spacer(modifier = Modifier.fillMaxHeight(0f))
                }
                ColumnCard()
            }

            // Graph


        }

        Spacer(modifier = Modifier.padding(10.dp))

        Box(contentAlignment = Alignment.TopCenter) {
            Column {
                Row(
                    modifier = Modifier
                        .weight(1.0f)
                        .fillMaxWidth()
                        .background(color = Color(0xFF292F3B))
                ) {
                }

                Row(
                    modifier = Modifier
                        .weight(9.0f)
                        .fillMaxWidth()
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                        )
                        .padding(top = 40.dp)
                ) {


                    TansiyonValueList(navController)
                }
            }

            Row(
                modifier = Modifier
                    .padding(start = 50.dp, end = 50.dp)
                    .background(
                        color = colorResource(
                            id = R.color.login
                        ), shape = CircleShape
                    )
                    .fillMaxWidth(1f)
                    .height(60.dp)
                    .clickable {
                        counterAu++
                        navController.navigate(Screen.AddValue.roote) { popUpTo(0) }

                        if (counterAu % 13 == 0 && mInterstitialAd != null) {
                            mInterstitialAd?.show(context as Activity)
                            counterAu = 0
                        } else {
                            Log.d("TAG", "The interstitial ad wasn't ready yet.")
                        }

                               },

                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = stringResource(id = R.string.ekle),
                    fontSize = 22.sp,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold
                )

            }


        }


    }


}


@Composable
fun TansiyonValueList(navController: NavController) {


    val context = LocalContext.current
    val viewModel: AnasayfaViewModel = viewModel(
        factory = AnasayfaViewModelFactory(context.applicationContext as Application)
    )

    val viewModel2: KisiSilSayfaViewModel = viewModel(
        factory = KisiSilSayfaViewModelFactory(context.applicationContext as Application)
    )
    val liste = viewModel.personList.observeAsState(listOf())





    LazyColumn {
        items(count = liste.value.count(),

            itemContent = {
                val kisi = liste.value[it]
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, start = 15.dp)
                        .clickable { navController.navigate(Screen.AddValue.roote) { popUpTo(0) } }
                ) {

                    Column(
                        modifier = Modifier
                            .size(55.dp)
                            .background(color = Color.White)
                            .border(
                                2.75.dp, color = if (kisi.bTan < 90 || kisi.kTan < 60) {
                                    colorResource(id = R.color.tan1)
                                } else if (kisi.bTan >= 90 && kisi.bTan <= 119 && kisi.kTan >= 60 && kisi.kTan <= 79) {
                                    colorResource(id = R.color.tan2)
                                } else if (kisi.bTan >= 120 && kisi.bTan <= 129 && kisi.kTan >= 60 && kisi.kTan <= 79) {
                                    colorResource(id = R.color.tan3)
                                } else if (kisi.bTan >= 130 && kisi.bTan <= 139 || kisi.kTan >= 80 && kisi.kTan <= 89) {
                                    colorResource(id = R.color.tan4)
                                } else if (kisi.bTan >= 140 && kisi.bTan <= 180 || kisi.kTan >= 90 && kisi.kTan <= 120) {
                                    colorResource(id = R.color.tan5)
                                } else if (kisi.bTan > 180 || kisi.kTan > 120) {
                                    colorResource(id = R.color.tan6)
                                } else colorResource(id = R.color.purple_500),

                                shape = CircleShape
                            ),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {

                        Text(
                            text = kisi.bTan.toString(),
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Box(
                            modifier = Modifier
                                .background(
                                    color = if (kisi.bTan < 90 || kisi.kTan < 60) {
                                        colorResource(id = R.color.tan1)
                                    } else if (kisi.bTan >= 90 && kisi.bTan <= 119 && kisi.kTan >= 60 && kisi.kTan <= 79) {
                                        colorResource(id = R.color.tan2)
                                    } else if (kisi.bTan >= 120 && kisi.bTan <= 129 && kisi.kTan >= 60 && kisi.kTan <= 79) {
                                        colorResource(id = R.color.tan3)
                                    } else if (kisi.bTan >= 130 && kisi.bTan <= 139 || kisi.kTan >= 80 && kisi.kTan <= 89) {
                                        colorResource(id = R.color.tan4)
                                    } else if (kisi.bTan >= 140 && kisi.bTan <= 180 || kisi.kTan >= 90 && kisi.kTan <= 120) {
                                        colorResource(id = R.color.tan5)
                                    } else if (kisi.bTan > 180 || kisi.kTan > 120) {
                                        colorResource(id = R.color.tan6)
                                    } else colorResource(id = R.color.purple_500)
                                )
                                .fillMaxWidth()
                                .height(1.25.dp)
                        )
                        Text(
                            text = kisi.kTan.toString(),
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )


                    }

                    Spacer(modifier = Modifier.padding(10.dp))

                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.height(50.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_green_circle),
                                contentDescription = "",
                                tint = if (kisi.bTan < 90 || kisi.kTan < 60) {
                                    colorResource(id = R.color.tan1)
                                } else if (kisi.bTan >= 90 && kisi.bTan <= 119 && kisi.kTan >= 60 && kisi.kTan <= 79) {
                                    colorResource(id = R.color.tan2)
                                } else if (kisi.bTan >= 120 && kisi.bTan <= 129 && kisi.kTan >= 60 && kisi.kTan <= 79) {
                                    colorResource(id = R.color.tan3)
                                } else if (kisi.bTan >= 130 && kisi.bTan <= 139 || kisi.kTan >= 80 && kisi.kTan <= 89) {
                                    colorResource(id = R.color.tan4)
                                } else if (kisi.bTan >= 140 && kisi.bTan <= 180 || kisi.kTan >= 90 && kisi.kTan <= 120) {
                                    colorResource(id = R.color.tan5)
                                } else if (kisi.bTan > 180 || kisi.kTan > 120) {
                                    colorResource(id = R.color.tan6)
                                } else colorResource(id = R.color.purple_500),
                                modifier = Modifier.size(12.dp)
                            )
                            Spacer(modifier = Modifier.padding(5.dp))
                            Text(
                                text = if (kisi.bTan < 90 || kisi.kTan < 60) {
                                    stringResource(id = R.string.hipotansiyon)
                                } else if (kisi.bTan >= 90 && kisi.bTan <= 119 && kisi.kTan >= 60 && kisi.kTan <= 79) {
                                    stringResource(id = R.string.normal)
                                } else if (kisi.bTan >= 120 && kisi.bTan <= 129 && kisi.kTan >= 60 && kisi.kTan <= 79) {
                                    stringResource(id = R.string.yüksek)
                                } else if (kisi.bTan >= 130 && kisi.bTan <= 139 || kisi.kTan >= 80 && kisi.kTan <= 89) {
                                    stringResource(id = R.string.hipertansiyonbirinciasama)
                                } else if (kisi.bTan >= 140 && kisi.bTan <= 180 || kisi.kTan >= 90 && kisi.kTan <= 120) {
                                    stringResource(id = R.string.hipertansiyonikinciasama)
                                } else if (kisi.bTan > 180 || kisi.kTan > 120) {
                                    stringResource(id = R.string.hipertansif)
                                } else "null",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Start
                            )
                        }

                        Row() {
                            Text(
                                text = "${kisi.date} , ${kisi.nabiz} BPM",
                                color = Color.DarkGray,
                                fontSize = 13.sp
                            )

                        }

                    }

                    Spacer(Modifier.weight(1f))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_trash),
                        contentDescription = "pencil ",
                        tint = Color.LightGray,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 10.dp)
                            .clickable {
                                navController.navigate(BottomBarScreen.Audience.roote) { popUpTo(0) }
                                viewModel2.sil(
                                    kisi.person_id,
                                    kisi.bTan,
                                    kisi.kTan,
                                    kisi.nabiz,
                                    kisi.date
                                )
                            },


                        )


                }
            })
    }


}


@Composable
fun ColumnCard() {
    val buyuk = stringResource(id = R.string.buyuk_tansiyon)
    val kucuk = stringResource(id = R.string.kucuk_tansiyon)
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val viewModel: AnasayfaViewModel = viewModel(
        factory = AnasayfaViewModelFactory(context.applicationContext as Application)
    )
    val liste = viewModel.personList.observeAsState(listOf())


    Row(
        modifier = Modifier
            .width(350.dp)
            .fillMaxHeight()
            .horizontalScroll(state = scrollState)
            .padding(0.dp),
        verticalAlignment = Alignment.Bottom
    ) {


        LazyRow(
            modifier = Modifier
                .width(350.dp)
                .padding(start = 60.dp), verticalAlignment = Alignment.Bottom
        ) {
            items(
                count = liste.value.count(),
                itemContent = {

                    val kisi = liste.value[it]

                    Box(modifier = Modifier
                        .padding(start = 20.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .width(20.dp)
                        .fillMaxHeight((kisi.bTan / 240f))//((kisi.bTan - ((kisi.kTan) * 0.90)) / 220).toFloat()
                        .background(
                            if (kisi.bTan < 90 || kisi.kTan < 60) {
                                colorResource(id = R.color.tan1)
                            } else if (kisi.bTan >= 90 && kisi.bTan <= 119 && kisi.kTan >= 60 && kisi.kTan <= 79) {
                                colorResource(id = R.color.tan2)
                            } else if (kisi.bTan >= 120 && kisi.bTan <= 129 && kisi.kTan >= 60 && kisi.kTan <= 79) {
                                colorResource(id = R.color.tan3)
                            } else if (kisi.bTan >= 130 && kisi.bTan <= 139 || kisi.kTan >= 80 && kisi.kTan <= 89) {
                                colorResource(id = R.color.tan4)
                            } else if (kisi.bTan >= 140 && kisi.bTan <= 180 || kisi.kTan >= 90 && kisi.kTan <= 120) {
                                colorResource(id = R.color.tan5)
                            } else if (kisi.bTan > 180 || kisi.kTan > 120) {
                                colorResource(id = R.color.tan6)
                            } else colorResource(id = R.color.purple_500)
                        )
                        .clickable {
                            Toast
                                .makeText(
                                    context,
                                    "${buyuk}: ${kisi.bTan}  ${kucuk} : ${kisi.kTan}",
                                    Toast.LENGTH_SHORT
                                )
                                .show()

                        })

                }
            )
        }


    }

}

