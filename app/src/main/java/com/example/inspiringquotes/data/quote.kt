package com.example.inspiringquotes.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.inspiringquotes.R

data class Quote(
    @StringRes val quote: Int,
    @StringRes val author: Int,
    @DrawableRes val image: Int
)

val quotes = listOf(
    Quote(R.string.confucius_quote, R.string.confucius, R.drawable.image1),
    Quote(R.string.socrates_quote, R.string.socrates, R.drawable.image2),
    Quote(R.string.aristotle_quote, R.string.aristotle, R.drawable.image3),
    Quote(R.string.nietzsche_quote, R.string.nietzsche, R.drawable.image4),
    Quote(R.string.watts_quote, R.string.watts, R.drawable.image5),
    Quote(R.string.epictetus_quote, R.string.epictetus, R.drawable.image6),
    Quote(R.string.james_quote, R.string.james, R.drawable.image7),
    Quote(R.string.heraclitus_quote, R.string.heraclitus, R.drawable.image8),
    Quote(R.string.dewey_quote, R.string.dewey, R.drawable.image9),
    Quote(R.string.bruyere_quote, R.string.bruyere, R.drawable.image10),
    Quote(R.string.thales_quote, R.string.thales, R.drawable.image11),
    Quote(R.string.gasset_quote, R.string.gasset, R.drawable.image12),
    Quote(R.string.tzu_quote, R.string.tzu, R.drawable.image13),
    Quote(R.string.ali_quote, R.string.ali, R.drawable.image14),
    Quote(R.string.buddha_quote, R.string.buddha, R.drawable.image15),
    Quote(R.string.gandhi_quote, R.string.gandhi, R.drawable.image16),
    Quote(R.string.unknown_quote, R.string.unknown, R.drawable.image17),
    Quote(R.string.armstrong_quote, R.string.armstrong, R.drawable.image18),
    Quote(R.string.carnegie_quote, R.string.carnegie, R.drawable.image19),
    Quote(R.string.maxwell_quote, R.string.maxwell, R.drawable.image20),
    Quote(R.string.jung_quote, R.string.jung, R.drawable.image21),
    Quote(R.string.lama_quote, R.string.lama, R.drawable.image22),
    Quote(R.string.voltaire_quote, R.string.voltaire, R.drawable.image23),
    Quote(R.string.franklin_quote, R.string.franklin, R.drawable.image24),
    Quote(R.string.tolle_quote, R.string.tolle, R.drawable.image25),
    Quote(R.string.mandela_quote, R.string.mandela, R.drawable.image26),
    Quote(R.string.caesar_quote, R.string.caesar, R.drawable.image27),
    Quote(R.string.asimov_quote, R.string.asimov, R.drawable.image28),
    Quote(R.string.kant_quote, R.string.kant, R.drawable.image29),
    Quote(R.string.pythagoras_quote, R.string.pythagoras, R.drawable.image30)
)
