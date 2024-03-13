package com.tlw.perfisystask2.ui.screen

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.palette.graphics.Palette
import com.tlw.perfisystask2.R
import com.tlw.perfisystask2.model.ContentData
import com.tlw.perfisystask2.ui.theme.AppBarColor
import com.tlw.perfisystask2.ui.theme.BodyText
import com.tlw.perfisystask2.ui.theme.HintText
import com.tlw.perfisystask2.ui.theme.ThemeColor


@Composable
fun HomeScreen() {

    val quotesList by remember {
        mutableStateOf(
            mutableListOf(
                ContentData(id = 1, resourceId = R.drawable.qutotes_1),
                ContentData(id = 2, resourceId = R.drawable.qutotes_2),
                ContentData(id = 3, resourceId = R.drawable.qutotes_3),
                ContentData(id = 4, resourceId = R.drawable.qutotes_4),
                ContentData(id = 5, resourceId = R.drawable.qutotes_5),
                ContentData(id = 6, resourceId = R.drawable.qutotes_6),
                ContentData(id = 7, resourceId = R.drawable.qutotes_7),
                ContentData(id = 8, resourceId = R.drawable.qutotes_8),
                ContentData(id = 9, resourceId = R.drawable.qutotes_9),
                ContentData(id = 10, resourceId = R.drawable.qutotes_10),
            )
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBar()
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            items(quotesList.size, key = { quotesList[it].id }) { index ->
                CustomQuotesView(quotesList[index])
            }
        }
    }
}


@Composable
fun CustomQuotesView(contentData: ContentData) {
    val context = LocalContext.current
    val bitmap = BitmapFactory.decodeResource(context.resources, contentData.resourceId)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(extractVibrantColor(bitmap))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black), 300f
                )
            )
    ) { // Change here
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                painter = painterResource(id = contentData.resourceId),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(vertical = 10.dp),
                shape = RoundedCornerShape(5.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                )
            ) {
                Row {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .padding(10.dp)
                            .weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
                        Text(text = "Save", fontSize = 12.sp, color = HintText)
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .padding(10.dp)
                            .weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            Modifier.rotate(90f)
                        )
                        Text(text = "Download", fontSize = 12.sp, color = HintText)
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .padding(10.dp)
                            .weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = null)
                        Text(text = "Share", fontSize = 12.sp, color = HintText)
                    }
                }
            }
        }
    }
}


@Composable
fun TopBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppBarColor)
            .padding(10.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 5.dp),
            text = "Enjoy the afternoon sun?",
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = BodyText
        )

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Button(shape = RoundedCornerShape(5.dp), colors = ButtonDefaults.buttonColors(
                containerColor = ThemeColor
            ), onClick = { /*TODO*/ }) {
                Text(text = "Motivational", color = Color.White)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(2.dp)
                    .background(
                        color = Color.White, RoundedCornerShape(25.dp)
                    )
                    .clip(RoundedCornerShape(25.dp))
                    .border(BorderStroke(1.dp, HintText), RoundedCornerShape(25.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(5.dp),
                    imageVector = Icons.Default.Search,
                    contentDescription = "search",
                    tint = HintText
                )
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(5.dp),
                    painter = painterResource(R.drawable.ic_mic),
                    contentDescription = "search",
                    tint = HintText
                )
            }
        }
    }
}


fun extractVibrantColor(bitmap: Bitmap): Color {
    // Generate the palette and get the vibrant swatch
    val vibrantSwatch = Palette.from(bitmap).generate().vibrantSwatch

    // Return the vibrant color if available, otherwise return a default color
    return vibrantSwatch?.let { Color(it.rgb) } ?: DEFAULT_COLOR
}

// Define a default color in case the vibrant color cannot be extracted
private val DEFAULT_COLOR = Color(0xFFCCCCCC) // Light gray as default color

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreviewHome() {
    HomeScreen()
}