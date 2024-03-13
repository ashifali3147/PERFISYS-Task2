package com.tlw.perfisystask2.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tlw.perfisystask2.R
import com.tlw.perfisystask2.ui.theme.BodyText
import com.tlw.perfisystask2.ui.theme.HintText

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Spacer(modifier = )

        ToolBarTitle(title = "Profile")
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.user_profile),
            contentDescription = "profile image",
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier
                .size(100.dp)
                .border(
                    BorderStroke(3.dp, Color.Black),
                    CircleShape
                )
                .padding(3.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(20.dp))
        CustomCard(modifier = Modifier.height(50.dp), title = "Ashif", fontWeight = FontWeight.Bold)
        Row {
            CustomCard(
                modifier = Modifier
                    .height(70.dp)
                    .weight(1f)
                    .padding(end = 10.dp),
                title = "Share",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                fontColor = HintText
            )
            CustomCard(
                modifier = Modifier
                    .height(70.dp)
                    .weight(1f)
                    .padding(start = 10.dp),
                title = "Contact us",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                fontColor = HintText
            )
        }
        CustomCard(
            modifier = Modifier.height(50.dp),
            title = "About us",
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            fontColor = HintText
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(shape = RoundedCornerShape(5.dp), colors = ButtonDefaults.buttonColors(
            containerColor = HintText
        ), onClick = { /*TODO*/ }) {
            Text(text = "LOGOUT", color = Color.Black)
        }
    }
}

@Composable
fun CustomCard(
    title: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 20.sp,
    fontColor: Color = BodyText,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .then(modifier),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Row(modifier.padding(0.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                text = title,
                textAlign = TextAlign.Center,
                fontWeight = fontWeight,
                fontSize = fontSize,
                color = fontColor
            )
        }
    }
}

@Composable
fun ToolBarTitle(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = BodyText
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview2() {
    ProfileScreen()
}