package com.anasskhouyyi.jetbizcard


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anasskhouyyi.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard(){
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(412.dp)
            .height(300.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                CreatorImageProfile()
                Divider(thickness = 2.dp, color = Color.Black)
                CreateInfo()
                Button(onClick = {
                    buttonClickedState.value = !buttonClickedState.value
                }
                ){
                    Text(text = "Portfolio", style = MaterialTheme.typography.displayMedium)
                }
                if(buttonClickedState.value){
                    Content()
                    Text(text = "hello")
                }else{
                    Box {
                    }
                }
            }
        }
    }
}
//@Preview
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){}
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
                shape = RoundedCornerShape(corner = CornerSize(6.dp)),
                border = BorderStroke(width = 2.dp,
                color = Color.LightGray)) {
            Portfolio(data = listOf("Project 1",
                "Project 2",
                "Project 3",
                "Project 4"))
        }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data) { item ->
            Text(item)
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Anass K.",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(text = "Engineer", modifier = Modifier.padding(0.dp))
        Text(text = "06 01 24 00 65", modifier = Modifier.padding(0.dp))
    }
}

@Composable
private fun CreatorImageProfile() {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        tonalElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.icone_image_profile),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    JetBizCardTheme {
        CreateBizCard()
    }
}