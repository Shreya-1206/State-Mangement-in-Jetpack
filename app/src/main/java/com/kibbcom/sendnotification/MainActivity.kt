package com.kibbcom.sendnotification

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var counter :MutableState<Int> =  remember { mutableStateOf(0) }
          Column {
              sendNotification(counter.value, {counter.value++})   /// here we add the parameter 1 and second is lamdba and used it in composable to invoke this lambda
              cardNotification(counter.value)
          }
        }
    }
}



@Composable

fun sendNotification (counter :Int, increment : () -> Unit) {

//    Log.d("TAGGED", "Intial render")
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have sent ${counter} notifications")
        Button(
            onClick = {
                 increment()
                Log.d("TAGGED" , "intial render and on button click render")
            }) {

            Text(text = "Send Notification")

        }
    }

}


@Composable

fun cardNotification(counter :Int) {
    Card (
        elevation = CardDefaults.cardElevation(9.dp)
    ){
        Row (
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 7.dp)
        ){
            Image(
                imageVector =Icons.Outlined.MailOutline,
                contentDescription = "Message box"
            )
            Text(text = "There are $counter messages sent")
        }
    }
}