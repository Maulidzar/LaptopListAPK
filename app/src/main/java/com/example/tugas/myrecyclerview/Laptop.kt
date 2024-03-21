package com.example.tugas.myrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Laptop(
    val name: String,
    val price: String,
    val photo: Int,
    val description: String
) : Parcelable {
}
