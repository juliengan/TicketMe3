package com.example.inventorymanagement

import android.app.DownloadManager.COLUMN_ID
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.media.tv.TvContract.PreviewPrograms.COLUMN_AUTHOR
import android.media.tv.TvContract.PreviewPrograms.COLUMN_TITLE
import android.widget.Toast

private const val DATABASE_NAME = "TicketMe.db"
private const val DATABASE_VERSION = 1
private const val TABLE_NAME = "my_library"
private const val COLUMN_ID = "_id"
private const val COLUMN_TITLE = "book_title"
private const val COLUMN_AUTHOR = "book_author"
private const val COLUMN_PAGES = "book_pages"

class MyDatabaseHelper(var context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_AUTHOR + " TEXT, " +
                COLUMN_PAGES + " INTEGER);"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, i: Int, i2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }



fun addBook(book: Book){
    val db = this.writableDatabase
    var cv = ContentValues()
    cv.put(COLUMN_TITLE, book.title)
    cv.put(COLUMN_AUTHOR, book.author)
    cv.put(COLUMN_PAGES, book.pages)
    var result = db.insert (TABLE_NAME, null, cv)
    if (result == -1.toLong())
        Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
    else
        Toast.makeText(context, "Added successfully", Toast.LENGTH_SHORT).show()

}
}

