package com.example.recyclerviewtest

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contact_item.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var contactAdapter: ContactAdapter
    private var contacts = mutableListOf<Contact>()

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0..20) {
            contacts.add(Contact("Name $i", "01231232${Random.nextInt(0,9)}${i/2}"))
        }

        //textViewName.setBackgroundColor(Color.GRAY)
//        val linearParam = LinearLayout.LayoutParams(
//            LinearLayout.LayoutParams.MATCH_PARENT,
//            200
//        )
//        textViewName.layoutParams = linearParam
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)


        button.setOnClickListener {
            contactAdapter = ContactAdapter(contacts as ArrayList<Contact>)
            recyclerView.adapter = contactAdapter
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        button2.setOnClickListener {
            for (i in 21..30) {
                contacts.add(i, Contact("Name $i", "01231232${Random.nextInt(0,9)}"))
            }
            contactAdapter.notifyItemRangeInserted(21, 30)
            Toast.makeText(this, "Add 10 item", Toast.LENGTH_SHORT).show()
        }


        button3.setOnClickListener {
//            linear_layout_item.setBackgroundColor(Color.GRAY)
//            val linearParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 400)
//            linear_layout_item.layoutParams = linearParams

//            textViewName.setBackgroundColor(Color.GRAY)
//            val linearParam = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                200
//            )
//            textViewName.layoutParams = linearParam
//            textViewPhoneNumber.layoutParams = linearParam
//
//            contactAdapter.getItemViewType(R.layout.contact_item)

//            val textView = TextView(this)
//            textView.id = 100
//            textView.text = "test"
//            textView.setBackgroundColor(Color.GRAY)
//            val linearParam = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                200
//            )
            contactAdapter.setViewType(2)
            contactAdapter.notifyDataSetChanged()


            //linear_layout_item.addView(textView)

        }
    }

    private fun setView() {
        textViewName.setBackgroundColor(Color.GRAY)
        val linearParam = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            200
        )
        textViewName.layoutParams = linearParam
    }
}