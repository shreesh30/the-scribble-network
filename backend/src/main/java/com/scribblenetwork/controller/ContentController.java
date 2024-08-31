package com.scribblenetwork.controller;

import com.scribblenetwork.model.ContentModel;
import com.scribblenetwork.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

    private ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService){
        this.contentService=contentService;
    }

    @PostMapping(path = "/content/create")
    public ContentModel createContent(@RequestBody ContentModel content) {
        return contentService.createContent(content);
    }
}
