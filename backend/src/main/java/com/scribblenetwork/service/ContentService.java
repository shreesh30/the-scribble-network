package com.scribblenetwork.service;

import com.scribblenetwork.exception.ScribbleException;
import com.scribblenetwork.model.ContentModel;

public interface ContentService {
    ContentModel createContent(ContentModel contentModel) throws ScribbleException;

    ContentModel deleteContent(String contentId) throws ScribbleException;

    ContentModel editContent(String contentId,ContentModel content) throws ScribbleException;
}
