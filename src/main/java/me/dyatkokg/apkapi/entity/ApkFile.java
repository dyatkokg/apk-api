package me.dyatkokg.apkapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class ApkFile {

    @Id
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;

    private byte[] file;

    private String name;

    private String version;

    private Integer buildNumber;

}
