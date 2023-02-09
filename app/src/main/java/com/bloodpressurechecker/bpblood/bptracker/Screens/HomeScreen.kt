package com.bloodpressurechecker.bpblood.bptracker.Screens

import android.app.Application
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bloodpressurechecker.bpblood.bptracker.screen.AnasayfaViewModel
import com.bloodpressurechecker.bpblood.bptracker.screen.AnasayfaViewModelFactory
import com.bloodpressurechecker.bpblood.bptracker.R
import com.bloodpressurechecker.bpblood.bptracker.screen.BottomBarScreen
import com.bloodpressurechecker.bpblood.bptracker.screen.Screen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun homeScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    SideEffect {

        systemUiController.setSystemBarsColor(
            Color.White,
            darkIcons = true
        )
    }
    systemUiController.isNavigationBarVisible = true

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .background(color = Color.White)
            .padding(bottom = 7.dp)


    ) {

        //BottomNav(context = context)
        Text(
            text = stringResource(id = R.string.ana_giris),
            fontSize = 22.sp,
            color = MaterialTheme.colors.onSecondary,
            fontStyle = FontStyle(758),
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 14.dp, top = 17.dp)
        )
        Spacer(modifier = Modifier.padding(7.dp))
        Text(
            text = stringResource(id = R.string.tansiyonum),
            fontSize = 17.sp,
            color = MaterialTheme.colors.onSecondary,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(start = 14.dp)
        )


        BloodPressureList(navController)

        Transactions(navController)

        Spacer(modifier = Modifier.padding(bottom = 15.dp))

        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                text = stringResource(id = R.string.tansiyon_bilgileri),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
                color = Color(0xFF292F3B)
            )
            Text(
                text = "${stringResource(id = R.string.daha)} >",
                fontSize = 15.sp,
                color = Color.DarkGray,
                modifier = Modifier.clickable {
                    navController.navigate(BottomBarScreen.Informations.roote) {
                        popUpTo(0)
                    }
                })

        }

    }


}

@Composable
fun Transactions(navController: NavController) {


    val context = LocalContext.current
    val viewModel: AnasayfaViewModel = viewModel(
        factory = AnasayfaViewModelFactory(context.applicationContext as Application)
    )
    val sayac = viewModel.personbTan.observeAsState(listOf())
    val kayitsay = viewModel.personList.observeAsState(listOf())

    LaunchedEffect(key1 = true) {

        viewModel.LoadPerson()
    }
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(MaterialTheme.colors.secondary, shape = CircleShape)
                .width(190.dp)
                .height(40.dp)
                .clickable { navController.navigate(BottomBarScreen.Audience.roote) { popUpTo(0) } }

        ) {


                Text(
                    text = "${stringResource(id = R.string.tum_kayitlar)}" +
                            " (${kayitsay.value.size})",
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold
                )


        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color(0xFF292F3B), shape = CircleShape)
                .width(120.dp)
                .height(40.dp)
                .clickable { navController.navigate(Screen.AddValue.roote) { popUpTo(0) } }

        ) {

            Text(
                text = "+ ${stringResource(id = R.string.ekle)}",
                fontSize = 15.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,

                )
        }
    }
}

@Composable
fun BloodPressure(blood: Blood, navController: NavController) {

    val scrollState = rememberScrollState(0)
    var shouldAnimate = remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = shouldAnimate) {
        scrollState.animateScrollTo(
            scrollState.value,
            animationSpec = tween(10000, 30, easing = CubicBezierEasing(2f, 1f, 1f, 1f))
        )
        scrollState.scrollTo(0)
        shouldAnimate != shouldAnimate
    }
    val context = LocalContext.current
    val viewModel: AnasayfaViewModel = viewModel(
        factory = AnasayfaViewModelFactory(context.applicationContext as Application)
    )
    val enSon = viewModel.personbTan.observeAsState(listOf())

    LaunchedEffect(key1 = true) {

        viewModel.LoadPerson()
    }
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(12.dp)
            .background(
                color = blood.color,
                shape = RoundedCornerShape(15.dp)
            )
            .width(260.dp)
            .height(120.dp)
            .clickable { navController.navigate(BottomBarScreen.Audience.roote) { popUpTo(0) } }
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(260.dp)
                .wrapContentHeight()
                .padding(start = 15.dp, end = 15.dp, bottom = 8.dp, top = 5.dp)
        ) {

            Text(
                text = blood.time,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_green_circle),
                    contentDescription = "",
                    modifier = Modifier
                        .border(1.dp, color = Color.White, CircleShape)
                        .size(12.dp),
                    tint = blood.colorLevel
                )
                Spacer(modifier = Modifier.padding(start = 3.dp))
                Text(
                    text = blood.level,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    //textAlign = TextAlign.End,
                    modifier = Modifier
                        .horizontalScroll(scrollState, false)
                        .width(100.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1

                )
            }


        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(start = 15.dp, end = 20.dp)
                .width(260.dp)
                .wrapContentHeight()
        ) {

            Text(
                text = stringResource(id = R.string.buyuk_tansiyon),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = stringResource(id = R.string.kucuk_tansiyon),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
                .width(260.dp)
                .wrapContentHeight()
        ) {


            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = blood.hypertension,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(start = 2.dp))
                Text(
                    text = "mmHg",
                    fontSize = 10.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center


                )
            }

            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = blood.hypotension,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(start = 2.dp))

                Text(
                    text = "mmHg",
                    fontSize = 10.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }

        }
    }

}


data class Blood(
    val time: String,
    val level: String,
    val hypertension: String,
    val hypotension: String,
    val color: Color,
    val colorLevel: Color
)


@Composable
fun BloodPressureList(navController: NavController) {

    var sum: Int = 0
    var sumkucuk: Int = 0
    val context = LocalContext.current
    val viewModel: AnasayfaViewModel = viewModel(
        factory = AnasayfaViewModelFactory(context.applicationContext as Application)
    )
    val enSon = viewModel.personbTan.observeAsState(listOf())
    val ort = viewModel.personList.observeAsState(listOf())
    for (j in ort.value) {

        sum += j.bTan
        sumkucuk += j.kTan
    }

    LaunchedEffect(key1 = true) {

        viewModel.LoadPerson()
    }
    for (s in enSon.value) {


        val bloods = listOf(

            Blood(
                time = stringResource(id = R.string.en_son),
                level = if (s.bTan < 90 || s.kTan < 60) {
                    stringResource(id = R.string.hipotansiyon)
                } else if (s.bTan >= 90 && s.bTan <= 119 && s.kTan >= 60 && s.kTan <= 79) {
                    stringResource(id = R.string.normal)
                } else if (s.bTan >= 120 && s.bTan <= 129 && s.kTan >= 60 && s.kTan <= 79) {
                    stringResource(id = R.string.yüksek)
                } else if (s.bTan >= 130 && s.bTan <= 139 || s.kTan >= 80 && s.kTan <= 89) {
                    stringResource(id = R.string.hipertansiyonbirinciasama)
                } else if (s.bTan >= 140 && s.bTan <= 180 || s.kTan >= 90 && s.kTan <= 120) {
                    stringResource(id = R.string.hipertansiyonikinciasama)
                } else if (s.bTan > 180 || s.kTan > 120) {
                    stringResource(id = R.string.hipertansif)
                } else "Null",
                hypertension = s.bTan.toString(),
                hypotension = s.kTan.toString(),
                color = Color(0xFF00ADB1),
                colorLevel = if (s.bTan < 90 || s.kTan < 60) {
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
                } else colorResource(id = R.color.white)
            ),
            Blood(
                time = stringResource(id = R.string.ortalama),
                level = if (sumkucuk / ort.value.size < 60 || sum / ort.value.size < 90) {
                    stringResource(id = R.string.hipotansiyon)
                } else if (sum / ort.value.size >= 90 && sum / ort.value.size <= 119 && sumkucuk / ort.value.size >= 60 && sumkucuk / ort.value.size <= 79) {
                    stringResource(id = R.string.normal)
                } else if (sum / ort.value.size >= 120 && sum / ort.value.size <= 129 && sumkucuk / ort.value.size >= 60 && sumkucuk / ort.value.size <= 79) {
                    stringResource(id = R.string.yüksek)
                } else if (sum / ort.value.size >= 130 && sum / ort.value.size <= 139 || sumkucuk / ort.value.size >= 80 && sumkucuk / ort.value.size <= 89) {
                    stringResource(id = R.string.hipertansiyonbirinciasama)
                } else if (sum / ort.value.size >= 140 && sum / ort.value.size <= 180 || sumkucuk / ort.value.size >= 90 && sumkucuk / ort.value.size <= 120) {
                    stringResource(id = R.string.hipertansiyonikinciasama)
                } else if (sum / ort.value.size > 180 || sumkucuk / ort.value.size > 120) {
                    stringResource(id = R.string.hipertansif)
                } else "null",
                hypertension = (sum / ort.value.size).toString(),
                hypotension = (sumkucuk / ort.value.size).toString(),
                color = Color(0xFF292F3B),
                colorLevel = if (sum / ort.value.size < 90 || sumkucuk / ort.value.size < 60) {
                    colorResource(id = R.color.tan1)
                } else if (sum / ort.value.size >= 90 && sum / ort.value.size <= 119 && sumkucuk / ort.value.size >= 60 && sumkucuk / ort.value.size <= 79) {
                    colorResource(id = R.color.tan2)
                } else if (sum / ort.value.size >= 120 && sum / ort.value.size <= 129 && sumkucuk / ort.value.size >= 60 && sumkucuk / ort.value.size <= 79) {
                    colorResource(id = R.color.tan3)
                } else if (sum / ort.value.size >= 130 && sum / ort.value.size <= 139 || sumkucuk / ort.value.size >= 80 && sumkucuk / ort.value.size <= 89) {
                    colorResource(id = R.color.tan4)
                } else if (sum / ort.value.size >= 140 && sum / ort.value.size <= 180 || sumkucuk / ort.value.size >= 90 && sumkucuk / ort.value.size <= 120) {
                    colorResource(id = R.color.tan5)
                } else if (sum / ort.value.size > 180 || sumkucuk / ort.value.size > 120) {
                    colorResource(id = R.color.tan6)
                } else colorResource(id = R.color.white)

            )
        )


        LazyRow(content = {
            items(items = bloods, itemContent = { item ->
                BloodPressure(item, navController)
            })
        })
    }
}


@Composable
fun HomeScreen(navController: NavController) {
    val infoies = listOf(

        DataInfo(
            image = R.drawable.effect_know,
            title = stringResource(id = R.string.hipertansiyonayonelikyasam),
            str1 =stringResource(id = R.string.hiperetki),
            str2 =stringResource(id = R.string.hiperetki1),
            str3 =stringResource(id = R.string.hiperetki1tanim),
            str4 =stringResource(id = R.string.hiperetki2),
            str5 =stringResource(id = R.string.hiperetki2tanim),
            str6 =stringResource(id = R.string.hiperetki3),
            str7 =stringResource(id = R.string.hiperetki3tanim),
            str8 =stringResource(id = R.string.hiperetki4),
            str9 =stringResource(id = R.string.hiperetki4tanim),
            str10 =stringResource(id = R.string.hiperetki5),
            str11 =stringResource(id = R.string.hiperetki5tanim),
            str12 =stringResource(id = R.string.hiperetki6),
            str13 =stringResource(id = R.string.hiperetki6tanim),
            str14 =stringResource(id = R.string.hiperetki7),

            str15 =stringResource(id = R.string.hiperetki7tanim),
            str16 =stringResource(id = R.string.hiperetki8),
            str17 =stringResource(id = R.string.hiperetki8tanim),
            str18 =stringResource(id = R.string.hiperetki9),
            str19 =stringResource(id = R.string.hiperetki9tanim)




        ),


        DataInfo(
            image = R.drawable.lifestyle,
            title = stringResource(id = R.string.lifestyle),
            str1 =stringResource(id = R.string.hipertansiyongiris),
            str2 =stringResource(id = R.string.title1),
            str3 =stringResource(id = R.string.title1tanim),
            str4 =stringResource(id = R.string.title2),
            str5 =stringResource(id = R.string.title2tanim),
            str6 =stringResource(id = R.string.title3),
            str7 =stringResource(id = R.string.title3tanim),
            str8 =stringResource(id = R.string.title4),
            str9 =stringResource(id = R.string.title4tanim),
            str10 =stringResource(id = R.string.title5),
            str11 =stringResource(id = R.string.title5tanim),
            str12 =stringResource(id = R.string.title6),
            str13 =stringResource(id = R.string.title6alim),
            str14 =stringResource(id = R.string.title7),

            str15 =stringResource(id = R.string.title7alim),
            str16 =stringResource(id = R.string.title8),
            str17 =stringResource(id = R.string.title8alim),
            str18 =stringResource(id = R.string.title9),
            str19 =stringResource(id = R.string.title9alim)


        ),
        DataInfo(
            image = R.drawable.firsthypotensive,
            title = stringResource(id = R.string.first_aid),
            str1 =stringResource(id = R.string.hipoacil),
            str2 =stringResource(id = R.string.hipoacil1),
            str3 =stringResource(id = R.string.hipoacil1tanim),
            str4 =stringResource(id = R.string.hipoacil2),
            str5 =stringResource(id = R.string.hipoacil2tanim),
            str6 =stringResource(id = R.string.hipoacil3),
            str7 =stringResource(id = R.string.hipoacil3tanim),
            str8 =stringResource(id = R.string.hipoacil4),
            str9 =stringResource(id = R.string.hipoacil4tanim),
            str10 =stringResource(id = R.string.hipoacil5),
            str11 =stringResource(id = R.string.hipoacil5tanim),
            str12 =stringResource(id = R.string.hipoacil6),
            str13 =stringResource(id = R.string.hipoacil6tanim),
            str14 =stringResource(id = R.string.hipoacil7),

            str15 =stringResource(id = R.string.hipoacil7tanim),
            str16 =stringResource(id = R.string.hipoacil8),
            str17 =stringResource(id = R.string.hipoacil8tanim),
            str18 =stringResource(id = R.string.hipoacil9),
            str19 =stringResource(id = R.string.hipoacil9tanim)


        ),


        DataInfo(
            image = R.drawable.firsthypertensive,
            title = stringResource(id = R.string.exercises),
            str1 =stringResource(id = R.string.hipertansiyon_egzersiz),
            str2 =stringResource(id = R.string.aerobik_egzersiz),
            str3 =stringResource(id = R.string.aerobik_egzersiz_tanim),
            str4 =stringResource(id = R.string.aerobik_egzersiz_nekadar),
            str5 =stringResource(id = R.string.aerobik_egzersiz_nekadar_tanim),
            str6 =stringResource(id = R.string.aerobik_ornek_baslik),
            str7 =stringResource(id = R.string.aerobik_ornekler),
            str8 =stringResource(id = R.string.direnc),
            str9 =stringResource(id = R.string.direnc_tanim),
            str10 =stringResource(id = R.string.direnc_onlem),
            str11 =stringResource(id = R.string.direnc_onlem_tanim),
            str12 =stringResource(id = R.string.ekipman),
            str13 =stringResource(id = R.string.ekipman_ornekler),
            str14 =stringResource(id = R.string.esneklik),

            str15 =stringResource(id = R.string.essnekliktanim),
            str16 =stringResource(id = R.string.esneklikkactane),
            str17 =stringResource(id = R.string.esneklikkactanetanim),
            str18 =stringResource(id = R.string.esneklikornekbaslik),
            str19 =stringResource(id = R.string.esneklikornek)


        ),




        DataInfo(
            image = R.drawable.misunderstand,
            title = stringResource(id = R.string.Bp),
            str1 =stringResource(id = R.string.yanlisanlama),
            str2 =stringResource(id = R.string.yanlisanlamatitle1),
            str3 =stringResource(id = R.string.yanlisanlamatitle1tanim),
            str4 =stringResource(id = R.string.yanlisanlamatitle2),
            str5 =stringResource(id = R.string.yanlisanlamatitle2tanim),
            str6 =stringResource(id = R.string.yanlisanlamatitle3),
            str7 =stringResource(id = R.string.yanlisanlamatitle3tanim),
            str8 =stringResource(id = R.string.yanlisanlamatitle4),
            str9 =stringResource(id = R.string.yanlisanlamatitle4tanim),
            str10 =stringResource(id = R.string.yanlisanlamatitle5),
            str11 =stringResource(id = R.string.yanlisanlamatitle5tanim),
            str12 =stringResource(id = R.string.yanlisanlamatitle6),
            str13 =stringResource(id = R.string.yanlisanlamatitle6tanim),
            str14 =stringResource(id = R.string.yanlisanlamatitle7),

            str15 =stringResource(id = R.string.yanlisanlamatitle7tanim),
            str16 =stringResource(id = R.string.yanlisanlamatitle8),
            str17 =stringResource(id = R.string.yanlisanlamatitle8tanim),
            str18 =stringResource(id = R.string.yanlisanlamatitle9),
            str19 =stringResource(id = R.string.yanlisanlamatitle9tanim)



        ),

        DataInfo(
            image = R.drawable.mistakes,
            title = stringResource(id = R.string.topmistakes),
            str1 =stringResource(id = R.string.tanhata),
            str2 =stringResource(id = R.string.tanhata1),
            str3 =stringResource(id = R.string.tanhata1t),
            str4 =stringResource(id = R.string.tanhata2),
            str5 =stringResource(id = R.string.tanhata2t),
            str6 =stringResource(id = R.string.tanhata3),
            str7 =stringResource(id = R.string.tanhata3t),
            str8 =stringResource(id = R.string.tanhata4),
            str9 =stringResource(id = R.string.tanhata4t),
            str10 =stringResource(id = R.string.tanhata5),
            str11 =stringResource(id = R.string.tanhata5t),
            str12 =stringResource(id = R.string.tanhata6),
            str13 =stringResource(id = R.string.tanhata6t),
            str14 =stringResource(id = R.string.tanhata7),

            str15 =stringResource(id = R.string.tanhata7t),
            str16 =stringResource(id = R.string.tanhata8),
            str17 =stringResource(id = R.string.tanhata8t),
            str18 =stringResource(id = R.string.tanhata9),
            str19 =stringResource(id = R.string.tanhata9t)


        ),


        DataInfo(
            image = R.drawable.who,
            title = stringResource(id = R.string.first_aid_hypertensive),
            str1 =stringResource(id = R.string.hpacil),
            str2 =stringResource(id = R.string.hpacil1),
            str3 =stringResource(id = R.string.hpacil1tanim),
            str4 =stringResource(id = R.string.hpacil2),
            str5 =stringResource(id = R.string.hpacil2tanim),
            str6 =stringResource(id = R.string.hpacil3),
            str7 =stringResource(id = R.string.hpacil3tanim),
            str8 =stringResource(id = R.string.hpacil4),
            str9 =stringResource(id = R.string.hpacil4tanim),
            str10 =stringResource(id = R.string.hpacil5),
            str11 =stringResource(id = R.string.hpacil5tanim),
            str12 =stringResource(id = R.string.hpacil6),
            str13 =stringResource(id = R.string.hpacil6tanim),
            str14 =stringResource(id = R.string.hpacil7),

            str15 =stringResource(id = R.string.hpacil7tanim),
            str16 =stringResource(id = R.string.hpacil8),
            str17 =stringResource(id = R.string.hpacil8tanim),
            str18 =stringResource(id = R.string.hpacil9),
            str19 =stringResource(id = R.string.hpacil9tanim)


        ),


        DataInfo(
            image = R.drawable.fag,
            title = stringResource(id = R.string.faq),
            str1 =stringResource(id = R.string.faqq),
            str2 =stringResource(id = R.string.faq1),
            str3 =stringResource(id = R.string.faq1t),
            str4 =stringResource(id = R.string.faq2),
            str5 =stringResource(id = R.string.faq2t),
            str6 =stringResource(id = R.string.faq3),
            str7 =stringResource(id = R.string.faq3t),
            str8 =stringResource(id = R.string.faq4),
            str9 =stringResource(id = R.string.faq4t),
            str10 =stringResource(id = R.string.faq5),
            str11 =stringResource(id = R.string.faq5t),
            str12 =stringResource(id = R.string.faq6),
            str13 =stringResource(id = R.string.faq6t),
            str14 =stringResource(id = R.string.faq7),

            str15 =stringResource(id = R.string.faq7t),
            str16 =stringResource(id = R.string.faq8),
            str17 =stringResource(id = R.string.faq8t),
            str18 =stringResource(id = R.string.faq9),
            str19 =stringResource(id = R.string.faq9t)


        ),
        DataInfo(
            image = R.drawable.number,
            title = stringResource(id = R.string.understanding),
            str1 =stringResource(id = R.string.bpunder),
            str2 =stringResource(id = R.string.bpunder1),
            str3 =stringResource(id = R.string.bpunder1t),
            str4 =stringResource(id = R.string.bpunder2),
            str5 =stringResource(id = R.string.bpunder2t),
            str6 =stringResource(id = R.string.bpunder3),
            str7 =stringResource(id = R.string.bpunder3t),
            str8 =stringResource(id = R.string.bpunder4),
            str9 =stringResource(id = R.string.bpunder4t),
            str10 =stringResource(id = R.string.bpunder5),
            str11 =stringResource(id = R.string.bpunder5t),
            str12 =stringResource(id = R.string.bpunder6),
            str13 =stringResource(id = R.string.bpunder6t),
            str14 =stringResource(id = R.string.bpunder7),

            str15 =stringResource(id = R.string.bpunder7t),
            str16 =stringResource(id = R.string.bpunder8),
            str17 =stringResource(id = R.string.bpunder8t),
            str18 =stringResource(id = R.string.bpunder9),
            str19 =stringResource(id = R.string.bpunder9t)

        ),


        DataInfo(
            image = R.drawable.risk,
            title = stringResource(id = R.string.risk),
            str1 =stringResource(id = R.string.riskk),
            str2 =stringResource(id = R.string.risk1),
            str3 =stringResource(id = R.string.risk1t),
            str4 =stringResource(id = R.string.risk2),
            str5 =stringResource(id = R.string.risk2t),
            str6 =stringResource(id = R.string.risk3),
            str7 =stringResource(id = R.string.risk3t),
            str8 =stringResource(id = R.string.risk4),
            str9 =stringResource(id = R.string.risk4t),
            str10 =stringResource(id = R.string.risk5),
            str11 =stringResource(id = R.string.risk5t),
            str12 =stringResource(id = R.string.risk6),
            str13 =stringResource(id = R.string.risk6t),
            str14 =stringResource(id = R.string.risk7),

            str15 =stringResource(id = R.string.risk7t),
            str16 =stringResource(id = R.string.risk8),
            str17 =stringResource(id = R.string.risk8t),
            str18 =stringResource(id = R.string.risk9),
            str19 =stringResource(id = R.string.risk9t)



        )




    )
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(1.dp),
        modifier = Modifier.padding(bottom = 62.dp),
        content = {
            items(count = 1, itemContent = {
                homeScreen(navController)
            })

            items(items = infoies) { items ->

                InfoCard(items, navController)

            }
        })
}


