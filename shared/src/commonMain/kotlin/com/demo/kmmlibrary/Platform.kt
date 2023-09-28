package com.demo.kmmlibrary

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform