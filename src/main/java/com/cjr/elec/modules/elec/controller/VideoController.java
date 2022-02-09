package com.cjr.elec.modules.elec.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cjr.elec.common.api.CommonResult;
import com.cjr.elec.modules.elec.model.VideoInfo;
import com.cjr.elec.modules.elec.vo.DurationVO;
import org.apache.http.HttpEntity;
import com.cjr.elec.common.exception.Asserts;
import org.springframework.web.bind.annotation.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

/**
 * @author CJR
 * @create 2022-02-09-16:34
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @GetMapping("/duration")
    public CommonResult getDuration(@RequestParam String BVNumber, @RequestParam Integer start, @RequestParam Integer end) throws IOException {
        int sum = 0;
        int hour = 0;
        int minute = 0;
        String url = "https://api.bilibili.com/x/player/pagelist?bvid=" + BVNumber + "&jsonp=jsonp";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String json = EntityUtils.toString(entity, "UTF-8").trim();
            JSONObject jsonObject = JSONObject.parseObject(json);
            Object data = jsonObject.get("data");
            String dataJson = JSON.toJSONString(data);
            List<VideoInfo> videoInfoList = JSONObject.parseArray(dataJson, VideoInfo.class);
            for (int i = start - 1; i < end; i++) {
                if (i >= 0 && i < videoInfoList.size()) {
                    sum += videoInfoList.get(i).getDuration();
                } else {
                    Asserts.fail("分p输入非法");
                }
            }
            hour = sum / 3600;
            sum %= 3600;
            minute = sum / 60;
            sum %= 60;
            return CommonResult.success(new DurationVO(hour, minute, sum));
        } else {
            return CommonResult.failed();
        }
    }
}
