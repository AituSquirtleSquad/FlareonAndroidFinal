package com.davevarga.flareon

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import de.hdodenhof.circleimageview.CircleImageView
import java.io.IOException

class EditProfile : AppCompatActivity() {
    var switchCompat: SwitchCompat? = null
    private var imageView: CircleImageView? = null
    var imageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.Theme_Dark)
        } else {
            setTheme(R.style.Theme_Light)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile)
        switchCompat = findViewById(R.id.bt_switch)
        switchCompat!!.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        })
        imageView = findViewById<View>(R.id.userImage1) as CircleImageView
        imageView!!.setOnClickListener(View.OnClickListener {
            val gallery = Intent()
            gallery.type = "image/*"
            gallery.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(gallery, "Select Picture"), Pick_Img)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Pick_Img && resultCode == RESULT_OK) {
            imageUri = data!!.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
                imageView!!.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    companion object {
        private const val Pick_Img = 1
    }
}