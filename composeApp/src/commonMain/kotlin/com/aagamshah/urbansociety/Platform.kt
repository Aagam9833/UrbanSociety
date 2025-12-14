package com.aagamshah.urbansociety

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform