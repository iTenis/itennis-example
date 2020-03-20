package com.itennishy.db.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class appController {

    @Autowired
    private AppRepository appRepository;

    @RequestMapping("/test")
    public void test() throws InterruptedException {
        Optional<App> opt = appRepository.findById("1");
        App a = opt.isPresent() ? opt.get().setPersisted(true) : new App().setId("1");
        a.setAppname("t2");
        appRepository.save(a);
    }
}
