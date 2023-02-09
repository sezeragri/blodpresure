package com.bloodpressurechecker.bpblood.bptracker.Screens

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.util.Log
import android.widget.NumberPicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bloodpressurechecker.bpblood.bptracker.R
import com.bloodpressurechecker.bpblood.bptracker.screen.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty

var counter = 1
@SuppressLint("NewApi", "RememberReturnType")
@Composable
fun AddValue(

    navController: NavController,

    state1: MutableState<Int>,
    state2: MutableState<Int>,
    state3: MutableState<Int>
) {


    val context = LocalContext.current
    val viewModel: AnasayfaViewModel = viewModel(
        factory = AnasayfaViewModelFactory(context.applicationContext as Application)
    )
    val enSon = viewModel.personbTan.observeAsState(listOf())

    val ortsez = viewModel.personList.observeAsState(listOf())

    val viewModel2: KisiKayitSayfaViewModel = viewModel(
        factory = KisiKayitSayfaViewModelFactory(context.applicationContext as Application)
    )


    val sdf = remember {
        mutableStateOf(SimpleDateFormat("'Date: \t 'dd-MM-yyyy '\t'HH:mm"))
    }


    val currentDateAndTime = sdf.value.format(Date())

    val systemUiController = rememberSystemUiController()
    SideEffect {

        systemUiController.setStatusBarColor(
            Color(0xFF292F3B),
            darkIcons = false
        )

        systemUiController.setNavigationBarColor(
            Color.White,
            darkIcons = false
        )

    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.backscreen)),
    ) {

        Row(modifier = Modifier.padding(start = 10.dp, top = 20.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.cancel),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(20.dp)
                    .clickable { navController.navigate(BottomBarScreen.Audience.roote) { popUpTo(0) } }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = stringResource(id = R.string.yenirekor),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.padding(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.height(230.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.buyuk_tansiyon),
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "mmHg", color = Color.White, fontSize = 13.sp)
                    Spacer(modifier = Modifier.padding(5.dp))
                    PickerNumber(0, 300, if (state1.value == 0) 110 else state1.value, state1)
                }


                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.kucuk_tansiyon),
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "mmHg", color = Color.White, fontSize = 13.sp)
                    Spacer(modifier = Modifier.padding(5.dp))
                    PickerNumber(0, 300, if (state2.value == 0) 75 else state2.value, state2)
                }


                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.nabiz),
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "BPM", color = Color.White, fontSize = 13.sp)
                    Spacer(modifier = Modifier.padding(5.dp))
                    PickerNumber(0, 200, if (state3.value == 0) 65 else state3.value, state3)
                }


            }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text =  if (state1.value < 90 || state2.value < 60) {
                    stringResource(id = R.string.hipotansiyon)
                } else if (state1.value  >= 90 && state1.value  <= 119 && state2.value >= 60 && state2.value <= 79) {
                    stringResource(id = R.string.normal)
                } else if (state1.value  >= 120 && state1.value  <= 129 && state2.value >= 60 && state2.value <= 79) {
                    stringResource(id = R.string.yüksek)
                } else if (state1.value  >= 130 && state1.value  <= 139 || state2.value >= 80 && state2.value <= 89) {
                    stringResource(id = R.string.hipertansiyonbirinciasama)
                } else if (state1.value  >= 140 && state1.value  <= 180 || state2.value >= 90 && state2.value <= 120) {
                    stringResource(id = R.string.hipertansiyonikinciasama)
                } else if (state1.value  > 180 || state2.value > 120) {
                    stringResource(id = R.string.hipertansif)
                } else "Null",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_question),
                contentDescription = "questions",
                modifier = Modifier
                    .size(20.dp)
                    .clickable { navController.navigate(Screen.Understand.roote) { popUpTo(0) } }
            )

        }
//
        Text(
            text =  if (state1.value < 90 || state2.value < 60) {
                "${stringResource(id = R.string.buyuk_tansiyon)} < 90 &  ${stringResource(id = R.string.kucuk_tansiyon)} < 60"
            } else if (state1.value  >= 90 && state1.value  <= 119 && state2.value >= 60 && state2.value <= 79) {
                "${stringResource(id = R.string.buyuk_tansiyon)} 90-119 &  ${stringResource(id = R.string.kucuk_tansiyon)} 60-79"
            } else if (state1.value  >= 120 && state1.value  <= 129 && state2.value >= 60 && state2.value <= 79) {
               "${stringResource(id = R.string.buyuk_tansiyon)} 120-129 &  ${stringResource(id = R.string.kucuk_tansiyon)} 60-79"
            } else if (state1.value  >= 130 && state1.value  <= 139 || state2.value >= 80 && state2.value <= 89) {
                "${stringResource(id = R.string.buyuk_tansiyon)} 130-139 ||  ${stringResource(id = R.string.kucuk_tansiyon)} 80-89"
            } else if (state1.value  >= 140 && state1.value  <= 180 || state2.value >= 90 && state2.value <= 120) {
                "${stringResource(id = R.string.buyuk_tansiyon)} 140-180 ||  ${stringResource(id = R.string.kucuk_tansiyon)} 90-120"
            } else if (state1.value  > 180 || state2.value > 120) {
                "${stringResource(id = R.string.buyuk_tansiyon)} > 180 ||  ${stringResource(id = R.string.kucuk_tansiyon)} > 120"
            } else "Null",
            color = Color.LightGray,
            fontSize = 15.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.padding(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 10.dp, end = 10.dp)
                .clickable { navController.navigate(Screen.Understand.roote) { popUpTo(0) } },
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            ColorBlood(color = colorResource(id = R.color.tan1), width = 35)
            ColorBlood(color = colorResource(id = R.color.tan2), width = 68)
            ColorBlood(color = colorResource(id = R.color.tan3), width = 68)
            ColorBlood(color = colorResource(id = R.color.tan4), width = 68)
            ColorBlood(color = colorResource(id = R.color.tan5), width = 68)
            ColorBlood(color = colorResource(id = R.color.tan6), width = 38)

        }


        Spacer(modifier = Modifier.padding(10.dp))


        Text(
            text =  if (state1.value < 90 || state2.value < 60) {
                stringResource(id = R.string.hipoad)
            } else if (state1.value  >= 90 && state1.value  <= 119 && state2.value >= 60 && state2.value <= 79) {
                stringResource(id = R.string.normalad)
            } else if (state1.value  >= 120 && state1.value  <= 129 && state2.value >= 60 && state2.value <= 79) {
                stringResource(id = R.string.yuksekad)
            } else if (state1.value  >= 130 && state1.value  <= 139 || state2.value >= 80 && state2.value <= 89) {
                stringResource(id = R.string.hiperonead)
            } else if (state1.value  >= 140 && state1.value  <= 180 || state2.value >= 90 && state2.value <= 120) {
                stringResource(id = R.string.hipertwoad)
            } else if (state1.value  > 180 || state2.value > 120) {
                stringResource(id = R.string.tansifad)
            } else "Null",
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        )


        Spacer(modifier = Modifier.padding(10.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                ),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = stringResource(id = R.string.tarihvesaat),
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                //Text(text = "${stringResource(id = R.string.not)} +", color = colorResource(id = R.color.green), fontSize = 16.sp)


            }



            Text(
                text = currentDateAndTime,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

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

                        counter++

                            viewModel2.kayit(
                                0,
                                if (state1.value == 0)110 else state1.value,
                                if (state2.value == 0)110 else state2.value,
                                if (state3.value == 0)110 else state3.value,
                                currentDateAndTime
                            )


                        navController.navigate(BottomBarScreen.Audience.roote) {
                            popUpTo(0)
                        }

                        if (counter %4 == 0 && mInterstitialAd != null) {
                            mInterstitialAd?.show(context as Activity)
                        } else {
                            Log.d("TAG", "The interstitial ad wasn't ready yet.")
                        }

                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {


                Text(
                    text = stringResource(id = R.string.kaydet),
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold
                )

            }


        }


    }


}



data class BpTracker(
    val person_id: Int,
    val bTan: Int,
    val kTan: Int,
    val nabiz: Int
)


@Composable
fun ColorBlood(color: Color, width: Int) {

    Row(
        modifier = Modifier
            .width(width.dp)
            .height(13.dp)
            .background(color = color, shape = CircleShape)
    ) {

    }

}


@SuppressLint("ResourceAsColor", "NewApi")
@Composable
fun SimpleNumberPicker(
    value: Int,
    min: Int = 0,
    max: Int = 300,
    onValueChange: (Int) -> Unit,
    color: Color = Color.White


) {
    AndroidView(
        modifier = Modifier.fillMaxWidth(),
        factory = { context ->
            NumberPicker(context).apply {
                setOnValueChangedListener { numberPicker, i, i2 ->
                    onValueChange(numberPicker.value)
                }
                minValue = min
                maxValue = max
                this.value = value
                textColor = R.color.white
                showDividers = Color.White.value.toInt()
                textSize = 70.sp.value


            }
        },
        update = {},


        )
}

@SuppressLint("RememberReturnType")
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun PickerNumber(min: Int, max: Int, value: Int, state: MutableState<Int>) {

    val context = LocalContext.current
    val viewModel: AnasayfaViewModel = viewModel(
        factory = AnasayfaViewModelFactory(context.applicationContext as Application)
    )

    Row(
        modifier = Modifier
            .height(230.dp)
            .width(100.dp)
            .background(color = colorResource(id = R.color.backscreen)),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Column(
            modifier = Modifier
                .width(100.dp)
                .wrapContentHeight()
                .background(
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(15.dp)
                )
        ) {

            SimpleNumberPicker(value =  value , onValueChange = {


                state.value = it



            }, min = min, max = max)


        }


    }


}








