package com.bosonit.block11uploaddownloadfiles.application;

import com.bosonit.block11uploaddownloadfiles.domain.FileEntity;
import com.bosonit.block11uploaddownloadfiles.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final Path rootFolder = Paths.get("uploads");
    private final FileRepository fileRepository;
    @Override
    public void save(MultipartFile file) throws Exception {
        Files.copy(file.getInputStream(), this.rootFolder.resolve(Objects.requireNonNull(file.getOriginalFilename())));

        uploadDB(file);
    }

    @Override
    public void save(List<MultipartFile> files) throws Exception {
        for (MultipartFile file : files) {
            this.save(file);
        }
    }

    @Override
    public FileEntity uploadDB(MultipartFile file) throws IOException {
        FileEntity fl = new FileEntity();

        fl.setName(file.getOriginalFilename());
        fl.setUploadDate(new Date());
        fl.setType(file.getContentType());
        fl.setFileData(file.getBytes());

        return fileRepository.save(fl);
    }



    @Override
    public ResponseEntity<Object> getByIdMapped(Integer id) {
        Optional<FileEntity> fileEntity = fileRepository.findById(id);

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileEntity.get().getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= " + fileEntity.get().getName())
                .body(new ByteArrayResource(fileEntity.get().getFileData()));
    }

    @Override
    public ResponseEntity<Object> getByNameMapped(String name) {
        Optional<FileEntity> fileEntity = Optional.ofNullable(fileRepository.findFileEntityByName(name));

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileEntity.get().getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= " + fileEntity.get().getName())
                .body(new ByteArrayResource(fileEntity.get().getFileData()));
    }

    @Override
    public void downloadById(Integer id) throws IOException {
        FileEntity fileEntity = fileRepository.findById(id).orElseThrow();

        File file = new File(fileEntity.getName());

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(fileEntity.getFileData());
        fileOutputStream.close();
    }

    @Override
    public void downloadByName(String name) throws IOException {
        FileEntity fileEntity = fileRepository.findFileEntityByName(name);

        File file = new File(fileEntity.getName());

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(fileEntity.getFileData());
        fileOutputStream.close();
    }
}
