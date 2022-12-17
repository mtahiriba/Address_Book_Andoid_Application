package com.example.addressbook

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE contacts(name TEXT, phone TEXT, street TEXT, email TEXT, city TEXT)")

        var values = ContentValues()
        values.put("name", "Muhammad Tahir");
        values.put("phone", "03113488858");
        values.put("street", "khairpur");
        values.put("email", "mtm75474@gmail.com");
        values.put("city", "khirpur");
        if (db != null) {
            db.insert("contacts", null, values)
        }
    }


    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertRecord( name: String, phone: String, street: String, email: String, city: String){

        var values = ContentValues()
        values.put("name", name);
        values.put("phone", phone);
        values.put("street", street);
        values.put("email", email);
        values.put("city", city);
        writableDatabase.insert("contacts", null, values)
    }

    fun getAllData(): ArrayList<String>{

        val arrayList: ArrayList<String> = ArrayList<String>()

        val query = "SELECT * FROM contacts"
        val cursor = readableDatabase.rawQuery(query, null)
        cursor.moveToFirst()
        do {
            arrayList.add(cursor.getString(0))
        }while (cursor.moveToNext())

        return arrayList
    }
}