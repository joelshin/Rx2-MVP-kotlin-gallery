package com.joel.archtecture.rxjava.photogallery.ui.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.joel.archtecture.rxjava.photogallery.data.PhotoData
import kotlinx.android.synthetic.main.post_list_item.view.*
import com.joel.archtecture.rxjava.photogallery.ui.view.common.loadImage
import com.joel.archtecture.rxjava.photogallery.ui.detailview.PhotoDetailActivity

import com.joel.archtecture.rxjava.photogallery.R

class PhotoItemsAdapter(val photoItems: List<PhotoData>, val context: Context) : RecyclerView.Adapter<PhotoItemsAdapter.ViewHolder>() {


    //private var photos: List<PhotoData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.post_list_item, parent, false))

    }


    override fun getItemCount(): Int {
       // return photos.size
       return (photoItems.size - 1)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = photoItems[position]
        val itemLayout = holder.itemView

        holder?.itemView.photo_name.text = photoItems.get(position).name
        holder?.itemView.photo_thumbnail.loadImage(photoItems.get(position).small)

        itemLayout.setOnClickListener{

            val name = item.name
            val descrption = item.description
            val imageUrl = item.large

            navigateToDetail(name, descrption, imageUrl)
        }

    }

     fun navigateToDetail(name: String, description: String, imageUrl: String) {
        val intent = Intent(context, PhotoDetailActivity::class.java)

        // Putting extra data into intent
        intent.putExtra("name", name)
        intent.putExtra("description", description)
        intent.putExtra("imageUrl", imageUrl)
//
//         intent.setFlag(Context.FLAG_ACTIVITY_SINGLE_TOP)
//         intent.setFlag(Context.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(intent)

    }

     // 아래 view 는 gridLayout 임
    class ViewHolder(val itemLayout: View) : RecyclerView.ViewHolder(itemLayout) {
       // val textView by bindView<TextView>(R.id.photo_name)
      //  val imageView by bindView<ImageView>(R.id.photo_thumbnail)
    }
}