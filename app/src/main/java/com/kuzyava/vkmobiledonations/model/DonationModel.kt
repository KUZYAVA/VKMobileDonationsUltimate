package com.kuzyava.vkmobiledonations.model

import android.net.Uri
import java.io.Serializable


class DonationModel(
    val title: String = "",
    val amount: String = "",
    val goal: String = "",
    val desc: String = "",
    val img: Uri? = null,
    var author: String = "",
    var date: String = "",
    val type:Int = -1,
    var label:String = ""
) : Serializable