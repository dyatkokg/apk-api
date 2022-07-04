package me.dyatkokg.apkapi.mapper;

import me.dyatkokg.apkapi.dto.ApkFileDTO;
import me.dyatkokg.apkapi.dto.ApkFileForViewDTO;
import me.dyatkokg.apkapi.entity.ApkFile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApkFileMapper {

    ApkFile toEntity(ApkFileDTO dto);

    ApkFileDTO toDTO(ApkFile apkFile);

    ApkFileForViewDTO toEntityView(ApkFile apkFile);
}
