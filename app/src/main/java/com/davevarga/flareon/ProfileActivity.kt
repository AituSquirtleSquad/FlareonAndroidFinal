package com.davevarga.flareon

import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class ProfileActivity : AppCompatActivity() {
    var phoneRecycler: RecyclerView? = null
    var adapter: RecyclerView.Adapter<*>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_user)

        //Hooks
//        phoneRecycler = findViewById(R.id.my_recyclers1)
//        phoneRecycler()
//
//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
//        bottomNavigationView.selectedItemId = R.id.profileActivity
//        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.
//        OnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.profileActivity -> return@OnNavigationItemSelectedListener true
//                R.id.listFragment -> {
//                    startActivity(Intent(applicationContext, HomeActivity::class.java))
//                    overridePendingTransition(0, 0)
//                    return@OnNavigationItemSelectedListener true
//                }
//            }
//            false
//        })

        val button = findViewById<Button>(R.id.buttonEdit)
        button.setOnClickListener{
            val intent = Intent(this, EditProfile::class.java)
            startActivity(intent)
            finish()
        }
    }
//
//    private fun phoneRecycler() {
//
//        //All Gradients
//        val gradient2 = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(-0x2b341b, -0x2b341b))
//        val gradient1 = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(-0x852331, -0x852331))
//        val gradient3 = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(-0x83a61, -0x83a61))
//        val gradient4 = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(-0x47280b, -0x47280b))
//        phoneRecycler!!.setHasFixedSize(true)
//        phoneRecycler!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        val phonelocations = ArrayList<CarouselHelper>()
//        phonelocations.add(CarouselHelper(gradient1, R.drawable.bat, "Samsung"))
//        phonelocations.add(CarouselHelper(gradient4, R.drawable.eeaao, "Vivo"))
//        phonelocations.add(CarouselHelper(gradient2, R.drawable.scott, "Apple"))
//        phonelocations.add(CarouselHelper(gradient4, R.drawable.hand, "Realme"))
//        phonelocations.add(CarouselHelper(gradient2, R.drawable.breakfast, "Poco"))
//        adapter = AdapterPhone(phonelocations, this)
//        phoneRecycler!!.adapter = adapter
//    }

//    override fun onphoneListClick(clickedItemIndex: Int) {}
}