package me.dyatkokg.apkapi.repository;

import me.dyatkokg.apkapi.entity.ApkFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApkFileRepository extends PagingAndSortingRepository<ApkFile, String> {

    ApkFile findByVersion(String version);

    boolean existsApkFileByNameAndVersion(String name, String version);

    Page<ApkFile> findByName(Pageable pageable, String name);

}
