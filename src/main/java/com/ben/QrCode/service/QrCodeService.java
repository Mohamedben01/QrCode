package com.ben.QrCode.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class QrCodeService {

	public byte[] generateQRCode(String keyWord){
		byte[] qrCodeByteArray = null;
		try {
			String contents = "www.google.com";
			int width = 100;
			int height = 100;

			// generate QR code
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix bitMatrix = qrCodeWriter.encode(keyWord, BarcodeFormat.QR_CODE, width, height);

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
			qrCodeByteArray = outputStream.toByteArray();
			return qrCodeByteArray;
		} catch (WriterException | IOException e) {
			e.printStackTrace();
		}
		return qrCodeByteArray;
	}


}
