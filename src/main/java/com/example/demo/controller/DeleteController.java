package com.example.demo.controller;

import com.example.demo.config.SpringContextUtil;
import com.example.demo.repository.BaseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by song on 2017/11/10.
 */
@RestController
//实现批量删除
public class DeleteController {
    @RequestMapping(method = RequestMethod.POST, value = "/api/delete/{model}")
    @Transactional
    public Response objectDelete(@RequestBody List<Long> ids, @PathVariable String model){
        try {
            BaseRepository repository = (BaseRepository) SpringContextUtil.getBean(model + "Repository");
            repository.deleteByIdIn(ids);
        }catch (Exception e){
            return new Response("500");
        }
        return new Response("200");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/delete/hellos")
    public String objectDelete(){
        return "hellos";
    }

    @Data
    @AllArgsConstructor
    class Response{
        String status;
    }
}
