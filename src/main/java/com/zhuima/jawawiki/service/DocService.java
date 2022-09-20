package com.zhuima.jawawiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuima.jawawiki.domain.Content;
import com.zhuima.jawawiki.domain.Doc;
import com.zhuima.jawawiki.domain.DocExample;
import com.zhuima.jawawiki.mapper.ContentMapper;
import com.zhuima.jawawiki.mapper.DocMapper;
import com.zhuima.jawawiki.req.DocQueryReq;
import com.zhuima.jawawiki.req.DocSaveReq;
import com.zhuima.jawawiki.resp.DocResp;
import com.zhuima.jawawiki.resp.PageResp;
import com.zhuima.jawawiki.util.CopyUtil;
import com.zhuima.jawawiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class DocService {
    private static final Logger logger = LoggerFactory.getLogger(DocService.class);


    @Autowired
    private DocMapper docMapper;


    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private SnowFlake snowFlake;


    public PageResp<DocResp> list(DocQueryReq req) {

        DocExample docExample = new DocExample();
        DocExample.Criteria criteria = docExample.createCriteria();
        // System.out.println("Listing Doc: " + req.getName());
        // criteria.andNameLike("%" + req.getName() + "%");

        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }

        PageHelper.startPage(req.getPage(), req.getSize());
        List<Doc> DocList = docMapper.selectByExample(docExample);

        PageInfo<Doc> pageInfo = new PageInfo<>(DocList);

        List<DocResp> repoList = CopyUtil.copyList(DocList, DocResp.class);
        PageResp<DocResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(repoList);
        return pageResp;

    }

    /**
     * 新增或更新一个文档
     * 
     * @param req
     */
    public void save(DocSaveReq req) {
        Doc doc = CopyUtil.copy(req, Doc.class);
        Content content = CopyUtil.copy(req, Content.class);
        if (ObjectUtils.isEmpty((req.getId()))) {
            // 新增
            doc.setId(snowFlake.nextId());
            docMapper.insert(doc);

            content.setId(doc.getId());
            contentMapper.insert(content);
        } else {
            // 更新
            docMapper.updateByPrimaryKey(doc);
            contentMapper.updateByPrimaryKeyWithBLOBs(content);
        }

    }


    /**
     * 获取单个文档
     * @param id
     * @return
     */
    public Doc getById(Long id) {
        return docMapper.selectByPrimaryKey(id);
    }

    /**
     * 删除一个文档
     *
     * @param id
     * @return
     */
    public int deleteById(Long id) {
        return docMapper.deleteByPrimaryKey(id);
    }


    /**
     * 删除一批文档
     *
     * @param ids
     * @return
     */
    public int deleteByIds(List<String> ids) {
        DocExample docExample = new DocExample();
        DocExample.Criteria criteria = docExample.createCriteria();
        criteria.andIdIn(ids);
        return docMapper.deleteByExample(docExample);
    }

    /**
     * 查找文档内容
     * @param id
     * @return
     */
    public String findContent(Long id) {
        Content content = contentMapper.selectByPrimaryKey(id);
        if (ObjectUtils.isEmpty(content)) {
            return "";
        } else {
            return content.getContent();

        }
    }


    /**
     * 获取一本书的所有文档
     * @param ebookId
     * @return
     */
    public List<DocResp> all(Long ebookId) {
        DocExample docExample = new DocExample();
        docExample.createCriteria().andEbookIdEqualTo(ebookId);
        docExample.setOrderByClause("sort asc");
        List<Doc> docList = docMapper.selectByExample(docExample);

        // 列表复制
        List<DocResp> list = CopyUtil.copyList(docList, DocResp.class);


        logger.info("list --->{}", list.toString());
        return list;
    }

}
