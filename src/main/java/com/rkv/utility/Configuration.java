package com.rkv.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {
    public  String base_uri ;
    public String pets_ep;

    public String pets_image_ep;

    public String findByStatus;

    public String user_ep;

    public Configuration() {
        Properties propApi = new Properties();
        Properties propConfig = new Properties();
        try {
            propApi.load(new FileInputStream("src/main/resources/api.properties"));
            propConfig.load(new FileInputStream("src/main/resources/config.properties"));
            this.base_uri = propConfig.getProperty("BASE_URI");
            this.pets_ep = propApi.getProperty("PET");
            this.findByStatus = propApi.getProperty("PET_BY_STATUS");
            this.pets_image_ep = propApi.getProperty("UPLOAD_IMAGE");
            this.user_ep = propApi.getProperty("USER");

        } catch (Exception e) { e.printStackTrace();}
    }


}
