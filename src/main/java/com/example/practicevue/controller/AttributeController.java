package com.example.practicevue.controller;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.GoodsAttr;
import com.example.practicevue.model.GoodsAttrDTO;
import com.example.practicevue.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zcy
 * @date 2020/12/4
 */
@RestController
@RequestMapping(path = "/categories/attributes")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public APIResponse<List<GoodsAttr>> attributesList(@PathVariable Integer id, @RequestParam String sel){
        return attributeService.attributesList(id, sel);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    public APIResponse<GoodsAttr> createAttribute(@PathVariable Integer id, @RequestBody GoodsAttrDTO goodsAttrDTO){
        return attributeService.createAttribute(id, goodsAttrDTO);
    }

    @RequestMapping(path = "/{id}/{attrId}", method = RequestMethod.DELETE)
    public APIResponse<GoodsAttr> deleteAttribute(@PathVariable Integer id, @PathVariable Integer attrId){
        return attributeService.deleteAttribute(id, attrId);
    }

    @RequestMapping(path = "/{id}/{attrId}", method = RequestMethod.GET)
    public APIResponse<GoodsAttr> selectAttributeById(@PathVariable Integer id, @PathVariable Integer attrId,
                                                      @RequestParam String sel, String vals){
        return attributeService.selectAttributeById(id, attrId, sel, vals);
    }

    @RequestMapping(path = "/{id}/{attrId}", method = RequestMethod.PUT)
    public APIResponse<GoodsAttr> editAttribute(@PathVariable Integer id, @PathVariable Integer attrId,
                                                @RequestBody GoodsAttr goodsAttr){
        return attributeService.editAttribute(id, attrId, goodsAttr);
    }
}
