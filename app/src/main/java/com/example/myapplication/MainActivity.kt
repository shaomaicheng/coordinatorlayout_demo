package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.RelativeLayout
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lastOffset = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        appbarlayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appbar, offset ->
//            Log.e("chenglei-head", viewHead.height.toString())
            Log.e("chenglei", offset.toString())
            if (offset == -300) {
                if (lastOffset != -300) {
                    val tv2Lp = tv2.layoutParams as RelativeLayout.LayoutParams
                    tv2Lp.removeRule(RelativeLayout.BELOW)
                    tv2Lp.addRule(RelativeLayout.RIGHT_OF, R.id.tv1)
                    tv2.layoutParams = tv2Lp
                }
            } else {
                if (lastOffset == -300) {
                    val tv2Lp = tv2.layoutParams as RelativeLayout.LayoutParams
                    tv2Lp.removeRule(RelativeLayout.RIGHT_OF)
                    tv2Lp.addRule(RelativeLayout.BELOW, R.id.tv1)
                    tv2.layoutParams = tv2Lp
                }
            }
            lastOffset = offset
        })
    }
}
