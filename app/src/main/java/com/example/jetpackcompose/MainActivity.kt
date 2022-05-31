package com.example.jetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

private val messages: List<MyMessage> = listOf(
    MyMessage("Hola JetPack Compose 1", "¿Preparada? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean laoreet finibus erat, vitae tristique nisl pellentesque in. "),
    MyMessage("Hola JetPack Compose 2", "¿Preparada? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean laoreet finibus erat, vitae tristique nisl pellentesque in. Nunc auctor tristique risus, lacinia faucibus libero pellentesque rutrum. "),
    MyMessage("Hola JetPack Compose 3", "¿Preparada? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean laoreet finibus erat, vitae tristique nisl pellentesque in. Nunc auctor tristique risus. "),
    MyMessage("Hola JetPack Compose 4d", "¿Preparada? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean laoreet finibus erat, vitae tristique nisl pellentesque in. Nunc auctor tristique risus, lacinia faucibus libero pellentesque rutrum. "),
    MyMessage("Hola JetPack Compose 5", "¿Preparada? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean laoreet finibus erat, vitae tristique nisl pellentesque in. Nunc auctor tristique risus, lacinia faucibus libero pellentesque rutrum. Nam eget augue neque. Mauris in suscipit risus, sed lacinia nisl. Nulla augue felis, tincidunt in nisl eget, fringilla consectetur tellus."),
    MyMessage("Hola JetPack Compose 6", "¿Preparada? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean laoreet finibus erat, vitae tristique nisl pellentesque in. Nunc auctor tristique risus, lacinia faucibus libero pellentesque rutrum. Nam eget augue neque. Mauris in suscipit risus, sed lacinia nisl. "),
    MyMessage("Hola JetPack Compose 76", "¿Preparada? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean laoreet finibus erat, vitae tristique nisl pellentesque in. Nunc auctor tristique risus, lacinia faucibus libero pellentesque rutrum. Nam eget augue neque. Mauris in suscipit risus, sed lacinia nisl. Nulla augue felis, tincidunt in nisl eget."),
    MyMessage("Hola JetPack Compose 8", "¿Preparada? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean laoreet finibus erat, vitae tristique nisl pellentesque in. Nunc auctor tristique risus, lacinia faucibus libero pellentesque rutrum. "),
    MyMessage("Hola JetPack Compose 9", "¿Preparada? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean laoreet finibus erat, vitae tristique nisl pellentesque in. Nunc auctor tristique risus, lacinia faucibus libero pellentesque rutrum. Nam eget augue neque. Mauris in suscipit risus, sed lacinia nisl. Nulla augue felis, tincidunt in nisl eget, fringilla consectetur tellus. Phasellus sagittis luctus diam, quis egestas dolor blandit eu. Suspendisse elementum justo nibh."),
    MyMessage("Hola JetPack Compose 10", "¿Preparada? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean laoreet finibus erat, vitae tristique nisl pellentesque in. Nunc auctor tristique risus, lacinia faucibus libero pellentesque rutrum. Nam eget augue neque. Mauris in suscipit risus, sed lacinia nisl. Nulla augue felis, tincidunt in nisl eget, fringilla consectetur tellus. Phasellus sagittis luctus diam, quis egestas dolor blandit eu. Suspendisse elementum justo nibh, vel elementum nisi ultrices in. Praesent ipsum massa, tempus sit amet purus id, euismod pellentesque lorem."),
    MyMessage("Hola JetPack Compose 11", "¿Preparada? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean laoreet finibus erat, vitae tristique nisl pellentesque in. Nunc auctor tristique risus, lacinia faucibus libero pellentesque rutrum. "),
    MyMessage("Hola JetPack Compose 12", "¿Preparada? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean laoreet finibus erat, vitae tristique nisl pellentesque in. Nunc auctor tristique risus, lacinia faucibus libero pellentesque rutrum. Nam eget augue neque. Mauris in suscipit risus, sed lacinia nisl. Nulla augue felis, tincidunt in nisl eget, fringilla consectetur tellus. Phasellus sagittis luctus diam, quis egestas dolor blandit eu. Suspendisse elementum justo nibh, vel elementum nisi ultrices in. Praesent ipsum massa."),
    MyMessage("Hola JetPack Compose 13", "¿Preparada? Lorem ipsum dolor sit amet, consectetur adipiscing elit"),

)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            JetpackComposeTheme() {
                MyMessages(messages)
            }
        }
    }
}

data class MyMessage(val title: String, val body: String)

@Composable
fun MyMessages(messages: List<MyMessage>){
    LazyColumn{
        items(messages) { message ->
            MyComponent(message)
        }
    }
}

@Composable
fun MyComponent(message: MyMessage){
    Row(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(8.dp)) {
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyImage(){
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        "Mi imagen de prueba",
        modifier = Modifier
            .clip(CircleShape)
            .size(64.dp)
            .background(MaterialTheme.colors.primary)
    
    )
}

@Composable
fun MyTexts(message: MyMessage){

    var expanded by remember{ mutableStateOf( false)}

    Column(modifier = Modifier
        .padding(start = 8.dp)
        .clickable {

            expanded = !expanded

        }){
        MyText(
                message.title,
                MaterialTheme.colors.primary,
                MaterialTheme.typography.subtitle1)
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            message.body,
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2,
            if(expanded) Int.MAX_VALUE else 1
        )

    }
}

@Composable
fun MyText(text: String, color: Color, style: androidx.compose.ui.text.TextStyle, lines: Int = Int.MAX_VALUE){
    Text(text, color = color, style = style, maxLines = lines)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewCompat(){
    JetpackComposeTheme() {
        MyMessages(messages)
    }
}


