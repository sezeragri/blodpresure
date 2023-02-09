package com.bloodpressurechecker.bpblood.bptracker.Screens

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.bloodpressurechecker.bpblood.bptracker.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@ExperimentalPagerApi
@Composable
fun ProfileScreen(navController: NavController) {

    val appURL = "https://play.google.com/store/apps/details?id=com.bloodpressurechecker.bpblood.bptracker.screen"
    val appURLPrivacy = "https://www.freeprivacypolicy.com/live/7ca4593e-db20-4848-a1b7-c4e72f512add"
    val systemUiController = rememberSystemUiController()
    val context = LocalContext.current
    
    val hey = stringResource(id = R.string.heyy)

    SideEffect {

        systemUiController.setStatusBarColor(
            Color.LightGray,
            darkIcons = true
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {


        Text(
            text = stringResource(id = R.string.ayarlar),
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 30.dp, top = 20.dp)
        )


        //Records(navController)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 15.dp, end = 15.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(25.dp)
                ),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
                    .padding(top = 20.dp)
                    .clickable {


                        openPlayStore(context, appURL)

                    },
                verticalAlignment = Alignment.CenterVertically
            ) {

                Spacer(modifier = Modifier.padding(8.dp))
                Column(
                    modifier = Modifier
                        .size(45.dp)
                        .background(color = Color.LightGray, shape = RoundedCornerShape(12.dp)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {

                    Image(
                        painter = painterResource(id = R.drawable.rate),
                        contentDescription = "rate",
                        modifier = Modifier
                            .size(30.dp)


                    )
                }


                Spacer(modifier = Modifier.padding(20.dp))

                Text(text = stringResource(id = R.string.oy), color = Color.DarkGray, fontSize = 20.sp)


            }



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(top = 50.dp)
                    .clickable {

                        val sendIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(
                                Intent.EXTRA_TEXT,
                                " ${hey} !  ${appURL}"
                            )
                            type = "text/plain"
                        }
                        val shareIntent = Intent.createChooser(sendIntent, null)
                        context.startActivity(shareIntent)

                    },
                verticalAlignment = Alignment.CenterVertically
            ) {


                Spacer(modifier = Modifier.padding(8.dp))
                Column(
                    modifier = Modifier
                        .size(45.dp)
                        .background(color = Color.Blue, shape = RoundedCornerShape(12.dp)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_sharenew),
                        contentDescription = "share",
                        modifier = Modifier
                            .size(30.dp)
                            .shadow(shape = RectangleShape, elevation = 0.dp)
                    )
                }

                Spacer(modifier = Modifier.padding(20.dp))

                Text(text = stringResource(id = R.string.ark), color = Color.DarkGray, fontSize = 20.sp)


            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(top = 50.dp)
                    .clickable {
                        context.sendMail(
                            to = "simsekmehmet7588@gmail.com",
                            subject = "Some subject"
                        )

                    },
                verticalAlignment = Alignment.CenterVertically
            ) {


                Spacer(modifier = Modifier.padding(8.dp))
                Column(
                    modifier = Modifier
                        .size(45.dp)
                        .background(color = Color.Magenta, shape = RoundedCornerShape(12.dp)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_feedback),
                        contentDescription = "feedback",
                        modifier = Modifier
                            .size(30.dp)

                    )

                }
                Spacer(modifier = Modifier.padding(20.dp))

                Text(text = stringResource(id = R.string.geri), color = Color.DarkGray, fontSize = 20.sp)


            }



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                    )
                    .padding(top = 50.dp, bottom = 20.dp)
                    .clickable { openPlayStore(context, appURLPrivacy) },
                verticalAlignment = Alignment.CenterVertically
            ) {


                Spacer(modifier = Modifier.padding(8.dp))
                Column(
                    modifier = Modifier
                        .size(45.dp)
                        .background(color = Color.LightGray, shape = RoundedCornerShape(12.dp)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_privacy),
                        contentDescription = "privacy",
                        modifier = Modifier
                            .size(30.dp)
                            .shadow(shape = RoundedCornerShape(20.dp), elevation = 0.dp)
                    )
                }

                Spacer(modifier = Modifier.padding(20.dp))

                Text(text = stringResource(id = R.string.gizlilik), color = Color.DarkGray, fontSize = 20.sp)


            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Transparent)
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Version 1.1.1", color = Color.Gray, fontSize = 22.sp)

        }
    }
}




fun openPlayStore(activityContext: Context, appURL: String) {
    val playIntent: Intent = Intent().apply {

        action = Intent.ACTION_VIEW

        data = Uri.parse(appURL)

    }
    try {
        activityContext.startActivity(playIntent)
    } catch (e: Exception) {
        // handle the exception
    }
}



fun Context.sendMail(to: String, subject: String) {
    try {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "message/rfc822" // or "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        // TODO: Handle case where no email app is available
    } catch (t: Throwable) {
        // TODO: Handle potential other type of exceptions
    }
}



