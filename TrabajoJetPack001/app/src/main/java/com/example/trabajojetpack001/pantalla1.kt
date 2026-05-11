package com.example.trabajojetpack001

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun PantallaPrincipal(navController: NavController) {
    var number by remember { mutableIntStateOf(0) }
    var sms by remember { mutableStateOf(" ") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "CONTADOR : :")

        Text("$number", fontSize = 40.sp)
        // Add el boton
        BotonAdd(){
            number++
            if (number>=5){
                sms = "ALTO"
            }else if(number >=-5)
                sms = ""

        }
        Boton2(){
            number--
            if (number<=-5){
                sms = "BAJO"
            }else if(number <=5)
                sms = ""
        }

        Text("$sms" )

        Button(onClick = {
            navController.navigate("MessageCard")
        }) {
            Text("Ir a otra pantalla")
        }
    }
}


@Composable
fun BotonAdd(onClick: () -> Unit) {

    Button(
        onClick = {
            onClick()
        }
    ) {
        Text("ADD")
    }
}

@Composable
fun Boton2(onClick: () -> Unit) {

    Button(
        onClick = {
            onClick()
        }
    ) {
        Text("DISMINUIR")
    }
}

