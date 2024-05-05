package com.example.fragmentbestpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class NewsContentFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_content_fragment, container, false)
    }

    fun refresh(title: String, content: String) {
        //有什么方法能避免频繁判空吗？
        val contentLayout: LinearLayout? = activity?.findViewById(R.id.contentLayout)
        val newsTitle = activity?.findViewById<TextView>(R.id.newsTitle)
        val newsContent = activity?.findViewById<TextView>(R.id.newsContent)

        contentLayout?.visibility = View.VISIBLE
        newsTitle?.text = title
        newsContent?.text = content
    }
}