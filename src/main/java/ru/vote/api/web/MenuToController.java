package ru.vote.api.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuToController {


}
