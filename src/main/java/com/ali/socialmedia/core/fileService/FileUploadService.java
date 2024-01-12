package com.ali.socialmedia.core.fileService;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@Service
public class FileUploadService {
    private final Path path = Paths.get("src/main/java/com/ali/socialmedia/core/uploads");
    public void uploadPostFile(MultipartFile file,String fileName) throws IOException {
        Path filePath = path.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    }
}
