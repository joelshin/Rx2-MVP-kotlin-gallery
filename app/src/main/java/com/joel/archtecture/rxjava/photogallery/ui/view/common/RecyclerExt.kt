@file:Suppress("UNCHECKED_CAST")
package com.joel.archtecture.rxjava.photogallery.ui.view.common


import android.support.v7.widget.RecyclerView
import android.view.View

fun <T : View> RecyclerView.ViewHolder.bindView(viewId: Int)
        = lazy { itemView.findViewById<T>(viewId) }