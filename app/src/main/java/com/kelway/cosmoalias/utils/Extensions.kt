package com.kelway.cosmoalias.utils

import android.app.AlertDialog
import android.content.Context
import androidx.fragment.app.Fragment
import com.kelway.cosmoalias.R

fun Fragment.dialog(message: String, context: Context, onPositiveButtonClick: () -> Unit, onNegativeButtonClick: () -> Unit) {
    val builder = AlertDialog.Builder(context)
    builder.setTitle(R.string.enter_name_team)
        .setMessage(message)
        .setCancelable(true)
        .setPositiveButton(getString(R.string.create)) { dialogMessage, _ ->
            onPositiveButtonClick()
            dialogMessage.cancel()
        }
        .setNegativeButton(getString(R.string.cancel)) { dialogMessage, _ ->
            onNegativeButtonClick()
            dialogMessage.cancel()
        }
    builder.show()
}