package me.dyatkokg.apkapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApkFileForViewDTO {

    private String id;

    private String name;

    private String version;

    private Integer buildNumber;

}
