package me.dyatkokg.apkapi.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.apkapi.dto.ApkFileDTO;
import me.dyatkokg.apkapi.dto.ApkFileForViewDTO;
import me.dyatkokg.apkapi.entity.ApkFile;
import me.dyatkokg.apkapi.service.ApkFileService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("apk")
@RequiredArgsConstructor
public class ApkFileController {

    private final ApkFileService service;

    @PostMapping(value = "upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApkFileDTO> upload(@RequestPart("file") MultipartFile file, @RequestPart("data") ApkFileDTO dataDTO) {
        return ResponseEntity.ok(service.upload(file, dataDTO));
    }

    @GetMapping("all")
    public ResponseEntity<Page<ApkFileForViewDTO>> getAll(@RequestParam(value = "size", required = false, defaultValue = "10") int page,
                                                          @RequestParam(value = "page", required = false, defaultValue = "0") int size) {
        return ResponseEntity.ok(service.getAll(page, size));
    }

    @GetMapping("versions")
    public ResponseEntity<Page<ApkFileForViewDTO>> getAllVersionByName(@RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                                                       @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                                       @RequestParam("name") String name) {
        return ResponseEntity.ok(service.getVersionByName(size, page, name));
    }

    @GetMapping("download")
    public ResponseEntity<byte[]> downloadFile(@RequestParam("version") String version) {
        ApkFile file = service.download(version);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
                + file.getName() + ".apk\"").body(file.getFile());
    }
}
