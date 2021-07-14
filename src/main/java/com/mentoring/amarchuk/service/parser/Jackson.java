package com.mentoring.amarchuk.service.parser;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Artsiom Prokharau 12.07.2021
 */

public class Jackson {

    MultipartFile file;

    public Jackson(MultipartFile file) {
        this.file = file;
    }

    public UserDto loaderXmlFile() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        InputStream inputStream = file.getInputStream();
        return xmlMapper.readValue(inputStream, UserDto.class);
    }
}

