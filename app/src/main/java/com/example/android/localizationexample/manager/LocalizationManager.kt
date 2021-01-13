package com.example.android.localizationexample.manager

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.example.android.localizationexample.R

interface ILocalizableDelegate {
    val rawValue: Int
    val fromServer: Boolean
}

abstract class LocalizablePlural : ILocalizableDelegate {
    abstract fun localized(quantity: Int): String

    override val fromServer: Boolean
        get() = false
}

abstract class LocalizableString : ILocalizableDelegate {
    val localized: String
        get() = LocalizationManager.appContext.getString(rawValue)

    override val fromServer: Boolean
        get() = false
}

abstract class LocalizableDrawable : ILocalizableDelegate {
    val localized: Drawable?
        get() = ContextCompat.getDrawable(LocalizationManager.appContext, rawValue)

    override val fromServer: Boolean
        get() = false
}

class LocalizationManager {

    companion object {
        fun init(context: Context) {
            appContext = context
        }

        internal lateinit var appContext: Context
    }

    object FirstScreen {
        val next = object : LocalizableString() {
            override val rawValue: Int
                get() = R.string.firstScreenNextKey
        }

        val image = object : LocalizableDrawable() {
            override val rawValue: Int
                get() = R.drawable.ic_launcher_background
        }
    }

    object SecondScreen {

        val label = object : LocalizablePlural() {
            override val rawValue: Int
                get() = 0

            override fun localized(quantity: Int): String {
                return when (quantity) {
                    1 -> appContext.getString(R.string.secondScreenLabelOneKey)
                    else -> appContext.getString(R.string.secondScreenLabelManyKey)
                }
            }

        }

    }

}