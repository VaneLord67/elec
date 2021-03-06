package com.cjr.elec;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cjr.elec.modules.elec.model.VideoInfo;
import org.apache.http.HttpEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class ElecApplicationTests {

    @Test
    void bTest() throws IOException {
        int start = 1;
        int end = 168;
        String BV = null;
        int sum = 0;
        int hour = 0;
        int minute = 0;
        String url = "https://api.bilibili.com/x/player/pagelist?bvid=BV1Zy4y1K7SH&jsonp=jsonp";
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
                sum += videoInfoList.get(i).getDuration();
            }
            hour = sum / 3600;
            sum %= 3600;
            minute = sum / 60;
            sum %= 60;
            System.out.println(hour + "小时" + minute + "分钟" + sum + "秒");
        }

    }

    @Test
    void contextLoads() {
    }

}
