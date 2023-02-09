package com.bloodpressurechecker.bpblood.bptracker.Screens

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bloodpressurechecker.bpblood.bptracker.screen.AnasayfaViewModel
import com.bloodpressurechecker.bpblood.bptracker.screen.AnasayfaViewModelFactory
import com.bloodpressurechecker.bpblood.bptracker.R


@Composable
fun Past() {
    var sum: Int = 0
    var sumkucuk: Int = 0
    var sumNabiz: Int = 0
    val context = LocalContext.current
    val viewModel: AnasayfaViewModel = viewModel(
        factory = AnasayfaViewModelFactory(context.applicationContext as Application)
    )
    val enSon = viewModel.personbTan.observeAsState(listOf())


    val ort = viewModel.personList.observeAsState(listOf())

    for (j in ort.value) {

        sum += j.bTan
        sumkucuk += j.kTan
        sumNabiz += j.nabiz

    }

    val maxBtan = viewModel.personMaxBtan.value
    val maxKtan = viewModel.personMaxKtan.value
    val maxNabiz = viewModel.personMaxNabiz.value
    val minBtan = viewModel.personMinBtan.value
    val minKtan = viewModel.personMinKtan.value
    val minNabiz = viewModel.personMinNabiz.value




    for (s in enSon.value) {
        val buyuk = sum / (ort.value.size)
        val kucuk = sumkucuk / (ort.value.size)
        val pasts = listOf(
            PastData(
                title = stringResource(id = R.string.ortalama),
                bTan = buyuk,
                kTan = kucuk,
                nabiz = sumNabiz / (ort.value.size),

                color = if (buyuk < 90 || kucuk < 60) {
                    colorResource(id = R.color.tan1)
                } else if (buyuk >= 90 && buyuk <= 119 && kucuk >= 60 && kucuk <= 79) {
                    colorResource(id = R.color.tan2)
                } else if (buyuk >= 120 && buyuk <= 129 && kucuk >= 60 && kucuk <= 79) {
                    colorResource(id = R.color.tan3)
                } else if (buyuk >= 130 && buyuk <= 139 || kucuk >= 80 && kucuk <= 89) {
                    colorResource(id = R.color.tan4)
                } else if (buyuk >= 140 && buyuk <= 180 || kucuk >= 90 && kucuk <= 120) {
                    colorResource(id = R.color.tan5)
                } else if (buyuk > 180 || kucuk > 120) {
                    colorResource(id = R.color.tan6)
                } else colorResource(id = R.color.purple_500)

            ),
            PastData(
                title = stringResource(id = R.string.en_son),
                bTan = s.bTan,
                kTan = s.kTan,
                nabiz = s.nabiz,
                color = if (s.bTan < 90 || s.kTan < 60) {
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
                } else colorResource(id = R.color.purple_500)

            ),
            PastData(
                title = "MAX",
                bTan = maxBtan!!,
                kTan = maxKtan!!,
                nabiz = maxNabiz!!,
                color = if (maxBtan < 90 || maxKtan < 60) {
                    colorResource(id = R.color.tan1)
                } else if (maxBtan >= 90 && maxBtan <= 119 && maxKtan >= 60 && maxKtan <= 79) {
                    colorResource(id = R.color.tan2)
                } else if (maxBtan >= 120 && maxBtan <= 129 && maxKtan >= 60 && maxKtan <= 79) {
                    colorResource(id = R.color.tan3)
                } else if (maxBtan >= 130 && maxBtan <= 139 || maxKtan >= 80 && maxKtan <= 89) {
                    colorResource(id = R.color.tan4)
                } else if (maxBtan >= 140 && maxBtan <= 180 || maxKtan >= 90 && maxKtan <= 120) {
                    colorResource(id = R.color.tan5)
                } else if (maxBtan > 180 || maxKtan > 120) {
                    colorResource(id = R.color.tan6)
                } else colorResource(id = R.color.purple_500)

            ),
            PastData(
                title = "MIN",
                bTan = minBtan!!,
                kTan = minKtan!!,
                nabiz = minNabiz!!,
                color = if (minBtan < 90 || minKtan < 60) {
                    colorResource(id = R.color.tan1)
                } else if (minBtan >= 90 && minBtan <= 119 && minKtan >= 60 && minKtan <= 79) {
                    colorResource(id = R.color.tan2)
                } else if (minBtan >= 120 && minBtan <= 129 && minKtan >= 60 && minKtan <= 79) {
                    colorResource(id = R.color.tan3)
                } else if (minBtan >= 130 && minBtan <= 139 || minKtan >= 80 && minKtan <= 89) {
                    colorResource(id = R.color.tan4)
                } else if (minBtan >= 140 && minBtan <= 180 || minKtan >= 90 && minKtan <= 120) {
                    colorResource(id = R.color.tan5)
                } else if (minBtan > 180 || minKtan > 120) {
                    colorResource(id = R.color.tan6)
                } else colorResource(id = R.color.purple_500)

            ),

        )

        LazyColumn(content = {
            items(items = pasts, itemContent = { item ->

                PastCard(item)
            })
        })

    }
}

data class PastData(
    val title: String,
    val bTan: Int,
    val kTan: Int,
    val nabiz: Int,
    val color: Color
)

@Composable
fun PastCard(pastData: PastData) {
    Row(modifier = Modifier.padding(bottom = 15.dp))
    {

        Row(
            modifier = Modifier
                .background(
                    color = pastData.color,
                    RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)
                )
                .weight(1f)
                .height(150.dp)
        ) {

        }


        Column(
            modifier = Modifier
                .weight(13f)
                .height(150.dp)
                .background(
                    color = Color.White,
                    RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp)
                )
                .padding(start = 10.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = pastData.title,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Column(verticalArrangement = Arrangement.SpaceEvenly) {
                    Text(
                        text = stringResource(id = R.string.buyuk_tansiyon),
                        color = Color.DarkGray,
                        fontSize = 13.sp
                    )
                    Text(
                        text = pastData.bTan.toString(),
                        color = Color.Black,
                        fontSize = 35.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(text = "mmHg", color = Color.DarkGray, fontSize = 13.sp)


                }
                //Box(modifier = Modifier.fillMaxHeight(0.5f).width(2.dp).background(color = Color.LightGray))

                Column(verticalArrangement = Arrangement.SpaceEvenly) {
                    Text(
                        text = stringResource(id = R.string.kucuk_tansiyon),
                        color = Color.DarkGray,
                        fontSize = 13.sp
                    )
                    Text(
                        text = pastData.kTan.toString(),
                        color = Color.Black,
                        fontSize = 35.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(text = "mmHg", color = Color.DarkGray, fontSize = 13.sp)

                }

                Column(verticalArrangement = Arrangement.SpaceEvenly) {
                    Text(
                        text = stringResource(id = R.string.nabiz),
                        color = Color.DarkGray,
                        fontSize = 13.sp
                    )
                    Text(
                        text = pastData.nabiz.toString(),
                        color = Color.Black,
                        fontSize = 35.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(text = "BPM", color = Color.DarkGray, fontSize = 13.sp)

                }

            }

        }
    }

}