package com.abelint.adapterlistdemonstration

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CardListAdapter(private val context : Context, private val cardItems: List<Card>) : BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return cardItems.size
    }

    override fun getItem(position: Int): Any {
        return cardItems[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            view = inflater.inflate(R.layout.card, parent, false)
        }

        val tv = view?.findViewById<TextView>(R.id.tv_card)?: TextView(context)
        val btn = view?.findViewById<Button>(R.id.button)?: Button(context)

        val nowItem = cardItems[position]

        tv.text = nowItem.name + " " + nowItem.age
        btn.setOnClickListener {
            Toast.makeText(context, "Position " + nowItem.id.toString(), Toast.LENGTH_LONG).show()
        }

        return  view!!
    }
}