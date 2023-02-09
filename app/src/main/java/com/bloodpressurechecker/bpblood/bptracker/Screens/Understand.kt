package com.bloodpressurechecker.bpblood.bptracker.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bloodpressurechecker.bpblood.bptracker.R
import com.bloodpressurechecker.bpblood.bptracker.screen.BottomBarScreen
import com.bloodpressurechecker.bpblood.bptracker.screen.Screen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlin.math.tan


@Composable
fun Understand(navController: NavController) {


    val systemUiController = rememberSystemUiController()
    SideEffect {

        systemUiController.setStatusBarColor(
            Color.LightGray,
            darkIcons = false
        )

    }
    Column(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
    ) {

        TopAppBar(backgroundColor = Color.LightGray) {

            Text(
                text = stringResource(id = R.string.kategori),
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(start = 15.dp, top = 5.dp)
            )
        }

        Column(
            modifier = Modifier
                .padding(
                    top = 50.dp,
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 50.dp
                )
                .background(color = Color.White, shape = RoundedCornerShape(25.dp))
        ) {

            tancardList()


        }

        Spacer(modifier = Modifier.padding(20.dp))
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

                    navController.navigate(Screen.AddValue.roote) {
                        popUpTo(0)
                    }


                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {


            Text(
                text = stringResource(id = R.string.anladım),
                fontSize = 25.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )

        }
    }
}

@Composable
fun tancard(tandata: tandata) {

    Row(
        modifier = Modifier
            .background(color = Color.White, RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .padding(top = 20.dp, start = 15.dp, bottom = 20.dp),
        verticalAlignment = Alignment.CenterVertically,

        ) {

        Box(
            modifier = Modifier
                .background(color = tandata.color, shape = CircleShape)
                .size(35.dp)
                .padding(start = 15.dp)
        )

        Spacer(modifier = Modifier.padding(12.dp))

        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = tandata.nametan,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.Black
            )

            Text(
                text = tandata.deger,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                color = Color.DarkGray
            )

        }





    }
}

data class tandata(
    val nametan: String,
    val deger: String,
    val color: Color
)


@Composable
fun tancardList() {

    val tann = listOf(

        tandata(
            nametan = stringResource(id = R.string.hipotansiyon),
            deger = "${stringResource(id = R.string.buyuk_tansiyon)} < 90 &  ${stringResource(id = R.string.kucuk_tansiyon)} < 60",
            color = colorResource(id = R.color.tan1)
        ),
        tandata(
            nametan = stringResource(id = R.string.normal),
            deger = "${stringResource(id = R.string.buyuk_tansiyon)} 90-119 &  ${stringResource(id = R.string.kucuk_tansiyon)} 60-79",
            color = colorResource(id = R.color.tan2)

        ),
        tandata(
            nametan = stringResource(id = R.string.yüksek),
            deger = "${stringResource(id = R.string.buyuk_tansiyon)} 120-129 &  ${stringResource(id = R.string.kucuk_tansiyon)} 60-79",
            color = colorResource(id = R.color.tan3)
        ),
        tandata(
            nametan = stringResource(id = R.string.hipertansiyonbirinciasama),
            deger = "${stringResource(id = R.string.buyuk_tansiyon)} 130-139 ||  ${stringResource(id = R.string.kucuk_tansiyon)} 80-89",
            color = colorResource(id = R.color.tan4)
        ),
        tandata(
            nametan = stringResource(id = R.string.hipertansiyonikinciasama),
            deger = "${stringResource(id = R.string.buyuk_tansiyon)} 140-180 ||  ${stringResource(id = R.string.kucuk_tansiyon)} 90-120",
            color = colorResource(id = R.color.tan5)
        ),
        tandata(
            nametan = stringResource(id = R.string.hipertansif),
            "${stringResource(id = R.string.buyuk_tansiyon)} > 180 ||  ${stringResource(id = R.string.kucuk_tansiyon)} > 120",
            color = colorResource(id = R.color.tan6)
        )
    )

    LazyColumn(content = {
        items(items = tann, itemContent = {

            tancard(it)
        })

    })

}