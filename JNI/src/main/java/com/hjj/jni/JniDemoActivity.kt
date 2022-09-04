package com.hjj.jni

import android.os.Bundle
import android.os.PersistableBundle
import com.hjj.jni.data.TestData
import com.hjj.jni.databinding.ActivityJniDemoBinding
import com.hjj.jni.load.JniLoader
import com.hjj.lib_common.base.BaseActivity

class JniDemoActivity : BaseActivity() {

    private lateinit var binding: ActivityJniDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJniDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sampleText.text = JniLoader.getTestData().toString()
        JniLoader.test(
            true,
            1,
            ',',
            3,
            4,
            3.3f,
            2.2,
            "Dev",
            28,
            intArrayOf(1, 2, 3, 4, 5, 6),
            arrayOf("2", "3", "4"),
            TestData("数据"),
            booleanArrayOf(true, false)
        )
        JniLoader.dynamicRegister("动态注册")
        initListener()
    }

    fun initListener() {
        binding.sampleBtn.setOnClickListener { JniLoader.dynamicRegister2("测试异常处理") }
    }

}