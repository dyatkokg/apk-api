package me.dyatkokg.apkapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApkFileDataDTO {

    private String name;

    private String version;

    private Integer buildNumber;
}
