package com.shopwave.service;

import com.shopwave.model.Seller;
import com.shopwave.model.SellerReport;

public interface SellerReportService {
    SellerReport getSellerReport(Seller seller);
    SellerReport updateSellerReport( SellerReport sellerReport);

}
