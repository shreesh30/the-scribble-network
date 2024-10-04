package com.scribblenetwork.controller;

import com.scribblenetwork.exception.ScribbleException;
import com.scribblenetwork.model.ContentModel;
import com.scribblenetwork.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

    Logger logger = LoggerFactory.getLogger(getClass());

    private ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService){
        this.contentService=contentService;
    }

    @PostMapping(path = "/content/create")
    public ResponseEntity<ContentModel> createContent(@RequestBody ContentModel content) throws ScribbleException {
        try {
            return new ResponseEntity<>(contentService.createContent(content),HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error while processing content ");
            throw new ScribbleException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
