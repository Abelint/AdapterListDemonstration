package com.abelint.adapterlistdemonstration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var listCard = mutableListOf<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val card1 = Card(null, "smth name", 56)
        listCard.add(card1)
        val card2 = Card(null, "Ииииигаааарь", 6)
        listCard.add(card2)

        var lv = findViewById<ListView>(R.id.lv_cards)
        val adapter = CardListAdapter(this, listCard)
        lv.adapter = adapter

        val etName = findViewById<EditText>(R.id.ed_name)
        val etAge =  findViewById<EditText>(R.id.editTextNumber)
        findViewById<Button>(R.id.btn_add_card).setOnClickListener {
            val card = Card(null,
                etName.text.toString(),
                etAge.text.toString().toInt()
                )
            listCard.add(card)
            adapter.notifyDataSetChanged()
        }
    }
}