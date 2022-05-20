package com.kelway.cosmoalias.utils

import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.kelway.cosmoalias.R

fun Fragment.dialogInputText(
    context: Context,
    onPositiveButtonClick: (inputText: EditText) -> Unit,
    onNegativeButtonClick: () -> Unit
) {
    val builder = AlertDialog.Builder(context)
    val editTextLayout = layoutInflater.inflate(R.layout.field_input_edittext, null)
    val editText = editTextLayout.findViewById<EditText>(R.id.et_team_input)
    builder.setTitle(R.string.enter_name_team)
        .setCancelable(true)
        .setPositiveButton(getString(R.string.create)) { dialogMessage, _ ->
            onPositiveButtonClick(editText)
            dialogMessage.cancel()
        }
        .setNegativeButton(getString(R.string.cancel)) { dialogMessage, _ ->
            onNegativeButtonClick()
            dialogMessage.cancel()
        }
        .setView(editTextLayout)
    builder.show()
}

fun showSnack(message: String, view: View) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}