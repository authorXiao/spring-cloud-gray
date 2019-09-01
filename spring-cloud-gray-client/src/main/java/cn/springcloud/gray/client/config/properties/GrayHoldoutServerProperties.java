package cn.springcloud.gray.client.config.properties;

import cn.springcloud.gray.model.InstanceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(value = "gray.holdout-server")
public class GrayHoldoutServerProperties {

    private boolean enabled;
    private boolean zoneAffinity;
    private boolean cacheable;

    private Map<String, List<InstanceStatus>> services = new HashMap<>();
}
