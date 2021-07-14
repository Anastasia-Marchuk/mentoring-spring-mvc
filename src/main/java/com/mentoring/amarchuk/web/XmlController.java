package by.prohor.web;

import by.prohor.facade.BookingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Artsiom Prokharau 12.07.2021
 */

@Controller
public class XmlController {

    @Autowired
    BookingFacade bookingFacade;

    @PostMapping(value = "/xml", produces = MediaType.TEXT_HTML_VALUE)
    public String getPageXml(@RequestParam("file") MultipartFile file) {
        bookingFacade.preloadUsers(file);
        return "redirect:/";
    }
}
