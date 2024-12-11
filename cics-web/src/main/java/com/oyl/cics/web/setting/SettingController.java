package com.oyl.cics.web.setting;

import com.oyl.cics.model.setting.SettingService;
import com.oyl.cics.web.common.result.RestResult;
import com.oyl.cics.web.setting.request.ConfigRequest;
import com.oyl.cics.web.setting.response.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class SettingController {

    private static final Logger log = LoggerFactory.getLogger(SettingController.class);

    @Resource
    private SettingService settingService;

    @PostMapping("/setting/query")
    public RestResult<Config> query() {
        Config config = new Config();
        config.setAutoUpload(settingService.autoUpload());

        return RestResult.ok(config);
    }

    @PostMapping("/setting/save")
    public RestResult<Config> save(
            @RequestBody @Valid @NotNull(message = "请求对象不能为空") ConfigRequest request, BindingResult bindingResult) {
        settingService.setAutoUpload(request.getAutoUpload());

        Config config = new Config();
        config.setAutoUpload(request.getAutoUpload());
        return RestResult.ok(config);
    }
}
