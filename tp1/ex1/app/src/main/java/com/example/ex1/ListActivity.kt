package com.example.ex1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity(){
  private lateinit var textViewTitle: TextView
  private lateinit var listViewOptions: ListView

  override fun onCreate(savedInstanceState: Bundle?){
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list)

    textViewTitle = findViewById(R.id.textViewTitle)
    listViewOptions = findViewById(R.id.listViewOptions)

    val language = intent.getStringExtra("language")

    if(language == "French"){
      textViewTitle.text = "Options en Francais"
      val frenchOptions = arrayOf("Voiture","Maison","Ecole","Banque")
      listViewOptions.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,frenchOptions)
    }
    else {
      textViewTitle.text  = "Options in English"
      val englishOptions = arrayOf("Car","House","School","Bank")
      listViewOptions.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,englishOptions)
    }
  }
}