package com.cardvalue.penguin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-28 10:27.
 *
 * @Description:
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadFileController {

    @RequestMapping(value = "/uploadfile",method = RequestMethod.POST)
    @ResponseBody
    public Map uploadFile(HttpServletRequest request,String url ,String data){

//        url: "${wsCrmRestfulMerchantUrl}/merchants/${newMerchantUserModel.objectId}/checklists/" + checklistId + "/files/" + results.origin.name
//        data: results.base64.substring(results.base64.indexOf(",") + 1)
        Map map = new HashMap();
        return map;
    }
}
