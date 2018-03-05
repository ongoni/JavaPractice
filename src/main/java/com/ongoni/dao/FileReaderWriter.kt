package com.ongoni.dao

import java.io.File

class FileReaderWriter {

    fun write(content: String, to: File) = to.writeText(content)

    fun readAll(from: File) : String = from.readText()

}