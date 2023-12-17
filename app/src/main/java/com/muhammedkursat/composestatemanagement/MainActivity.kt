package com.muhammedkursat.composestatemanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammedkursat.composestatemanagement.ui.theme.ComposeStateManagementTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}
@Composable
fun MyButton(){
    Button(onClick = {
        println("Buttona tıklandı Selam")
    }, colors = ButtonDefaults.buttonColors(Color.Green),


    ) {
        Text(text = "Button", fontSize = 25.sp, color = Color.Black)
    }
    Spacer(modifier = Modifier.padding(5.dp))
}

@Composable
fun MyText(myText: String,color: Color){
        Text(text = myText,
            modifier = Modifier
                .background(color = color, shape = MaterialTheme.shapes.large)
                .clickable {
                    if (myText.equals("Selam")) {
                        println("Selam Sana")
                    } else {
                        println("aleykum Sana")
                    }

                }
                .padding(10.dp),
            color = Color.Black,
            fontSize = 25.sp,
            fontStyle = null
        )
        Spacer(modifier = Modifier.padding(5.dp))
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(){
    var myString = remember {
        mutableStateOf("Jet Compose")
    }
    //var myString :String= "Jetpack Compose"
    TextField(value = myString.value, onValueChange = {
        myString.value=it
    })
}
@Composable
fun Imagem(){
    Image(bitmap = ImageBitmap.imageResource(id = R.drawable.mhmd),
        contentDescription = "Hazreti Muhammed Sallalahu Aleyhi ve Sellem",
        modifier = Modifier
            .background(color = Color.Black)
            //.fillMaxSize()
            .size(100.dp))
    Spacer(modifier = Modifier.padding(5.dp))
}
@Composable
fun MainScreen(){
    Surface(color = Color.LightGray) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {
            MyText(myText = "Selam",Color.Blue)
            MyText(myText = "aleyküm",Color.Red)
            MyButton()
            Imagem()
            MyTextField()

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen()
}