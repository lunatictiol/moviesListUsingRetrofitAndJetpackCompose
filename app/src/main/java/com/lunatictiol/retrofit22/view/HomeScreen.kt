package com.lunatictiol.retrofit22.view

import android.icu.number.Scale
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.base.R
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.lunatictiol.retrofit22.Greeting
import com.lunatictiol.retrofit22.model.Movie
import com.lunatictiol.retrofit22.ui.theme.Retrofit22Theme

@Composable
fun MovieItem(movie: Movie) {

    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface() {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

                Image(
                    painter = rememberImagePainter(
                        data = movie.imageUrl,

                        builder = {
                            scale(coil.size.Scale.FILL)
                            placeholder(R.drawable.notification_action_background)
                            transformations(CircleCropTransformation())

                        }
                    ),
                    contentDescription = movie.desc,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = movie.name,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = movie.category,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(
                                androidx.compose.ui.graphics.Color.LightGray
                            )
                            .padding(4.dp)
                    )
                    Text(
                        text = movie.desc,
                        style = MaterialTheme.typography.body1,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                }
            }
        }
    }

} @Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Retrofit22Theme {
       MovieItem(movie = Movie(
           category = "HGCFYF",
           imageUrl = "asasas",
           name = "axax",
           desc = "uincsiunhbcsiubcs"

       ))

    }
}