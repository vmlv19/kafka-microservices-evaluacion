package com.bank.producer.controller;

import com.bank.producer.model.Message;
import com.bank.producer.service.NotifyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class PublishController {

    private final NotifyService notifyService;

    public PublishController(NotifyService notifyService) {
        this.notifyService = notifyService;
    }

    @PostMapping
    public ResponseEntity<String> publish(@RequestBody Message request) {
        notifyService.sendMsg(request.getMessage());
        return ResponseEntity.ok("Mensaje enviado a KAFKA: " + request.getMessage());
    }

}
