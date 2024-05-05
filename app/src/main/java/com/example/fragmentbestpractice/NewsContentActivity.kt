package com.example.fragmentbestpractice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class NewsContentActivity: AppCompatActivity() {

    companion object {
        fun actionStart (context: Context, title: String, content: String) {
            val intent = Intent(context, NewsContentActivity::class.java).apply {
                putExtra("news_title", title)
                putExtra("news_content", content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)

        val title = intent.getStringExtra("news_title")
        val content = intent.getStringExtra("news_content")
        val newsContentFrag = findViewById<RelativeLayout>(R.id.newsContentFrag)

        if (title != null && content != null) {
            //这个as NewsContentFragment是一定要写的，不然就找不到refresh方法.
            val fragment = newsContentFrag as NewsContentFragment
            fragment.refresh(title, content)
        }
    }
}