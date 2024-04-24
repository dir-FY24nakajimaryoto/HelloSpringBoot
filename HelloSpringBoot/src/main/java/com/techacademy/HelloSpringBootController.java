package com.techacademy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController // MVCアノテーション.RESThulControllerであると示す
public class HelloSpringBootController {

    // MVCアノテーション
    @GetMapping("/") // ルートURL(/)へのGETリクエストを受け取るとメソッドが呼び出されるように指定
    public String index() {
        return "Hello SpringBoot World";
    }
    
    @GetMapping("now")
    public String dispTime() {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        return "現在時刻：" + now;
    }
    
    @GetMapping("/plus/{val1}/{val2}") // パスパラメータ：URLのパス部分に指定した値を変数として取り出す機能
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) { // PathVariableで変数取得
        int res = 0;
        res = val1 + val2;
        return "計算結果：" + res;
    }
    
}
