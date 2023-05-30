package com.bosonit.block11uploaddownloadfiles.controller;

import com.bosonit.block11uploaddownloadfiles.application.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFiles(@RequestParam("files")List<MultipartFile> files) throws Exception {
        fileService.save(files);

        return ResponseEntity.status(HttpStatus.OK).body("Files succesfully uploaded");
    }

    @PostMapping("/upload/db")
    public ResponseEntity<String> uploadBD(@RequestParam("files") MultipartFile file) throws Exception {
        fileService.uploadDB(file);

        return ResponseEntity.status(HttpStatus.OK).body("Files succesfully uploaded");
    }



    @GetMapping("/mappedid/{id}")
    public ResponseEntity<Object> getByIdMapped(@PathVariable("id") Integer id) throws Exception {
        ResponseEntity<Object> fileEnt = fileService.getByIdMapped(id);

        return fileEnt;
    }

    @GetMapping("/mappedname/{name}")
    public ResponseEntity<Object> getByNameMapped(@PathVariable("name") String name) throws Exception {
        ResponseEntity<Object> fileEnt = fileService.getByNameMapped(name);

        return fileEnt;
    }

    @GetMapping("/downloadid/{id}")
    public void downloadById(@PathVariable("id") Integer id) throws Exception {
        fileService.downloadById(id);
    }

    @GetMapping("/downloadname/{name}")
    public void downloadByName(@PathVariable("name") String name) throws Exception {
        fileService.downloadByName(name);
    }
}
