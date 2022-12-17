package com.example.addressbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.util.zip.Inflater
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var list: ListView
    var dbHelper:DBHelper = DBHelper(this, "Mydatabase", null, 1)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = findViewById(R.id.list)

        Log.d("Message", "Main Call")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Message", "onResume call")
        var arrayList = dbHelper.getAllData()

        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arrayList)

        list.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent: Intent = Intent(this, SaveContact::class.java)
        startActivityForResult(intent, 1234)
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK && requestCode == 1234) {

            val str = data?.getStringExtra("name")
            Log.d("Message", ""+str)
            dbHelper.insertRecord(""+str, "031134565987","Memon", "example@gmail.com","Khairpur")

        }
        else
        {
            Log.d("Message", "Name Not Found")
        }

    }
}