package com.tobiWeber.pdfOcrFinder

import java.io.File

fun main(args: Array<String>) {
    println("PDF OCR finder | Args: ${args.joinToString()}")

    val files = FileLoader.getPdfFilesFromFolder(File("."))

    println("Files in current folder: ${files.joinToString(", ")}")
}
