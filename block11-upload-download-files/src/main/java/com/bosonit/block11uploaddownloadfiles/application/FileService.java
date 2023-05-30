package com.bosonit.block11uploaddownloadfiles.application;

import com.bosonit.block11uploaddownloadfiles.domain.FileEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    public void save(MultipartFile file) throws Exception;
    public void save(List<MultipartFile> file) throws Exception;
    public FileEntity uploadDB(MultipartFile multipartFile) throws IOException;
    public ResponseEntity<Object> getByIdMapped(Integer id);
    public ResponseEntity<Object> getByNameMapped(String name);
    public void downloadById(Integer id) throws IOException;
    public void downloadByName(String name) throws IOException;
}

