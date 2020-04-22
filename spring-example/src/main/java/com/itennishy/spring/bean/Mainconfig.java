package com.itennishy.spring.bean;

import com.itennishy.spring.filter.MyFilter;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScans(value = {
        @ComponentScan(value = "com.itennishy.spring", includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = PersonService.class),
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyFilter.class)
        }, useDefaultFilters = false),
})
public class Mainconfig {

    @Bean("person")
    public Person person() {
        System.out.println("初始化");
        return new Person("lisi", 30);
    }
}
