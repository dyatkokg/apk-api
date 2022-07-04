package me.dyatkokg.apkapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import me.dyatkokg.apkapi.dto.ApkFileDTO;
import me.dyatkokg.apkapi.dto.ApkFileForViewDTO;
import me.dyatkokg.apkapi.entity.ApkFile;
import me.dyatkokg.apkapi.exception.FileWithNameAndVersionAlreadyExistException;
import me.dyatkokg.apkapi.exception.IncorrectFileTypeException;
import me.dyatkokg.apkapi.mapper.ApkFileMapper;
import me.dyatkokg.apkapi.repository.ApkFileRepository;
import me.dyatkokg.apkapi.service.ApkFileService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ApkFileServiceImpl implements ApkFileService {

    private final ApkFileRepository repository;

    private final ApkFileMapper mapper;

    @Override
    @SneakyThrows
    public ApkFileDTO upload(MultipartFile file, ApkFileDTO dataDTO) {
        if (Objects.requireNonNull(file.getOriginalFilename()).endsWith(".apk")) {
            if (repository.existsApkFileByNameAndVersion(dataDTO.getName(), dataDTO.getVersion())) {
                throw new FileWithNameAndVersionAlreadyExistException();
            }
            byte[] bytes = file.getBytes();
            ApkFile apkFile = mapper.toEntity(dataDTO);
            apkFile.setFile(bytes);
            return mapper.toDTO(repository.save(apkFile));
        } else throw new IncorrectFileTypeException();
    }

    @Override
    public Page<ApkFileForViewDTO> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).map(mapper::toEntityView);
    }

    @Override
    public Page<ApkFileForViewDTO> getVersionByName(int size, int page, String name) {
        Pageable pageable = PageRequest.of(size, page, Sort.Direction.DESC, "version");
        return repository.findByName(pageable, name)
                .map(mapper::toEntityView);
    }

    @Override
    @SneakyThrows
    public ApkFile download(String version) {
        return repository.findByVersion(version);
    }
}
