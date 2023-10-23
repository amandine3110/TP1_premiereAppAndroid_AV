package com.villatte.tp1_premiereappandroid

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
// import androidx.compose.foundation.layout.RowScopeInstance.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.villatte.tp1_premiereappandroid.ui.theme.TP1_premiereAppAndroidTheme


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TP1_premiereAppAndroidTheme {
        Greeting("Android")
    }
}

@Composable
fun Screen(windowClass: WindowSizeClass, navController: NavController) {
    when (windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp, 30.dp).fillMaxSize()
            ) {
                Image(
                    painterResource(id = R.drawable.chat_intelligent),
                    contentDescription = "Photo de profil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp,200.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    text = "Amandine Villatte",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "Etudiante",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "Ecole d'ingénieur ISIS - INU Champollion",
                    style = MaterialTheme.typography.bodySmall,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(Modifier.height(50.dp))
                Row() {
                    Image(
                        painterResource(id = R.drawable.mail_logo),
                        contentDescription = "Photo de profil", modifier = Modifier
                            .size(20.dp)
                    )
                    Text(
                        text = "amandine.villatte@etud.univ-jfc.fr",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Spacer(Modifier.height(5.dp))
                Row() {
                    Image(
                        painterResource(id = R.drawable.linkedin_logo),
                        contentDescription = "Photo de profil", modifier = Modifier
                            .size(20.dp)
                    )
                    Text(
                        text = "www.linkedin.com/in/amandine-villatte",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .paddingFromBaseline(2.dp)
                        //.align(Alignment.CenterHorizontally)
                    )
                }
                Button(onClick = {navController.navigate("filmsList")}, modifier = Modifier.padding(vertical = 40.dp)) {
                    Text(text = "Démarrer")
                }
            }
        }
            else -> {

Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
    Image(
        painterResource(id = R.drawable.chat_intelligent),
        contentDescription = "Photo de profil",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            //.width(200.dp)
            .size(200.dp,200.dp)
            .clip(CircleShape)
    )
    //Spacer(Modifier.weight(50.dp))
Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Spacer(Modifier.height(20.dp))
    Text(
        text = "Amandine Villatte",
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier
    )
    Spacer(Modifier.height(20.dp))
    Text(
        text = "Etudiante",
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier
    )
    Spacer(Modifier.height(5.dp))
    Text(
        text = "Ecole d'ingénieur ISIS - INU Champollion",
        style = MaterialTheme.typography.bodySmall,
        fontStyle = FontStyle.Italic,
        modifier = Modifier
    )
}
}
                    Spacer(Modifier.height(90.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row() {
                        Image(
                            painterResource(id = R.drawable.mail_logo),
                            contentDescription = "Logo mail", modifier = Modifier
                                .size(20.dp)
                        )
                        Text(
                            text = "amandine.villatte@etud.univ-jfc.fr",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    Spacer(Modifier.height(5.dp))
                    Row() {
                        Image(
                            painterResource(id = R.drawable.linkedin_logo),
                            contentDescription = "Logo LinkedIn", modifier = Modifier
                                .size(20.dp)
                        )
                        Text(
                            text = "www.linkedin.com/in/amandine-villatte",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier
                                .paddingFromBaseline(2.dp)
                            //.align(Alignment.CenterHorizontally)
                        )
                    }
                    }
                    Button(onClick = {navController.navigate("filmsList")}, modifier = Modifier.padding(horizontal = 5.dp, vertical = 140.dp)) {
                        Text(text = "Démarrer")
                    }
                }
        }
    }

