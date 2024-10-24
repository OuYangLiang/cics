package com.oyl.cics.web.guidaoheng;

import com.oyl.cics.model.common.cfg.PropertiesConfig;
import com.oyl.cics.model.common.utils.AESUtil;
import com.oyl.cics.model.common.utils.JsonUtil;
import com.oyl.cics.model.common.utils.MD5Encryptor;
import com.oyl.cics.model.common.utils.RandomGenerator;
import com.oyl.cics.model.common.utils.http.HttpUtil;
import com.oyl.cics.model.guidaoheng.Guidaoheng;
import com.oyl.cics.model.guidaoheng.GuidaohengGenerator;
import com.oyl.cics.model.guidaoheng.GuidaohengService;
import com.oyl.cics.model.guidaoheng.request.SearchCondition;
import com.oyl.cics.model.guidaoheng.response.SearchResult;
import com.oyl.cics.model.guidaoheng.GuidaohengRepos;
import com.oyl.cics.web.common.result.RestResult;
import com.oyl.cics.web.guidaoheng.request.UploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
public class GuidaohengController {
    private static final Logger log = LoggerFactory.getLogger(GuidaohengController.class);

    @Resource
    private GuidaohengRepos guidaohengRepos;

    @Resource
    private GuidaohengService guidaohengService;

    @PostMapping("/guidaoheng/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(guidaohengRepos.search(condition));
    }

    @PostMapping("/guidaoheng/upload")
    public RestResult<Void> upload(@RequestBody UploadRequest request) {
        List<Guidaoheng> guidaohengs = guidaohengRepos.queryByKeys(Arrays.stream(request.getIds()).mapToLong(Long::longValue).toArray());

        try {
            guidaohengService.upload(guidaohengs, request.getOperator());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return RestResult.ok(null);
    }

    @Resource
    private PropertiesConfig propertiesConfig;

//    @GetMapping("/guidaoheng/test")
//    public RestResult<String> test() {
//        Guidaoheng guidaoheng = GuidaohengGenerator.generateRandomGuidaoheng();
//
//        String url = propertiesConfig.getUrl() + "/api/dlhg/guidaoheng";
//        String millis = Long.toString(System.currentTimeMillis());
//        String nonce = RandomGenerator.inst.strs(6);
//
//        Map<String, String> headers = new HashMap<>();
//        headers.put("appId", propertiesConfig.getAppId());
//        headers.put("millis", millis);
//        headers.put("nonce", nonce);
//        headers.put("sn", MD5Encryptor.inst.getMD5(propertiesConfig.getAppId() + propertiesConfig.getAppSecret() + millis + nonce).toLowerCase());
//        headers.put("Content-Type", "application/json");
//
//        String json = JsonUtil.inst.toJson(Collections.singleton(guidaoheng));
//        String encrypted = null;
//        try {
//            encrypted = AESUtil.inst.encrypt(json, propertiesConfig.getDataSecret());
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            return RestResult.fail("Error", e.getMessage());
//        }
//
//        try {
//            String resultJson = HttpUtil.inst.request(url, encrypted, headers);
//            log.info(resultJson);
//            return RestResult.ok(resultJson);
//        } catch (IOException e) {
//            log.error(e.getMessage(), e);
//            return RestResult.fail("Error", e.getMessage());
//        }
//    }

    @GetMapping("/guidaoheng/test")
    public RestResult<Guidaoheng> test2() {
        List<Guidaoheng> list = guidaohengRepos.queryFromOldSystem();
        log.info("{} records found", list == null ? 0 : list.size());

        if (list != null && !list.isEmpty()) {
            return RestResult.ok(list.get(0));
        }

        return RestResult.ok(null);
    }
}
