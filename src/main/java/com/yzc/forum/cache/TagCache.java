package com.yzc.forum.cache;

import com.yzc.forum.dto.TagDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TagCache {
    public List<TagDTO> get(){
        ArrayList<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("js","javascript","php","html","html5","css","java","node","python","c++","c","golang","c#","spring","swoole","ruby","asp.net","rust","scala","laverel","android","ios","小程序","webapp","xcode","swift","react-native","objective-c","mysql","redis","json","elasticsearch","shell","typescript"));
        tagDTOS.add(program);

        TagDTO framework = new TagDTO();
        framework.setCategoryName("平台架构");
        framework.setTags(Arrays.asList("laravel","spring","spring boot","spring cloud","flask","django","struts","yii","koa","express","ruby-on-rails","tornado"));
        tagDTOS.add(framework);

        TagDTO server = new TagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("linux","nginx","docker","apache","ubuntu","centos","缓存","tomcat","负载均衡","unix","hadtop","windows-server"));
        tagDTOS.add(server);

//        TagDTO
//        "mysql","redis","mongodb","sql","oracle","nosql","memcached",,sqlserver,postgresql,sqlite
        return tagDTOS;
    }
}
