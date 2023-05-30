package com.bosonit.block11uploaddownloadfiles.repository;

import com.bosonit.block11uploaddownloadfiles.domain.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Integer> {
    FileEntity findFileEntityByName(String name);
}
