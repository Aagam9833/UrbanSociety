package com.aagamshah.urbansociety

import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.aagamshah.urbansociety.data.DatabaseDriverFactory
import com.aagamshah.urbansociety.db.UrbanSocietyDatabase

class AndroidDatabaseDriverFactory(
    private val context: Context
) : DatabaseDriverFactory {

    override fun create(): SqlDriver =
        AndroidSqliteDriver(
            schema = UrbanSocietyDatabase.Schema,
            context = context,
            name = "urbansociety.db",
            callback = object : AndroidSqliteDriver.Callback(
                UrbanSocietyDatabase.Schema
            ) {
                override fun onOpen(db: SupportSQLiteDatabase) {
                    super.onOpen(db)
                    db.execSQL("PRAGMA foreign_keys=ON;")
                }
            }
        )
}
