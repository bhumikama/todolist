package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    lateinit var things : EditText
    lateinit var addButton : Button
    lateinit var lv : ListView
    var itemList = ArrayList<String>()
     var helper = FileHelper ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        things =findViewById(R.id.text_word)
        addButton=findViewById(R.id.add_button)
        lv =findViewById(R.id.list_things)


        itemList = helper.readData(this)
        var adapterB = ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,itemList)
        lv.adapter = adapterB

        addButton.setOnClickListener(View.OnClickListener {

            var insert: String = things.text.toString()
            itemList.add(insert)
            things.setText("")
            adapterB.notifyDataSetChanged()
        })

    }
}