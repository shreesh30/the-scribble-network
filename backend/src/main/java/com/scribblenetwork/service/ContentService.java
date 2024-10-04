package com.scribblenetwork.service;

import com.scribblenetwork.exception.ScribbleException;
import com.scribblenetwork.model.ContentModel;

public interface ContentService {
    ContentModel createContent(ContentModel contentModel) throws ScribbleException;
}
