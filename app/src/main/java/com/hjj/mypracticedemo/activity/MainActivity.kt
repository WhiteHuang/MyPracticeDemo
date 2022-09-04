package com.hjj.mypracticedemo.activity

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hjj.jni.JniDemoActivity
import com.hjj.lib_common.base.BaseActivity
import com.hjj.mypracticedemo.R
import com.hjj.mypracticedemo.adapter.MainAdapter
import com.hjj.mypracticedemo.databinding.ActivityMainBinding
import java.util.*

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<String>()
    private val adapter: MainAdapter by lazy {
        MainAdapter(R.layout.cv_item_test, list)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Example of a call to a native method
//        binding.sampleText.text = stringFromJNI()
        initView()
        initData()
        intiListener()
    }

    private fun intiListener() {
        adapter.setOnItemClickListener { adapter, view, position ->
            when (list[position]) {
                "OpenGL" -> {
//                    toActivity(OpenGLActivity::class.java)
                }
                "JNI" -> {
                    toActivity(JniDemoActivity::class.java)
                }
                "音视频" -> {

                }

            }
        }
    }

    private fun toActivity(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }

    private fun initData() {
        list.add("OpenGL")
        list.add("JNI")
        list.add("音视频")
        adapter.notifyDataSetChanged()

    }

    private fun initView() {
        binding.rcMessageList.layoutManager = LinearLayoutManager(this)
        binding.rcMessageList.adapter = adapter
    }


}