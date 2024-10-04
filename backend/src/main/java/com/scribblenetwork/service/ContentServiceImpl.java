package com.scribblenetwork.service;

import com.scribblenetwork.entity.ContentEntity;
import com.scribblenetwork.exception.ScribbleException;
import com.scribblenetwork.model.ContentModel;
import com.scribblenetwork.repository.ContentRepository;
import com.scribblenetwork.utils.ContentUtils;
import com.scribblenetwork.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContentServiceImpl implements ContentService{

    Logger logger= LoggerFactory.getLogger(getClass());

    private ContentRepository contentRepository;

    @Autowired
    ContentServiceImpl(ContentRepository contentRepository){
        this.contentRepository=contentRepository;
    }

    @Transactional(rollbackFor = ScribbleException.class)
    @Override
    public ContentModel createContent(ContentModel contentModel) throws ScribbleException {
        try {
            String contentId = ContentUtils.generateContentId();
            Long createdOn = System.currentTimeMillis();
            Long lastUpdated = System.currentTimeMillis();

            ContentEntity content = new ContentEntity();
            content.setId(contentId);
            content.setContent(contentModel.getContent());
            content.setUserId(UserUtils.getLoggedInUser());
            content.setCreatedOn(createdOn);
            content.setLastUpdated(lastUpdated);

            content = contentRepository.save(content);

            contentModel.setId(content.getId());
            contentModel.setCreatedOn(content.getCreatedOn());
            contentModel.setLastUpdated(content.getLastUpdated());
            contentModel.setUserId(content.getUser().getId());

            return contentModel;
        }catch (Exception e){
            throw new ScribbleException("Error saving content "+e);
        }
    }
}
