package com.example.UrlShortner.Controller;

import com.example.UrlShortner.Models.MapShortLongUrl;
import com.example.UrlShortner.Models.QRCodes;
import com.example.UrlShortner.Repo.MapShortLongUrlRepo;
import com.example.UrlShortner.Repo.QRCodeRepo;
import com.example.UrlShortner.Services.UrlService;
import com.example.UrlShortner.util.QRCodeGeneratorUtil;
import com.google.zxing.WriterException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@Log4j2
@RequestMapping("/api/Qr")
@CrossOrigin(origins = "*")
public class QRCodeController {

    @Value("${url.shortner.default.url}")
    String urlShortnerUrl;

    @Autowired
    UrlService urlService;

    @Autowired
    QRCodeRepo qrCodeRepo;

    @Autowired
    MapShortLongUrlRepo mapShortLongUrlRepo;

    @GetMapping
    public ResponseEntity<byte[]> generateQRCode(@RequestParam Integer id) {
        log.info("base Url for the QR : " + urlShortnerUrl);
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "image/png");
            Optional<QRCodes> qrCode = qrCodeRepo.findByMapId(id);
            if (qrCode.isPresent()) {
                return new ResponseEntity<>(qrCode.get().getQRCode(), headers, HttpStatus.OK);
            }

            MapShortLongUrl map = mapShortLongUrlRepo.getReferenceById(id);
            String shortUrl = urlShortnerUrl + "/" + map.getShortUrl();
            log.info("Final QR Url : " + shortUrl);
            byte[] qrImage = QRCodeGeneratorUtil.getQRCodeImage(shortUrl, 300, 300);

            QRCodes newQrCode = new QRCodes();
            newQrCode.setMapId(id);
            newQrCode.setQRCode(qrImage);

            newQrCode = qrCodeRepo.save(newQrCode);

            return new ResponseEntity<>(newQrCode.getQRCode(), headers, HttpStatus.OK);
        } catch (WriterException | IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
