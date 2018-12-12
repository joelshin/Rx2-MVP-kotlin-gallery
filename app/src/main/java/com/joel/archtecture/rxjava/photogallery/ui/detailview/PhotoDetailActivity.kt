package com.joel.archtecture.rxjava.photogallery.ui.detailview

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem


import com.joel.archtecture.rxjava.photogallery.data.PhotoData
//import com.kakao2.photogallery.ui.view.common.extra
import com.joel.archtecture.rxjava.photogallery.ui.view.common.getIntent
import com.joel.archtecture.rxjava.photogallery.ui.view.common.loadImage
import kotlinx.android.synthetic.main.activity_photo_detail.*
import com.joel.archtecture.rxjava.photogallery.R


class PhotoDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_detail)
        setUpToolbar()


        supportActionBar?.title = intent.getStringExtra("name")

        descriptionView.text = intent.getStringExtra("description")
//        occurrencesView.text = makeOccurrencesText()
        val photourl = intent.getStringExtra("imageUrl")

        headerView.loadImage(photourl, centerCropped = true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when {
        item.itemId == android.R.id.home -> onBackPressed().let { true }
        else -> super.onOptionsItemSelected(item)
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    private fun String.addList(introductionTextId: Int, list: List<String>): String {
        if (list.isEmpty()) return this
        val introductionText = getString(introductionTextId)
        val listText = list.joinToString(transform = { " $bullet $it" }, separator = "\n")
        return this + "$introductionText\n$listText\n\n"
    }

    companion object {
        private const val bullet = '\u2022'
        private const val CHARACTER_ARG = "com.joel.archtecture.rxjava.photogallery.ui.PhotoDetailActivity.CharacterArgKey"

        fun getIntent(context: Context, character: PhotoData) = context
                .getIntent<PhotoDetailActivity>()
                .apply { /*putExtra(CHARACTER_ARG, character) */}

        fun start(context: Context, character: PhotoData) {
            val intent = getIntent(context, character)
            context.startActivity(intent)
        }
    }
}