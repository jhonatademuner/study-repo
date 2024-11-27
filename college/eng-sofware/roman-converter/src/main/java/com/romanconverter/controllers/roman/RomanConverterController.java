package com.romanconverter.controllers.roman;

import com.romanconverter.services.roman.RomanConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanConverterController {

    @Autowired
    private RomanConverterService romanConverterService;

    @PostMapping("api/arabic/{input}")
    public String convertArabicToRoman(@PathVariable String input){
        return romanConverterService.romanToArabic(input);
    }

}
