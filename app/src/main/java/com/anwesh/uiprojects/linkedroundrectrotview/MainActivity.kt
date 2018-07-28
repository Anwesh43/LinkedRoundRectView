package com.anwesh.uiprojects.linkedroundrectrotview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.anwesh.uiprojects.lrrrview.LRRRView

class MainActivity : AppCompatActivity() {

    private val completeListener : (Int) -> Unit = { createToast("completed animation ${it + 1}")}

    private val resetListener : (Int) -> Unit = {createToast("animation is reset ${it + 1}")}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view : LRRRView = LRRRView.create(this)
        fullScreen()
        view.addAnimationListener(completeListener, resetListener)
    }

    private fun createToast(msg : String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}

fun MainActivity.fullScreen() {
    supportActionBar?.hide()
    window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}