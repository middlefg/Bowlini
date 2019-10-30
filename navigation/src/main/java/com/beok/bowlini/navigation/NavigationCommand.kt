package com.beok.bowlini.navigation

import androidx.navigation.NavDirections

sealed class NavigationCommand {
    data class To(val direction: NavDirections) : NavigationCommand()
}