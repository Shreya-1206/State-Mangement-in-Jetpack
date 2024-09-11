package com.kibbcom.sendnotification

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kibbcom.sendnotification.ui.theme.SendNotificationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
          sendNotification()
        }
    }
}




@Preview(showBackground = true)
@Composable

fun sendNotification () {
    var counter :MutableState<Int> =  remember { mutableStateOf(0) }
//    Log.d("TAGGED", "Intial render")
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have sent ${counter.value} notifications")
        Button(
            onClick = {
                counter.value++
                Log.d("TAGGED" , "intial render and on button click render")
            }) {

            Text(text = "Send Notification")

        }
    }

}
