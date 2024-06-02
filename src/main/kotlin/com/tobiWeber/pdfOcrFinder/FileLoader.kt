package com.tobiWeber.pdfOcrFinder

import java.io.File

object FileLoader {
    fun getPdfFilesFromFolder(directory: File): List<File> {
        return directory.listFiles { _, name -> name.endsWith(".pdf") }?.toList() ?: emptyList()
    }
}
