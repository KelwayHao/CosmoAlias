package com.kelway.cosmoalias.data.room.words_set_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_set")
data class WordsSetEntity(
    @PrimaryKey
    var id: Long,
    @ColumnInfo(name = "title_words_set")
    val title: String,
    @ColumnInfo(name = "article_set")
    val article: String,
    @ColumnInfo(name = "list_words")
    val listWords: String
)