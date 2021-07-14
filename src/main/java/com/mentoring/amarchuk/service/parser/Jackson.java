package by.prohor.service.parser;

import by.prohor.dao.UserDao;
import by.prohor.model.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
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

