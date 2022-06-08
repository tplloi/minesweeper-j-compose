/*
 * Copyright 2022 Jaya Surya Thotapalli
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jayasuryat.difficultyselection.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.jayasuryat.difficultyselection.R
import com.jayasuryat.difficultyselection.logic.DifficultyItem

@Composable
internal fun DifficultyItem(
    modifier: Modifier = Modifier,
    difficulty: DifficultyItem,
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            // Title
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(),
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
                text = difficulty.title,
            )

            Spacer(modifier = Modifier.height(32.dp))

            // 10 x 10
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .wrapContentSize(),
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
                text = difficulty.gridMessage,
            )

            Row {

                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .wrapContentSize()
                        .align(alignment = Alignment.CenterVertically),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground,
                    text = difficulty.difficulty.mines.toString(),
                )

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colors.error)
                        .padding(4.dp),
                    painter = painterResource(id = R.drawable.icon_mine),
                    tint = MaterialTheme.colors.onError,
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview(
    @PreviewParameter(DifficultyItemParamProvider::class) difficulty: DifficultyItem,
) {

    DifficultyItem(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        difficulty = difficulty,
    )
}
