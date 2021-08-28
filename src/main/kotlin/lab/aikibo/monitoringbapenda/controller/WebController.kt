package lab.aikibo.monitoringbapenda.controller

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.util.EntityUtils
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*

@Controller
class WebController {

    @RequestMapping("/")
    fun index(model: Model): String {
        model.addAttribute("tanggal", Calendar.getInstance())

        val url = "http://pajak-daerah.brebeskab.go.id:4040"
        val client = HttpClientBuilder.create().build()
        var req = HttpGet(url)

        req.addHeader("User-Agent", "Apache HTTPClient")
        val resp = client.execute(req)
        val status = resp.statusLine

        val entity = resp.entity
        model.addAttribute("response", status.statusCode)
//        model.addAttribute("response", 404)

        return "index"
    }

    @RequestMapping("/home")
    fun home(): String {
        return "home"
    }

}