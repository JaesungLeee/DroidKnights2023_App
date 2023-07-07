package com.droidknights.app2023.feature.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    var currentTab by remember { mutableStateOf(MainTab.HOME) }
    Scaffold(
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF9F9F9))
                    .padding(padding)
            ) {
                // TODO: 컨텐츠 추가
            }
        },
        bottomBar = {
            MainBottomBar(
                tabs = MainTab.values().toList(),
                currentTab = currentTab,
                onTabSelected = { currentTab = it }
            )
        },
    )
}

@Composable
private fun MainBottomBar(
    tabs: List<MainTab>,
    currentTab: MainTab,
    onTabSelected: (MainTab) -> Unit,
) {
    Row(
        modifier = Modifier
            .navigationBarsPadding()
            .padding(start = 8.dp, end = 8.dp, bottom = 28.dp)
            .fillMaxWidth()
            .height(56.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFDCDCDC), // lightgray
                shape = RoundedCornerShape(size = 28.dp)
            )
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(28.dp))
            .padding(horizontal = 28.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        tabs.forEach { tab ->
            MainBottomBarItem(
                selected = tab == currentTab,
                onClick = { onTabSelected(tab) },
                resId = tab.iconResId,
            )
        }
    }
}

@Composable
private fun RowScope.MainBottomBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    resId: Int,
) {
    Box(
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .selectable(
                selected = selected,
                indication = null,
                role = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painterResource(id = resId),
            contentDescription = null,
            tint = if (selected) Color(0xFF49F300) else Color(0xFFDCDCDC),
            modifier = Modifier.size(34.dp),
        )
    }
}
