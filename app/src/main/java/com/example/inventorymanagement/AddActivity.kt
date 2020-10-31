package com.example.inventorymanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        val titleInput = findViewById<EditText>(R.id.title_input);
        val authorInput = findViewById<EditText>(R.id.author_input);
        val pagesInput = findViewById<EditText>(R.id.pages_input);
        findViewById<Button>(R.id.add_button).setOnClickListener { view ->
            var book = Book(authorInput.text.toString(), pagesInput.text.toString().toInt(),titleInput.text.toString())
            var myDB = MyDatabaseHelper(this);
            myDB.addBook(book)

        }
    }
}