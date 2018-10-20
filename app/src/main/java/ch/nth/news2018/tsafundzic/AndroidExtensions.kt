package ch.nth.news2018.tsafundzic

import android.app.Activity
import android.content.Context
import android.content.Intent

inline fun <reified T : Activity> Context.getIntent() = Intent(this, T::class.java)
