package com.joel.archtecture.rxjava.photogallery.ui.detailview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.joel.archtecture.rxjava.photogallery.data.PhotoData
import com.joel.archtecture.rxjava.photogallery.R;
import com.joel.archtecture.rxjava.photogallery.ui.ItemAdapter
import com.joel.archtecture.rxjava.photogallery.ui.view.common.bindView
import com.joel.archtecture.rxjava.photogallery.ui.view.common.loadImage

class PhotoDetailAdapter(
        val photoInfo: PhotoData,
        val clicked: (PhotoData) -> Unit
) : ItemAdapter<PhotoDetailAdapter.ViewHolder>(R.layout.item_character) {

    override fun onCreateViewHolder(itemView: View) = ViewHolder(itemView)

    override fun ViewHolder.onBindViewHolder() {
        itemView.setOnClickListener { clicked(photoInfo) }
        textView.text = photoInfo.name
        imageView.loadImage(photoInfo.large)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView by bindView<TextView>(R.id.textView)
        val imageView by bindView<ImageView>(R.id.imageView)
    }
}
