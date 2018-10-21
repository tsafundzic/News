package ch.nth.news2018.tsafundzic.common

import android.content.Context
import android.text.format.DateUtils
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*


fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, duration).show()

fun returnTimeAgo(time: String): String {


    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm")

    //some time from Api is in different formats, so I use only date, minutes and hour
    val hoursAndMinutes = time.split("T")
    val formattedTime = hoursAndMinutes[0] + " " + hoursAndMinutes[1].substring(0, 5)

    val articleTime = sdf.parse(formattedTime).time
    val now = System.currentTimeMillis()

    val ago = DateUtils.getRelativeTimeSpanString(articleTime, now, DateUtils.MINUTE_IN_MILLIS).toString()

    val agoSplitted = ago.trim().split(" ")
    var timeToShow = (agoSplitted[0] + " " + agoSplitted[1].substring(0, 1))

    val language = Locale.getDefault().language

    if (language == "hr") {
        timeToShow = if (agoSplitted[2].substring(0, 1) == "s") {
            agoSplitted[1] + " h"
        } else {
            agoSplitted[1] + " " + agoSplitted[2].substring(0, 1)
        }
    }

    return timeToShow
}