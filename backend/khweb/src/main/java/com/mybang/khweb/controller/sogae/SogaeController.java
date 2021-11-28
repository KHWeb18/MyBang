package com.mybang.khweb.controller.sogae;

import com.mybang.khweb.entity.Sogae;
import com.mybang.khweb.request.SogaeRequest;
import com.mybang.khweb.service.SogaeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @Slf4j
    @Controller
    @RequestMapping("/sogae")
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
    public class SogaeController {

        @Autowired
        private SogaeService service;

        @PostMapping("/register")
        public ResponseEntity<Void> upload(@Validated @RequestBody SogaeRequest sogaeRequest) throws Exception {
            log.info("upload(): " + sogaeRequest);

            service.upload(sogaeRequest);

            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        @GetMapping("/list")
        public ResponseEntity<List<Sogae>> list() throws Exception {
            log.info("getList(): " + service.list());

            List<Sogae> list = service.list();
            //List<Board> list = null;

            return new ResponseEntity<List<Sogae>>(list, HttpStatus.OK);
        }

        @GetMapping("/{sogaeNo}")
        public ResponseEntity<Sogae> read(@PathVariable("sogaeNo") Integer sogaeNo) throws Exception {
            log.info("read() sogaeNo: " + sogaeNo);

            Sogae sogae = service.read(sogaeNo);

            return new ResponseEntity<Sogae>(sogae, HttpStatus.OK);
        }

        @DeleteMapping("/{sogaeNo}")
        public ResponseEntity<Void> delete(@PathVariable("sogaeNo") Integer sogaeNo) throws Exception {
            log.info("delete() sogaeNo: " + sogaeNo);

            service.delete(sogaeNo);

            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        @PutMapping("/{sogaeNo}")
        public ResponseEntity<Void> modify(@Validated @RequestBody SogaeRequest sogaeRequest) throws Exception {
            log.info("modify(): " + sogaeRequest);


            service.modify(sogaeRequest);

            return new ResponseEntity<Void>(HttpStatus.OK);
        }

    }
