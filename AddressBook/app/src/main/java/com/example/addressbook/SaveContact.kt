package com.example.addressbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.view.View
import android.widget.EditText

class SaveContact : AppCompatActivity() {

    var dbHelper:DBHelper? = null
    lateinit var name: EditText
    lateinit var phone:EditText
    lateinit var city: EditText
    lateinit var street: EditText
    lateinit var email: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_contact)

        phone = findViewById(R.id.phone)
        name = findViewById(R.id.name)
        city = findViewById(R.id.city)
        street = findViewById(R.id.Address)
        email = findViewById(R.id.email)
    }

    fun AddContact(view: View){
        val intent: Intent = Intent()
        intent.putExtra("name", name.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}