package com.kelway.cosmoalias.presentation.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kelway.cosmoalias.domain.models.BaseItem

abstract class BaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bindItem(baseItem: BaseItem)
}