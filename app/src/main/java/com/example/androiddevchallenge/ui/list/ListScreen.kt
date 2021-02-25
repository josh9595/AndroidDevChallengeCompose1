/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Pets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.DogRepository
import com.example.androiddevchallenge.ui.Screen
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun ListScreen(
    navigateTo: (Screen) -> Unit
) {
    val dogs = DogRepository().fetchDogs()

    Surface(color = MaterialTheme.colors.background) {
        Scaffold (
            topBar = {
                val title = stringResource(id = R.string.app_name)
                TopAppBar(
                    title = { Text(text = title) },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Filled.Pets,
                                contentDescription = "Back"
                            )

                        }
                    }
                )
            },
            content = {
                Column(Modifier.padding(16.dp)) {
                    LazyColumn() {
                        item {
                            Text(
                                text = "Find your furever friend!",
                                style = typography.h4)
                            Spacer(Modifier.height(16.dp))
                        }
                        items(dogs.items) { dog ->
                            DogItem(dog, navigateTo)
                        }
                    }
                }

            }
        )
    }
}

@Composable
fun DogItem(dog: Dog, navigateTo: (Screen) -> Unit) {
    val typography = MaterialTheme.typography
    Column(modifier = Modifier
        .clickable(onClick = { navigateTo(Screen.Details(dog.name)) })
        .fillMaxWidth()) {
        val imageModifier = Modifier
            .heightIn(min = 180.dp)
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.medium)
        Image(
            painter = painterResource(dog.image),
            contentDescription = null, // decorative
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(16.dp))

        Text(
            text = dog.name,
            style = typography.h5
        )
        Row(){
            Icon(
                imageVector = Icons.Filled.LocationOn,
                contentDescription = "Located"
            )
            Text(
                text = dog.location,
                style = typography.body1
            )
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTheme {
        DogItem(
            Dog(
                "Lexi",
                7,
                "Female",
                "Akita",
                "7 year old Lexi has the most adorable head tilt and it seems as though she takes in every word you say! She's typically aloof most of the time, something any Akita fan will know, but she does enjoy attention and a gentle fuss, especially a good bum scratch.",
                R.drawable.lexi,
                "Merseyside (Liverpool)"
            ),
            {}
        )
    }
}