package com.ongoni.dao

import java.io.File

class FileWriter {

    companion object {
        @JvmStatic
        fun write(content: String, to: File) = to.writeText(content)
    }

}