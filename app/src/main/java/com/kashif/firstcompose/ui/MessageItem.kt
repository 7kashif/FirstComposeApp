package com.kashif.firstcompose.ui

import com.kashif.firstcompose.R

data class MessageItem(
    val author: String,
    val message: String,
    val profilePic: Int
)

val sampleMessages = arrayListOf<MessageItem>(
    MessageItem("Husky", "Hi...!!!", R.drawable.wolf),
    MessageItem("Cat", "Hi...", R.drawable.cat),
    MessageItem("Husky", "How Are you???", R.drawable.wolf),
    MessageItem("Cat", "I am fine. How you doing?", R.drawable.cat),
    MessageItem("Husky", "Doing great. Are you free this weekend?", R.drawable.wolf),
    MessageItem("Cat", "Yes... Wanna hangout?", R.drawable.cat),
    MessageItem("Husky", "Yeah, sure.", R.drawable.wolf),
    MessageItem("Cat", "Saturday it is then.", R.drawable.cat),
    MessageItem("Husky", "Very nice.", R.drawable.wolf),
    MessageItem("Cat", "See you then.", R.drawable.cat),
)
