package com.hjj.mypracticedemo.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.hjj.mypracticedemo.R

/**
 * File description.
 * @author hjj
 * @date 2021/5/6
 * @function
 */
class MainAdapter constructor(layoutResId: Int, data: MutableList<String>) : BaseQuickAdapter<String, BaseViewHolder>(layoutResId, data) {

    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.tvTest, item)
    }
}