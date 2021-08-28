package lab.aikibo.monitoringbapenda.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class WebController {

    @RequestMapping("/")
    @ResponseBody
    fun home() = "Hai semua"

}