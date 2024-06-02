package com.tobiWeber.pdfOcrFinder

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.File
import java.nio.file.Path

class FileLoaderTest {
    @TempDir
    lateinit var tempDir: Path

    @Test
    fun `should return empty list when no pdf files are in folder`() {
        File(tempDir.toFile(), "file1.pdf").createNewFile()
        File(tempDir.toFile(), "file2.pdf").createNewFile()
        File(tempDir.toFile(), "file3.txt").createNewFile()
        val files = FileLoader.getPdfFilesFromFolder(tempDir.toFile())

        assertThat(files).hasSize(2)
        assertThat(files).containsExactlyInAnyOrder(
            File(tempDir.toFile(), "file1.pdf"),
            File(tempDir.toFile(), "file2.pdf"),
        )
    }

    @Test
    fun `should return empty list when folder is empty`() {
        val files = FileLoader.getPdfFilesFromFolder(tempDir.toFile())

        assertThat(files).isEmpty()
    }
}
