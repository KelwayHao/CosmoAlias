package com.kelway.cosmoalias.utils

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.kelway.cosmoalias.R

fun Fragment.dialogInputText(
    context: Context,
    onPositiveButtonClick: (inputText: EditText) -> Unit,
    onNegativeButtonClick: () -> Unit
) {
    val builder = AlertDialog.Builder(context)
    val dialogLayout = layoutInflater.inflate(R.layout.dialog_alert_edittext, null)
    val editText = dialogLayout.findViewById<EditText>(R.id.et_team_input)
    val textViewTitle = dialogLayout.findViewById<TextView>(R.id.title_dialog)
    val negativeButton = dialogLayout.findViewById<ImageButton>(R.id.buttonNegativeAnswer)
    val positiveButton = dialogLayout.findViewById<ImageButton>(R.id.buttonPositiveAnswer)
    builder.setCancelable(false)
    builder.setView(dialogLayout)

    val alertDialog = builder.create()
    alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    textViewTitle.text = context.getString(R.string.enter_name_team)
    positiveButton.setOnClickListener {
        onPositiveButtonClick(editText)
        alertDialog.dismiss()
    }
    negativeButton.setOnClickListener {
        onNegativeButtonClick()
        alertDialog.dismiss()
    }
    alertDialog.show()
}

fun showSnack(message: String, view: View) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}

fun Fragment.dialogPermission(
    message: String,
    context: Context,
    onPositiveButtonClick: () -> Unit,
    onNegativeButtonClick: () -> Unit
) {
    val builder = AlertDialog.Builder(context)
    val dialogLayout = layoutInflater.inflate(R.layout.dialog_alert, null)
    val textViewTitle = dialogLayout.findViewById<TextView>(R.id.title_dialog)
    val negativeButton = dialogLayout.findViewById<ImageButton>(R.id.buttonNegativeAnswer)
    val positiveButton = dialogLayout.findViewById<ImageButton>(R.id.buttonPositiveAnswer)
    builder.setCancelable(false)
    builder.setView(dialogLayout)

    val alertDialog = builder.create()
    alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    textViewTitle.text = message
    positiveButton.setOnClickListener {
        onPositiveButtonClick()
        alertDialog.cancel()
    }
    negativeButton.setOnClickListener {
        onNegativeButtonClick()
        alertDialog.cancel()
    }
    alertDialog.show()
}

fun String.isValidationTeam(): Boolean {
    return Regex(Constants.VALID_TEAM).matches(this)
}

fun String.isValidationTitleWordsSet(): Boolean {
    return Regex(Constants.VALID_WORDS_SET).matches(this)
}

fun String.isValidationCountWords(): Boolean {
    return Regex(Constants.VALID_COUNT_WORDS).matches(this)
}

fun String.isValidationCountRounds(): Boolean {
    return Regex(Constants.VALID_COUNT_ROUNDS).matches(this)
}

fun String.isValidationTimeRound(): Boolean {
    return Regex(Constants.VALID_TIME_ROUND).matches(this)
}