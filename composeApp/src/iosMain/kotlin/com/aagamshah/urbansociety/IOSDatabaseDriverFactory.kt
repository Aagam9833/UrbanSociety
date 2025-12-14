package com.aagamshah.urbansociety

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.aagamshah.urbansociety.data.DatabaseDriverFactory
import com.aagamshah.urbansociety.db.UrbanSocietyDatabase

class IOSDatabaseDriverFactory : DatabaseDriverFactory {

    override fun create(): SqlDriver =
        NativeSqliteDriver(
            UrbanSocietyDatabase.Schema,
            "urbansociety.db"
        )
}
