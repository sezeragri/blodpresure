package com.bloodpressurechecker.bpblood.bptracker.screen

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.ContextWrapper
import android.util.Log
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.PathNode
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bloodpressurechecker.bpblood.bptracker.R
import com.bloodpressurechecker.bpblood.bptracker.Screens.counter
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlinx.coroutines.delay

 var mInterstitialAd: InterstitialAd? = null
 var adRequest: AdRequest? =null
 var count  = 0
@Composable
fun Login(navController: NavController) {
    val context = LocalContext.current
    var progress by remember { mutableStateOf(0.1f) }
    var adRequest = AdRequest.Builder().build()

    val systemUiController = rememberSystemUiController()
    systemUiController.isNavigationBarVisible = false

    SideEffect {

        systemUiController.setSystemBarsColor(
            Color(0xFF00ADB1),
            darkIcons = true
        )
    }






    Surface(
        modifier = Modifier
            .background(colorResource(id = R.color.teal_200))
            .fillMaxSize()
    ) {


        val scale = remember {
            Animatable(0f)
        }

        val animatedProgress = animateFloatAsState(
            targetValue = progress,
            animationSpec = tween(durationMillis = 3000, delayMillis = 3000)
        ).value


        LaunchedEffect(key1 = true) {

            scale.animateTo(
                targetValue = 0.6f,
                animationSpec = tween(durationMillis = 800, easing = {
                    OvershootInterpolator(7f).getInterpolation(it)
                })
            )

            delay(5000L)
            navController.navigate(route = BottomBarScreen.Home.roote)
            count++

            if (count %2 == 0 && mInterstitialAd != null) {
                mInterstitialAd?.show(context as Activity)


            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.")
            }



        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.background(colorResource(id = R.color.login))
        ) {


            Icon(
                painter = painterResource(id = R.drawable.ic_heart),
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .padding(start = 15.dp)
                    .scale(scale.value),
                tint = Color.White,


                )

            Text(
                text = "BLOOD PRESSURE",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 15.dp)
            )
            Text(
                text = "TRACKER & INFO",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 15.dp)
            )

        }

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)



        ) {
            var progress by remember { mutableStateOf(0f) }
            val progressAnimDuration = 5000
            val progressAnimation by animateFloatAsState(
                targetValue = progress,
                animationSpec = tween(
                    durationMillis = progressAnimDuration,
                    easing = FastOutSlowInEasing
                )
            )
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 60.dp, start = 10.dp, end = 10.dp),
                progress = progressAnimation,
                color = Color.White,
                backgroundColor = colorResource(id = R.color.teal_200)
            )
            LaunchedEffect(progress) {
                progress = 1f
            }
        }


    }
}



fun addListener(context: Context) {

    mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
        override fun onAdClicked() {
            // Called when a click is recorded for an ad.
            Log.d(ContentValues.TAG, "Ad was clicked.")
        }

        override fun onAdDismissedFullScreenContent() {
            // Called when ad is dismissed.
            Log.d(ContentValues.TAG, "Ad dismissed fullscreen content.")
            mInterstitialAd = null
            adsLoaded(context)
           counter= 1

        }

        override fun onAdFailedToShowFullScreenContent(p0: AdError) {

            mInterstitialAd = null

        }

    }
}

fun adsLoaded(context: Context) {
    adRequest = AdRequest.Builder().build()

    InterstitialAd.load(context, "ca-app-pub-4270315255262769/9425865628",
        adRequest!!, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d(ContentValues.TAG, adError?.toString())
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                mInterstitialAd = interstitialAd
                addListener(context)


            }


        })
}

