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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

class DogRepository {
    val dogs = Dogs(
        listOf(
            Dog(
                "Lexi",
                7,
                "Female",
                "Akita",
                "7 year old Lexi has the most adorable head tilt and it seems as though she takes in every word you say! She's typically aloof most of the time, something any Akita fan will know, but she does enjoy attention and a gentle fuss, especially a good bum scratch.",
                R.drawable.lexi,
                "Merseyside (Liverpool)"
            ),
            Dog(
                "Jessie",
                6,
                "Female",
                "Pug",
                "Jessie is a 6 year old Pug who came to us after her owners felt that they could no longer give her the care she deserved. She is finding kennel life quite stressful, she does bark whilst she is in her kennel but loves heading out and about on her walkies! She does get out of breath easily due to her weight, she is already on a diet here at the centre and will need owner willing to help her loose those pounds! Whilst off lead, she loves running around with a tennis ball. Jessie has made a few dog friends here at the centre but isn't too interested in them and is happier doing her own thing. ",
                R.drawable.jessie,
                "Harefield (West London)"
            ),
            Dog(
                "Wishbone",
                14,
                "Male",
                "Terrier Cross",
                "Wishbone is a sweet boy, but is very sad in kennels and probably still grieving over the loss of his owner. He gets very excited when heading out for a walk and does take time to settle once you go into the kennel with him. He enjoys meeting other dogs but doesn't get much from them but will happily walk with them. ",
                R.drawable.wishbone,
                "Harefield (West London)"
            ),
            Dog(
                "Jess",
                5,
                "Female",
                "Spaniel Cross",
                "Jess is a sweet but shy little lady. It takes her time to build confidence with new people, but once she has made friends with you she is very attached and wants to with you wherever you go. Jess shows her worries when out on walks but she will often perk up at the sight of another dog and want to play. She would benefit from regular interactions with dogs as this has really helped her confidence during her time in foster.",
                R.drawable.jess,
                "Loughborough"
            ),
        )
    )

    fun fetchDogs(): Dogs = dogs

    fun fetchDog(dogName: String): Dog = dogs.items.first { dog -> dog.name == dogName }
}