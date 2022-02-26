package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/flow-data")
public class BootController {
	
	SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSS");
	
    @PostMapping(value = "/save")
    public Object flowDataSave(@RequestBody String json) {
    	File file = new File("src/main/resources/flow."+SDF.format(new Date())+".json");
    	try {
        	if(!file.exists()){
        		file.createNewFile();
        	}
        	FileWriter fileWritter = new FileWriter(file);
            fileWritter.write(json);
            fileWritter.close();

            System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
        return json;
    }
}
