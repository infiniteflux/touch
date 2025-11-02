package com.touch
data class Story(val id: Int, val username: String, val imageRes: Int)
data class Post(val id: Int, val username: String, val userImageRes: Int, val postImageRes: Int, val caption: String)

val placeholderImage = R.drawable.img
val dummyStories = listOf(
    Story(1, "dev", placeholderImage),
    Story(2, "dev1", placeholderImage),
    Story(3, "dev2", placeholderImage),
    Story(4, "dev3", placeholderImage),
    Story(5, "dev4", placeholderImage),
    Story(6, "dev5", placeholderImage),
    Story(7, "dev6", placeholderImage)
)

val dummyPosts = listOf(
    Post(1, "dev_android", placeholderImage, placeholderImage, "Check out my new piece!"),
    Post(2, "dev1_devops", placeholderImage, placeholderImage, "Cloud is important."),
    Post(3, "dev2_ml", placeholderImage, placeholderImage, "Latest tech news.")
)
