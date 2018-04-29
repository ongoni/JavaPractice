package com.ongoni.dao.utils

import java.io.File

class FileReader {

    companion object {
        @JvmStatic
        fun readAll(from: File) : String = from.readText()
    }

}