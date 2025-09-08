package com.example.sheduleapp

import android.content.Context
import android.util.AttributeSet
import android.widget.HorizontalScrollView


class SyncedHorizontalScrollView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : HorizontalScrollView(context, attrs) {

    var partner: SyncedHorizontalScrollView? = null

    private var isSyncing = false

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)

        if (!isSyncing) {
            partner?.let {
                it.isSyncing = true
                it.scrollTo(l, t)
                it.isSyncing = false
            }
        }
    }
}
