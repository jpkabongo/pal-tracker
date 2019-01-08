package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private final String port;
    private final String ml;
    private final String cii;
    private final String cia;

    public EnvController(@Value("${PORT:NO SET}") String port, @Value("${MEMORY_LIMIT:NO SET}") String ml, @Value("${CF_INSTANCE_INDEX:NO SET}") String cii, @Value("${CF_INSTANCE_ADDR:NO SET}") String cia) {
         this.port=port;
        this.ml=ml;
        this.cii=cii;
        this.cia=cia;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> env = new HashMap<>();
        env.put("PORT",port);
        env.put("MEMORY_LIMIT",ml);
        env.put("CF_INSTANCE_INDEX",cii);
        env.put("CF_INSTANCE_ADDR",cia);

        return env;

    }
}
