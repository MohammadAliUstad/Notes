package com.seismic.notes

sealed class Screens(val route:String) {
    data object HomeScreen:Screens("home_screen")
    data object AddScreen:Screens("add_screen")
    data object EditScreen:Screens("edit_screen")
}