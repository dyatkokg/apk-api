package me.dyatkokg.apkapi.service;

import me.dyatkokg.apkapi.dto.ApkFileDTO;
import me.dyatkokg.apkapi.dto.ApkFileForViewDTO;
import me.dyatkokg.apkapi.entity.ApkFile;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface ApkFileService {

    ApkFileDTO upload(MultipartFile file, ApkFileDTO dataDTO);

    Page<ApkFileForViewDTO> getAll(int page, int size);

    Page<ApkFileForViewDTO> getVersionByName(int size, int page, String name);

    ApkFile download(String version);
}
