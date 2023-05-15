package com.example.inspiringquotes

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.example.inspiringquotes.data.Quote
import com.example.inspiringquotes.data.quotes
import com.example.inspiringquotes.ui.theme.InspiringQuotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InspiringQuotesTheme {
                InspiringQuotesApp()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InspiringQuotesApp() {
    Scaffold(
        topBar = { InspiringQuotesTopBar() }
    ) {
        LazyColumn(
            modifier = Modifier.padding(top = 16.dp).background(MaterialTheme.colors.background)
        ) {
            items(quotes) { QuoteItem(quote = it) }
        }
    }
}

@Composable
fun InspiringQuotesTopBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary)
            .padding(bottom = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Inspiring Quotes Daily",
            style = MaterialTheme.typography.h1
        )
    }
}

@Composable
fun QuoteItem(quote: Quote, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    val context = LocalContext.current
    /* Convert our Image Resource into a Bitmap */
    val bitmap = remember { BitmapFactory.decodeResource(context.resources, quote.image) }
    /* Create the Palette, pass the bitmap to it */
    val palette = remember { Palette.from(bitmap).generate() }
    /* Get the vibrant swatch */
    val vibrantSwatch = palette.vibrantSwatch


    Box(
        modifier = modifier
            .clickable { expanded = !expanded }
    ) {
        if (expanded) {
            Expanded(
                quote = quote.quote,
                author = quote.author,
                imageQuote = quote.image,
                modifier = modifier
            )
        } else {
            NotExpanded(
                quote = quote.quote,
                author = quote.author,
                imageQuote = quote.image,
                vibrantSwatch = vibrantSwatch,
                modifier = modifier
            )
        }
    }
}

@Composable
fun NotExpanded(
    @StringRes quote: Int,
    author: Int,
    @DrawableRes imageQuote: Int,
    vibrantSwatch: Palette.Swatch?,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 8.dp,

        ) {
        Canvas(
            modifier = Modifier
                .size(100.dp)
        ) {
            drawRect(
                color = vibrantSwatch?.let { Color(it.rgb) } ?: Color.White,
                size = Size(5.dp.toPx(), 136.dp.toPx())
            )
        }
        Row(
            modifier = modifier.padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = modifier
                    .width(230.dp)
                    .padding(start = 7.dp),
            ) {
                Text(
                    text = stringResource(id = quote),
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.h2
                )
                Text(
                    text = stringResource(id = author),
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.body1
                )
                Icon(
                    imageVector = Icons.Filled.ExpandMore,
                    tint = MaterialTheme.colors.secondary,
                    contentDescription = null
                )
            }
            Box(
                modifier = modifier
                    .size(120.dp)
                    .padding(top = 8.dp, end = 12.dp, bottom = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = imageQuote),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .align(Alignment.Center)
                        .clip(shapes.small)
                )
            }
        }
    }

}

@Composable
fun Expanded(
    @StringRes quote: Int,
    author: Int,
    @DrawableRes imageQuote: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = shapes.large,
        elevation = 8.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Box(
            modifier = modifier
                .padding(start = 2.dp, top = 10.dp, end = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = modifier
                    .padding(start = 8.dp),
            ) {
                Image(
                    painter = painterResource(id = imageQuote),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .clip(shapes.medium)
                        .fillMaxWidth()
                )
                Spacer(modifier = modifier.height(7.dp))
                Text(
                    text = stringResource(id = quote),
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.h2,
                    modifier = modifier.padding(start = 2.dp, end = 2.dp)
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    text = stringResource(id = author),
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.body1,
                    modifier = modifier.padding(start = 2.dp)
                )
                Icon(
                    imageVector = Icons.Filled.ExpandLess,
                    tint = MaterialTheme.colors.secondary,
                    contentDescription = null
                )
            }
        }
    }
}