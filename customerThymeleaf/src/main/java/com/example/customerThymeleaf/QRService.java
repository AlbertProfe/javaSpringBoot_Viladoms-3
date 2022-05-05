package com.example.customerThymeleaf;

public interface QRService {
	
	
	 byte[] generateQRCode(String qrContent, int width, int height);

}
