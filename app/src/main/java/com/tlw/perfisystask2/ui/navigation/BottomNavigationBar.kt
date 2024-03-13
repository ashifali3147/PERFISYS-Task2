package com.tlw.perfisystask2.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tlw.perfisystask2.model.BottomNavItems
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun BottomNavigationBar(
    navItem: List<BottomNavItems>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItems) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(modifier = modifier, backgroundColor = Color.White, elevation = 5.dp) {
        navItem.forEach { item ->
            val isSelected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(selected = isSelected, onClick = { onItemClick(item) }, icon = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    if (isSelected) {
                        Icon(imageVector = item.iconFill, contentDescription =item.name)
                        Text(text = item.name, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    } else{
                        Icon(imageVector = item.iconStroke, contentDescription =item.name)
                        Text(text = item.name, fontSize = 12.sp, fontWeight = FontWeight.Normal)
                    }
                }
            })
        }
    }

}