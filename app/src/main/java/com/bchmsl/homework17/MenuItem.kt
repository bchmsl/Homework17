package com.bchmsl.homework17

import android.graphics.Color

data class MenuItem(
    val title: String,
    val icon: Int,
    val menuType: MenuType,
    val badgeCount: Int? = null,
    val badgeColor: Int = Color.RED,
) {
    companion object {
        val menuList = listOf(
            MenuItem("Camera", R.drawable.ic_menu_camera, MenuType.CAMERA1),
            MenuItem("Gallery", R.drawable.ic_menu_gallery, MenuType.GALLERY1, 15),
            MenuItem(
                "Slideshow",
                R.drawable.ic_menu_slideshow,
                MenuType.SLIDESHOW1,
                20,
                Color.GRAY
            ),
            MenuItem("Camera", R.drawable.ic_menu_camera, MenuType.CAMERA2),
            MenuItem("Gallery", R.drawable.ic_menu_gallery, MenuType.GALLERY2, 7),
            MenuItem("Slideshow", R.drawable.ic_menu_slideshow, MenuType.SLIDESHOW2),
        )
    }

    enum class MenuType {
        CAMERA1,
        GALLERY1,
        SLIDESHOW1,
        CAMERA2,
        GALLERY2,
        SLIDESHOW2
    }
}