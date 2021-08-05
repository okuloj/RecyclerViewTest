package com.example.recyclerviewtest

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_item.*
import kotlinx.android.synthetic.main.contact_item.view.*

class ContactAdapter(private var contacts: ArrayList<Contact>): RecyclerView.Adapter<ContactAdapter.ViewHolder>(){
    //private var viewHolderList = mutableListOf<ViewHolder>
    private var viewType: Int = 1

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(contact: Contact, viewType: Int) {
            itemView.textViewName.text = contact.name
            itemView.textViewPhoneNumber.text = contact.phoneNumber
            itemView.textViewName.height = 88*viewType
            itemView.textViewPhoneNumber.height = 68*viewType
            Log.v("check", "bind - $this")
            //Log.v("itemView", itemView.toString())

            itemView.setOnFocusChangeListener { v, hasFocus ->

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.v("check", "onCreate")
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewHolder = layoutInflater.inflate(R.layout.contact_item, parent, false)
        return ViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.v("check", "onBind")
        holder.bind(contacts[position], viewType)
    }

    override fun getItemCount(): Int {
        Log.v("check", "size")
        return contacts.size
    }


    fun setViewType(viewType: Int) {
        this.viewType = viewType
    }
}
