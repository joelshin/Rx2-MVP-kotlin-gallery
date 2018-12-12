package com.joel.archtecture.rxjava.photogallery.ui.photos

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log

import com.joel.archtecture.rxjava.photogallery.R


import com.joel.archtecture.rxjava.photogallery.data.PhotoData
import com.joel.archtecture.rxjava.photogallery.ui.BaseActivity
import com.joel.archtecture.rxjava.photogallery.ui.adapters.PhotoItemsAdapter
import com.joel.archtecture.rxjava.photogallery.ui.detailview.PhotoDetailActivity
import com.joel.archtecture.rxjava.photogallery.ui.detailview.PhotoDetailAdapter
import kotlinx.android.synthetic.main.activity_post.*

class PhotoViewActivity : BaseActivity(), PhotoView {


   var postPresenter: PhotosPresenterImpl?=null


    override fun setLayout(): Int {

        return R.layout.activity_post
    }

    override fun init(savedInstanceState: Bundle?) {
      //  postPresenter.getAllPosts()
        getPresenter()?.let {
            it.getAllPosts()
        }
    }

    fun getPresenter(): PhotosPresenterImpl?{
        postPresenter = PhotosPresenterImpl(this, application)
        return postPresenter
    }






    override fun onStartScreen() {
    }

    override fun stopScreen() {
        postPresenter?.let {
            postPresenter!!.unbindView()
            postPresenter = null
        }

    }





    override fun showAllPosts(photoList: List<PhotoData>) {

        Log.d("Response", "" + photoList)
        //rv_post_list.layoutManager = LinearLayoutManager(this)
        val columns: Int
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            columns = 3
        } else {
            columns = 2
        }
//        val layoutManager = GridLayoutManager(this, columns)
        rv_post_list.layoutManager =  GridLayoutManager(this, columns)
        rv_post_list.adapter = PhotoItemsAdapter(photoList, this)

        //onclick
//        rv_post_list!!.addOnItemTouchListener(GalleryAdapter.RecyclerTouchListener(applicationContext, recyclerView!!, object : GalleryAdapter.ClickListener {
//            override fun onClick(view: View, position: Int) {
//                val bundle = Bundle()
//                bundle.putSerializable("images", images)
//                bundle.putInt("position", position)
//
//            }
//
//            override fun onLongClick(view: View?, position: Int) {
//
//            }
//        }))
    }


    private fun createCategoryItemAdapter(photoInfo: PhotoData)
            = PhotoDetailAdapter(photoInfo, { showPhotoDetail(photoInfo) })

    private fun showPhotoDetail(photoInfo: PhotoData) {
        PhotoDetailActivity.start(this, photoInfo)
    }

//    override fun navigateToDetail(id: String) {
//        navigate<PhotoViewActivity>(id, findItemById(id), BaseActivity.IMAGE_TRANSITION_NAME)
//    }
//
//    private fun findItemById(id: String): View {
//        val pos = adapter.findPositionById(id)
//        val holder = ui.recycler.findViewHolderForLayoutPosition(pos)
//                as BaseAdapter.BaseViewHolder<ImageTitleAdapter.Component>
//        return holder.ui.image
//    }
//
//    inline fun <reified T : Activity> Activity.navigate(id: String, sharedView: View? = null,
//                                                        transitionName: String? = null) {
//        val intent = Intent(this, T::class.java)
//        intent.putExtra("id", id)
//
//        var options: ActivityOptionsCompat? = null
//
//        if (sharedView != null && transitionName != null) {
//            options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, sharedView, transitionName)
//        }
//
//        ActivityCompat.startActivity(this, intent, options?.toBundle())
//    }
//
//    fun Activity.getNavigationId(): String {
//        val intent = intent
//        return intent.getStringExtra("id")
//    }
}
