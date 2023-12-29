package com.ben.QrCode.controller;

import com.ben.QrCode.service.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QrCodeController {

	@Autowired
	private QrCodeService qrCodeService;

	@GetMapping(value = "/generateQRCode", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> generateQrCode(@RequestParam("keyWord") String keyWord){
		return ResponseEntity.ok().body(qrCodeService.generateQRCode(keyWord));
	}
}
