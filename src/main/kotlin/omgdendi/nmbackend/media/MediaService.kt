package omgdendi.nmbackend.media

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.io.path.Path

@Service
class MediaService {
    fun saveFile(multipartFile: MultipartFile): String {
        val date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"))
        val fileName = date + multipartFile.originalFilename
        val p = Path("static/media/$fileName")
        multipartFile.transferTo(p)
        return fileName
    }

    fun deleteFile(name: String) {
        Files.delete(Path("static/media/$name"))
    }
}