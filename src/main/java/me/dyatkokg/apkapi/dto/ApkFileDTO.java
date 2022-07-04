package me.dyatkokg.apkapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApkFileDTO {

    private byte[] file;

    private String name;

    private String version;

    private Integer buildNumber;

}
