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
package com.example.androiddevchallenge.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.DogRepository

@Composable
fun DetailsScreen(
    dog: String,
    onBack: () -> Unit
) {
    val dog = DogRepository().fetchDog(dog)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = ""
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = {
            DogDetails(dog)
        }
    )
}

@Composable
fun DogDetails(
    dog: Dog
) {
    val imageModifier = Modifier
        .heightIn(min = 180.dp)
        .fillMaxWidth()
        .clip(shape = MaterialTheme.shapes.medium)
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(dog.image),
            contentDescription = null, // decorative
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Spacer(androidx.compose.ui.Modifier.height(16.dp))
        Text(
            text = dog.name + ", " + dog.gender + " - Aged: " + dog.age.toString(),
            style = MaterialTheme.typography.h4
        )
        Text(text = "Breed: " + dog.breed, style = MaterialTheme.typography.h5)
        Row() {
            Icon(
                imageVector = Icons.Filled.LocationOn,
                contentDescription = "Located"
            )
            Text(text = dog.location, style = MaterialTheme.typography.h6)
        }
        Spacer(Modifier.height(16.dp))
        Text(text = dog.description, style = MaterialTheme.typography.body1)
    }

}