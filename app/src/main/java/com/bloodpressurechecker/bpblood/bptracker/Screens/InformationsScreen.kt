package com.bloodpressurechecker.bpblood.bptracker.Screens

import android.app.Activity
import android.opengl.Visibility
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentDialog
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bloodpressurechecker.bpblood.bptracker.R
import com.bloodpressurechecker.bpblood.bptracker.screen.*
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
var counterinfo = 0
@Composable
fun InformationsScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()

    SideEffect {

        systemUiController.setStatusBarColor(
            Color.White,
            darkIcons = true
        )
    }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.padding(top = 20.dp, bottom = 65.dp)
    ) {

        Text(
            text = stringResource(id = R.string.bilgiler),
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 22.sp,
            modifier = Modifier.padding(start = 20.dp, bottom = 20.dp)
        )
        InfoList(navController)


    }

}

data class DataInfo(
    val image: Int,
    val title: String,
    val str1 : String,
    val str2 : String,
    val str3 : String,
    val str4 : String,
    val str5 : String,
    val str6 : String,
    val str7 : String,
    val str8 : String,
    val str9 : String,
    val str10 : String,
    val str11 : String,
    val str12 : String,
    val str13 : String,
    val str14 : String,
    val str15 : String,
    val str16 : String,
    val str17 : String,
    val str18 : String,
    val str19 : String,
)




@Composable
fun InfoList(navController: NavController) {
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
LazyColumn {


 items(items = infoies) { items ->

     InfoCard(items, navController)

 }
}


}

@Composable
fun InfoCard(dataInfo: DataInfo, navController: NavController) {

    val context = LocalContext.current
Column(
 modifier = Modifier
     .background(shape = RoundedCornerShape(20.dp), color = Color.White)
     .fillMaxWidth()
     .height(170.dp)
     .padding(start = 20.dp, end = 20.dp, bottom = 15.dp)
     .clickable {
         counterinfo++
         DataTransfer(
             navController,
             title = dataInfo.title,
             image = dataInfo.image,
             str1 = dataInfo.str1,
             str2 = dataInfo.str2,
             str3 = dataInfo.str3,
             str4 = dataInfo.str4,
             str5 = dataInfo.str5,
             str6 = dataInfo.str6,
             str7 = dataInfo.str7,
             str8 = dataInfo.str8,
             str9 = dataInfo.str9,
             str10 = dataInfo.str10,
             str11 = dataInfo.str11,
             str12 = dataInfo.str12,
             str13 = dataInfo.str13,
             str14 = dataInfo.str14,
             str15 = dataInfo.str15,
             str16 = dataInfo.str16,
             str17 = dataInfo.str17,
             str18 = dataInfo.str18,
             str19 = dataInfo.str19,


             )

         if (counterinfo %5 == 0 && mInterstitialAd != null) {
             mInterstitialAd?.show(context as Activity)
             counterinfo=0
         } else {
             Log.d("TAG", "The interstitial ad wasn't ready yet.")
         }
     }


) {
 Card(
     modifier = Modifier
         .background(shape = RoundedCornerShape(20.dp), color = Color.White)
         .fillMaxWidth()
         .height(170.dp),


     ) {
     Image(
         painter = painterResource(id = dataInfo.image),
         contentDescription = "man",
         contentScale = ContentScale.Crop,
         modifier = Modifier.background(
             shape = RoundedCornerShape(30.dp)
             ,
             color = Color.White
         ).fillMaxWidth()

     )

     Text(
         text = dataInfo.title,
         fontSize = 20.sp,
         fontWeight = FontWeight.Bold,
         color = Color.White,
         modifier = Modifier
             .padding(start = 10.dp, top = 90.dp)
             .width(200.dp)
             .height(170.dp),
         textAlign = TextAlign.Left
     )
 }


}


}
fun DataTransfer(
navController: NavController,
title: String,
image: Int,
str1 : String,
str2 : String,
str3 : String,
str4 : String,
str5 : String,
str6 : String,
str7 : String,
str8 : String,
str9 : String,
str10 : String,
str11 : String,
str12 : String,
str13 : String,
str14 : String ,
str15 : String,
str16 : String,
str17 : String,
str18 : String,
str19 : String
) {

val ROUTE_USER_DETAILS = "info_details/data={data}"

val data = Data(
 title,
 image,
 str1 ,
 str2 ,
 str3 ,
 str4 ,
 str5 ,
 str6 ,
 str7 ,
 str8 ,
 str9 ,
 str10 ,
 str11 ,
 str12 ,
 str13 ,
 str14 ,
 str15 ,
 str16 ,
 str17 ,
 str18 ,
 str19 ,


)


val mapper = jacksonObjectMapper()


navController.navigate(

 ROUTE_USER_DETAILS.replace("{data}", mapper.writeValueAsString(data))
)


}

@Composable
fun InfoDetails(window : Window,data: Data) {

val systemUiController = rememberSystemUiController()

SideEffect {

 systemUiController.setStatusBarColor(
     Color.White,
     darkIcons = true
 )
}

val scrollState = rememberScrollState()



Column(

 modifier = Modifier
     .background(Color.White)
     .fillMaxSize()
) {

 //TopAppBar(backgroundColor = Color.Transparent, modifier = Modifier.height(75.dp)) {}

 Column(
     verticalArrangement = Arrangement.SpaceEvenly,
     modifier = Modifier.background(color = Color.White)
 ) {

     Box(
         modifier = Modifier
             .fillMaxSize()
             .background(color = Color.White)
             .verticalScroll(state = scrollState)
     ) {

         Image(
             painter = painterResource(id = data.soundImage),
             contentDescription = "man sezerrr",
             contentScale = ContentScale.FillBounds,
             modifier = Modifier
                 .fillMaxWidth()
                 .height(260.dp)
         )

         Column(
             modifier = Modifier
                 .padding(top = 220.dp)
                 .background(
                     shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
                     color = Color.White
                 )
                 .fillMaxWidth()
         ) {

             Text(
                 text = data.title,
                 color = Color.Black,
                 fontSize = 25.sp,
                 fontWeight = FontWeight.ExtraBold,
                 modifier = Modifier.padding(start = 20.dp, top = 30.dp)
             )
             Spacer(modifier = Modifier.padding(10.dp))


             Text(
                 text = data.str1,
                 fontSize = 18.sp,
                 color = Color.DarkGray,
                 modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 70.dp)
             )


             Column(verticalArrangement = Arrangement.SpaceEvenly) {
                 Row(modifier = Modifier
                     .fillMaxWidth()
                     .padding(start = 10.dp, end = 10.dp), verticalAlignment = Alignment.Bottom) {
                     Column(modifier = Modifier
                         .height(21.dp)
                         .width(5.dp)
                         .background(
                             color = colorResource(
                                 id = R.color.login
                             )
                         )
                         .padding(start = 10.dp, end = 10.dp),
                         verticalArrangement = Arrangement.Top
                     ) {

                     }

                     Text(
                         text = data.str2,
                         color = Color.Black,
                         fontSize = 20.sp,
                         fontWeight = FontWeight.ExtraBold,
                         modifier = Modifier.padding(start = 20.dp, end = 10.dp),

                     )



                 }

                 Text(
                     text = data.str3,
                     fontSize = 18.sp,
                     color = Color.DarkGray,
                     modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 70.dp)
                 )
             }




             Column(verticalArrangement = Arrangement.SpaceEvenly) {
                 Row(modifier = Modifier
                     .fillMaxWidth()
                     .padding(start = 10.dp, end = 10.dp), verticalAlignment = Alignment.Bottom) {
                     Column(modifier = Modifier
                         .height(21.dp)
                         .width(5.dp)
                         .background(
                             color = colorResource(
                                 id = R.color.login
                             )
                         )
                         .padding(start = 10.dp, end = 10.dp),
                         verticalArrangement = Arrangement.Top
                     ) {

                     }

                     Text(
                         text = data.str4,
                         color = Color.Black,
                         fontSize = 20.sp,
                         fontWeight = FontWeight.ExtraBold,
                         modifier = Modifier.padding(start = 20.dp, end = 10.dp),

                     )



                 }

                 Text(
                     text = data.str5,
                     fontSize = 18.sp,
                     color = Color.DarkGray,
                     modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 70.dp)
                 )
             }

             Column(verticalArrangement = Arrangement.SpaceEvenly) {
                 Row(modifier = Modifier
                     .fillMaxWidth()
                     .padding(start = 10.dp, end = 10.dp), verticalAlignment = Alignment.Bottom) {
                     Column(modifier = Modifier
                         .height(21.dp)
                         .width(5.dp)
                         .background(
                             color = colorResource(
                                 id = R.color.login
                             )
                         )
                         .padding(start = 10.dp, end = 10.dp),
                         verticalArrangement = Arrangement.Top
                     ) {

                     }

                     Text(
                         text = data.str6,
                         color = Color.Black,
                         fontSize = 20.sp,
                         fontWeight = FontWeight.ExtraBold,
                         modifier = Modifier.padding(start = 20.dp, end = 10.dp),

                     )



                 }

                 Text(
                     text = data.str7,
                     fontSize = 18.sp,
                     color = Color.DarkGray,
                     modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 70.dp)
                 )
             }

             Row(modifier = Modifier
                 .fillMaxWidth()
                 .padding(start = 10.dp, end = 10.dp), verticalAlignment = Alignment.Bottom) {
                 Column(modifier = Modifier
                     .height(21.dp)
                     .width(5.dp)
                     .background(
                         color = colorResource(
                             id = R.color.login
                         )
                     )
                     .padding(start = 10.dp, end = 10.dp),
                     verticalArrangement = Arrangement.Top
                 ) {

                 }

                 Text(
                     text = data.str8,
                     color = Color.Black,
                     fontSize = 20.sp,
                     fontWeight = FontWeight.ExtraBold,
                     modifier = Modifier.padding(start = 20.dp, end = 10.dp),

                 )



             }
             Text(
                 text = data.str9,
                 fontSize = 18.sp,
                 color = Color.DarkGray,
                 modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 70.dp)
             )


             Column(verticalArrangement = Arrangement.SpaceEvenly) {
                 Row(modifier = Modifier
                     .fillMaxWidth()
                     .padding(start = 10.dp, end = 10.dp), verticalAlignment = Alignment.Bottom) {
                     Column(modifier = Modifier
                         .height(21.dp)
                         .width(5.dp)
                         .background(
                             color = colorResource(
                                 id = R.color.login
                             )
                         )
                         .padding(start = 10.dp, end = 10.dp),
                         verticalArrangement = Arrangement.Top
                     ) {

                     }

                     Text(
                         text = data.str10,
                         color = Color.Black,
                         fontSize = 20.sp,
                         fontWeight = FontWeight.ExtraBold,
                         modifier = Modifier.padding(start = 20.dp, end = 10.dp),

                     )



                 }

                 Text(
                     text = data.str11,
                     fontSize = 18.sp,
                     color = Color.DarkGray,
                     modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 70.dp)
                 )
             }

             Column(verticalArrangement = Arrangement.SpaceEvenly) {
                 Row(modifier = Modifier
                     .fillMaxWidth()
                     .padding(start = 10.dp, end = 10.dp), verticalAlignment = Alignment.Bottom) {
                     Column(modifier = Modifier
                         .height(21.dp)
                         .width(5.dp)
                         .background(
                             color = colorResource(
                                 id = R.color.login
                             )
                         )
                         .padding(start = 10.dp, end = 10.dp),
                         verticalArrangement = Arrangement.Top
                     ) {

                     }

                     Text(
                         text = data.str12,
                         color = Color.Black,
                         fontSize = 20.sp,
                         fontWeight = FontWeight.ExtraBold,
                         modifier = Modifier.padding(start = 20.dp, end = 10.dp),

                     )



                 }

                 Text(
                     text = data.str13,
                     fontSize = 18.sp,
                     color = Color.DarkGray,
                     modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 70.dp)
                 )
             }

             Row(modifier = Modifier
                 .fillMaxWidth()
                 .padding(start = 10.dp, end = 10.dp), verticalAlignment = Alignment.Bottom) {
                 Column(modifier = Modifier
                     .height(21.dp)
                     .width(5.dp)
                     .background(
                         color = colorResource(
                             id = R.color.login
                         )
                     )
                     .padding(start = 10.dp, end = 10.dp),
                     verticalArrangement = Arrangement.Top
                 ) {

                 }

                 Text(
                     text =data.str14,
                     color = Color.Black,
                     fontSize = 20.sp,
                     fontWeight = FontWeight.ExtraBold,
                     modifier = Modifier.padding(start = 20.dp, end = 10.dp),

                 )



             }
             Text(
                 text = data.str15,
                 fontSize = 18.sp,
                 color = Color.DarkGray,
                 modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 70.dp)
             )


             Column(verticalArrangement = Arrangement.SpaceEvenly) {
                 Row(modifier = Modifier
                     .fillMaxWidth()
                     .padding(start = 10.dp, end = 10.dp), verticalAlignment = Alignment.Bottom) {
                     Column(modifier = Modifier
                         .height(21.dp)
                         .width(5.dp)
                         .background(
                             color = colorResource(
                                 id = R.color.login
                             )
                         )
                         .padding(start = 10.dp, end = 10.dp),
                         verticalArrangement = Arrangement.Top
                     ) {

                     }

                     Text(
                         text = data.str16,
                         color = Color.Black,
                         fontSize = 20.sp,
                         fontWeight = FontWeight.ExtraBold,
                         modifier = Modifier.padding(start = 20.dp, end = 10.dp),

                     )



                 }

                 Text(
                     text = data.str17,
                     fontSize = 18.sp,
                     color = Color.DarkGray,
                     modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 70.dp)
                 )
             }

             Column(verticalArrangement = Arrangement.SpaceEvenly) {
                 Row(modifier = Modifier
                     .fillMaxWidth()
                     .padding(start = 10.dp, end = 10.dp), verticalAlignment = Alignment.Bottom) {
                     Column(modifier = Modifier
                         .height(21.dp)
                         .width(5.dp)
                         .background(
                             color = colorResource(
                                 id = R.color.login
                             )
                         )
                         .padding(start = 10.dp, end = 10.dp),
                         verticalArrangement = Arrangement.Top
                     ) {

                     }

                     Text(
                         text = data.str18,
                         color = Color.Black,
                         fontSize = 20.sp,
                         fontWeight = FontWeight.ExtraBold,
                         modifier = Modifier.padding(start = 20.dp, end = 10.dp),
                     )



                 }

                 Text(
                     text = data.str19,
                     fontSize = 18.sp,
                     color = Color.DarkGray,
                     modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 70.dp)
                 )
             }




         }

     }

 }


}




}
