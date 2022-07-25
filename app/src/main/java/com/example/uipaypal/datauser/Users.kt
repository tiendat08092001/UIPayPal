package com.example.uipaypal.datauser

import android.content.res.Resources
import com.example.uipaypal.R

fun userList(resources: Resources): List<User> {
    return listOf(
        User(id = 1, name = "Carlos Roca", image = R.drawable.bitmap_copy),
        User(id = 2, name = "Ruby Sanz", image = R.drawable.bitmap_copy_3),
        User(id = 3, name = "Mary Rich", image = R.drawable.bitmap_copy_4),
        User(id = 4, name = "José Porto", image = R.drawable.bitmap_copy_5),
        User(id = 1, name = "Carlos Roca", image = R.drawable.bitmap_copy),
        User(id = 2, name = "Ruby Sanz", image = R.drawable.bitmap_copy_3),
        User(id = 3, name = "Mary Rich", image = R.drawable.bitmap_copy_4),
        User(id = 4, name = "José Porto", image = R.drawable.bitmap_copy_5),
        User(id = 1, name = "Carlos Roca", image = R.drawable.bitmap_copy),
        User(id = 2, name = "Ruby Sanz", image = R.drawable.bitmap_copy_3),
        User(id = 3, name = "Mary Rich", image = R.drawable.bitmap_copy_4),
        User(id = 4, name = "José Porto", image = R.drawable.bitmap_copy_5),
    )
}