package com.touch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val brightPinkColor = Color(0xFFFF00AF)

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { HomeTopBar() },
        bottomBar = { HomeBottomNavigation() },
        backgroundColor = Color.White
    ) { innerPadding ->
        FeedScreen(modifier = Modifier.padding(innerPadding))
    }
}


@Composable
fun HomeTopBar() {
    TopAppBar(
        title = { },
        backgroundColor = brightPinkColor,
        elevation = 0.dp,

        navigationIcon = {
            IconButton(onClick = { }) {
                Image(
                    painter = painterResource(id = R.drawable.cat),
                    contentDescription = "View",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(2.dp, brightPinkColor, CircleShape),
                    contentScale = ContentScale.Crop

                )
            }
        },

        actions = {
            Text(
                text = "TOUCH",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 16.dp)
            )
        }
    )
}

@Composable
fun HomeBottomNavigation() {

    val iconColor = Color.Black
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            shape = customBottomUi(bubbleheight = 20.dp),
            color = brightPinkColor,
            elevation = 0.dp
        ) {
            BottomNavigation(
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            ) {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    selected = true,
                    onClick = {  },
                    selectedContentColor = iconColor,
                    unselectedContentColor = iconColor
                )

                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                    selected = false,
                    onClick = {  },
                    selectedContentColor = iconColor,
                    unselectedContentColor = iconColor
                )

                BottomNavigationItem(
                    selected = false,
                    onClick = { },
                    icon = { },
                    enabled = false
                )

                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Likes") },
                    selected = false,
                    onClick = {  },
                    selectedContentColor = iconColor,
                    unselectedContentColor = iconColor
                )

                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    selected = false,
                    onClick = {  },
                    selectedContentColor = iconColor,
                    unselectedContentColor = iconColor
                )
            }
        }

        IconButton(
            onClick = {  },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-11).dp)
                .size(56.dp)
                .clip(CircleShape)
                .background(Color.Black)
                .border(2.dp, brightPinkColor, CircleShape)
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "Add",
                tint = brightPinkColor
            )
        }
    }
}

@Composable
fun FeedScreen(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        item {
            StoriesRow(stories = dummyStories)
            HorizontalDivider(thickness = 0.5.dp, color = Color.DarkGray)
        }

        items(dummyPosts) { post ->
            PostCard(post = post)
        }
    }
}


@Composable
fun StoriesRow(stories: List<Story>) {
    LazyRow(
        modifier = Modifier.padding(vertical = 8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(stories) { story ->
            StoryItem(story)
        }
    }
}

@Composable
fun StoryItem(story: Story) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        Image(
            painter = painterResource(id = story.imageRes),
            contentDescription = "Story by ${story.username}",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .border(2.dp,Color.Black, CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = story.username,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Composable
fun PostCard(post: Post) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.White,
        elevation = 10.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = post.userImageRes),
                    contentDescription = "${post.username}'s profile picture",
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = post.username,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = "More options",
                    tint = Color.Black
                )
            }

            Image(
                painter = painterResource(id = post.postImageRes),
                contentDescription = "Post image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                PostActionButton(icon = Icons.Default.FavoriteBorder, "Like")
                PostActionButton(icon = Icons.Default.Email, "Comment")
                Spacer(modifier = Modifier.weight(1f))
                PostActionButton(icon = Icons.Default.Share, "Share")
            }

            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                Text(
                    text = "1,884 likes",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${post.username} ${post.caption}",
                    color = Color.Black,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun PostActionButton(icon: ImageVector, description: String) {
    IconButton(onClick = {  }) {
        Icon(
            imageVector = icon,
            contentDescription = description,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}