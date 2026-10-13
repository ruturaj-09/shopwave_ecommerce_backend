package com.shopwave.service;

import com.shopwave.model.Home;
import com.shopwave.model.HomeCategory;

import java.util.List;

public interface HomeService {

    Home creatHomePageData(List<HomeCategory> categories);

}
